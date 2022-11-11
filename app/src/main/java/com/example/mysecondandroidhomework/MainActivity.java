package com.example.mysecondandroidhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA;
    private EditText editTextB;
    private EditText editTextC;
    private TextView textViewX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.edit_text_a);
        editTextB = findViewById(R.id.edit_text_b);
        editTextC = findViewById(R.id.edit_text_c);
        textViewX = findViewById(R.id.text_view_x);
    }

    private double getDoubleValue(EditText editText){
        if (editText.getText().toString().isEmpty()){
            Toast.makeText(this,"Поля не могут быть пустыми!", Toast.LENGTH_SHORT).show();
            return 0;
        }else if ((editText.getText().toString().equals("."))||((editText.getText().toString().equals("-")))){
            Toast.makeText(this,"Заполнять поля нужно числами!", Toast.LENGTH_LONG).show();
            return 0;
        }else {
            return Double.parseDouble(editText.getText().toString());
        }
    }

    private String getDiscriminant(double a,double b,double c) {
        Double D = b * b - 4 * a * c;
        String x = "";
        if (a == 0.00){
            x = "x = "+String.format("%.2f", -c/b==0? 0d:-c/b);
        }else if(a==0&&b==0){
            x = "x - любое";
        }else if (D == 0) {
            x = "x = "+String.format("%.2f", (0-b)/(2*a));
        } else if (D<0){
            x = "Решений нет(";
        }else{
            double x1 = (Math.sqrt(D)-b)/(2*a);
            double x2 = (0-Math.sqrt(D)-b)/(2*a);
            x = "x1 = "+String.format("%.2f", x1)+" x2 = "+String.format("%.2f", x2);
        }
        return x;
    }

    public void click(View view){
        double a = getDoubleValue(editTextA);
        double b = getDoubleValue(editTextB);
        double c = getDoubleValue(editTextC);
        textViewX.setText(getDiscriminant(a,b,c));
    }
}