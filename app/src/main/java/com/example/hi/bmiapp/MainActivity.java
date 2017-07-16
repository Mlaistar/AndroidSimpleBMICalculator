package com.example.hi.bmiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtWeight;
    EditText txtHeight;
    Button btnShowBMI;
    TextView txtViewMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtWeight= (EditText)findViewById(R.id.txtWeight);
        txtHeight  = (EditText)findViewById(R.id.txtHeight);
        txtViewMessage = (TextView)findViewById(R.id.txtViewMessage);
        btnShowBMI = (Button)findViewById(R.id.btnShowBMI);

        btnShowBMI.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

                double weight = Double.valueOf(txtWeight.getText().toString());
                double height = Double.valueOf(txtHeight.getText().toString());
                double bmiValue = weight / (height * height);
                bmiValue = (double)Math.round(bmiValue * 100.d) / 100.d;
                calculateBMI(bmiValue);

                //Most appropreately
            }
        });
    }
    public void calculateBMI(double bmiValue){

        String[] bmiMessage = { "Slim", "Medium", "Fat", "Very Fat", "Very Very Fat!" };
        double[] bmiRange = { 18.5, 20, 25, 30, 35 };
                        //{ 18.5, 25, 30, 35, 35 };
        for (int i = 0; i < bmiRange.length; i++)
            if(bmiValue <= bmiRange[i]){
                txtViewMessage.setText(bmiMessage[i]+" " +bmiValue);
                break;
        }

           // else if(bmiValue > bmiRange[bmiRange.length])
           //         textView.setText(bmiMessage[bmiRange.length]);
    }
}
