package com.example.quanlychitieu_n23.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import com.example.quanlychitieu_n23.Entity.Thu;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.ui.Thu.KhoanThuFragment;
import com.example.quanlychitieu_n23.ui.Thu.KhoanThuViewModel;



public class ThuDetailDialog {
    private KhoanThuViewModel mViewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDialog;

    private TextView tvidThu,tvNamelThu,tvNameThu,tvAmount,tvGhichu,tvdate1;
    private boolean mEditmode;

    public ThuDetailDialog(final Context context, KhoanThuFragment fragment, Thu Thu) {
        mViewModel = fragment.getViewModel();
        mLayoutInflater = LayoutInflater.from(context);
        View view=mLayoutInflater.inflate(R.layout.dialog_detail_khoan_thu,null);
        tvidThu= view.findViewById(R.id.tvidThu);
        tvNamelThu=view.findViewById(R.id.tvNameLThu);
        tvNameThu=view.findViewById(R.id.tvNameThu);
        tvAmount=view.findViewById(R.id.tvAmount);
        tvGhichu=view.findViewById(R.id.tvghichu);
        tvdate1=view.findViewById(R.id.tvDate1);

        tvidThu.setText(""+Thu.tid);
        tvNamelThu.setText(""+Thu.ltid);
        tvNameThu.setText(Thu.ten);
        tvAmount.setText(""+Thu.sotien);
        tvGhichu.setText(Thu.ghichu);
        tvdate1.setText(Thu.date);

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setView(view)
                .setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
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
