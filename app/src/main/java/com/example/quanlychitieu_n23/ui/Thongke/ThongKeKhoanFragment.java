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

import com.example.quanlychitieu_n23.Entity.Chi;
import com.example.quanlychitieu_n23.Entity.Thu;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.adapter.ThongKeChiRecyclerAdapter;
import com.example.quanlychitieu_n23.adapter.ThongKeThuRecyclerAdapter;

import java.util.List;


public class ThongKeKhoanFragment extends Fragment {

    private ThongKeKhoanViewModel mthongKeKhoanViewModel;
    private RecyclerView rvThongKeThu,rvTongkeChi;
    private ThongKeThuRecyclerAdapter mThongKeThuAdapter;
    private ThongKeChiRecyclerAdapter mThongkeChiAdapter;



    public ThongKeKhoanFragment() {

    }


    public static ThongKeKhoanFragment newInstance(String param1, String param2) {
        ThongKeKhoanFragment fragment = new ThongKeKhoanFragment();
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

        View view= inflater.inflate(R.layout.thong_ke_khoan_fragment, container, false);
        rvThongKeThu=view.findViewById(R.id.rvThongkeThu);
        rvTongkeChi=view.findViewById(R.id.rvThongkeChi);
        mthongKeKhoanViewModel=new ViewModelProvider(this).get(ThongKeKhoanViewModel.class);
        mThongKeThuAdapter=new ThongKeThuRecyclerAdapter(getActivity());
        mThongkeChiAdapter=new ThongKeChiRecyclerAdapter(getActivity());
        rvThongKeThu.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTongkeChi.setLayoutManager(new LinearLayoutManager(getActivity()));

        rvThongKeThu.setAdapter(mThongKeThuAdapter);
        rvTongkeChi.setAdapter(mThongkeChiAdapter);

        mthongKeKhoanViewModel.getThongKeThus().observe(getActivity(), new Observer<List<Thu>>() {
            @Override
            public void onChanged(List<Thu> thongkethus) {
                mThongKeThuAdapter.setList(thongkethus);
            }
        });
        mthongKeKhoanViewModel.getThongkeChis().observe(getActivity(), new Observer<List<Chi>>() {
            @Override
            public void onChanged(List<Chi> thongkechis) {
                mThongkeChiAdapter.setList(thongkechis);
            }
        });


        return view;
    }

}