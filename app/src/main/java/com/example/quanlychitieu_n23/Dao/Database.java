package com.example.quanlychitieu_n23.Dao;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.quanlychitieu_n23.Entity.LoaiChi;
import com.example.quanlychitieu_n23.Entity.LoaiThu;

@androidx.room.Database(entities = {LoaiThu.class, LoaiChi.class} ,version = 1,exportSchema = false)
public abstract class Database extends RoomDatabase {
    public abstract LoaiChiDao loaiChiDao();
    public abstract LoaiThuDao loaiThuDao();

    public static Database INSTANCE;
    public static RoomDatabase.Callback callback=new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };
    public static Database getDatabase(final Context context)
    {
        if(INSTANCE==null)
        {
            synchronized (Database.class)
            {
                INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                        Database.class,"App_db")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .addCallback(callback)
                        .build();
            }
        }
        return INSTANCE;
    }
}
