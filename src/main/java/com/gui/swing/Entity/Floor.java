package com.gui.swing.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int floorId;

    private String floorName;

    @OneToMany(mappedBy = "floor")
    private List<Room> roomList;
}
