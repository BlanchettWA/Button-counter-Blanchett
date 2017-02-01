package tk.blanchettapps.button_counter_blanchett;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button increment;
    private Button decrement;
    private Button clear;
    private TextView viewfield;
    private EditText leapset;
    private Integer count = 0;
    private Integer leapnum = 5;
    private Button leapup;
    private Button leapdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        increment = (Button) findViewById(R.id.plusbutton);
        decrement = (Button) findViewById(R.id.minusbutton);
        clear = (Button) findViewById(R.id.clearbutton);
        viewfield = (TextView) findViewById(R.id.counterview);
        leapset = (EditText) findViewById(R.id.leapnumber);


        leapup = (Button) findViewById(R.id.jumpforward);
        leapdown = (Button) findViewById(R.id.jumpback);

        leapset.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    leapnum = Integer.valueOf(s.toString());
                }
                else
                {
                    leapnum = 5;
                }
            }
        });

        leapup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count += leapnum;
                viewfield.setText(count.toString());
            }
        });

        leapdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count -= leapnum;
                viewfield.setText(count.toString());
            }
        });
        increment.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                System.out.println("Value originally: " + count.toString());

                count += 1;
                System.out.println("Value Should now be" + count);
                viewfield.setText(count.toString());

            }
        });

        decrement.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                System.out.println("Value originally: " + count);

                count -= 1;
                System.out.println("Value Should now be" + count);
                viewfield.setText(count.toString());


            }
        });

        clear.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                System.out.println("Setting current value " + count + " to Zero.");

                count = 0;
                viewfield.setText(count.toString());
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("countvalue",count);
        outState.putInt("leapy", leapnum);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("countvalue");
        viewfield.setText(count.toString());
        Integer tempnum = savedInstanceState.getInt("leapy");

        if (tempnum == 5) {
            leapnum = 5;
        }else
        {
            leapnum = tempnum;
            leapset.setText(leapnum.toString());
        }

    }
}
