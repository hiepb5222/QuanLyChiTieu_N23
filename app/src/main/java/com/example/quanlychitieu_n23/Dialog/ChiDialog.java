package com.example.quanlychitieu_n23.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quanlychitieu_n23.Entity.Chi;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.ui.Chi.KhoanChiFragment;
import com.example.quanlychitieu_n23.ui.Chi.KhoanChiViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class ChiDialog {
    private KhoanChiViewModel mViewModel2;
    private LayoutInflater mLayoutInflater2;
    private AlertDialog mDialog;

    private TextInputEditText etId2,etName2,etAmount,etNote;
    private Spinner spType;
    private boolean mEditmode;

    public ChiDialog(final Context context, KhoanChiFragment fragment, Chi ... chi)
    {
        mEditmode = true;
        mViewModel2 =fragment.getmViewModel();
        mLayoutInflater2 = LayoutInflater.from(context);
        View view = mLayoutInflater2.inflate(R.layout.dialog_chi,null);
        etId2 =view.findViewById(R.id.etid2) ;
        etName2 = view.findViewById(R.id.etName2);
        etAmount= view.findViewById(R.id.tvAmount);
        etNote = view.findViewById(R.id.etNote);


        if(chi != null && chi.length>0){
            etId2.setText(""+chi[0].idChi);
            etName2.setText(chi[0].ten);
            etAmount.setText(""+chi[0].soTien);
            etNote.setText(chi[0].ghiChu);
            mEditmode=true;
        }
        else{
            mEditmode =false;
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
                        Chi lc = new Chi();
                        lc.ten = etName2.getText().toString();
                        lc.soTien = Float.parseFloat(etAmount.getText().toString());
                        lc.ghiChu= etNote.getText().toString();

                        if (mEditmode){
                            lc.chiID =Integer.parseInt(etId2.getText().toString());
                            mViewModel2.update(lc);
                        }else {
                            mViewModel2.insert(lc);
                            Toast.makeText(context,"Đã được lưu",Toast.LENGTH_SHORT).show();
                    }}
                });
        mDialog= builder.create();

    }
    public  void sshow(){
        mDialog.show();
    }
}
