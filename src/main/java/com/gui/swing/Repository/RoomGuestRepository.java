package com.gui.swing.Repository;

import com.gui.swing.Entity.RoomGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomGuestRepository extends JpaRepository<RoomGuest, Integer> {

    public Boolean existsRoomGuestByRoomRoomIdAndDateBeginBeforeAndDateEndAfter(int roomId, LocalDateTime dateBegin, LocalDateTime dateEnd);

}