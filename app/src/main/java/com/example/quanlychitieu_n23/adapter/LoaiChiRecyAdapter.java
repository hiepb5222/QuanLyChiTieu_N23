package com.example.quanlychitieu_n23.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlychitieu_n23.Entity.LoaiChi;
import com.example.quanlychitieu_n23.Entity.LoaiThu;
import com.example.quanlychitieu_n23.R;

import java.util.List;

public class LoaiChiRecyAdapter extends RecyclerView.Adapter<LoaiChiRecyAdapter.LoaiChiViewHolder>{
    private LayoutInflater minflater;
    private List<LoaiChi> mlistchi;
    public LoaiChiRecyAdapter(Context context){

        minflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public LoaiChiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = minflater.inflate(R.layout.recyclerview_chi_item,parent,false);
        return new LoaiChiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiChiViewHolder holder, int position) {
        if (mlistchi != null){
            holder.tvName2.setText(mlistchi.get(position).tenLoaiChi);
        }
    }

    @Override
    public int getItemCount() {
        if (mlistchi == null)
        return 0;
        return mlistchi.size();
    }
    public LoaiChi getItem(int postision){
        if(mlistchi==null || postision>= mlistchi.size()){
            return null;
        }
        return mlistchi.get(postision);
    }

    public void setlistchi(List<LoaiChi> mlistchi) {
        this.mlistchi = mlistchi;
        notifyDataSetChanged();
    }

    public static class LoaiChiViewHolder extends RecyclerView.ViewHolder{
        public TextView tvName2;
        public ImageView ivEdit2,ivView2;
        public CardView cv2;
        public LoaiChiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName2= itemView.findViewById(R.id.tvName2);
            ivView2=itemView.findViewById(R.id.ivView2);
            ivEdit2=itemView.findViewById(R.id.ivEdit2);
            cv2=(CardView) itemView;
        }
    }
}
