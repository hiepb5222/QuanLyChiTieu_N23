package com.example.quanlychitieu_n23.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.lifecycle.Observer;

import com.example.quanlychitieu_n23.Entity.LoaiThu;
import com.example.quanlychitieu_n23.Entity.Thu;
import com.example.quanlychitieu_n23.R;
import com.example.quanlychitieu_n23.adapter.LoaiThuSpinnerAdapter;
import com.example.quanlychitieu_n23.ui.Thu.KhoanThuFragment;
import com.example.quanlychitieu_n23.ui.Thu.KhoanThuViewModel;
import com.example.quanlychitieu_n23.ui.Thu.ThuFragment;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class ThuDialog {
    private KhoanThuViewModel mViewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDialog;

    private TextInputEditText etId,etName,etAmount,etNote;
    private Spinner spType;
    private boolean mEditmode;
    private LoaiThuSpinnerAdapter mAdapter;

    public ThuDialog(final Context context, KhoanThuFragment fragment, Thu ... Thu) {
        mViewModel = fragment.getViewModel();
        mLayoutInflater = LayoutInflater.from(context);
        View view=mLayoutInflater.inflate(R.layout.dialog_thu,null);
        etId= view.findViewById(R.id.etid);
        etName=view.findViewById(R.id.etName);
        etAmount=view.findViewById(R.id.etAmount);
        etNote=view.findViewById(R.id.etNote);
        spType=view.findViewById(R.id.spType);
        mAdapter=new LoaiThuSpinnerAdapter(fragment.getActivity());

        mViewModel.getAllLoaiThu().observe(fragment.getActivity(), new Observer<List<LoaiThu>>() {
            @Override
            public void onChanged(List<LoaiThu>loaiThus) {
                mAdapter.setList(loaiThus);
            }
        });
        spType.setAdapter(mAdapter);
        if(Thu != null&& Thu.length>0) {
            etId.setText(""+Thu[0].tid);
            etName.setText(Thu[0].ten);
            etAmount.setText(""+Thu[0].sotien);
            etNote.setText(Thu[0].ghichu);
            mEditmode=true;
        }
        else {
            mEditmode=false;
        }
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
                        Thu lt=new Thu();
                        lt.ten=etName.getText().toString();
                        lt.sotien=Float.parseFloat(etAmount.getText().toString());
                        lt.ghichu=etNote.getText().toString();
                        lt.ltid=((LoaiThu) mAdapter.getItem(spType.getSelectedItemPosition())).lid;
                        if (mEditmode) {
                            lt.tid=Integer.parseInt(etId.getText().toString());
                            mViewModel.update(lt);
                        }
                        else {
                            mViewModel.insert(lt);
                            Toast.makeText(context, "Loai Thu duoc luu", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                mDialog=builder.create();
    }
    public void show(){
        mDialog.show();
    }
}
