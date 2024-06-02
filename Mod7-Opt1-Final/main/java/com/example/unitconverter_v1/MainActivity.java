package com.example.unitconverter_v1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textview2;
    private EditText editText;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textview2 = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                int kg = Integer.parseInt(s);
                double pounds = 2.20462 * kg;
                textview2.setText("Pounds ="+ pounds);
                Toast.makeText(MainActivity.this, "Value is" + pounds, Toast.LENGTH_SHORT).show();
            }
        });


    }

}