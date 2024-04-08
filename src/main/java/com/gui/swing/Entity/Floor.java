package com.gui.swing.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int floorId;

    @Column(unique = true)
    private String floorName;

    @OneToMany(mappedBy = "floor", fetch = FetchType.EAGER)
    private List<Room> roomList;
}
