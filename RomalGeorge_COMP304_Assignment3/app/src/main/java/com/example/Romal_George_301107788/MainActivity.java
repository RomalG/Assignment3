package com.example.Romal_George_301107788;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.Exercises));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, Exercise1.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(MainActivity.this, Exercise2.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(MainActivity.this, Exercise3.class);
                    startActivity(intent);
                }
            }
        });
        listView.setAdapter(arrayAdapter);


    }
}
