package com.example.quanlychitieu_n23.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychitieu_n23.Entity.LoaiThu;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.ui.Thu.LoaiThuFragment;
import com.example.quanlychitieu_n23.ui.Thu.LoaiThuViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class LoaiThuDetailDialog {
    private LoaiThuViewModel mViewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDialog;

    private TextView tvid,tvName;
    private boolean mEditmode;

    public LoaiThuDetailDialog(final Context context, LoaiThuFragment fragment, LoaiThu loaiThu) {
        mViewModel = fragment.getViewModel();
        mLayoutInflater = LayoutInflater.from(context);
        View view=mLayoutInflater.inflate(R.layout.dialog_detail_loai_thu,null);
        tvid= view.findViewById(R.id.tvid);
        tvName=view.findViewById(R.id.tvName);
        tvid.setText(""+loaiThu.lid);
        tvName.setText(loaiThu.ten);

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setView(view)
                .setNegativeButton("Dong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mDialog.dismiss();
                    }
                });
                mDialog=builder.create();
    }
    public void show(){
        mDialog.show();
    }
}
