package com.example.quanlychitieu_n23.ui.Thu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.quanlychitieu_n23.Entity.LoaiThu;
import com.example.quanlychitieu_n23.Entity.Thu;
import com.example.quanlychitieu_n23.Repository.LoaiThuRepository;
import com.example.quanlychitieu_n23.Repository.ThuRepository;

import java.util.List;

public class KhoanThuViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private ThuRepository mThuRepository;
    private LiveData<List<Thu>> mAllThu;
    private LoaiThuRepository mLoaiThuRepository;
    private LiveData<List<LoaiThu>>mAllLoaiThu;
    public KhoanThuViewModel(@NonNull Application application) {
        super(application);
        mThuRepository= new ThuRepository(application);
        mAllThu =mThuRepository.getAllThu();
        mLoaiThuRepository=new LoaiThuRepository(application);
        mAllLoaiThu=mLoaiThuRepository.getAllLoaiThu();
    }
    public LiveData<List<Thu>> getAllThu() {
        return mAllThu;
    }
    public LiveData<List<LoaiThu>> getAllLoaiThu(){
        return mAllLoaiThu;
    }
    public void insert(Thu thu)
    {

        mThuRepository.insert(thu);
    }

    public void delete(Thu thu)
    {
        mThuRepository.delete(thu);
    }

    public void update(Thu thu){
        mThuRepository.update(thu);
    }
}