package com.example.quanlychitieu_n23.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlychitieu_n23.Entity.Chi;
import com.example.quanlychitieu_n23.R;

import java.util.List;

public class ChiRecyAdapter extends RecyclerView.Adapter<ChiRecyAdapter.ChiViewHolder>{
    private LayoutInflater minflater;
    private List<Chi> mlistchi;

    public static ItemClickListener itemClickListener;
    public static ItemClickListener itemViewListener;



    public ChiRecyAdapter(Context context){

        minflater = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener) {
        ChiRecyAdapter.itemClickListener = itemClickListener;
    }

    public void setOnItemViewListener(ItemClickListener itemViewListener) {
        ChiRecyAdapter.itemViewListener = itemViewListener;

    }

    @NonNull
    @Override
    public ChiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = minflater.inflate(R.layout.recyclerview_chi_item,parent,false);
        return new ChiViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ChiViewHolder holder, int position) {
        if (mlistchi != null){
            holder.tvName2.setText(mlistchi.get(position).ten);
            holder.tvAmount.setText(""+mlistchi.get(position).soTien+" Đồng");
            holder.pos = position;
        }
    }

    @Override
    public int getItemCount() {
        if (mlistchi == null)
        return 0;
        return mlistchi.size();
    }
    public Chi getItem(int postision){
        if(mlistchi==null || postision>= mlistchi.size()){
            return null;
        }
        return mlistchi.get(postision);
    }

    public void setlistchi(List<Chi> mlistchi) {
        this.mlistchi = mlistchi;
        notifyDataSetChanged();
    }

    public static class ChiViewHolder extends RecyclerView.ViewHolder{
        public TextView tvName2,tvAmount;
        public ImageView ivEdit2,ivView2;
        public CardView cv2;

        public int pos;
        public ChiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName2= itemView.findViewById(R.id.tvName);
            ivView2=itemView.findViewById(R.id.ivView);
            ivEdit2=itemView.findViewById(R.id.ivEdit);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            cv2=(CardView) itemView;
            ivView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(itemViewListener != null){
                        itemViewListener.onItemClick(pos);
                    }
                }
            });
            ivEdit2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(itemClickListener != null){
                        itemClickListener.onItemClick(pos);
                    }
                }
            });
        }
    }
}
