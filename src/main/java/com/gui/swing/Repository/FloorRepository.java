package com.gui.swing.Repository;

import com.gui.swing.Entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FloorRepository extends JpaRepository<Floor, Integer> {
}