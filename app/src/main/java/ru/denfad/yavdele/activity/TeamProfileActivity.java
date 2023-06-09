package ru.denfad.yavdele.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.akexorcist.roundcornerprogressbar.TextRoundCornerProgressBar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

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

        Button response = findViewById(R.id.button_response);
        response.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogAddResponse();
            }
        });
    }

   private void dialogAddResponse() {
       new MaterialAlertDialogBuilder(TeamProfileActivity.this, com.google.android.material.R.style.ThemeOverlay_Material3_MaterialAlertDialog_Centered)
               .setIcon(R.drawable.add_response)
               .setTitle("Создать отклик")
               .setMessage("Добавьте полезный коментарий к отклику")
               .setView(R.layout.edit_text_layout)
               .setPositiveButton(
                       "Откликнуться",
                       (dialog, which) -> {
                           TextView input = ((AlertDialog) dialog).findViewById(android.R.id.text1);
                           Toast.makeText(TeamProfileActivity.this, "Запрос отправлен", Toast.LENGTH_SHORT).show();
                       })
               .show();
    }

}