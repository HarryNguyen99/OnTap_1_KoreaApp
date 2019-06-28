package com.example.baihoc1.ontap1appkorea.Controller.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.baihoc1.ontap1appkorea.Model.PlaceDetail;
import com.example.baihoc1.ontap1appkorea.Model.PromotionResult;
import com.example.baihoc1.ontap1appkorea.R;
import com.example.baihoc1.ontap1appkorea.interfaces.OnClickSccues;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.PrmotionViewHolder> {
    public Context context;
    public List<PromotionResult> data;
    OnClickSccues onClickSccues;

    public void setContext(Context context, OnClickSccues onClickSccues) {
        this.context = context;
        this.onClickSccues = onClickSccues;
    }

    public void setData(List<PromotionResult> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PrmotionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate
                (R.layout.promotion_intem_layout, viewGroup, false);
        return new PrmotionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrmotionViewHolder prmotionViewHolder, final int i) {
        PromotionResult promotionResult = data.get(i);
        Picasso.get().
                load(promotionResult.getPlaceDetail().getUrlLogoPlace()).
                into(prmotionViewHolder.imgKhachSan);
        prmotionViewHolder.tvNameKS.setText(promotionResult.getPlaceDetail().getPlaceName());
        prmotionViewHolder.tvMotaKS.setText(promotionResult.getPromotionName());
        prmotionViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSccues.onClickSucces(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PrmotionViewHolder extends RecyclerView.ViewHolder {
        ImageView imgKhachSan;
        TextView tvNameKS;
        TextView tvMotaKS;

        public PrmotionViewHolder(@NonNull View itemView) {
            super(itemView);
            imgKhachSan = itemView.findViewById(R.id.img_logo_ks);
            tvNameKS = itemView.findViewById(R.id.tv_name_ks);
            tvMotaKS = itemView.findViewById(R.id.tv_mota_ks);
        }
    }
}
