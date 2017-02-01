package tk.blanchettapps.button_counter_blanchett;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button increment;
    private Button decrement;
    private Button clear;
    private TextView viewfield;
    private Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        increment = (Button) findViewById(R.id.plusbutton);
        decrement = (Button) findViewById(R.id.minusbutton);
        clear = (Button) findViewById(R.id.clearbutton);
        viewfield = (TextView) findViewById(R.id.counterview);

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


}
