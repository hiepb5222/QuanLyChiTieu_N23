package com.example.quanlychitieu_n23.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlychitieu_n23.Entity.Chi;


import java.util.List;

@Dao
public interface ChiDao {
    @Query("Select * from Chi")
    LiveData<List<Chi>> findall();

    @Insert
    void insertChi(Chi chi);

    @Update
    void updateChi(Chi chi);
    @Delete
    void deleteChi(Chi chi);
}