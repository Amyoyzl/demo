package com.oyzl.demo.config;

import com.oyzl.demo.service.UserDetailService;
import com.oyzl.demo.util.PasswordEncoderUtil;
import org.bouncycastle.openssl.PasswordException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailService userDetailService;

    @Autowired
    public SecurityAuthenticationProvider(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoderUtil();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Logger logger = LoggerFactory.getLogger(SecurityAuthenticationProvider.class);
        Assert.isInstanceOf(UsernamePasswordAuthenticationToken.class, authentication, "非验证类型");
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        if(ObjectUtils.isEmpty(userDetails)){
            throw new UsernameNotFoundException("用户名/密码无效");
        }
        if(!userDetails.getPassword().equals(password)) {
            throw new UsernameNotFoundException("密码错误！");
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password, authorities);
        token.setDetails(userDetails);
        return token;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(aClass));
    }
}
