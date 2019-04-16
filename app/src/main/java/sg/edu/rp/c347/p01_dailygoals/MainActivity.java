package sg.edu.rp.c347.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg1, rg2, rg3;
    RadioButton rb1, rb2, rb3;
    EditText et;
    TextView tv1, tv2, tv3;
    int selected1, selected2, selected3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDone = findViewById(R.id.button);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg1 = findViewById(R.id.rg1);
                rg2 = findViewById(R.id.rg2);
                rg3 = findViewById(R.id.rg3);
                selected1 = rg1.getCheckedRadioButtonId();
                rb1 = findViewById(selected1);
                selected2 = rg2.getCheckedRadioButtonId();
                rb2 = findViewById(selected2);
                selected3 = rg3.getCheckedRadioButtonId();
                rb3 = findViewById(selected3);
                et = findViewById(R.id.editText);
                tv1 = findViewById(R.id.textView);
                tv2 = findViewById(R.id.textView3);
                tv3 = findViewById(R.id.textView5);
                String[] info = {tv1.getText().toString(), rb1.getText().toString(), tv2.getText().toString(), rb2.getText().toString(), tv3.getText().toString(), rb3.getText().toString(), et.getText().toString()};

                Intent i = new Intent(MainActivity.this, Main2Activity.class);

                i.putExtra("info", info);
                startActivity(i);
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefedit = prefs.edit();
                prefedit.putInt("read", selected1);
                prefedit.putInt("arrive", selected2);
                prefedit.putInt("attempt", selected3);
                prefedit.putString("reflect", et.getText().toString());
                prefedit.commit();
            }
        });




    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);


        int read = prefs.getInt("read", 0);
        int arrive = prefs.getInt("arrive", 0);
        int attempt = prefs.getInt("attempt", 0);
        String reflect = prefs.getString("reflect", "");
        et = findViewById(R.id.editText);
        et.setText(reflect);
        if (read!=0 && arrive!=0 && attempt!=0){
        rb1 = findViewById(read);
        rb1.setChecked(true);
        rb2 = findViewById(arrive);
        rb2.setChecked(true);
        rb3 = findViewById(attempt);
        rb3.setChecked(true);
        }
    }
}
