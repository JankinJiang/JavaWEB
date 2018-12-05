package Dao;

import Entity.UserEntity;

import java.util.List;

public interface UserEntityDao {
    //find
    UserEntity getByid(int id);
    UserEntity getByname(String name);
    UserEntity getByphone(String phone);
    List<UserEntity> getBysex(String sex);
    //add
    boolean addUser(UserEntity user);
    //delete
    boolean delUserByid(int id);
    //update
    boolean updateUser(UserEntity user);
}
