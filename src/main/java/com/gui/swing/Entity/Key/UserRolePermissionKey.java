package com.gui.swing.Entity.Key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class UserRolePermissionKey implements Serializable {

    @Column(name = "user_id")
    private int userId;

    @Column(name = "role_permission_id")
    private int rolePermissionId;
}
