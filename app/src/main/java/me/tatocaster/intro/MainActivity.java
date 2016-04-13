package me.tatocaster.intro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import me.tatocaster.intro.fragments.TestFragment;
import me.tatocaster.intro.interfaces.IOnButtonClickListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IOnButtonClickListener {

    private static final String TAG = "MainActivity";
    private EditText mEditText;
    private Button mButton;
    private TextView mTextView;
    private Button mOpenTestFragmentBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button);
        mOpenTestFragmentBtn = (Button) findViewById(R.id.open_test_fragment);
        mTextView = (TextView) findViewById(R.id.textView);

        mButton.setOnClickListener(this);
        mOpenTestFragmentBtn.setOnClickListener(this);

        /*mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputValue = "";
                inputValue = mEditText.getText().toString();
                mTextView.setText(inputValue);
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick() called with: " + "v = [" + v + "]");
        switch (v.getId()) {
            case R.id.button:
                //mTextView.setText("Hello " + mEditText.getText().toString());
                copyValue();
                break;
            case R.id.open_test_fragment:
                getFragmentManager().beginTransaction().replace(R.id.test_fragment_holder,
                        new TestFragment()).commit();
                break;

        }
    }


    /**
     * copy value from editext to textview
     */
    private void copyValue() {
        /*String inputValue = "";
        inputValue = mEditText.getText().toString();*/
        Log.d(TAG, "copyValue: ");
        mTextView.setText("Hello " + mEditText.getText().toString());
    }

    @Override
    public void onButtonClick(View v) {
        Toast.makeText(this, "Activity Toast", Toast.LENGTH_SHORT).show();
    }

    //android:onClick="changeText"
    /*public void changeText(View view) {
        String inputValue = "";
        inputValue = mEditText.getText().toString();
        mTextView.setText("Hello " + inputValue);
    }*/
}
