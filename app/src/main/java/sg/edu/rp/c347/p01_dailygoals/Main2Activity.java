package sg.edu.rp.c347.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tv = findViewById(R.id.textView8);
        Button btn = findViewById(R.id.button2);
        Intent i = getIntent();
        String[] info = i.getStringArrayExtra("info");
        tv.setText(info[0] + " : " + info[1] + "\n" + info[2] + " : " + info[3] + "\n" + info[4] + " : " + info[5] + "\n Reflection:" + info[6] + ".");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
