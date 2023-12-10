package com.example.AttendanceManage.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Data
@Table(name = "data")
public class UserEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "name")
    private String name;

    @Column(name = "work_space")
    private Integer work_space;

    @Column(name = "begin_time")
    private String begin_time;

    @Column(name = "end_time")
    private String end_time;


}