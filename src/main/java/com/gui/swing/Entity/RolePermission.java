package com.gui.swing.Entity;

import jakarta.persistence.*;

@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"role_id", "permission_id"})
)
@Entity
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rolePermissionId;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "permission_id", nullable = false)
    private Permission permission;

}
