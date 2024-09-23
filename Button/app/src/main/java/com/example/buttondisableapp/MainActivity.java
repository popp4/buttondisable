package com.example.buttondisableapp;

import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonDisable;
    private Button buttonEnable;
    private int liczba = 0;
    private TextSwitcher zmiana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDisable = findViewById(R.id.buttonDisable);
        buttonEnable = findViewById(R.id.buttonEnable);
        zmiana = findViewById(R.id.zmiana);

        zmiana.setFactory(() -> {
            TextView textView = new TextView(MainActivity.this);
            textView.setTextSize(18);
            return textView;
        });

        zmiana.setCurrentText("Ilość kliknięć: " + liczba);

        buttonDisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonDisable.setEnabled(false);
                liczba = liczba + 1;
                zmiana.setText("Ilość kliknięć: " + liczba);
                Toast.makeText(MainActivity.this, "Przycisk został wyłączony", Toast.LENGTH_SHORT).show();
            }
        });

        buttonEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                buttonDisable.setEnabled(true);
                Toast.makeText(MainActivity.this, "Przycisk został włączony", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
