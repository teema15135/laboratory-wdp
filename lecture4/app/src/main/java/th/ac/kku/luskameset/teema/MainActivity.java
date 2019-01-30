package th.ac.kku.luskameset.teema;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button calcBtn;
    EditText o1;
    EditText o2;
    TextView resText;

    RadioGroup operatorGroup;

    final int TOASTS_DURATION = Toast.LENGTH_SHORT;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        calcBtn = (Button)findViewById(R.id.cal);
        o1 = (EditText) findViewById(R.id.o1);
        o2 = (EditText) findViewById(R.id.o2);
        resText = (TextView)findViewById(R.id.result);
        operatorGroup = (RadioGroup)findViewById(R.id.operatorRbGroup);

        calcBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == calcBtn) {
            if (o1.getText().toString().isEmpty() || o2.getText().toString().isEmpty()) {
                makeAToast("Please enter a number");
                return;
            }
            float result;
            float val1 = Float.parseFloat(o1.getText().toString());
            float val2 = Float.parseFloat(o2.getText().toString());

            switch (operatorGroup.getCheckedRadioButtonId()) {
                case R.id.rbAdd:
                    result = val1 + val2;
                    break;
                case R.id.rbSub:
                    result = val1 - val2;
                    break;
                case R.id.rbMul:
                    result = val1 * val2;
                    break;
                case R.id.rbDiv:
                    if(val2 == 0) {
                        makeAToast("Number divided by zero");
                        return;
                    }
                    result = val1 / val2;
                    break;
                default:
                    return;
            }
            resText.setText("=" + Float.toString(result));
        }
    }

    protected void makeAToast(String text) {
        Toast toast =  Toast.makeText(context, text, TOASTS_DURATION);
        toast.setGravity(Gravity.RIGHT, 0, 0);
        toast.show();
    }

}
