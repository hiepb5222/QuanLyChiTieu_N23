package com.example.quanlychitieu_n23.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.quanlychitieu_n23.Entity.LoaiChi;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.ui.Chi.LoaiChiViewModel;
import com.example.quanlychitieu_n23.ui.Chi.LoaiChiFragment;

import com.google.android.material.textfield.TextInputEditText;

public class LoaiChiDialog {
    private LoaiChiViewModel mViewModel2;
    private LayoutInflater mLayoutInflater2;
    private AlertDialog mDialog;

    private TextInputEditText etId2,etName2;
    private boolean mEditmode;

    public LoaiChiDialog(final Context context,LoaiChiFragment fragment)
    {
        mViewModel2 =fragment.getmViewModel2();
        mLayoutInflater2 = LayoutInflater.from(context);
        View view = mLayoutInflater2.inflate(R.layout.dialog_loai_chi,null);
        etId2 =view.findViewById(R.id.etid2) ;
        etName2 = view.findViewById(R.id.etName2);
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setView(view)
                .setNegativeButton("Dong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mDialog.dismiss();
                    }
                })
                .setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        LoaiChi lc = new LoaiChi();
                        lc.tenLoaiChi = etName2.getText().toString();
                        mViewModel2.insert2(lc);
                        Toast.makeText(context,"Đã được lưu",Toast.LENGTH_SHORT).show();
                    }
                });
        mDialog= builder.create();

    }
    public  void sshow(){
        mDialog.show();
    }
}
