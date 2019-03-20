package com.coe.wdpviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText op1, op2;
    TextView resultText;
    Button calcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        op1 = (EditText) findViewById(R.id.op1);
        op2 = (EditText) findViewById(R.id.op2);
        resultText = (TextView) findViewById(R.id.result);
        calcBtn = (Button) findViewById(R.id.calcBtn);

        calcBtn.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("op1", op1.getText().toString());
        outState.putString("op2", op2.getText().toString());
        outState.putString("result", resultText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        op1.setText(savedInstanceState.getString("op1"));
        op2.setText(savedInstanceState.getString("op2"));
        resultText.setText(savedInstanceState.getString("result"));
    }

    @Override
    public void onClick(View v) {
        if (v == calcBtn) {
            calc();
        }
    }

    private void calc() {
        float val1 = Float.parseFloat(op1.getText().toString());
        float val2 = Float.parseFloat(op2.getText().toString());
        float result = val1 + val2;

        resultText.setText(Float.toString(result));
    }
}
