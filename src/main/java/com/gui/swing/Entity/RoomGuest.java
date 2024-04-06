package com.gui.swing.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class RoomGuest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomUserId;

    private Date dateBegin;

    private Date dateEnd;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest user;

}
