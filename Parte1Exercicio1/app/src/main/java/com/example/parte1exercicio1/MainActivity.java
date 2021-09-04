package com.example.parte1exercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 =  findViewById(R.id.editTextNumber2);
        textView = findViewById(R.id.textBox);
    }


    public void sum(View view) {
        String stringValue1 = editTextNumber1.getText().toString();
        String stringValue2 = editTextNumber2.getText().toString();
        
        Integer value1 = stringValue1.isEmpty() ? 0 : Integer.parseInt(stringValue1) ;
        Integer value2 = stringValue2.isEmpty() ? 0 : Integer.parseInt(stringValue2) ;
        Integer sum = value1 + value2;

        textView.setText(sum.toString());

        
    }
}