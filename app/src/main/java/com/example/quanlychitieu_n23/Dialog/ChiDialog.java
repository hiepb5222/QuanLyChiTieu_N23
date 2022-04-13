package com.example.quanlychitieu_n23.Dialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.lifecycle.Observer;

import com.example.quanlychitieu_n23.Entity.Chi;
import com.example.quanlychitieu_n23.Entity.LoaiChi;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.adapter.ChiSpinnerAdapter;
import com.example.quanlychitieu_n23.ui.Chi.KhoanChiFragment;
import com.example.quanlychitieu_n23.ui.Chi.KhoanChiViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.List;

public class ChiDialog {
    private KhoanChiViewModel mViewModel2;
    private LayoutInflater mLayoutInflater2;
    private AlertDialog mDialog;
    DatePickerDialog picker;
    private TextInputEditText etId2,etName2,etAmount,etNote,etDateChi;
    private Spinner spType;
    private boolean mEditmode;
    private ChiSpinnerAdapter adapter;

    public ChiDialog(final Context context, KhoanChiFragment fragment, Chi ... chi)
    {

        mViewModel2 =fragment.getViewModel();
        mLayoutInflater2 = LayoutInflater.from(context);

        View view = mLayoutInflater2.inflate(R.layout.dialog_chi,null);
        etId2 =view.findViewById(R.id.etidDia) ;
        etName2 = view.findViewById(R.id.etNamedia);
        etAmount= view.findViewById(R.id.etAmountDia);
        etNote = view.findViewById(R.id.etNotedia);
        etDateChi=view.findViewById(R.id.etDateChi);
        etDateChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                etDateChi.setText(String.valueOf(dayOfMonth) + "/" + String.valueOf((monthOfYear + 1)) + "/" + String.valueOf(year));
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        spType = view.findViewById(R.id.spType2);
        adapter = new ChiSpinnerAdapter(fragment.getActivity());
        mViewModel2.getmAllloaiChi().observe(fragment.getActivity(), new Observer<List<LoaiChi>>() {
                    @Override
                    public void onChanged(List<LoaiChi> loaiChis) {
                        adapter.setlist(loaiChis);

                    }
                });
                spType.setAdapter(adapter);



        if(chi != null && chi.length>0){
            etId2.setText(""+chi[0].chiID);
            etName2.setText(chi[0].ten);
            etAmount.setText(""+chi[0].soTien);
            etNote.setText(chi[0].ghiChu);
            etDateChi.setText(chi[0].date);
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
                        lc.date=etDateChi.getText().toString();
                        lc.idChi =((LoaiChi) adapter.getItem(spType.getSelectedItemPosition())).tenLoaiChi;
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
