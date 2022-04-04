package com.example.quanlychitieu_n23.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.quanlychitieu_n23.Entity.LoaiThu;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.ui.Thu.LoaiThuFragment;
import com.example.quanlychitieu_n23.ui.Thu.LoaiThuViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class LoaiThuDialog {
    private LoaiThuViewModel mViewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDialog;

    private TextInputEditText etId,etName;
    private boolean mEditmode;

    public LoaiThuDialog(final Context context, LoaiThuFragment fragment) {
        mViewModel = fragment.getViewModel();
        mLayoutInflater = LayoutInflater.from(context);
        View view=mLayoutInflater.inflate(R.layout.dialog_loai_thu,null);
        etId= view.findViewById(R.id.etid);
        etName=view.findViewById(R.id.etName);
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setView(view)
                .setNegativeButton("Dong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mDialog.dismiss();
                    }
                })
                .setPositiveButton("Luu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        LoaiThu lt=new LoaiThu();
                        lt.ten=etName.getText().toString();
                        mViewModel.insert(lt);
                        Toast.makeText(context, "Loai Thu duoc luu", Toast.LENGTH_SHORT).show();
                    }
                });
                mDialog=builder.create();
    }
    public void show(){
        mDialog.show();
    }
}
