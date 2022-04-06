package com.example.quanlychitieu_n23.Dao;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.quanlychitieu_n23.Entity.LoaiChi;
import com.example.quanlychitieu_n23.Entity.LoaiThu;
import com.example.quanlychitieu_n23.Entity.Thu;

@androidx.room.Database(entities = {LoaiThu.class, LoaiChi.class, Thu.class} ,version = 2,exportSchema = false)
public abstract class Database extends RoomDatabase {
    public abstract LoaiChiDao loaiChiDao();
    public abstract LoaiThuDao loaiThuDao();
    public abstract ThuDao thuDao();

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
    public static class Populate extends AsyncTask<Void,Void,Void>{
        private ThuDao thuDao;
        private LoaiThuDao loaiThuDao;
        public Populate(Database db){
            thuDao=db.thuDao();
            loaiThuDao=db.loaiThuDao();

        }
        @Override
        protected Void doInBackground(Void... voids) {
            String [] loaithus=new String[]{"Luong","Thuong","Co phieu"};
            for(String it:loaithus){
                LoaiThu lt=new LoaiThu();
                lt.ten=it;
                loaiThuDao.insert(lt);
            }
            Thu thu=new Thu();
            thu.ten="Luong thang 1";
            thu.sotien=3000;
            thu.ltid=1;
            thu.ghichu="";
            thuDao.insert(thu);
            return null;

        }
    }
}
