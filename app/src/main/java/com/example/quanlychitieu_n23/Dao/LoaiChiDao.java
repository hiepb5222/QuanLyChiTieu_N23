package com.example.quanlychitieu_n23.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlychitieu_n23.Entity.LoaiChi;

import java.util.List;

@Dao
public interface LoaiChiDao {
    @Query("Select * from LoaiChi")
    LiveData<List<LoaiChi>> findall();

    @Insert
    void insertChi(LoaiChi loaiChi);

    @Update
    void updateChi(LoaiChi loaiChi);
}