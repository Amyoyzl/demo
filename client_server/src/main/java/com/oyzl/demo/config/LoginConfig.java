package com.oyzl.demo.config;

import static com.oyzl.common.Constant.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

@Configuration
public class LoginConfig {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.clientRegistration());
    }

    private ClientRegistration clientRegistration() {
        return ClientRegistration.withRegistrationId("REGISTRATION_ID")
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .clientId(CLIENT_ID)
                .clientSecret(SECRET)
                .scope(SCOPES)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUriTemplate(REDIRECT_URL)
                .authorizationUri(AUTHORIZATION_URL)
                .tokenUri(TOKEN_URL)
                .userInfoUri(RESOURCE_URL)
                .userNameAttributeName("userName")
                .build();
    }
}
