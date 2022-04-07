package com.example.quanlychitieu_n23.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlychitieu_n23.Entity.LoaiChi;
import com.example.quanlychitieu_n23.R;

import java.util.List;

public class ChiSpinnerAdapter extends BaseAdapter {

    private List<LoaiChi> mlist;
    private LayoutInflater mLayoutInf;
    public ChiSpinnerAdapter(Context context){

        mLayoutInf = LayoutInflater.from(context);
    }

    public void setlist(List<LoaiChi> mlist) {
        this.mlist = mlist;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mlist==null){
            return 0;
        }
        return mlist.size();
    }

    @Override
    public Object getItem(int i) {
        if (mlist == null)
            return null;
        return mlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        KhoanChiViewHolder holder;
        if ((view  == null)){
            view= mLayoutInf.inflate(R.layout.spinner_chi_item,null,false);
            holder = new KhoanChiViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (KhoanChiViewHolder) view.getTag();
        }
        holder.tvName.setText(mlist.get(i).tenLoaiChi);
        return view;
    }
    public static class KhoanChiViewHolder {
        public TextView tvName;
        public  KhoanChiViewHolder(View view){
            tvName=view.findViewById(R.id.tvName);
        }
    }
}
