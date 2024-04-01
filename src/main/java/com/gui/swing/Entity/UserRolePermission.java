package com.gui.swing.Entity;

import com.gui.swing.Entity.Key.UserRolePermissionKey;
import jakarta.persistence.*;

@Entity
public class UserRolePermission {

    @EmbeddedId
    private UserRolePermissionKey userRolePermissionKey;
    private String userRolePermissionIsActive;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("rolePermissionId")
    @JoinColumn(name = "role_permission_id")
    private RolePermission rolePermission;

}
