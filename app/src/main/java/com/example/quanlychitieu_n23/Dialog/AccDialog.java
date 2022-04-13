package com.example.quanlychitieu_n23.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychitieu_n23.Entity.UserEntity;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.ui.TaiKhoan.AccoutViewModel;
import com.example.quanlychitieu_n23.ui.TaiKhoan.AccoutFragment;

public class AccDialog {
    private AccoutViewModel viewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDialog;


    private EditText etPass;
    private TextView etNameAcc;
    private boolean mEditmode;

    public AccDialog(final Context context, AccoutFragment fragment, UserEntity... userEntities) {
        viewModel = fragment.getMviewModel();
        mLayoutInflater = LayoutInflater.from(context);

        View view = mLayoutInflater.inflate(R.layout.dialog_acc, null);

        etNameAcc = view.findViewById(R.id.etNameAccout);
        etPass = view.findViewById(R.id.etPass);

        if (userEntities != null && userEntities.length > 0) {
            etNameAcc.setText("" + userEntities[0].getUserID());
            etPass.setText(""+ userEntities[0].getPassword());
            mEditmode = true;
        } else {
            mEditmode = false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setView(view)
                .setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mDialog.dismiss();
                    }
                })
                .setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        UserEntity lc = new UserEntity();
                        lc.setPassword(etPass.getText().toString());
                        if (mEditmode) {
                            lc.setUserID(etNameAcc.getText().toString());
                            viewModel.update(lc);
                            Toast.makeText(context, "Thay đổi thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            lc.setUserID(etNameAcc.getText().toString());
                            viewModel.update(lc);
                            Toast.makeText(context, "Thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        mDialog = builder.create();

    }

    public void sshow() {
        mDialog.show();
    }
}
