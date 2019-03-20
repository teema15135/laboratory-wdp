package com.coe.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setIntentData();
    }

    public void setIntentData() {
//        Bundle extras = getIntent().getExtras();
//        String inputString = extras.getString("name");
//
//        Log.d("resulttest", getIntent().getStringExtra("name"));
        TextView view = (TextView) findViewById(R.id.textRView);
        view.setText(getIntent().getStringExtra("name"));
    }

    @Override
    public void finish() {
        // TODO 1 create new Intent
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        // TODO 2 read the data of the EditText field
        EditText et = (EditText) findViewById(R.id.returnValue);
        String word = et.getText().toString();
        // with the id returnValue
        // TODO 3 put the text from EditText
        // as String extra into the intent
        intent.putExtra("word", word);

        // return the Intent to the application
        setResult(RESULT_OK, intent);
        super.finish();

    }
}
