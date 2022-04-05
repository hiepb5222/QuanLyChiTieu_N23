package com.example.quanlychitieu_n23.Dao;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.quanlychitieu_n23.Entity.LoaiThu;

@Database(entities = {LoaiThu.class},version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LoaiThuDao loaiThuDao();

    public static AppDatabase INSTANCE;
    public static RoomDatabase.Callback callback=new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateData(INSTANCE).execute();
        }
    };

    public static AppDatabase getDatabase(final Context context)
    {
        if(INSTANCE==null)
        {
            synchronized (AppDatabase.class)
            {
                INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class,"personal_db")
                        .fallbackToDestructiveMigration()
                        .addCallback(callback)
                        .build();
            }
        }
        return INSTANCE;
    }
    public static class PopulateData extends AsyncTask<Void,Void,Void>{
        public LoaiThuDao loaiThuDao;

        public PopulateData(AppDatabase db) {
            loaiThuDao= db.loaiThuDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            String[] loaithus =new String[]{"Luong","Thuong","Co phieu"};
            for (String it:loaithus)
            {
                LoaiThu lt=new LoaiThu();
                lt.ten=it;
                loaiThuDao.insert(lt);
            }
            return null;
        }
    }


}
