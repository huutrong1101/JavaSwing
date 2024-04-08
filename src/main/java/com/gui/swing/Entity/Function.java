package com.gui.swing.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "functions")
public class Function {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int functionId;

    private String functionValue;

    private boolean functionIsActive;
}
