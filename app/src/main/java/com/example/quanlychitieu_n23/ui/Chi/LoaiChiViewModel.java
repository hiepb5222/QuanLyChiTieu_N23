package com.example.quanlychitieu_n23.ui.Chi;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.quanlychitieu_n23.Entity.LoaiChi;
import com.example.quanlychitieu_n23.Repository.LoaiChiRep;

import java.util.List;

public class LoaiChiViewModel extends AndroidViewModel {

    private LoaiChiRep mLoaiChiRep;
    private LiveData<List<LoaiChi>> mallloaichi;
    public LoaiChiViewModel(@NonNull Application application) {
        super(application);
        mLoaiChiRep = new LoaiChiRep(application);
        mallloaichi = mLoaiChiRep.getmAllLoaiChi();
    }

    public LiveData<List<LoaiChi>> getallloaichi() {

        return mallloaichi;
    }

    public void insert2(LoaiChi loaiChi){

        mLoaiChiRep.insert2(loaiChi);
    }
    public void delete2(LoaiChi loaiChi)
    {
        mLoaiChiRep.delete(loaiChi);
    }
}