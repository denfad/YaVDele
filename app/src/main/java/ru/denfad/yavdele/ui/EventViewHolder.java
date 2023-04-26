package ru.denfad.yavdele.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexboxLayout;

import ru.denfad.yavdele.R;

public class EventViewHolder  extends RecyclerView.ViewHolder {
    TextView place;
    TextView date;
    TextView online;
    TextView name;
    RecyclerView box;
    Button about;

    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
        box = itemView.findViewById(R.id.event_box);
        name = itemView.findViewById(R.id.event_name);
        place = itemView.findViewById(R.id.event_place);
        date = itemView.findViewById(R.id.event_date);
        online = itemView.findViewById(R.id.event_online);
        about = itemView.findViewById(R.id.button_about);


    }
}

