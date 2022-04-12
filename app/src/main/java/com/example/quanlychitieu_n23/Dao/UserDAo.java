package com.example.quanlychitieu_n23.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlychitieu_n23.Entity.UserEntity;

import java.util.List;

@Dao
public interface UserDAo {
    @Insert
    void registerUser(UserEntity userEntity);
    @Query("SELECT * FROM users where userID =(:userID) and password = (:password)")
    UserEntity login(String userID , String password);
    @Update
    void  update(UserEntity userEntity);
    @Delete
    void delete(UserEntity userEntity);
    @Query("SELECT * from users")
    LiveData<List<UserEntity>> findall();

}
