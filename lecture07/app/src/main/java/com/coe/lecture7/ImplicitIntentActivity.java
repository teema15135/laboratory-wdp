package com.coe.lecture7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ImplicitIntentActivity extends AppCompatActivity implements View.OnClickListener {

    Button intentTrigger;
    Spinner spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        intentTrigger = (Button)findViewById(R.id.trigger);
        intentTrigger.setOnClickListener(this);

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.intents, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v == intentTrigger) {
            int pos = spinner.getSelectedItemPosition();
            String intentAction = "";
            Uri intentURI = null;
            switch (pos) {
                case 0:
                    intentAction = Intent.ACTION_VIEW;
                    intentURI = Uri.parse("http://m.kku.ac.th/");
                    break;
                case 1:
                    intentAction = Intent.ACTION_DIAL;
                    intentURI = Uri.parse("tel:043009700");
                    break;
                case 2:
                    intentAction = Intent.ACTION_VIEW;
                    intentURI = Uri.parse("geo:0.0?q=Khon Kaen University");
                    break;
                case 3:
                    intentAction = Intent.ACTION_VIEW;
                    intentURI = Uri.parse("content://contacts/people");
                    break;
                default:
                    break;
            }
            if(intentAction != "" && intentURI != null)
                startActivity(new Intent(intentAction, intentURI));
        }
    }

    private void openBrowser() {
        String url = "http://m.kku.ac.th";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void dialNow() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+"043009700"));
        startActivity(intent);
    }

    private void searchOnMap() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:16.468086,102.831126"));
        startActivity(intent);
    }

    private void showContractNow() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
        startActivity(intent);
    }
}
