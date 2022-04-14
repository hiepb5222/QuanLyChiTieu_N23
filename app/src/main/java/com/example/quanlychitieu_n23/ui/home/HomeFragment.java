package com.example.quanlychitieu_n23.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransactionKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.example.quanlychitieu_n23.Dao.ChiDao;
import com.example.quanlychitieu_n23.Dao.Database;
import com.example.quanlychitieu_n23.Dao.ThuDao;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.ui.Thongke.ThongkeFragment;
import com.example.quanlychitieu_n23.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private TextView a,gotothongke;
    private ImageView b;
    Database database;
    private int check =0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        database = Database.getDatabase(getContext());
        ThuDao thuDao = database.thuDao();
        ChiDao chiDao = database.chiDao();

        Float tongThu1 = thuDao.sumTongThu1();
        Float tongChi1 = chiDao.sumTongChi1();
        Float Sodu = tongThu1 -tongChi1;

        a = view.findViewById(R.id.sotiencon);

        if (Sodu>0){
            a.setText(Sodu.toString()+" đ");
        }else
        {
            a.setText("Tài khoản của bạn âm :<");
        }

        b = view.findViewById(R.id.imageVieweye);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check==0){
                    a.setText("******");
                    check = 1;
                }
                else {
                    if (Sodu>0){
                        a.setText(Sodu.toString()+" đ");
                        check = 0;
                    }else
                    {
                        a.setText("Tài khoản của bạn âm :<");
                        check = 0;
                    }
                }
            }
        });

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}