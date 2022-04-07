package com.example.quanlychitieu_n23.ui.Thongke;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.quanlychitieu_n23.Entity.ThongKeLoaiChi;
import com.example.quanlychitieu_n23.Entity.ThongKeLoaiThu;
import com.example.quanlychitieu_n23.Repository.ChiRepository;
import com.example.quanlychitieu_n23.Repository.ThuRepository;

import java.util.List;

public class ThongKeViewModel extends AndroidViewModel {

    private ThuRepository mThuRepository;
    private LiveData<Float> mTongThu;
    private ChiRepository mChiRepository;
    private LiveData<Float>mTongChi;
    private LiveData<List<ThongKeLoaiThu>> mThongKeLoaiThus;
    private LiveData<List<ThongKeLoaiChi>> mThongKeLoaiChis;

    public ThongKeViewModel(@NonNull Application application) {
        super(application);

        mThuRepository=new ThuRepository(application);
        mTongThu=mThuRepository.sumTongThu();
        mThongKeLoaiThus=mThuRepository.sumbyLoaiThu();

        mChiRepository=new ChiRepository(application);
        mTongChi=mChiRepository.sumTongChi();
        mThongKeLoaiChis=mChiRepository.sumbyLoaiChi();
    }

    public LiveData<Float> getTongThu() {
        return mTongThu;
    }
    public LiveData<Float> getTongChi() {
        return mTongChi;
    }

    public LiveData<List<ThongKeLoaiChi>> getThongKeLoaiChis() {
        return mThongKeLoaiChis;
    }
    public LiveData<List<ThongKeLoaiThu>> getThongKeLoaiThus() {
        return mThongKeLoaiThus;
    }
}
