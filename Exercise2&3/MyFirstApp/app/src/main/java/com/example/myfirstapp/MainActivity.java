package com.example.myfirstapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String currentAmount = "";
    int tip_percent = 0;
    int split_bill_amount = 1;

    double total_to_pay = 0;
    double total_tip = 0;
    double total_per_person = 0;

    int decimal_count = 0;

    MainActivity mainActivity;
    FileStorage fileStorage;

    public static final String CURRENT_AMOUNT = "current_amount";
    public static final String TOTAL_TIP_PERCENTAGE = "total_tip_percent";
    public static final String SPLIT_BILL_CUSTOMERS = "split_bill";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = (ImageView) findViewById(R.id.imageviewde2);
        final Bitmap bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        final DrawShapes drawShapes = new DrawShapes(canvas);
        drawShapes.drawDefault();
        mainActivity = this;
        fileStorage = new FileStorage(this.getApplicationContext());
        if ((savedInstanceState != null) && (savedInstanceState.getBoolean("filestorage") != true)) {
            fileStorage.setUp();
        }

        imageView.setImageBitmap(bitmap);

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
                Bitmap bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                final DrawShapes drawShapes = new DrawShapes(canvas);
                drawShapes.drawOval();
                imageView.setImageBitmap(bitmap);
            }
        });

        Button button_2 = (Button)findViewById(R.id.button7);
        button_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '2';
                total_bill_amount.setText(currentAmount);
                Bitmap bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                final DrawShapes drawShapes = new DrawShapes(canvas);
                drawShapes.drawCircle();
                imageView.setImageBitmap(bitmap);
            }
        });

        Button button_3 = (Button)findViewById(R.id.button8);
        button_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '3';
                total_bill_amount.setText(currentAmount);
                Bitmap bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                final DrawShapes drawShapes = new DrawShapes(canvas);
                drawShapes.drawRectangle();
                imageView.setImageBitmap(bitmap);
            }
        });

        Button button_4 = (Button)findViewById(R.id.button9);
        button_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '4';
                total_bill_amount.setText(currentAmount);
                Bitmap bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                final DrawShapes drawShapes = new DrawShapes(canvas);
                drawShapes.drawSquare();
                imageView.setImageBitmap(bitmap);
            }
        });

        Button button_5 = (Button)findViewById(R.id.button10);
        button_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '5';
                total_bill_amount.setText(currentAmount);
                Bitmap bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                final DrawShapes drawShapes = new DrawShapes(canvas);
                drawShapes.drawTriangle();
                imageView.setImageBitmap(bitmap);
            }
        });

        Button button_6 = (Button)findViewById(R.id.button11);
        button_6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '6';
                total_bill_amount.setText(currentAmount);
                Bitmap bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                final DrawShapes drawShapes = new DrawShapes(canvas);
                drawShapes.drawRhombus();
                imageView.setImageBitmap(bitmap);
            }
        });

        Button button_7 = (Button)findViewById(R.id.button12);
        button_7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '7';
                total_bill_amount.setText(currentAmount);
                Bitmap bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                final DrawShapes drawShapes = new DrawShapes(canvas);
                drawShapes.drawStar();
                imageView.setImageBitmap(bitmap);

            }
        });

        Button button_8 = (Button)findViewById(R.id.button13);
        button_8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '8';
                total_bill_amount.setText(currentAmount);
                Bitmap bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                final DrawShapes drawShapes = new DrawShapes(canvas);
                drawShapes.drawHexagon();
                imageView.setImageBitmap(bitmap);

            }
        });

        Button button_9 = (Button)findViewById(R.id.button14);
        button_9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '9';
                total_bill_amount.setText(currentAmount);
                Bitmap bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                final DrawShapes drawShapes = new DrawShapes(canvas);
                drawShapes.drawOctagon();
                imageView.setImageBitmap(bitmap);

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
                drawShapes.drawDefault();
                imageView.setImageBitmap(bitmap);

            }
        });

        Button button_0 = (Button)findViewById(R.id.button16);
        button_0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                currentAmount = currentAmount + '0';
                total_bill_amount.setText(currentAmount);
                Bitmap bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                final DrawShapes drawShapes = new DrawShapes(canvas);
                drawShapes.drawPentagon();
                imageView.setImageBitmap(bitmap);
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
                double total_amount = Double.parseDouble(currentAmount);

                total_tip = total_amount*((double)tip_percent/100);
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


        Button button_save_view = (Button) findViewById(R.id.button26);
        button_save_view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onSaveButtonClicked(view);
            }
        });

        Button button_navigate_view = (Button) findViewById(R.id.button25);
        button_navigate_view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });



    }

    public void sendMessage(){
        Intent intent = new Intent(this, NewActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Navigate to View", "View");
        startActivity(intent);
    }


    private void onSaveButtonClicked(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View view1 = inflater.inflate(R.layout.save_transaction_dialog, null);
        builder.setView(view1);

        final TextView totalAmount = (TextView) view1.findViewById(R.id.total_amount);
        totalAmount.setText(currentAmount);
        TextView totalTip =  (TextView) view1.findViewById(R.id.totaltip_amount);
        totalTip.setText(String.valueOf(total_tip));
        TextView numberOfDiners = (TextView) view1.findViewById(R.id.number_of_diners_amount);
        numberOfDiners.setText(String.valueOf( split_bill_amount));

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick( DialogInterface dialog, int id) { /* do nothing */ }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                Spinner restaurantsspinner  = (Spinner) view1.findViewById(R.id.restaurants_spinner);
                String spinner_value = restaurantsspinner.getSelectedItem().toString();

                Spinner ratingspinner = (Spinner) view1.findViewById(R.id.rating_stars);
                int rating = Integer.parseInt(ratingspinner.getSelectedItem().toString());

                fileStorage.writeToStorage(spinner_value, Double.parseDouble(currentAmount), total_tip, split_bill_amount, rating, new Date().toString());

            }
        });

        AlertDialog FileSaveDialog = builder.create();
        FileSaveDialog.show();
        FileSaveDialog.getWindow().setLayout(1000, 2000);

    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putBoolean("filestorage", true);
    }



}
