package com.example.quanlychitieu_n23.Repository;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.quanlychitieu_n23.Dao.Database;
import com.example.quanlychitieu_n23.Dao.LoaiThuDao;
import com.example.quanlychitieu_n23.Entity.LoaiThu;

import java.util.List;


public class LoaiThuRepository {
    private LoaiThuDao mLoaiThuDao;
    private LiveData<List<LoaiThu>> mAllLoaiThu;

    public LoaiThuRepository(Application application) {
        this.mLoaiThuDao = Database.getDatabase(application).loaiThuDao();
        mAllLoaiThu=mLoaiThuDao.findall();
    }
    public LiveData<List<LoaiThu>> getAllLoaiThu()
    {
        return mAllLoaiThu;
    }
    public void insert(LoaiThu loaiThu){
        new InsertAsyncTask(mLoaiThuDao).execute(loaiThu);
    }
    public void delete(LoaiThu loaiThu){
        new DeleteAsyncTask(mLoaiThuDao).execute(loaiThu);
    }
    class InsertAsyncTask extends AsyncTask<LoaiThu,Void,Void>{
        private LoaiThuDao mLoaiThuDao;
        public InsertAsyncTask(LoaiThuDao loaiThuDao)
        {
            this.mLoaiThuDao= loaiThuDao;
        }
        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mLoaiThuDao.insert(loaiThus[0]);
            return null;
        }
    }

    class DeleteAsyncTask extends AsyncTask<LoaiThu,Void,Void>{
        private LoaiThuDao mLoaiThuDao;
        public DeleteAsyncTask(LoaiThuDao loaiThuDao)
        {
            this.mLoaiThuDao= loaiThuDao;
        }
        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mLoaiThuDao.delete(loaiThus[0]);
            return null;
        }
    }

}
