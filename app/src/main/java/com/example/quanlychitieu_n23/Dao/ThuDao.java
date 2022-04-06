package com.example.quanlychitieu_n23.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlychitieu_n23.Entity.LoaiThu;
import com.example.quanlychitieu_n23.Entity.Thu;

import java.util.List;

@Dao
public interface ThuDao {
        @Query("Select * from Thu")
        LiveData<List<Thu>> findall();

        @Insert
        void insert(Thu thu);

        @Update
        void update(Thu thu);

        @Delete
        void delete(Thu thu);
}
