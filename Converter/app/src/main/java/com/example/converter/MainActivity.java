package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton mtocm,cmtom,gmtokg,kgtogm;
    String num1,num3;
    Button submit;
    EditText editTextTextPersonName,num;
    Integer num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gmtokg = (RadioButton) findViewById(R.id.gmtokm);
        cmtom = (RadioButton) findViewById(R.id.cmtom);
        kgtogm = (RadioButton) findViewById(R.id.kmtogm);
        mtocm = (RadioButton) findViewById(R.id.mtocm);

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        num = findViewById(R.id.text);
        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!num.getText().toString().isEmpty()) {
                    if (gmtokg.isChecked()) {
                        if (num.getText().toString().length() > 0) {
                            double val = Double.parseDouble(num.getText().toString());
                            double conv = val/1000;
                            editTextTextPersonName.setText(String.valueOf(conv)+" KG");
                        }
                    }
                    else if (cmtom.isChecked()) {
                        if (num.getText().toString().length() > 0) {
                            double val = Double.parseDouble(num.getText().toString());
                            double conv = val*0.01;
                            editTextTextPersonName.setText(String.valueOf(conv)+" meter");
                        }
                    }
                    else if (mtocm.isChecked()) {
                        if (num.getText().toString().length() > 0) {
                            double val = Double.parseDouble(num.getText().toString());
                            double conv = val*100;
                            editTextTextPersonName.setText(String.valueOf(conv)+" Centimeter");
                        }
                    }
                    else if (kgtogm.isChecked()) {
                        if (num.getText().toString().length() > 0) {
                            double val = Double.parseDouble(num.getText().toString());
                            double conv = val*1000;
                            editTextTextPersonName.setText(String.valueOf(conv)+" grams");
                        }
                    }

                }
            }
        });

    }
}