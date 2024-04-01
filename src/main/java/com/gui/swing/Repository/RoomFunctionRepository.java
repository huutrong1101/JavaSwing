package com.gui.swing.Repository;

import com.gui.swing.Entity.Key.RoomFunctionKey;
import com.gui.swing.Entity.RoomFunction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomFunctionRepository extends JpaRepository<RoomFunction, RoomFunctionKey> {
}