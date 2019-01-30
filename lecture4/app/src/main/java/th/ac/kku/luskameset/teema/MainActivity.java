package th.ac.kku.luskameset.teema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button calcBtn;
    EditText o1;
    EditText o2;
    TextView resText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcBtn = (Button)findViewById(R.id.cal);
        o1 = (EditText) findViewById(R.id.o1);
        o2 = (EditText) findViewById(R.id.o2);
        resText = (TextView)findViewById(R.id.result);

        calcBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == calcBtn) {
            int result = Integer.parseInt(o1.getText().toString()) + Integer.parseInt(o2.getText().toString());
            resText.setText("=" + Integer.toString(result));
        }
    }
}
