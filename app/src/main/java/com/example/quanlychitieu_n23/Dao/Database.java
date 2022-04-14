package com.example.quanlychitieu_n23.Dao;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.quanlychitieu_n23.Entity.Chi;
import com.example.quanlychitieu_n23.Entity.LoaiChi;
import com.example.quanlychitieu_n23.Entity.LoaiThu;
import com.example.quanlychitieu_n23.Entity.Thu;
import com.example.quanlychitieu_n23.Entity.UserEntity;

@androidx.room.Database(entities = {UserEntity.class,LoaiThu.class, LoaiChi.class, Thu.class, Chi.class} ,version = 1,exportSchema = false)
public abstract class Database extends RoomDatabase {
    public abstract LoaiChiDao loaiChiDao();
    public abstract LoaiThuDao loaiThuDao();
    public abstract ThuDao thuDao();
    public abstract ChiDao chiDao();
    public abstract UserDAo userDAo();

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
