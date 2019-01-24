package th.ac.kku.luksameset.teema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kku.coe.hello.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameInput = (EditText)findViewById(R.id.name_input);
        final EditText phoneInput = (EditText)findViewById(R.id.phone_input);
        Button submitBtn = (Button)findViewById(R.id.submit_btn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GreetingActivity.class);
                intent.putExtra("name", nameInput.getText().toString());
                intent.putExtra("phone", phoneInput.getText().toString());
                startActivity(intent);
            }
        });
    }
}
