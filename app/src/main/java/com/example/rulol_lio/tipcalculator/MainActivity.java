package com.example.rulol_lio.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText enteredAmount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView totalResulTextViewxt;
    private TextView textViewSeekBar;
    private int seekBarPercentage;
    private float enteredTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredAmount =  (EditText)findViewById(R.id.billAmountID);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        calculateButton = (Button)findViewById(R.id.calculateButtonID);
        totalResulTextViewxt = (TextView)findViewById(R.id.resultID);
        textViewSeekBar = (TextView)findViewById(R.id.textViewSeekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewSeekBar.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarPercentage = seekBar.getProgress();
            }
        });

        calculateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        calculate();
        //TODO fix this code
    }

    public void calculate(){
        float result = 0.0f;

        if (enteredAmount.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, getResources().getString(R.string.error), Toast.LENGTH_LONG).show();
        }
        else{
            enteredTotal = Float.parseFloat(enteredAmount.getText().toString());
            result = enteredTotal * seekBarPercentage / 100;
            totalResulTextViewxt.setText("The tip will be $" + String.valueOf(result) + "\n Amount with tip will be $" + (String.valueOf(enteredTotal + result)));
        }
    }
}
