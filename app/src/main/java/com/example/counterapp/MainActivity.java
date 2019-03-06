package com.example.counterapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //identifiers like txtCount are called member variables
    //MainActivity is the class and an attribute or 'variable' of that class is TextView, which is a type of View. This particular TextView is named txtCount
    TextView txtCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtCount= findViewById(R.id.counter_text);

        //local variables can only be used within a specific method, unless referenced they cease to be usable after method is complete.
        Button ResBtn=findViewById(R.id.res_btn);

        ResBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCount.setText(String.valueOf(0));
                Toast.makeText(MainActivity.this, "resetting", Toast.LENGTH_SHORT).show();
            }
        });

        Button SubBtn=findViewById(R.id.sub_btn);
        SubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countValue=txtCount.getText().toString();
                int intCountValue=Integer.parseInt(countValue);
                intCountValue--;
                txtCount.setText(String.valueOf(intCountValue));
            }
        });

        Button AddBtn= findViewById(R.id.add_btn);
        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countValue =txtCount.getText().toString();
                int intCountValue =Integer.parseInt(countValue);
                intCountValue++;
                txtCount.setText(String.valueOf(intCountValue));
            }
        });

    }

    private void onCounterButtonClick(Button countingButton,boolean isIncrement) {
        String countValue =txtCount.getText().toString();
        int intCountValue =Integer.parseInt(countValue);
        if (isIncrement) {
            intCountValue++;
        } else {
            intCountValue--;
        }
        txtCount.setText(String.valueOf(intCountValue));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
