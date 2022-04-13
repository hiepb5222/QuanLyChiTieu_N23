package com.example.quanlychitieu_n23.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Thu {
    @PrimaryKey(autoGenerate = true)
    public int tid;
    @ColumnInfo(name="ltid")
    public String ltid;
    @ColumnInfo(name ="ten")
    public String ten;
    @ColumnInfo(name ="sotien")
    public float sotien;
    @ColumnInfo(name ="ghichu")
    public String ghichu;
    @ColumnInfo(name="Date")
    public String date;
}
