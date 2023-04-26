package ru.denfad.yavdele.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.denfad.yavdele.R;

public class TeamBigViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView activity;
    TextView description;
    TextView place;
    RecyclerView box;
    Button about;

    public TeamBigViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.team_name);
        activity = itemView.findViewById(R.id.team_activity);
        description = itemView.findViewById(R.id.team_description);
        place = itemView.findViewById(R.id.team_place);
        box = itemView.findViewById(R.id.team_box);
        about = itemView.findViewById(R.id.button_about);
    }
}
