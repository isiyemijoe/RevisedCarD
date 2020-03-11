package com.example.revisedcard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.myViewHolder> {
    private Context mContext;
    List<Sport> mData;

    public SportAdapter(Context mContext, List<Sport> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Glide.with(mContext)
                .load(mData.get(position)
                        .getImageResource())
                .into(holder.sportPhoto);

        holder.sportTitle.setText(mData.get(position).getTitle());
        holder.sportInfo.setText(mData.get(position).getInfo());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView sportPhoto;
        TextView sportTitle;
        TextView sportInfo;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            sportInfo = itemView.findViewById(R.id.sport_info_textview);
            sportTitle = itemView.findViewById(R.id.sport_title_text);
            sportPhoto = itemView.findViewById(R.id.sport_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Sport selected = mData.get(getAdapterPosition());
            Intent detailIntent = new Intent(mContext, details_activity.class);

            detailIntent.putExtra("title", selected.getTitle());
            detailIntent.putExtra("image_Resource", selected.getImageResource());
            mContext.startActivity(detailIntent);

        }
    }
}
