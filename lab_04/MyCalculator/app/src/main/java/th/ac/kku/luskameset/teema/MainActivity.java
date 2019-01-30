package th.ac.kku.luskameset.teema;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, Switch.OnCheckedChangeListener {

    Button calcBtn;
    EditText o1;
    EditText o2;
    TextView resText;

    Switch mainSw;

    RadioGroup operatorGroup;

    final int TOASTS_DURATION = Toast.LENGTH_SHORT;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeElement();
        updateSwitchStatus();
    }

    protected void initializeElement() {
        context = getApplicationContext();

        calcBtn = (Button)findViewById(R.id.cal);
        o1 = (EditText) findViewById(R.id.o1);
        o2 = (EditText) findViewById(R.id.o2);
        resText = (TextView)findViewById(R.id.result);
        operatorGroup = (RadioGroup)findViewById(R.id.operatorRbGroup);
        mainSw = (Switch)findViewById(R.id.mainSwitch);

        calcBtn.setOnClickListener(this);
        operatorGroup.setOnCheckedChangeListener(this);
        mainSw.setOnCheckedChangeListener(this);
    }

    private void acceptNumber() {
        try {
            calculate(operatorGroup.getCheckedRadioButtonId());
        } catch (NumberFormatException e) {
            showToast("Please enter only a number");
        }
    }

    private void calculate(int id) {
        long start = System.currentTimeMillis();
        float result;
        float val1 = Float.parseFloat(o1.getText().toString());
        float val2 = Float.parseFloat(o2.getText().toString());

        switch (id) {
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
                    showToast("Please divide by a non-zero number");
                    return;
                }
                result = val1 / val2;
                break;
            default:
                return;
        }
        resText.setText("= " + Float.toString(result));
        long runTime = System.currentTimeMillis() - start;
//        Log.d("Calculation", "Result = " + result);
        Log.d("Calculation", "computation time = " + Float.toString((((float)runTime))/1000.0f ));
    }

    private void showToast(String text) {
        Toast toast =  Toast.makeText(context, text, TOASTS_DURATION);
        toast.setGravity(Gravity.BOTTOM, 0, 100);
        toast.show();
    }

    private void updateSwitchStatus() {
        mainSw.setText( (mainSw.isChecked() ? mainSw.getTextOn() : mainSw.getTextOff() ) );
    }

    @Override
    public void onClick(View v) {
        if (v == calcBtn) {
            acceptNumber();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        acceptNumber();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        updateSwitchStatus();
    }
}
