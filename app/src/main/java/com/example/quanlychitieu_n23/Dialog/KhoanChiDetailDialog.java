package com.example.quanlychitieu_n23.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.quanlychitieu_n23.Entity.Chi;
import com.example.quanlychitieu_n23.Entity.LoaiChi;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.ui.Chi.KhoanChiFragment;
import com.example.quanlychitieu_n23.ui.Chi.KhoanChiViewModel;
import com.example.quanlychitieu_n23.ui.Chi.LoaiChiFragment;
import com.example.quanlychitieu_n23.ui.Chi.LoaiChiViewModel;

public class KhoanChiDetailDialog {
    private KhoanChiViewModel mViewModel22;

    //tét


    private LayoutInflater mLayoutInflater2;
    private AlertDialog mDialog;

    private TextView tvID,tvNamelchi,tvNameChi,tvAmount2,tvGhiChu,tvdate2;
    private boolean mEditmode;

    public KhoanChiDetailDialog(final Context context, KhoanChiFragment fragment, Chi chi)
    {

        mViewModel22 =fragment.getViewModel();
        mLayoutInflater2 = LayoutInflater.from(context);
        View view = mLayoutInflater2.inflate(R.layout.dialog_detail_chi,null);
        tvID =view.findViewById(R.id.tvidChi) ;
        tvNameChi = view.findViewById(R.id.tvNameChi);
        tvNamelchi = view.findViewById(R.id.tvNameLChi);
        tvAmount2 = view.findViewById(R.id.tvAmount2);
        tvGhiChu = view.findViewById(R.id.tvghichu2);
        tvdate2=view.findViewById(R.id.tvDate2);


        tvID.setText(""+chi.chiID);
        tvNameChi.setText(""+chi.ten);
        tvNamelchi.setText(""+chi.idChi);
        tvAmount2.setText(""+chi.soTien);
        tvGhiChu.setText(""+chi.ghiChu);
        tvdate2.setText(""+chi.date);

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setView(view)
                .setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mDialog.dismiss();
                    }
                });

        mDialog= builder.create();

    }
    public  void show(){
        mDialog.show();
    }
}
