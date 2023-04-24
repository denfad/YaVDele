package ru.denfad.yavdele.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.akexorcist.roundcornerprogressbar.TextRoundCornerProgressBar;

import ru.denfad.yavdele.R;

public class TeamProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_profile);

        ImageView teamImage = findViewById(R.id.team_image);
        teamImage.setClipToOutline(true);

        TextRoundCornerProgressBar rate= findViewById(R.id.team_rate_bar);
        rate.setProgress(4.5f);
        rate.setProgressText(String.valueOf(4.5));
    }

}