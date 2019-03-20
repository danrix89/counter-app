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

    public Button incrementButton;
    public Button decrementButton;
    public Button resetButton;
    public TextView countTextView;

    private View.OnClickListener counterButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int countValueInteger = Integer.parseInt(countTextView.getText().toString());

            if (v == incrementButton) {
                countValueInteger++;
            } else if (v == decrementButton) {
                countValueInteger--;
            } else if (v == resetButton) {
                countValueInteger = 0;
                Toast.makeText(MainActivity.this, "resetting", Toast.LENGTH_SHORT).show();
            }

            countTextView.setText(String.valueOf(countValueInteger));
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        countTextView = findViewById(R.id.counter_text);
        countTextView.setText("0");

        incrementButton = findViewById(R.id.add_btn);
        decrementButton = findViewById(R.id.sub_btn);
        resetButton = findViewById(R.id.res_btn);

        incrementButton.setOnClickListener(counterButtonOnClickListener);
        decrementButton.setOnClickListener(counterButtonOnClickListener);
        resetButton.setOnClickListener(counterButtonOnClickListener);
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
