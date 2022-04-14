package com.example.quanlychitieu_n23.ui.Thongke;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.quanlychitieu_n23.Entity.Chi;
import com.example.quanlychitieu_n23.Entity.Thu;
import com.example.quanlychitieu_n23.Repository.ChiRepository;
import com.example.quanlychitieu_n23.Repository.ThuRepository;

import java.util.List;

public class ThongKeKhoanViewModel extends AndroidViewModel {
    private LiveData<List<Thu>> mThongKeThus;
    private ThuRepository mThuRepository;
    private LiveData<List<Chi>> mThongkeChis;
    private ChiRepository mChiRepository;


    public ThongKeKhoanViewModel(@NonNull Application application) {
        super(application);
        mThuRepository=new ThuRepository(application);
        mChiRepository=new ChiRepository(application);
        mThongKeThus=mThuRepository.ThongkeThu();
        mThongkeChis=mChiRepository.Thongkechi();



    }

    public LiveData<List<Thu>> getThongKeThus() {
        return mThongKeThus;
    }

    public LiveData<List<Chi>> getThongkeChis() {
        return mThongkeChis;
    }
}