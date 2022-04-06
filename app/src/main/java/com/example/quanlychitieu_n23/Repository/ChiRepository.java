package com.example.quanlychitieu_n23.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.quanlychitieu_n23.Dao.Database;
import com.example.quanlychitieu_n23.Dao.ChiDao;
import com.example.quanlychitieu_n23.Entity.Chi;

import java.util.List;

public class ChiRepository {
    private ChiDao mchiDao;
    private LiveData<List<Chi>> mAllChi;

    public ChiRepository(Application application){
        this.mchiDao = Database.getDatabase(application).chiDao();
        mAllChi = mchiDao.findall();
    }
    public LiveData<List<Chi>> getmAllChi() {
        return mAllChi;
    }
    public void delete(Chi chi){
        new DeleteAsyncTask(mchiDao).execute(chi);
    }
    public void update(Chi chi){
        new UpdateAsyncTask(mchiDao).execute(chi);
    }

    public void insert(Chi chi){
        new InsertAsyncTask(mchiDao).execute(chi);
    }

    //?
    class InsertAsyncTask extends AsyncTask<Chi,Void,Void>{
        private ChiDao mChidao;
        public InsertAsyncTask(ChiDao chiDao){
            this.mChidao= chiDao;
        }

        @Override
        protected Void doInBackground(Chi... Chis) {
            mChidao.insertChi(Chis[0]);
            return null;
        }
    }
    class DeleteAsyncTask extends AsyncTask<Chi,Void,Void>{
        private ChiDao mChiDao;
        public DeleteAsyncTask(ChiDao chiDao)
        {
            this.mChiDao= chiDao;
        }

        @Override
        protected Void doInBackground(Chi... Chis) {
            mChiDao.deleteChi(Chis[0]);
            return null;
        }
    }
    class UpdateAsyncTask extends AsyncTask<Chi,Void,Void>{
        private ChiDao mChiDao;
        public UpdateAsyncTask(ChiDao mchiDao)
        {
            this.mChiDao= mchiDao;
        }

        @Override
        protected Void doInBackground(Chi... Chis) {
            mChiDao.updateChi(Chis[0]);
            return null;
        }
    }
}
