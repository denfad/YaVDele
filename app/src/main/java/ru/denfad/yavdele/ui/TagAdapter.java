package ru.denfad.yavdele.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.denfad.yavdele.R;

public class TagAdapter extends RecyclerView.Adapter<TagViewHolder>{

    private List<String> tags;
    public TagAdapter(List<String> tags) {
        this.tags = tags;
    }

    @NonNull
    @Override
    public TagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_tag, parent, false);

        // Return a new holder instance
        TagViewHolder viewHolder = new TagViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TagViewHolder holder, int position) {
        String tag = tags.get(position);
        holder.tag.setText(tag);
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }
}
