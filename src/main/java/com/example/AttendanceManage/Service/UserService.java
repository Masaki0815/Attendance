package com.example.AttendanceManage.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.AttendanceManage.Entity.UserEntity;
import com.example.AttendanceManage.Repository.UserRepository;
import com.example.AttendanceManage.Request.UserRequest;


/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    /**
     * ユーザー情報 Repository
     */
    @Autowired
    UserRepository userRepository;
    /**
     * ユーザー情報 全検索
     * @return 検索結果
     */
    public List<UserEntity> searchAll() {
        return (List<UserEntity>) userRepository.findAll();
    }

    /**
     * ユーザー情報新規登録
     * @param user ユーザー情報
     */
    public void create(UserRequest userRequest) {
        userRepository.save(CreateUser(userRequest));
    }

    public void delete(UserRequest userRequest) {
    	userRepository.deleteAll();;
    }
    /**
     * ユーザーTBLエンティティの生成
     * @param userRequest ユーザー情報リクエストデータ
     * @return ユーザーTBLエンティティ
     */
    private UserEntity CreateUser(UserRequest userRequest) {

        UserEntity userEntity = new UserEntity();
 
        userEntity.setName(userRequest.getName());
        
        return userEntity;
    }
}