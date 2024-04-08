package com.gui.swing.Entity;

import com.gui.swing.Entity.Enum.EnumTypeRoom;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomTypeId;

    @Enumerated(EnumType.STRING)
    private EnumTypeRoom roomTypeValue;

    private Double roomTypePrice;

    @OneToMany(mappedBy = "type")
    private List<Room> roomList;


}
