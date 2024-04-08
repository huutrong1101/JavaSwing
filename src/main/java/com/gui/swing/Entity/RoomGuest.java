package com.gui.swing.Entity;


import com.gui.swing.Entity.Enum.EnumTypeRent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomGuest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomGuestId;

    private LocalDateTime dateBegin;

    private LocalDateTime dateEnd;

    @Enumerated(EnumType.STRING)
    private EnumTypeRent typeRent;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

}
