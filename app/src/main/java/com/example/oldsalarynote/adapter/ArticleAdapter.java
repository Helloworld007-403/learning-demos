package com.example.oldsalarynote.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oldsalarynote.R;
import com.example.oldsalarynote.data.Article;

public class ArticleAdapter extends ListAdapter<Article,ArticleAdapter.VH> {
    public interface OnItemClick{
        void onItemClick(Article article);
    }

    private final OnItemClick listener;

    private static final DiffUtil.ItemCallback<Article> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Article>() {
                @Override
                public boolean areItemsTheSame(@NonNull Article oldItem, @NonNull Article newItem) {
                    return oldItem.id == newItem.id;
                }
                @Override
                public boolean areContentsTheSame(@NonNull Article oldItem, @NonNull Article newItem) {
                    return oldItem.title.equals(newItem.title)
                            && oldItem.summary.equals(newItem.summary);
                }
            };

    public ArticleAdapter(OnItemClick listener) {
        super(DIFF_CALLBACK);
        this.listener = listener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_article,parent,false);
        return new VH(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.bind(getItem(position));
    }

    static class VH extends RecyclerView.ViewHolder{
        private final  TextView tvTitle;
        private final TextView tvSummary;

        VH(View itemView, OnItemClick listener){
            super(itemView);

            this.tvTitle = itemView.findViewById(R.id.tvTitle);
            this.tvSummary = itemView.findViewById(R.id.tvSummary);

            itemView.setOnClickListener(v->{
                int pos = getBindingAdapterPosition();
                if (pos != RecyclerView.NO_POSITION && listener != null)
                {
                    listener.onItemClick((Article) itemView.getTag() );
                }
            });

        }
        void bind(Article article){
            tvTitle.setText(article.title);
            tvSummary.setText(article.summary);
            itemView.setTag(article);
        }

    }
}
