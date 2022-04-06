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

import com.example.quanlychitieu_n23.Dao.LoaiChiDao;
import com.example.quanlychitieu_n23.Dialog.LoaiChiDialog;
import com.example.quanlychitieu_n23.Entity.LoaiChi;
import com.example.quanlychitieu_n23.Entity.LoaiThu;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.adapter.ItemClickListener;
import com.example.quanlychitieu_n23.adapter.LoaiChiRecyAdapter;

import java.util.List;

public class LoaiChiFragment extends Fragment {
    private RecyclerView recyclerView;
    private LoaiChiRecyAdapter adapter2;
    private LoaiChiViewModel mViewModel2;


    public static LoaiChiFragment newInstance() {
        return new LoaiChiFragment();
    }

    public LoaiChiViewModel getmViewModel2(){return mViewModel2; }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.loai_chi_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.Recyle2);
        adapter2 = new LoaiChiRecyAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter2);

        final LoaiChiFragment chiFragment = this;

        adapter2.setOnItemClickListener(new ItemClickListener() {

            @Override
            public void onItemClick(int position) {
                LoaiChi loaiChi =adapter2.getItem(position);
                LoaiChiDialog dialog = new LoaiChiDialog(getActivity(),chiFragment, loaiChi);
                dialog.sshow();
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
                        LoaiChi lt=adapter2.getItem(position);

                        Toast.makeText(getActivity(),"Loại Chi đã được xóa",Toast.LENGTH_SHORT).show();
                        mViewModel2.delete2(lt);
                    }
                }
        );
        helper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel2 = new ViewModelProvider(this).get(LoaiChiViewModel.class);
        // TODO: Use the ViewModel
        mViewModel2.getallloaichi().observe(getActivity(), new Observer<List<LoaiChi>>() {
            @Override
            public void onChanged(List<LoaiChi> loaiChis) {
                adapter2.setlistchi(loaiChis);
            }
        });
    }

}