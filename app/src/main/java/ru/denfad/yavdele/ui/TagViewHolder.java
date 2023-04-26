package ru.denfad.yavdele.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.denfad.yavdele.R;

public class TagViewHolder  extends RecyclerView.ViewHolder {
    TextView tag;
    public TagViewHolder(@NonNull View itemView) {
        super(itemView);
        tag = itemView.findViewById(R.id.tag_text);
    }
}
