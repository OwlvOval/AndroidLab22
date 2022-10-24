package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class VtoroyActivity extends AppCompatActivity {
    String item;
    ArrayList<String> catNames = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vtoroy);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);
        Button b4 = findViewById(R.id.button4);
        ListView list = findViewById(R.id.list);
        EditText textPaint = findViewById(R.id.editTextTextPersonName2);
        Bundle lb = this.getIntent().getExtras();

        //catNames.add(lb.getString("h"));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, catNames);
        list.setAdapter(adapter);
        catNames.add(lb.getString("h"));
        adapter.notifyDataSetChanged();
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catNames.add(textPaint.getText().toString());
                list.setAdapter(adapter);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catNames.remove(item);
                list.setSelector(R.color.white);
                adapter.notifyDataSetChanged();
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.setSelector(R.color.teal_200);
                    item = adapter.getItem(i);
                adapter.notifyDataSetChanged();
            }
        });

    }
}