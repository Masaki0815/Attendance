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


    @Column(name = "work_space")
    private Integer work_space;

    @Column(name = "start_time")
    private String start_time;

    @Column(name = "end_time")
    private String end_time;

    @Column(name = "year")
    private String year;

    @Column(name = "start_break")
    private String start_break;

    @Column(name = "end_break")
    private String end_break;

}