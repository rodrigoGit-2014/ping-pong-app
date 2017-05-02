package com.pinpong.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player")
@Data
public class Player {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
}
