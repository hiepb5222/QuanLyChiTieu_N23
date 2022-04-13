package com.example.quanlychitieu_n23.ui.Thongke;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.quanlychitieu_n23.Entity.ThongKeLoaiChi;
import com.example.quanlychitieu_n23.Entity.ThongKeLoaiThu;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.adapter.ThongKeLoaiChiRecyclerViewAdapter;
import com.example.quanlychitieu_n23.adapter.ThongKeLoaiThuRecyclerViewAdapter;

import java.util.List;

public class ThongkeFragment extends Fragment {
    private ThongKeViewModel mThongKeViewModel;
    private EditText mEtTongThu,mEtTongChi;
    private RecyclerView rvThongKeLoaiChi;
    private RecyclerView rvThongKeLoaiThu;
    private ThongKeLoaiThuRecyclerViewAdapter mThongKeLoaiThuAdapter;
    private ThongKeLoaiChiRecyclerViewAdapter mThongKeLoaiChiAdapter;



    public ThongkeFragment() {

    }

    public static ThongkeFragment newInstance() {
        ThongkeFragment fragment = new ThongkeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_thongke, container, false);
       mEtTongThu=view.findViewById(R.id.etTongThu);
       mEtTongChi=view.findViewById(R.id.etTongChi);

       rvThongKeLoaiChi=view.findViewById(R.id.rvThongKeLoaiChi);
       rvThongKeLoaiThu=view.findViewById(R.id.rvThongKeLoaiThu);

        mThongKeViewModel=new ViewModelProvider(this).get(ThongKeViewModel.class);
        mThongKeLoaiChiAdapter=new ThongKeLoaiChiRecyclerViewAdapter(getActivity());
        mThongKeLoaiThuAdapter=new ThongKeLoaiThuRecyclerViewAdapter(getActivity());
        rvThongKeLoaiChi.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvThongKeLoaiThu.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvThongKeLoaiThu.setAdapter(mThongKeLoaiThuAdapter);
        rvThongKeLoaiChi.setAdapter(mThongKeLoaiChiAdapter);

        mThongKeViewModel.getTongChi().observe(getActivity(), new Observer<Float>() {
            @Override
            public void onChanged(Float tongChi) {
                mEtTongChi.setText(""+tongChi);
            }
        });
        mThongKeViewModel.getTongThu().observe(getActivity(), new Observer<Float>() {
            @Override
            public void onChanged(Float tong) {
                mEtTongThu.setText(""+tong);
            }
        });
        mThongKeViewModel.getThongKeLoaiChis().observe(getActivity(), new Observer<List<ThongKeLoaiChi>>() {
            @Override
            public void onChanged(List<ThongKeLoaiChi> thongKeLoaiChis) {
                mThongKeLoaiChiAdapter.setList(thongKeLoaiChis);
            }
        });
        mThongKeViewModel.getThongKeLoaiThus().observe(getActivity(), new Observer<List<ThongKeLoaiThu>>() {
            @Override
            public void onChanged(List<ThongKeLoaiThu> thongKeLoaiThus) {
                mThongKeLoaiThuAdapter.setList(thongKeLoaiThus);
            }
        });
        return view;
    }
}