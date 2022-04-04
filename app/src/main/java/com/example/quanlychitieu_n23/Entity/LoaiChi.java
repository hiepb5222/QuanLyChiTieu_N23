package com.example.quanlychitieu_n23.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LoaiChi {
    @PrimaryKey(autoGenerate = true)
    public int idChi;

    @ColumnInfo(name ="ten")
    public String tenLoaiChi;
}
