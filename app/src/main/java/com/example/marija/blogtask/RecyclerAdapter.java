package com.example.marija.blogtask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marija.blogtask.model.BlogItem;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

/**
 * Created by Marija on 23/5/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<BlogItem> items;
    private PostItemListener listener;
    Context mContext;



    interface PostItemListener{
        void onPostClick(long id);
    }

    public RecyclerAdapter(Context context, List<BlogItem> items, PostItemListener postItemListener){
        mContext = context;
        this.items = items;
        listener = postItemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView text, description;
        ImageView image;
        PostItemListener listener;
        public ViewHolder(View itemView, PostItemListener listener) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            image = (ImageView) itemView.findViewById(R.id.image);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            BlogItem item = items.get(getAdapterPosition());
            this.listener.onPostClick(item.getId());
//            notifyDataSetChanged();
        }
    }
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, this.listener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        BlogItem item = items.get(position);
        TextView text = holder.text;
        text.setText(item.getTitle());
        TextView desc = holder.description;
        desc.setText(Html.fromHtml(item.getDescription()));
        ImageView img = holder.image;
        Picasso.with(mContext)
                .load(item.getImageUrl())
                .into(img);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateDisplayed(List<BlogItem> items){
        this.items = items;
        notifyDataSetChanged();
    }

}
