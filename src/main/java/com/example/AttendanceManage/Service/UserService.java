package com.example.AttendanceManage.Service;

import com.example.AttendanceManage.Entity.UserEntity;
import com.example.AttendanceManage.Repository.UserRepository;
import com.example.AttendanceManage.Request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Autowired
    UserRepository userRepository;
    public List<UserEntity> searchAll() {
        return (List<UserEntity>) userRepository.findAll();
    }
    public void Create(UserRequest userRequest) {
        userRepository.save(CreateUser(userRequest));
    }

    public void Delete(UserRequest userRequest) {
        userRepository.deleteAll();
    }

    public UserEntity FindById(Integer id) {
        return userRepository.findById(id).get();
    }

    public UserEntity CreateUser(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userRequest.getName());
        userEntity.setWork_space(userRequest.getWork_space());
        return userEntity;
    }
    public UserEntity Begin_time(UserRequest userRequest) {
        UserEntity userEntity = CreateUser(userRequest);
        return userEntity;
    }
    public UserEntity End_time(UserRequest userRequest) {
        UserEntity userEntity = CreateUser(userRequest);
        return userEntity;
    }
}