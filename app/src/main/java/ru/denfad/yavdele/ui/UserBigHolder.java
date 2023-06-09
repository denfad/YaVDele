package ru.denfad.yavdele.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.denfad.yavdele.R;

public class UserBigHolder extends RecyclerView.ViewHolder{
    View view;
    TextView name;
    TextView place;
    RecyclerView box;
    Button about;
    ImageView image;
    public UserBigHolder(@NonNull View itemView) {
        super(itemView);
        this.view = itemView;
        name = itemView.findViewById(R.id.user_name);
        place = itemView.findViewById(R.id.user_place);
        box = itemView.findViewById(R.id.user_box);
        about = itemView.findViewById(R.id.button_about);
        image = itemView.findViewById(R.id.user_image);
    }
}
