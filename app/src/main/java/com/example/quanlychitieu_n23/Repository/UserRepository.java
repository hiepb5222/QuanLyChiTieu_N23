package com.example.quanlychitieu_n23.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.quanlychitieu_n23.Dao.ChiDao;
import com.example.quanlychitieu_n23.Dao.Database;
import com.example.quanlychitieu_n23.Dao.UserDAo;
import com.example.quanlychitieu_n23.Dao.Database;
import com.example.quanlychitieu_n23.Entity.Chi;
import com.example.quanlychitieu_n23.Entity.UserEntity;

import java.util.List;

public class UserRepository {
    private UserDAo muserdao;
    private LiveData<List<UserEntity>> mAlluser;

    public UserRepository(Application application){
        this.muserdao = Database.getDatabase(application).userDAo();
        mAlluser = muserdao.findall();
    }
    public LiveData<List<UserEntity>> getmAlluser() {
        return mAlluser;
    }
    public void delete(UserEntity userEntity){
        new DeleteAsyncTask(muserdao).execute(userEntity);
    }
    public void update(UserEntity userEntity){
        new UpdateAsyncTask(muserdao).execute(userEntity);
    }
    class DeleteAsyncTask extends AsyncTask<UserEntity,Void,Void> {
        private UserDAo muserdao;
        public DeleteAsyncTask(UserDAo userDAo)
        {
            this.muserdao = userDAo;
        }
        @Override
        protected Void doInBackground(UserEntity... userEntities) {
            muserdao.delete(userEntities[0]);
            return null;
        }
    }
    class UpdateAsyncTask extends AsyncTask<UserEntity,Void,Void>{
        private UserDAo muserdao;
        public UpdateAsyncTask(UserDAo userDAo)
        {
            this.muserdao= userDAo;
        }

        @Override
        protected Void doInBackground(UserEntity... userEntities) {
            muserdao.update(userEntities[0]);
            return null;
        }
    }

}
