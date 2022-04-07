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

import com.example.quanlychitieu_n23.Entity.Thu;
import com.example.quanlychitieu_n23.R;

import java.util.List;

public class ThuRecyclerviewAdapter extends RecyclerView.Adapter<ThuRecyclerviewAdapter.ThuViewHolder> {
    private LayoutInflater mLayoutInflater;
    private List<Thu> mList;

    public static ItemClickListener itemEditClickListener;
    public static ItemClickListener itemViewClickListener;

    public ThuRecyclerviewAdapter(Context context) {
        mLayoutInflater=LayoutInflater.from(context);
    }

    public void setOnItemEditClickListener(ItemClickListener itemEditClickListener) {
        ThuRecyclerviewAdapter.itemEditClickListener = itemEditClickListener;
    }

    public void setOnItemViewClickListener(ItemClickListener itemViewClickListener) {
        ThuRecyclerviewAdapter.itemViewClickListener = itemViewClickListener;
    }

    @NonNull
    @Override
    public ThuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =mLayoutInflater.inflate(R.layout.recyclerview_thu_item,parent,false);
        return new ThuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThuViewHolder holder, int position) {
    if(mList !=null)
    {
        holder.tvName.setText(mList.get(position).ten);
        holder.tvAmount.setText(""+mList.get(position).sotien+"Dong");
        holder.position=position;
    }
    }

    @Override
    public int getItemCount() {
        if(mList==null)
        return 0;
        return  mList.size();
    }
    public Thu getItem(int postision){
        if(mList==null || postision>= mList.size()){
            return null;
        }
        return mList.get(postision);
    }
    public void setList(List<Thu>mList)
    {
        this.mList=mList;
        notifyDataSetChanged();
    }

    public static class ThuViewHolder extends RecyclerView.ViewHolder
    {
        public TextView tvName,tvAmount;
        public ImageView ivEdit,ivView;
        public CardView cv;
        public int position;
        public ThuViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName= itemView.findViewById(R.id.tvNameLthu);
            tvAmount=itemView.findViewById(R.id.tvAmount);
            ivView=itemView.findViewById(R.id.ivView);
            ivEdit=itemView.findViewById(R.id.ivEdit);
            cv=(CardView) itemView;

            ivView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(itemViewClickListener !=null){
                        itemViewClickListener.onItemClick(position);
                    }
                }
            });
            ivEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(itemEditClickListener !=null){
                        itemEditClickListener.onItemClick(position);
                    }
                }
            });
        }
    }
}
