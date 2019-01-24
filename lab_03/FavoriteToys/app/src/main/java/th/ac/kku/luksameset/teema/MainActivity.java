package th.ac.kku.luksameset.teema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        TextView greenTextView = (TextView)findViewById(R.id.green);

        greenTextView.setText(R.string.content_green);  // android:text="@string/content_green"
        greenTextView.setTextSize(30); // android:textSize="@dimen/content_font_size"
        greenTextView.setGravity(Gravity.CENTER); // android:gravity="center"

    }
}
