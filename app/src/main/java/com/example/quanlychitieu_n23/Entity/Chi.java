package com.example.quanlychitieu_n23.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Chi {
    @PrimaryKey(autoGenerate = true)
    public int chiID;
    @ColumnInfo (name = "idChi")
    public String idChi;
    @ColumnInfo(name = "ten")
    public String ten;
    @ColumnInfo(name = "soTien")
    public float soTien;
    @ColumnInfo(name = "ghiChu")
    public String ghiChu;
    @ColumnInfo(name="Date")
    public String date;
}
