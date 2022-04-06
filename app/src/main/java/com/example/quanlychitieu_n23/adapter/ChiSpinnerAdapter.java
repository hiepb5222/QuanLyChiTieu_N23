package com.example.quanlychitieu_n23.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlychitieu_n23.Entity.Chi;
import com.example.quanlychitieu_n23.R;

import java.util.List;

public class ChiSpinnerAdapter extends BaseAdapter {
    private List<Chi> mlist;
    private LayoutInflater mLayoutInf;
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
    public static class KhoanChiViewHolder {
        public TextView tvName;
        public  KhoanChiViewHolder(View view){
            tvName=view.findViewById(R.id.tvName);
        }
    }
}
