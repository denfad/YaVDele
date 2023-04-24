package ru.denfad.yavdele.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.denfad.yavdele.R;

public class TagSelectingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_selecting);

        Button regist = findViewById(R.id.button_registration);
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(TagSelectingActivity.this, UserProfileActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}