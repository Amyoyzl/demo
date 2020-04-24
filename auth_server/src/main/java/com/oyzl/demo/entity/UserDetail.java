package com.oyzl.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER_DETAIL")
@Getter
@Setter
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", nullable = false)
    private long userId;

    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String userPassword;

    @OneToMany(mappedBy = "userDetail", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserRole> userRoles;

}
