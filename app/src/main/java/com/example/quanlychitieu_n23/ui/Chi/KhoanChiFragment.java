package com.example.quanlychitieu_n23.ui.Chi;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanlychitieu_n23.Entity.Chi;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.adapter.ChiRecyAdapter;

import java.util.List;

public class KhoanChiFragment extends Fragment {

    private KhoanChiViewModel mViewModel;
    private RecyclerView mRv;
    private ChiRecyAdapter mAdapter;

    public static KhoanChiFragment newInstance() {
        return new KhoanChiFragment();
    }

    public KhoanChiViewModel getmViewModel() {
        return mViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRv = view.findViewById(R.id.recyChi);
        mAdapter = new ChiRecyAdapter(getActivity());
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRv.setAdapter(mAdapter);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.khoan_chi_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(KhoanChiViewModel.class);
        mViewModel.getallchi().observe(getActivity(), new Observer<List<Chi>>() {
            @Override
            public void onChanged(List<Chi> chis) {
                mAdapter.setlistchi(chis);
            }
        });
    }

}