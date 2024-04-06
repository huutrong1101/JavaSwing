package com.gui.swing.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;

    @Column(unique = true)
    private String identificationCard;

}
