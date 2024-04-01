package com.gui.swing.Entity.Key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class RoomFunctionKey implements Serializable {
    @Column(name = "room_id")
    private int roomId;

    @Column(name = "function_id")
    private int functionId;
}
