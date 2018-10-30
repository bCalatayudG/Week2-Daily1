package com.example.billcalatayud.week2_daily1.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.billcalatayud.week2_daily1.R;

public class SecondActivity extends AppCompatActivity {

    SeekBar loanSeekBar, interestSeekBar, tenureSeekBar;
    TextView tView, tView2, tView3, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bindingViews();

        // initiate  views
        tView.setText("" + loanSeekBar.getProgress());
        tView2.setText("" + interestSeekBar.getProgress());
        tView3.setText("" + tenureSeekBar.getProgress());

        // perform seek bar change listener event used for getting the progress value
        loanSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tView.setText("" + progressChangedValue);
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                tView.setText("" + progressChangedValue);
                calculator(tView.getText().toString(), tView2.getText().toString(), tView3.getText().toString());
                Toast.makeText(SecondActivity.this, "Seek bar progress is :" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // perform seek bar change listener event used for getting the progress value
        interestSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tView2.setText("" + progressChangedValue);
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                tView2.setText("" + progressChangedValue);
                calculator(tView.getText().toString(), tView2.getText().toString(), tView3.getText().toString());
                Toast.makeText(SecondActivity.this, "Seek bar progress is :" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // perform seek bar change listener event used for getting the progress value
        tenureSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tView3.setText("" + progressChangedValue);
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                tView3.setText("" + progressChangedValue);
                calculator(tView.getText().toString(), tView2.getText().toString(), tView3.getText().toString());
                Toast.makeText(SecondActivity.this, "Seek bar progress is :" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();
            }
        });
        calculator(tView.getText().toString(), tView2.getText().toString(), tView3.getText().toString());
    }

    private void bindingViews() {
        tView = findViewById(R.id.tView);
        tView2 = findViewById(R.id.tView2);
        tView3 = findViewById(R.id.tView3);
        result = findViewById(R.id.result);

        loanSeekBar = findViewById(R.id.loanSeekBar);
        interestSeekBar = findViewById(R.id.interestSeekBar);
        tenureSeekBar = findViewById(R.id.tenureSeekBar);
    }

    private void calculator(String s1, String s2, String s3) {
        Double p = Double.parseDouble(s1);
        Double r = Double.parseDouble(s2);
        Double r_100 = r / 100;
        Double n = Double.parseDouble(s3);
        //Double res = (r_100 * p) / (1 - Math.pow(1 - r_100, -n));

        Double res = (r_100 * p * Math.pow((1 + r_100), n)) / (Math.pow((1 + r_100), n) - 1);

        result.setText("" + res);
    }
}
