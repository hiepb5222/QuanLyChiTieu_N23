package com.example.quanlychitieu_n23.ui.Chi;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.quanlychitieu_n23.Entity.Chi;
import com.example.quanlychitieu_n23.Repository.ChiRepository;

import java.util.List;

public class KhoanChiViewModel extends AndroidViewModel {
    private ChiRepository mChiRepository;
    private LiveData<List<Chi>> mallchi;

    public KhoanChiViewModel(@NonNull Application application) {
        super(application);
        mChiRepository = new ChiRepository(application);
        mallchi = mChiRepository.getmAllChi();
    }

    public LiveData<List<Chi>> getallchi() {

        return mallchi;
    }

    public void insert(Chi chi){

        mChiRepository.insert(chi);
    }
    public void delete(Chi chi)
    {
        mChiRepository.delete(chi);
    }
    public void update(Chi chi)
    {
        mChiRepository.update(chi);
    }
}