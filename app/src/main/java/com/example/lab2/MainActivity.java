package com.example.lab2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int SELECT_PICTURE = 1;

    private String selectedImagePath;
    @Override
    protected void onStart() {


        super.onStart();
        Log.i("ON START", "Start");
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.button);
        Button b5 = findViewById(R.id.button5);
        Bundle bl = new Bundle();

        Intent intent1 = new Intent(this, VtoroyActivity.class);
        Intent intent = new Intent();
        bl.putString("h", "image");
//        b5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                intent.addCategory(Intent.CATEGORY_OPENABLE);
//                startActivityForResult(Intent.createChooser(intent, "Select Picture"),1);
//
//              //  Log.i("asdasdasdasd", intent.getData().toString());
//                //Intent.createChooser(intent, "asdasd");
//            }
//        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.i("asdasdasdasd", intent.getData().toString());
//                Log.i("asdasdasdasd", "asd");
//                Uri selectedImageUri = intent.getData();
//                selectedImagePath = getPath(selectedImageUri);
//                if (selectedImageUri != null) {
//                    bl.putString("h", selectedImagePath);
//                    intent1.putExtras(bl);
//                    Log.i("ON", "lllll");
//                }
//                Log.i("asdasdasdasd", "xx");
//                // String path = intent.getData().getPath();

                intent1.putExtras(bl);
                startActivity(intent1);

            }
        });


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ON CREATE", "Create");
    }
    @Override
    protected void onPause () {
        super.onPause();
        Log.i("ON PAUSE", "Pause");
    }

    @Override
    protected void onResume () {
        super.onResume();
        Log.i("ON RESUME", "Resume");
    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        Log.i("ON DESTROY", "Destroy");
    }

    @Override
    protected void onStop () {
        super.onStop();
        Log.i("ON StOP", "Stop");
    }
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK) {
//            if (requestCode == SELECT_PICTURE) {
//                Uri selectedImageUri = data.getData();
//                selectedImagePath = getPath(selectedImageUri);
//            }
//        }
//    }
    public String getPath(Uri uri) {
        // just some safety built in
        if( uri == null ) {
            // TODO perform some logging or show user feedback
            return null;
        }
        // try to retrieve the image from the media store first
        // this will only work for images selected from gallery
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if( cursor != null ){
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            String path = cursor.getString(column_index);
            cursor.close();
            return path;
        }
        // this is our fallback here
        return uri.getPath();
    }
}



















