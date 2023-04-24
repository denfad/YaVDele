package ru.denfad.yavdele.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.akexorcist.roundcornerprogressbar.TextRoundCornerProgressBar;

import java.util.List;

import ru.denfad.yavdele.Model.Team;
import ru.denfad.yavdele.R;
import ru.denfad.yavdele.Service;
import ru.denfad.yavdele.ui.TeamSmallViewHolder;

public class UserProfileActivity extends AppCompatActivity {

    private List<Team> teams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        teams = Service.getInstance().getTeams();

        RecyclerView list = findViewById(R.id.list_page);
        TeamAdapter adapter = new TeamAdapter();
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ImageView teamImage = findViewById(R.id.user_image);
        teamImage.setClipToOutline(true);

        TextRoundCornerProgressBar rate= findViewById(R.id.user_rate_bar);
        rate.setProgress(4.5f);
        rate.setProgressText(String.valueOf(4.5));

        RadioGroup pages = findViewById(R.id.radio_button_pages);
        pages.check(R.id.button_user_teams);
        pages.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.button_user_teams:

                        break;
                    case R.id.button_user_photo:
                        break;
                    case R.id.button_user_friends:
                        break;

                }
            }
        });
    }

    class TeamAdapter extends RecyclerView.Adapter<TeamSmallViewHolder> {

        @NonNull
        @Override
        public TeamSmallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Inflate the custom layout
            View contactView = inflater.inflate(R.layout.item_small_team, parent, false);
            contactView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mainIntent = new Intent(UserProfileActivity.this, TeamProfileActivity.class);
                    startActivity(mainIntent);
                }
            });

            // Return a new holder instance
            TeamSmallViewHolder viewHolder = new TeamSmallViewHolder(contactView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull TeamSmallViewHolder holder, int position) {
            Team t = teams.get(position);
            holder.name.setText(t.getName());
            holder.activity.setText(t.getActivity());
        }

        @Override
        public int getItemCount() {
            return teams.size();
        }
    }
}