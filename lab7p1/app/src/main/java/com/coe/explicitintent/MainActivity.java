package com.coe.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 10;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void okButtonClicked(View view) {
        EditText name = (EditText) findViewById (R.id.editText);
        // To do 1. create new intent
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        // To do 2. put extra value with the intent
        intent.putExtra("name", name.getText().toString());
        // To do 3. use startActivityForResult with REQUEST_CODE
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            // Todo 1. get data from ResultActivity
            String word = data.getStringExtra("word");
	       // Todo 2. set the value of TextView with the received data
            tv = (TextView)findViewById(R.id.result);
            tv.setText(word);
        }
    }
}
