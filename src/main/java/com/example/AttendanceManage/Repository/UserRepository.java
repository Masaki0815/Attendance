package com.example.AttendanceManage.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.AttendanceManage.Entity.UserEntity;

/**
 * ユーザー情報 Repository
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {	
}