package com.example.quanlychitieu_n23.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychitieu_n23.Entity.LoaiChi;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.ui.Chi.LoaiChiFragment;
import com.example.quanlychitieu_n23.ui.Chi.LoaiChiViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class LoaiChiDetailDialog {
    private LoaiChiViewModel mViewModel2;
    private LayoutInflater mLayoutInflater2;
    private AlertDialog mDialog;

    private TextView tvID,tvName;
    private boolean mEditmode;

    public LoaiChiDetailDialog(final Context context, LoaiChiFragment fragment, LoaiChi loaiChi)
    {
        mViewModel2 =fragment.getmViewModel2();
        mLayoutInflater2 = LayoutInflater.from(context);
        View view = mLayoutInflater2.inflate(R.layout.dialog_detail_loai_chi,null);
        tvID =view.findViewById(R.id.tvIDchi) ;
        tvName = view.findViewById(R.id.tvNameChi);

        tvID.setText(""+loaiChi.idChi);
        tvName.setText(loaiChi.tenLoaiChi);

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
