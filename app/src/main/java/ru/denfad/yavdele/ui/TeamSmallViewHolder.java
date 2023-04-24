package ru.denfad.yavdele.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.denfad.yavdele.R;

public class TeamSmallViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView activity;
    public ImageView icon;

    public TeamSmallViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.item_team_name);
        activity = itemView.findViewById(R.id.item_team_activity);
        icon = itemView.findViewById(R.id.team_image);
        icon.setClipToOutline(true);
    }
}
