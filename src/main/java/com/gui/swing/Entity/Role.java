package com.gui.swing.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    private String roleName;

    private boolean roleIsActive;

    @OneToMany(mappedBy = "role")
    private List<RolePermission> rolePermissionList;
}
