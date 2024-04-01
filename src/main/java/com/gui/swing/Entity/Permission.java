package com.gui.swing.Entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int permissionId;

    private String permissionValue;

    private boolean permissionIsActive;

    @OneToMany(mappedBy = "permission")
    private List<RolePermission> rolePermissionList;

}
