package ro.pub.cs.systems.eim.practicaltest01Var03;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var03SecondaryActivity extends AppCompatActivity {

    private Button ok =null;
    private Button cancel = null;
    private TextView finalStr = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_ok:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.button_cancel:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary);

        finalStr = (TextView) findViewById(R.id.total_count_edit_text);
        Intent intent = getIntent();
        if(intent != null && intent.getExtras().containsKey("str")) {
            String str= intent.getStringExtra("str");
            finalStr.setText(String.valueOf(str));
        }

        ok = (Button) findViewById(R.id.button_ok);
        ok.setOnClickListener(buttonClickListener);
        cancel = (Button) findViewById(R.id.button_cancel);
        cancel.setOnClickListener(buttonClickListener);

    }

}
