package ru.denfad.yavdele.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.chivorn.smartmaterialspinner.SmartMaterialSpinner;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import id.zelory.compressor.Compressor;
import ru.denfad.yavdele.R;
import ru.denfad.yavdele.Service;
import ru.denfad.yavdele.ui.TagAdapter;

public class EditTeamActivity extends AppCompatActivity {

    private List<String> tags = new ArrayList<>();

    private static final int READ_EXTERNAL_STORAGE = 200;
    private static final int PICK_IMAGE = 100;
    ImageButton load;
    private Uri imageUri;
    private File mainFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_team);


        RecyclerView box = findViewById(R.id.team_box);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getApplicationContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        box.setLayoutManager(layoutManager);
        TagAdapter adapter = new TagAdapter(tags);
        box.setAdapter(adapter);

        SmartMaterialSpinner<String> tagsSpinner = findViewById(R.id.search_tags);
        tagsSpinner.setItem(Service.getInstance().getTags());
        tagsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                tags.add(Service.getInstance().getTags().get(position));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        load = findViewById(R.id.load_image);
        load.setClipToOutline(true);
        load.setOnClickListener(view -> {
            //запрос на доступ к галлереи
            view.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_animation));
            int permissionStatus = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
            if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
                openGallery();
            } else {
                ActivityCompat.requestPermissions(EditTeamActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        READ_EXTERNAL_STORAGE);
            }

        });

        Button addTeam = findViewById(R.id.button_add_team);
        addTeam.setOnClickListener(view -> {
            onBackPressed();
        });
    }

        private void openGallery() {
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(gallery, PICK_IMAGE);
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            String filePath = getRealPathFromURI(imageUri);
            load.setImageURI(imageUri);

            File file = new File(filePath);
            File compress = null;
            try {
                compress = new Compressor(getApplicationContext()).compressToFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //restApi
            mainFile = compress;

        } else if (resultCode == RESULT_CANCELED && requestCode == READ_EXTERNAL_STORAGE) {
            Toast.makeText(getApplicationContext(), "Пожалуйста, разрешите приложению доступ к галлереи", Toast.LENGTH_SHORT);
        }
    }

    //метод поиска полного пути до выбранного фото
    private String getRealPathFromURI(Uri contentURI) {
        String result;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }
}