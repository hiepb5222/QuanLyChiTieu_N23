package com.example.quanlychitieu_n23.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlychitieu_n23.Entity.LoaiThu;

import java.util.List;

@Dao
public interface LoaiThuDao {
        @Query("Select * from LoaiThu")
        LiveData<List<LoaiThu>> findall();

        @Insert
        void insert(LoaiThu loaiThu);

        @Update
        void update(LoaiThu loaiThu);
        @Delete
        void delete(LoaiThu loaiThu);
}
