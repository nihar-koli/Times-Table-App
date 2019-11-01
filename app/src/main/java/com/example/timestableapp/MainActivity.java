package com.example.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView tableList;
    TextView textView;

    public void generateTimesTable(int n){
        textView.setText("Table of "+ Integer.toString(n) + " : ");
        ArrayList<String> table = new ArrayList<String>();
        int j;
        for(j=1 ; j<=10 ; j++){
            table.add(Integer.toString(n*j));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,table);
        tableList.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableList = findViewById(R.id.tableList);
        final SeekBar getNumber = findViewById(R.id.numberSeekBar);
        textView = findViewById(R.id.textView);

        int max = 30;
        int startingPos = 10;

        getNumber.setMax(max);
        getNumber.setProgress(startingPos);


        generateTimesTable(startingPos);

        getNumber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int n;
                if(i<min){
                    n=min;
                    getNumber.setProgress(min);
                }
                else{
                    n=i;
                }
                generateTimesTable(n);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
