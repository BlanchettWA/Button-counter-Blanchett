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
import android.widget.Toast;

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

    private Integer store1 = 0;
    private Integer store2 = 0;
    private Integer store3 = 0;
    private Integer store4 = 0;

    private Button sbutton1;
    private Button sbutton2;
    private Button sbutton3;
    private Button sbutton4;


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

        sbutton1 = (Button) findViewById(R.id.Store1);
        sbutton2 = (Button) findViewById(R.id.Store2);
        sbutton3 = (Button) findViewById(R.id.Store3);
        sbutton4 = (Button) findViewById(R.id.Store4);

        sbutton1.setText(getText(R.string.store1) + store1.toString());
        sbutton2.setText(getText(R.string.store2) + store2.toString());
        sbutton3.setText(getText(R.string.store3) + store3.toString());
        sbutton4.setText(getText(R.string.store4) + store4.toString());

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

        sbutton1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                store1 = count;
                sbutton1.setText(getText(R.string.store1) + store1.toString());
                Toast.makeText(getApplicationContext(), "Value stored in slot 1!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        sbutton2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                store2 = count;
                sbutton2.setText(getText(R.string.store2) + store2.toString());
                Toast.makeText(getApplicationContext(), "Value stored in slot 2!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        sbutton3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                store3 = count;
                sbutton3.setText(getText(R.string.store3) + store3.toString());
                Toast.makeText(getApplicationContext(), "Value stored in slot 3!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        sbutton4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                store4 = count;
                sbutton4.setText(getText(R.string.store4) + store4.toString());
                Toast.makeText(getApplicationContext(), "Value stored in slot 4!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        sbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = store1;
                viewfield.setText(count.toString());
                Toast.makeText(getApplicationContext(), "Value restored from slot 1!", Toast.LENGTH_SHORT).show();
            }
        });

        sbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = store2;
                viewfield.setText(count.toString());
                Toast.makeText(getApplicationContext(), "Value restored from slot 2!", Toast.LENGTH_SHORT).show();
            }
        });


        sbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = store3;
                viewfield.setText(count.toString());
                Toast.makeText(getApplicationContext(), "Value restored from slot 3!", Toast.LENGTH_SHORT).show();
            }
        });


        sbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = store4;
                viewfield.setText(count.toString());
                Toast.makeText(getApplicationContext(), "Value restored from slot 4!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("countvalue",count);
        outState.putInt("leapy", leapnum);
        outState.putInt("s1", store1);
        outState.putInt("s2", store2);
        outState.putInt("s3", store3);
        outState.putInt("s4", store4);

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

        store1 = savedInstanceState.getInt("s1");
        store2 = savedInstanceState.getInt("s2");
        store3 = savedInstanceState.getInt("s3");
        store4 = savedInstanceState.getInt("s4");
        sbutton1.setText(getText(R.string.store1) + store1.toString());
        sbutton2.setText(getText(R.string.store2) + store2.toString());
        sbutton3.setText(getText(R.string.store3) + store3.toString());
        sbutton4.setText(getText(R.string.store4) + store4.toString());




    }
}
