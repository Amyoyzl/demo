package com.oyzl.demo.api;

import com.oyzl.demo.dto.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/oauth")
public class ServerApi {

    @GetMapping("/user")
    public UserInfo getUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("Amy");
        userInfo.setAddress("ZHA");
        userInfo.setCompany("OOCL");
        userInfo.setPhone("18229736326");
        Logger logger = LoggerFactory.getLogger(ServerApi.class);
        logger.info("Resource server: " + userInfo.toString());
        return userInfo;
    }

}
