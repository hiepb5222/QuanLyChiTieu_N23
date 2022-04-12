package com.example.quanlychitieu_n23.ui.gioithieu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;


import com.example.quanlychitieu_n23.Dialog.AccDialog;
import com.example.quanlychitieu_n23.Entity.UserEntity;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.adapter.AccRecyclerAdapter;

import com.example.quanlychitieu_n23.adapter.ItemClickListener;

import java.util.List;


public class GioiThieuFragment extends Fragment {
    private RecyclerView mRv;
    private AccRecyclerAdapter madapter;
    private AccoutViewModel mviewModel;



    public static GioiThieuFragment newInstance() {
        return new GioiThieuFragment();
    }
    public AccoutViewModel getMviewModel() {return mviewModel;}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRv = view.findViewById(R.id.recyleAcc);
        madapter = new AccRecyclerAdapter(getActivity());

        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRv.setAdapter(madapter);

        final GioiThieuFragment gioiThieuFragment = this;
        madapter.setOnItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                UserEntity userEntity = madapter.getItem(position);
                AccDialog dialog = new AccDialog(getActivity(),gioiThieuFragment,userEntity);
                dialog.sshow();
            }
        });
        madapter.setOnItemViewListener(new ItemClickListener() {
            @Override
            public void onItemClick(int position) {

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
                        UserEntity lt=madapter.getItem(position);

                        Toast.makeText(getActivity(),"Tài khoản đã được xóa",Toast.LENGTH_SHORT).show();
                        mviewModel.delete(lt);                    }
                }
        );
        helper.attachToRecyclerView(mRv);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gioi_thieu, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mviewModel = new ViewModelProvider(this).get(AccoutViewModel.class);
        mviewModel.getmAlluser().observe(getActivity(), new Observer<List<UserEntity>>() {
            @Override
            public void onChanged(List<UserEntity> userEntities) {
                madapter.setlistuser(userEntities);
            }
        });
    }
}
