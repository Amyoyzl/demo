package com.oyzl.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER_ROLE")
@Getter
@Setter
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID", nullable = false)
    private long roleId;

    @Column(name = "ROLE_NAME", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "USER_ID",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private UserDetail userDetail;

    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserPermission> permissions;

}
