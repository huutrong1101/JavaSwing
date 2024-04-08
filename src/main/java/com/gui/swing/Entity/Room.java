package com.gui.swing.Entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    private String roomName;

    private Boolean roomIsActive;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "floor_id", nullable = false)
    private Floor floor;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER)
    List<RoomInfo> roomInfoList;
}
