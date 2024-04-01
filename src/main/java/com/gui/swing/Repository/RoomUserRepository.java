package com.gui.swing.Repository;

import com.gui.swing.Entity.RoomUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomUserRepository extends JpaRepository<RoomUser, Integer> {
}