package com.example.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String currentAmount = "";
    int tip_percent = 0;
    int split_bill_amount = 1;

    float total_to_pay = 0;
    float total_tip = 0;
    float total_per_person = 0;

    int decimal_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView total_bill_amount = (TextView) findViewById(R.id.textView12);
        final TextView tip_percent_text = (TextView) findViewById(R.id.textView3);
        final TextView split_amount_text = (TextView) findViewById(R.id.textView5);
        final TextView total_to_pay_text = (TextView) findViewById(R.id.textView7);
        final TextView total_tip_text = (TextView) findViewById(R.id.textView13);
        final TextView total_per_person_text = (TextView) findViewById(R.id.textView14);

        final Button tip_percent_decrement = (Button)findViewById(R.id.button2);
        tip_percent_decrement.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(tip_percent > 0) {
                    tip_percent = tip_percent - 1;
                }
                System.out.printf("%d", tip_percent);
                tip_percent_text.setText(String.valueOf(tip_percent));
            }
        });

        final Button tip_percent_increment = (Button)findViewById(R.id.button3);
        tip_percent_increment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                tip_percent = tip_percent + 1;
                System.out.printf("%d", tip_percent);
                tip_percent_text.setText(String.valueOf(tip_percent));
            }
        });

        Button split_bill_decrement = (Button)findViewById(R.id.button4);
        split_bill_decrement.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                if(split_bill_amount > 1){
                    split_bill_amount = split_bill_amount - 1;
                }
                System.out.printf("%d", split_bill_amount);
                split_amount_text.setText(String.valueOf(split_bill_amount));
            }
        });

        Button split_bill_increment = (Button)findViewById(R.id.button5);
        split_bill_increment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                split_bill_amount = split_bill_amount + 1;
                System.out.printf("%d", split_bill_amount);
                split_amount_text.setText(String.valueOf(split_bill_amount));
            }
        });

        Button button_1 = (Button)findViewById(R.id.button6);
        button_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '1';
                total_bill_amount.setText(currentAmount);
            }
        });

        Button button_2 = (Button)findViewById(R.id.button7);
        button_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '2';
                total_bill_amount.setText(currentAmount);
            }
        });

        Button button_3 = (Button)findViewById(R.id.button8);
        button_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '3';
                total_bill_amount.setText(currentAmount);
            }
        });

        Button button_4 = (Button)findViewById(R.id.button9);
        button_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '4';
                total_bill_amount.setText(currentAmount);
            }
        });

        Button button_5 = (Button)findViewById(R.id.button10);
        button_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '5';
                total_bill_amount.setText(currentAmount);
            }
        });

        Button button_6 = (Button)findViewById(R.id.button11);
        button_6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '6';
                total_bill_amount.setText(currentAmount);
            }
        });

        Button button_7 = (Button)findViewById(R.id.button12);
        button_7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '7';
                total_bill_amount.setText(currentAmount);
            }
        });

        Button button_8 = (Button)findViewById(R.id.button13);
        button_8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '8';
                total_bill_amount.setText(currentAmount);
            }
        });

        Button button_9 = (Button)findViewById(R.id.button14);
        button_9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '9';
                total_bill_amount.setText(currentAmount);
            }
        });

        Button button_reset = (Button)findViewById(R.id.button15);
        button_reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = "";
                tip_percent = 0;
                split_bill_amount = 0;
                total_to_pay = 0;
                total_tip = 0;
                total_per_person = 0;
                total_bill_amount.setText(currentAmount);
                tip_percent_text.setText(String.valueOf(tip_percent));
                split_amount_text.setText(String.valueOf(split_bill_amount));
                total_to_pay_text.setText("");
                total_tip_text.setText("");
                total_per_person_text.setText("");
                decimal_count = 0;

            }
        });

        Button button_0 = (Button)findViewById(R.id.button16);
        button_0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '0';
                total_bill_amount.setText(currentAmount);
            }
        });

        Button button_del = (Button)findViewById(R.id.button17);
        button_del.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                int length = currentAmount.length();
                if(length > 0) {
                    currentAmount = currentAmount.substring(0, length - 1);
                }
                if(!currentAmount.contains(".")){
                    decimal_count = 0;
                }
                total_bill_amount.setText(currentAmount);

            }
        });

        Button button_calculate = (Button)findViewById(R.id.button18);
        button_calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                float total_amount = Float.parseFloat(currentAmount);

                total_tip = total_amount*((float)tip_percent/100);
                total_to_pay = total_amount + total_tip;
                total_per_person = total_to_pay/split_bill_amount;
                total_to_pay_text.setText(String.valueOf(total_to_pay));
                total_tip_text.setText(String.valueOf(total_tip));
                total_per_person_text.setText(String.valueOf(total_per_person));

            }
        });

        Button button_decimal = (Button)findViewById(R.id.button20);
        button_decimal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                if(decimal_count == 0) {
                    currentAmount = currentAmount + '.';
                    total_bill_amount.setText(currentAmount);
                    decimal_count = 1;
                }
            }
        });

    }
}
