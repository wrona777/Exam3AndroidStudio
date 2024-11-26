package com.example.eksam3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        getSupportActionBar().setTitle("czcionki");

        Czcionki();
    }
    void Czcionki(){
        TextView rozmiar = findViewById(R.id.textView2);
        TextView cytaty= findViewById(R.id.textView3);
        Button przycisk = findViewById(R.id.button);
        SeekBar slider = findViewById(R.id.seekBar);

        String[] cytatTAB ={"Dzień dobry", "buenos dias", "good morning"};

        int[] currentIndex = {1};

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             int i = currentIndex[0];

             cytaty.setText(cytatTAB[i]);

             currentIndex[0] = (i + 1) % cytatTAB.length;
            }
        });

        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar slider, int i, boolean b) {
                rozmiar.setText("Rozmiar: " + i);
                cytaty.setTextSize(i);
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