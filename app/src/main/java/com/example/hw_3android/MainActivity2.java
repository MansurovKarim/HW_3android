package com.example.hw_3android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private Button btn_button;
    private boolean isHeartTouched = false;
    TextView text;
    ImageButton heart;

    Spinner spinner;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        Button Button = findViewById(R.id.btn_Category);
        Button.setOnClickListener(v -> {

                Intent intent =  new Intent(MainActivity2.this, MainActivity3.class);

                startActivity(intent);
            });




        heart = findViewById(R.id.heart_button);
        text = findViewById(R.id.text);

        String result = getIntent().getStringExtra("result");
        text.setText(result);

        findViewById(R.id.btn_next).setOnClickListener(v -> finishAffinity());

        heart.setOnClickListener(v -> {
            isHeartTouched = !isHeartTouched;

            if (isHeartTouched) {
                heart.setImageResource(R.drawable.heart_touch);
            } else {
                heart.setImageResource(R.drawable.heart_untouched);
            }
        });

        spinner = findViewById(R.id.menu);

        String[] items = {"item 1", "Item 2", "Item 3"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                System.out.println("Selected: " + selectedItem);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}