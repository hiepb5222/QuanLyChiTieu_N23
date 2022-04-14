package com.example.quanlychitieu_n23.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlychitieu_n23.Entity.LoaiThu;
import com.example.quanlychitieu_n23.Entity.ThongKeLoaiThu;
import com.example.quanlychitieu_n23.Entity.Thu;

import java.util.List;

@Dao
public interface ThuDao {
        @Query("Select * from Thu")
        LiveData<List<Thu>> findall();

        @Query("Select sum(sotien) from Thu")
        LiveData<Float> sumTongThu();

        @Query("Select sum(sotien) from Thu")
        Float sumTongThu1();
        @Query("SELECT EXISTS (SELECT * FROM Thu)")
        Boolean IssumTongThuNull();

        @Query("Select b.lid,b.ten, sum(a.sotien) as tong from Thu a INNER JOIN loaithu b on a.tid=b.lid "+" Group by b.lid,b.ten")
        LiveData<List<ThongKeLoaiThu>> sumbyLoaiThu();

        @Insert
        void insert(Thu thu);

        @Update
        void update(Thu thu);

        @Delete
        void delete(Thu thu);
}
