package com.gui.swing.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "room_info")
@Data
public class RoomInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomInfoId;

    private String keyRoomInfo;

    private String valueRoomInfo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;


}
