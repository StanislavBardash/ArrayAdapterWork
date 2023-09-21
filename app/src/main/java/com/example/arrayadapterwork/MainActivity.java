package com.example.arrayadapterwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String[] firstNames;
    String[] lastNames;

    ArrayList<String> fullnames;
    ArrayAdapter<String> adapter;

    //Default amount of names displayed
    int n = 8;

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lstview);
        firstNames = getResources().getStringArray(R.array.firstNames);
        lastNames = getResources().getStringArray(R.array.lastNames);
        fullnames = new ArrayList<>();
        initialize_adapter();
    }
    public void initialize_adapter(){
        int sz = firstNames.length;
        for(int i = 0; i < n; i++){
            Random rand = new Random();
            int f_name_ind = rand.nextInt(sz);
            int l_name_ind = rand.nextInt(sz);
            fullnames.add(firstNames[f_name_ind] + " " + lastNames[l_name_ind]);
        }
        adapter = new ArrayAdapter<String>(this, R.layout.item, fullnames);
        lv.setAdapter(adapter);
    }

    public void onClick(View view) {
        int sz = firstNames.length;
        Random rand = new Random();
        int f_name_ind = rand.nextInt(sz);
        int l_name_ind = rand.nextInt(sz);
        fullnames.add(firstNames[f_name_ind] + " " + lastNames[l_name_ind]);
        adapter.notifyDataSetChanged();
    }
}