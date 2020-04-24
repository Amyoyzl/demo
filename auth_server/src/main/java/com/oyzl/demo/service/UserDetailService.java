package com.oyzl.demo.service;

import com.oyzl.demo.entity.UserDetail;
import com.oyzl.demo.entity.UserPermission;
import com.oyzl.demo.entity.UserRole;
import com.oyzl.demo.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserDetailRepository repository;

    @Autowired
    public UserDetailService(UserDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<UserDetail> users = repository.findAllByUserName(userName);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        UserDetail userDetail = users.get(0);
        for (UserRole userRole : userDetail.getUserRoles()) {
            for (UserPermission permission : userRole.getPermissions()) {
                authorities.add(new SimpleGrantedAuthority(userRole.getName() + "|" + permission.getPermissionName()));
            }
        }
        return new User(userDetail.getUserName(), userDetail.getUserPassword(), authorities);
    }
}
