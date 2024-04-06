package com.gui.swing.Repository;

import com.gui.swing.Entity.Key.UserRolePermissionKey;
import com.gui.swing.Entity.UserRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolePermissionRepository extends JpaRepository<UserRolePermission, UserRolePermissionKey> {
}