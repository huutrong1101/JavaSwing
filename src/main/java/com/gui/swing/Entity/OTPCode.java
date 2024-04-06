package com.gui.swing.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class OTPCode {

    @Id
    private int id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int value;

    private Date createdTime;
}
