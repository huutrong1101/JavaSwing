package com.gui.swing.Entity;


import jakarta.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    private String roomName;

    private boolean roomIsActive;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "floor_id", nullable = false)
    private Floor floor;
}
