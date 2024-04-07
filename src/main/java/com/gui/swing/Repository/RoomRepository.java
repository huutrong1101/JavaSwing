package com.gui.swing.Repository;

import com.gui.swing.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    public List<Room> findAllByFloorFloorName(String floorName);

}