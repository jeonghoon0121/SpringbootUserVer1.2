package com.org.userproject;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserDTO findByUsername(String username);
    void insertUser(UserDTO user); // 회원가입용 메서드 추가
}



