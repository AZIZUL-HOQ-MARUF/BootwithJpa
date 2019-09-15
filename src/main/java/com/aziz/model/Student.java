/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aziz.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Maruf
 */
@Entity
@Table(name = "Student")
public class Student implements Serializable {

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

    public List getBooks_issued() {
        return books_issued;
    }

    public void setBooks_issued(List books_issued) {
        this.books_issued = books_issued;
    }

    @Id
    @Column(name = "S_ID")
    private long id;
    @Column(name = "S_NAME")
    private String name;
    @OneToMany(targetEntity = Library.class)
    private List books_issued;

}
