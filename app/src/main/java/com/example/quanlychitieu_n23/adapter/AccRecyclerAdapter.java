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
import com.example.quanlychitieu_n23.Entity.UserEntity;
import com.example.quanlychitieu_n23.R;

import java.util.List;

public class AccRecyclerAdapter extends RecyclerView.Adapter<AccRecyclerAdapter.AccViewHolder> {
    private LayoutInflater minflater;
    private List<UserEntity> mlistuser;

    public static ItemClickListener itemClickListener;
    public static ItemClickListener itemViewListener;

    public AccRecyclerAdapter(Context context) {

        minflater = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener) {
        AccRecyclerAdapter.itemClickListener = itemClickListener;
    }



    @NonNull
    @Override
    public AccViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = minflater.inflate(R.layout.recyclerview_accout,parent,false);
        return new AccViewHolder(view);
    }
    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull AccRecyclerAdapter.AccViewHolder holder, int position) {
        if (mlistuser != null){
            holder.tvNameAcc.setText(mlistuser.get(position).getUserID());
            holder.pos = position;
        }
    }

    @Override
    public int getItemCount() {
        if (mlistuser == null)
            return 0;
        return mlistuser.size();
    }
    public UserEntity getItem(int postision){
        if(mlistuser==null || postision>= mlistuser.size()){
            return null;
        }
        return mlistuser.get(postision);
    }
    public void setlistuser(List<UserEntity> mlistuser) {
        this.mlistuser = mlistuser;
        notifyDataSetChanged();
    }

    public static class AccViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNameAcc;
        public ImageView ivEdit, ivView;
        public CardView cv2;
        public int pos;

        public AccViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameAcc = itemView.findViewById(R.id.tvNameAcc);
                        ivEdit = itemView.findViewById(R.id.ivEdit);

            cv2 = (CardView) itemView;
//            ivView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (itemViewListener != null) {
//                        itemViewListener.onItemClick(pos);
//                    }
//                }
//            });
            ivEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(pos);
                    }
                }
            });
        }
    }
}
