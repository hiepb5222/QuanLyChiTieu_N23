package com.example.quanlychitieu_n23.ui.gioithieu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.quanlychitieu_n23.Entity.Chi;
import com.example.quanlychitieu_n23.Entity.LoaiChi;
import com.example.quanlychitieu_n23.Entity.UserEntity;
import com.example.quanlychitieu_n23.Repository.ChiRepository;
import com.example.quanlychitieu_n23.Repository.LoaiChiRep;
import com.example.quanlychitieu_n23.Repository.UserRepository;

import java.util.List;

public class AccoutViewModel extends AndroidViewModel {
    private UserRepository mUserRepository;


    private LiveData<List<UserEntity>> mAlluser;
    public AccoutViewModel(@NonNull Application application) {
        super(application);
        mUserRepository = new UserRepository(application);
        mAlluser = mUserRepository.getmAlluser();

    }
    public LiveData<List<UserEntity>> getmAlluser(){return mAlluser;}
    public void delete(UserEntity userEntity){

        mUserRepository.delete(userEntity);
    }

    public void update(UserEntity userEntity)
    {
        mUserRepository.update(userEntity);
    }
}
