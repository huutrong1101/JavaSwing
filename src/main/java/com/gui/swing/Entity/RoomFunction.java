package com.gui.swing.Entity;


import com.gui.swing.Entity.Key.RoomFunctionKey;
import jakarta.persistence.*;


@Entity
public class RoomFunction {

    @EmbeddedId
    private RoomFunctionKey roomFunctionKey;

    private boolean roomFunctionIsActive;

    @ManyToOne
    @MapsId("roomId")
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @MapsId("functionId")
    @JoinColumn(name = "function_id")
    private Function function;
}
