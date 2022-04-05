package com.example.quanlychitieu_n23.Dao;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.quanlychitieu_n23.Entity.LoaiChi;

@Database(entities = {LoaiChi.class},version = 2)
public abstract class ChiDataBase extends RoomDatabase{
    public abstract LoaiChiDao loaiChiDao();

    public static ChiDataBase INSTANCE2;
    public static RoomDatabase.Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PoplateDate2(INSTANCE2).execute();
        }
    };

    public static ChiDataBase getInstance(final Context context){
        if (INSTANCE2==null){

            synchronized (ChiDataBase.class){
                INSTANCE2 = Room.databaseBuilder(context.getApplicationContext(),ChiDataBase.class,"Chi_db")
                        .fallbackToDestructiveMigration()
                        .addCallback(callback)
                        .build();
            }
        }
        return  INSTANCE2;
    }
    public static class PoplateDate2 extends AsyncTask<Void,Void,Void>{
        public LoaiChiDao loaiChiDao;

        public PoplateDate2(ChiDataBase db) {loaiChiDao = db.loaiChiDao(); }

        @Override
        protected Void doInBackground(Void... voids) {
            String[] loaichi =new String[]{"Luong","Thuong","Co phieu"};
            for (String it:loaichi){
                LoaiChi lc = new LoaiChi();
                lc.tenLoaiChi = it;
                loaiChiDao.insert(lc);
            }
        return null;
        }
    }
}

