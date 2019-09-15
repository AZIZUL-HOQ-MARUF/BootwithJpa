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
@Table(name = "SW_ENGR")
public class SwEngineer implements Serializable{
    @Id
    @Column(name = "ID")
    private long id;
    
    @Column(name = "NAME")
    private String name;
    
    @OneToOne
    @JoinColumn(name = "SPACE_ID")
    private ParkingSpace pSpace;

    public ParkingSpace getpSpace() {
        return pSpace;
    }

    public void setpSpace(ParkingSpace pSpace) {
        this.pSpace = pSpace;
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
