package com.example.quanlychitieu_n23.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;


import com.example.quanlychitieu_n23.Dao.Database;
import com.example.quanlychitieu_n23.Dao.LoaiChiDao;
import com.example.quanlychitieu_n23.Entity.LoaiChi;

import java.util.List;

public class LoaiChiRep {
    private LoaiChiDao loaiChiDao;
    private LiveData<List<LoaiChi>> mAllLoaiChi;

    public LoaiChiRep (Application application){
        this.loaiChiDao = Database.getDatabase(application).loaiChiDao();
        mAllLoaiChi = loaiChiDao.findall();
    }
    public LiveData<List<LoaiChi>> getmAllLoaiChi() {
        return mAllLoaiChi;
    }
    public void insert2(LoaiChi loaiChi){
        new InsertAsyncTask2(loaiChiDao).execute(loaiChi);
    }
    class InsertAsyncTask2 extends AsyncTask<LoaiChi,Void,Void>{
        private LoaiChiDao mLoaichidao;
        public InsertAsyncTask2(LoaiChiDao loaiChiDao){
            this.mLoaichidao= loaiChiDao;
        }

        @Override
        protected Void doInBackground(LoaiChi... loaiChis) {
            mLoaichidao.insertChi(loaiChis[0]);
            return null;
        }
    }
}
