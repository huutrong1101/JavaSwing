package com.gui.swing.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Function {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int functionId;

    private String functionValue;

    private boolean functionIsActive;
}
