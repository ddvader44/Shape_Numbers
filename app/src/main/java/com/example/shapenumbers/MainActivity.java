package com.example.shapenumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    class Number
    {
        int number;
        public boolean issquare()
        {
            double sq = Math.sqrt(number);
            if(sq == Math.floor(sq))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public boolean istriangular()
        {
            int x = 1;
            int t = 1;
            while(t<number)
            {
                x++ ;
                t = t + x;
            }
            if(t==number)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    public void shape(View view) {
        EditText editText = (EditText) findViewById(R.id.editText2);
        String msg;
        if (editText.getText().toString().isEmpty()) {
            msg = "Please enter a number";
        } else {
            Number mynumber = new Number();
            mynumber.number = Integer.parseInt((editText.getText().toString()));
            msg = editText.getText().toString();
            if (mynumber.issquare() && mynumber.istriangular()) {
                msg += " is both square and triangular";
            } else if (mynumber.istriangular()) {
                msg += " is a triangular number but not square";
            } else if (mynumber.issquare()) {
                msg += " is a square number but not triangular";
            } else {
                msg += " is neither square nor triangular";
            }
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
