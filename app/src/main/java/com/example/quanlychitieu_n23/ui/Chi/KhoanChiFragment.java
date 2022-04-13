package com.example.quanlychitieu_n23.ui.Chi;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quanlychitieu_n23.Dialog.ChiDialog;
import com.example.quanlychitieu_n23.Dialog.KhoanChiDetailDialog;
import com.example.quanlychitieu_n23.Dialog.LoaiChiDetailDialog;
import com.example.quanlychitieu_n23.Dialog.LoaiChiDialog;
import com.example.quanlychitieu_n23.Entity.Chi;
import com.example.quanlychitieu_n23.Entity.LoaiChi;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.adapter.ChiRecyAdapter;
import com.example.quanlychitieu_n23.adapter.ItemClickListener;
import com.example.quanlychitieu_n23.adapter.LoaiChiRecyAdapter;

import java.util.List;

public class KhoanChiFragment extends Fragment {

    private KhoanChiViewModel mViewModel;
    private RecyclerView mRv;
    private ChiRecyAdapter mAdapter;

    public static KhoanChiFragment newInstance() {
        return new KhoanChiFragment();
    }

    public KhoanChiViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRv = view.findViewById(R.id.recyChi);
        mAdapter = new ChiRecyAdapter(getActivity());

        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRv.setAdapter(mAdapter);


        final KhoanChiFragment khoanChiFragment = this;

        mAdapter.setOnItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Chi Chi =mAdapter.getItem(position);
                ChiDialog dialog = new ChiDialog(getActivity(),khoanChiFragment, Chi);
                dialog.sshow();
            }
        });
        mAdapter.setOnItemViewListener(new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Chi Chi =mAdapter.getItem(position);

                KhoanChiDetailDialog dialog = new KhoanChiDetailDialog(getActivity(),khoanChiFragment, Chi);
                dialog.show();
            }
        });



        ItemTouchHelper helper=new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT
                ) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                        int position =viewHolder.getAdapterPosition();
                        Chi lt=mAdapter.getItem(position);

                        Toast.makeText(getActivity(),"Loại Chi đã được xóa",Toast.LENGTH_SHORT).show();
                        mViewModel.delete(lt);
                    }
                }
        );
        helper.attachToRecyclerView(mRv);



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