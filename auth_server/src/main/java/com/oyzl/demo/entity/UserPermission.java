package com.oyzl.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "USER_PERMISSION")
@Getter
@Setter
public class UserPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERMISSION_ID", nullable = false)
    private long permissionID;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private UserRole userRole;

    @Column(name = "PERMISSION_NAME")
    private String permissionName;
}
