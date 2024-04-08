package com.gui.swing.Repository;

import com.gui.swing.Entity.RoomGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomUserRepository extends JpaRepository<RoomGuest, Integer> {
}