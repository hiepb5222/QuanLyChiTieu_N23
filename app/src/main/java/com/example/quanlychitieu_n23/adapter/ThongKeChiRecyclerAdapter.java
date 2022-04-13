package com.example.quanlychitieu_n23.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlychitieu_n23.Entity.Chi;
import com.example.quanlychitieu_n23.Entity.Thu;
import com.example.quanlychitieu_n23.R;

import java.util.List;

public class ThongKeChiRecyclerAdapter extends RecyclerView.Adapter<ThongKeChiRecyclerAdapter.ThongKeChiViewHolder>{
    private LayoutInflater mLayoutInflater;
    private List<Chi> mList;

    public ThongKeChiRecyclerAdapter(Context context) {
        mLayoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ThongKeChiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.recyclerview_thongke_khoanchi,parent,false);
        return new ThongKeChiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThongKeChiViewHolder holder, int position) {
        if(mList!=null)
        {
            holder.tvDatechi.setText(""+mList.get(position).date);
            holder.tvTenchi.setText(mList.get(position).ten);
            holder.tvTienchi.setText(""+mList.get(position).soTien);
        }
    }

    @Override
    public int getItemCount() {
        if(mList==null)
            return 0;
        return mList.size();
    }
    public void setList(List<Chi> list)
    {
        this.mList=list;
        notifyDataSetChanged();
    }
    public static class ThongKeChiViewHolder extends RecyclerView.ViewHolder{
        public TextView tvDatechi,tvTenchi,tvTienchi;
        public ThongKeChiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDatechi=itemView.findViewById(R.id.tvDatethongkechi);
            tvTenchi=itemView.findViewById(R.id.tvTenchi);
            tvTienchi=itemView.findViewById(R.id.tvAmountthongkechi);
        }
    }
}
