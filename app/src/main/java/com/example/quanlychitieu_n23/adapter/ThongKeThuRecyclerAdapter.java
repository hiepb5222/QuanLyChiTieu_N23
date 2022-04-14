package com.example.quanlychitieu_n23.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlychitieu_n23.Entity.Thu;
import com.example.quanlychitieu_n23.R;

import java.util.List;

public class ThongKeThuRecyclerAdapter extends RecyclerView.Adapter<ThongKeThuRecyclerAdapter.ThongKeThuViewHolder>{
    private LayoutInflater mLayoutInflater;
    private List<Thu> mList;

    public ThongKeThuRecyclerAdapter(Context context) {
        mLayoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ThongKeThuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.recyclerview_thongke_khoanthu,parent,false);
        return new ThongKeThuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThongKeThuViewHolder holder, int position) {
        if(mList!=null)
        {
            holder.tvDateThu.setText(""+mList.get(position).date);
            holder.tvTenThu.setText(mList.get(position).ten);
            holder.tvTienThu.setText(""+mList.get(position).sotien);
        }
    }

    @Override
    public int getItemCount() {
        if(mList==null)
            return 0;
        return mList.size();
    }
    public void setList(List<Thu> list)
    {
        this.mList=list;
        notifyDataSetChanged();
    }
    public static class ThongKeThuViewHolder extends RecyclerView.ViewHolder{
        public TextView tvDateThu,tvTenThu,tvTienThu;
        public ThongKeThuViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDateThu=itemView.findViewById(R.id.tvDatethongke);
            tvTenThu=itemView.findViewById(R.id.tvTenThu);
            tvTienThu=itemView.findViewById(R.id.tvAmountthongke);
        }
    }
}
