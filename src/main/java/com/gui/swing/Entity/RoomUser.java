package com.gui.swing.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"room_id", "user_id"})
)
@Entity
public class RoomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomUserId;

    private Date dateBegin;

    private Date dateEnd;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
