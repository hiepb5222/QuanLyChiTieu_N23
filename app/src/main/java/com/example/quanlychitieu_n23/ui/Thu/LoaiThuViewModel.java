package com.example.quanlychitieu_n23.ui.Thu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.quanlychitieu_n23.Dao.LoaiThuDao;
import com.example.quanlychitieu_n23.Entity.LoaiThu;
import com.example.quanlychitieu_n23.Repository.LoaiThuRepository;

import java.util.List;

public class LoaiThuViewModel extends AndroidViewModel {
    private LoaiThuRepository mLoaiThuRepository;
    private LiveData<List<LoaiThu>> mAllLoaiThu;
    public LoaiThuViewModel(@NonNull Application application) {
        super(application);
        mLoaiThuRepository= new LoaiThuRepository(application);
        mAllLoaiThu =mLoaiThuRepository.getAllLoaiThu();
    }
    public LiveData<List<LoaiThu>> getAllLoaiThu() {
        return mAllLoaiThu;
    }
    public void insert(LoaiThu loaiThu)
    {
        mLoaiThuRepository.insert(loaiThu);
    }
    // TODO: Implement the ViewModel
    public void delete(LoaiThu loaiThu)
    {
        mLoaiThuRepository.delete(loaiThu);
    }
}