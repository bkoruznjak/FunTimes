package bkoruznjak.from.hr.funtimes.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bkoruznjak.from.hr.funtimes.R;
import bkoruznjak.from.hr.funtimes.network.NetworkConstants;

/**
 * Created by bkoruznjak on 06/12/2016.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListItemViewHolder> {

    private List<ViewModel> list;
    private Context context;

    public ListAdapter(List<ViewModel> list) {
        this.list = list;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent, false);
        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {

        holder.itemTitle.setText(list.get(position).getTitle());
        holder.itemPublishedTime.setText(list.get(position).getPublishedTime());
        holder.itemAbstraction.setText(list.get(position).getAbstraction());

        if (!"".equals(list.get(position).getMediaUrl())) {
            String realUrl = NetworkConstants.IMAGE_URL_PREFIX.concat(list.get(position).getMediaUrl());
            Glide.with(context)
                    .load(realUrl)
                    .centerCrop()
                    .placeholder(R.drawable.img_placeholder)
                    .crossFade()
                    .into(holder.itemImageView);
        } else {
            Glide.with(context)
                    .load(R.drawable.img_placeholder)
                    .crossFade()
                    .into(holder.itemImageView);
        }


    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static class ListItemViewHolder extends RecyclerView.ViewHolder {

        public TextView itemTitle;
        public TextView itemPublishedTime;
        public TextView itemAbstraction;
        public ImageView itemImageView;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            itemTitle = (TextView) itemView.findViewById(R.id.title);
            itemPublishedTime = (TextView) itemView.findViewById(R.id.publishedAt);
            itemAbstraction = (TextView) itemView.findViewById(R.id.articleAbstract);
            itemImageView = (ImageView) itemView.findViewById(R.id.articleImage);

        }
    }
}