package com.example.AttendanceManage.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;


@Data
public class UserRequest implements Serializable {

    private Integer id;

    @NotEmpty(message = "名前を入力してください")
    @Size(max = 10, message = "名前は10文字以内で入力してください")
    private String name;

    private Integer work_space;

    private String begin_time;

    private String end_time;
}