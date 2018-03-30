package ro.pub.cs.systems.eim.practicaltest01Var03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var03 extends Activity {

    private CheckBox checkBoxName = null;
    private CheckBox checkBoxGrupa = null;
    private EditText editTextName = null;
    private EditText editTextGrupa = null;
    private EditText informationEdit = null;

    private Button displayButton = null;
    private Button navigate = null;

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String toPut = "";
            switch(view.getId()) {
                case R.id.display_button:
                    if(checkBoxGrupa.isChecked()) {
                        if(!editTextGrupa.getText().toString().equals("")) {
                            toPut += editTextGrupa.getText().toString();
                        } else {
                            Toast.makeText(getApplicationContext(), "Cannot be empty", Toast.LENGTH_LONG).show();
                        }
                    }
                    if(checkBoxName.isChecked()) {
                        if(!editTextName.getText().toString().equals("")) {
                            toPut += editTextName.getText().toString();
                        } else {
                            Toast.makeText(getApplicationContext(), "Cannot be empty", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.navigate_to_secondary_activity_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var03SecondaryActivity.class);
                    String str = editTextGrupa.getText().toString() + editTextName.getText().toString();
                    intent.putExtra("str", str);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
            informationEdit.setText(toPut);
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03);

        checkBoxName = findViewById(R.id.check_name);
        checkBoxGrupa = findViewById(R.id.check_grupa);
        editTextGrupa = (EditText) findViewById(R.id.grupa_edit_box);
        editTextName = (EditText) findViewById(R.id.name_edit_box);
        informationEdit = (EditText) findViewById(R.id.information_edit_text);

        displayButton = (Button) findViewById(R.id.display_button);

        displayButton.setOnClickListener(buttonClickListener);
        navigate = (Button) findViewById(R.id.navigate_to_secondary_activity_button);
        navigate.setOnClickListener(buttonClickListener);

        if(savedInstanceState != null) {
            if(savedInstanceState.containsKey("name")) {
               editTextName.setText(savedInstanceState.getString("name"));
            } else {
                editTextName.setText("");
            }
            if(savedInstanceState.containsKey("grupa")) {
                editTextGrupa.setText(savedInstanceState.getString("grupa"));
            } else {
                editTextGrupa.setText("");
            }
        } else {
            editTextGrupa.setText("");
            editTextName.setText("");
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }

    protected void onSaveInstanceState(Bundle savedInstanceState) { ;
        savedInstanceState.putString("name", editTextName.getText().toString());
        savedInstanceState.putString("grupa", checkBoxGrupa.getText().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test01_var03, menu);
        return true;
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("name")) {
            editTextName.setText(savedInstanceState.getString("name"));
        } else {
            editTextName.setText("");
        }
        if (savedInstanceState.containsKey("grupa")) {
            editTextGrupa.setText(savedInstanceState.getString("grupa"));
        } else {
            editTextGrupa.setText("");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
