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

    // Create variables to reference all the objects in the app: buttons, text fields, and internal
    // properties, such as integers. They must be stored here, because res is permanently final.

    //These buttons handle the basic counting up and counting down
    private Button increment;
    private Button decrement;
    private Button clear;

    //This is the textbox to display the current number
    private TextView viewfield;

    //This is the integer for the current count.
    private Integer count = 0;


    //These following variables handle the count leaping functionality.

    //This takes in user input to edit what the leap value is.
    private EditText leapset;

    //In case the leap value is never used, initialize it with a variable.
    private Integer leapnum = 5;

    //Buttons for when the leap should be utilized.
    private Button leapup;
    private Button leapdown;

    //Variables to store the value of the store slots. Initialized to 0 to prevent app crashing.
    private Integer store1 = 0;
    private Integer store2 = 0;
    private Integer store3 = 0;
    private Integer store4 = 0;

    //Buttons to handle the store/save functionality.
    private Button sbutton1;
    private Button sbutton2;
    private Button sbutton3;
    private Button sbutton4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Direct each variable to the object it needs to reference.
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

        //Correct the text on the store buttons to properly include the current slot values
        sbutton1.setText(getText(R.string.store1) + store1.toString());
        sbutton2.setText(getText(R.string.store2) + store2.toString());
        sbutton3.setText(getText(R.string.store3) + store3.toString());
        sbutton4.setText(getText(R.string.store4) + store4.toString());

        //Take action to change the leap value whenever the user changes the text in the box.
        leapset.addTextChangedListener(new TextWatcher()
        {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s)
            {
                //Prevent crashing by checking if the user enters a value
                if (s.length() > 0)
                {
                    //If a value is there, use it for leapnum
                    leapnum = Integer.valueOf(s.toString());
                }
                else
                {
                    //If the text box is empty, reset the leapnum to its default value.
                    leapnum = 5;
                }
            }
        });

        leapup.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When " Leap +" is clicked, add the leap number to the current value.
                count += leapnum;

                //Change the text box to reflect the current number's value
                viewfield.setText(count.toString());
            }
        });

        leapdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When " Leap -" is clicked, subtract the leap number from the current value.
                count -= leapnum;

                //Change the text box to reflect the current number's value
                viewfield.setText(count.toString());
            }
        });

        increment.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                //Add one to the current value when + is clicked
                count += 1;

                //Reflect the change in the visible text box
                viewfield.setText(count.toString());

            }
        });

        decrement.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //Subtract one from the current value when - is clicked
                count -= 1;

                //Reflect the change in value in the text box
                viewfield.setText(count.toString());
            }
        });

        clear.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                //If this button is clicked, reset the value to 0. Reflect the change.
                count = 0;
                viewfield.setText(count.toString());
            }
        });

        //If a slot button is held...
        sbutton1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //...save it in the correct slot...
                store1 = count;

                //...update the button text to show that a number is saved...
                sbutton1.setText(getText(R.string.store1) + store1.toString());

                //...and give the user some notification via toast message.
                Toast.makeText(getApplicationContext(), "Value stored in slot 1!", Toast.LENGTH_SHORT).show();
                return false; //Why is this listener a boolean anyway?
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

        //Should the user tap a store button...
        sbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //...set the current value to the stored number...
                count = store1;
                viewfield.setText(count.toString()); //...reflect the change, then give feedback
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
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        //Save important numbers, such as the current value, the leap number, and the stored slots
        outState.putInt("countvalue",count);
        outState.putInt("leapy", leapnum);
        outState.putInt("s1", store1);
        outState.putInt("s2", store2);
        outState.putInt("s3", store3);
        outState.putInt("s4", store4);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);

        //Return the count to its former place and reflect the change
        count = savedInstanceState.getInt("countvalue");
        viewfield.setText(count.toString());

        // temporarily hold the leap value so tests can be run.
        Integer tempnum = savedInstanceState.getInt("leapy");

        //if the value is the default, then just reset it to the default
        if (tempnum == 5) {leapnum = 5;}

        else
        {
            //If its not the default, restore the number, then reflect the current value in the text box
            leapnum = tempnum;
            leapset.setText(leapnum.toString());
        }

        //Restore the store slots to their previous values, then reflect the change in the button labels.
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
