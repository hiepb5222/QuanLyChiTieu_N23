package com.example.quanlychitieu_n23.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlychitieu_n23.Entity.Chi;
import com.example.quanlychitieu_n23.Entity.ThongKeLoaiChi;
import com.example.quanlychitieu_n23.Entity.ThongKeLoaiThu;


import java.util.List;

@Dao
public interface ChiDao {
    @Query("Select * from Chi")
    LiveData<List<Chi>> findall();

    @Query("Select sum(soTien) from Chi")
    LiveData<Float> sumTongChi();

    @Query("Select b.idChi,b.ten, sum(a.sotien) as tong from Chi a INNER JOIN loaichi b on a.chiID=b.idChi "+" Group by b.idChi,b.ten")
    LiveData<List<ThongKeLoaiChi>> sumbyLoaiChi();

    @Insert
    void insertChi(Chi chi);

    @Update
    void updateChi(Chi chi);
    @Delete
    void deleteChi(Chi chi);
}