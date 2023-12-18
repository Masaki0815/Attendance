package com.example.AttendanceManage.Request;

import lombok.Data;

import java.io.Serializable;


@Data
public class UserRequest implements Serializable {
    private Integer id;

    private Integer work_space;

    private String start_time;

    private String end_time;

    private String year;

    private String start_break;

    private String end_break;


}