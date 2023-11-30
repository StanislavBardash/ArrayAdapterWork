package com.example.arrayadapterwork;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    int n = 18;

    ListView lv;
    View lastView;
    boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lstview);
        firstNames = getResources().getStringArray(R.array.firstNames);
        lastNames = getResources().getStringArray(R.array.lastNames);
        fullnames = new ArrayList<>();
        initialize_adapter();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(Color.YELLOW);
                if(isClicked){
                    lastView.setBackgroundColor(Color.WHITE);
                }
                else{
                    isClicked = true;

                }
                lastView = view;
            }
        });
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