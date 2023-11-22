package com.example.AttendanceManage.Request;

import java.io.Serializable;

import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserRequest implements Serializable {

    /**
     * 名前
     */
    private String name;
    
    
}