package com.example.quanlychitieu_n23.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.quanlychitieu_n23.Entity.UserEntity;

@Dao
public interface UserDAo {
    @Insert
    void registerUser(UserEntity userEntity);
    @Query("SELECT * FROM users where userID =(:userID) and password = (:password)")
    UserEntity login(String userID , String password);
}
