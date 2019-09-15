/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aziz.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "PARKING_SPACE")
public class ParkingSpace implements Serializable{

    @Id
    @Column(name = "SPACE_ID")
    private long id;

    @Column(name = "SPACE_NAME")
    private String name; 
    
    @OneToOne(mappedBy = "pSpace")
    private SwEngineer engineer;

    public SwEngineer getEngineer() {
        return engineer;
    }

    public void setEngineer(SwEngineer engineer) {
        this.engineer = engineer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
