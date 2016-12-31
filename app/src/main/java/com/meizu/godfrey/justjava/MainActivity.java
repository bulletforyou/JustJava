package com.meizu.godfrey.justjava;

import android.icu.util.IslamicCalendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  submitOrder(View view){
        CheckBox checkBox=(CheckBox)findViewById(R.id.checkbox1);
        final boolean hasWhippedCream=checkBox.isChecked();
        Log.v("MainActivity","has Whipped Cream"+hasWhippedCream);
        int price= calculationPrice();
        String priceMessage=createOrderSummary(price,hasWhippedCream);
        displayMessage(priceMessage);
    }

    public void displayMessage(String price) {
        TextView tv=(TextView)findViewById(R.id.textView3);
        tv.setText(price);

    }

    public String createOrderSummary(int price, boolean addWhippedCream) {
        String priceMessage = " Name:Lyla the Labyrinth";
        priceMessage += "\n Add Whipped cream?" + addWhippedCream;
        priceMessage += "\n Quantity:" + quantity;
        priceMessage += "\n Total:" + calculationPrice();
        priceMessage += "\n Thank you";
        return priceMessage;

    }

    public int calculationPrice() {
        return quantity * 5;
    }

    public void decrement(View view) {
        quantity -= 1;
        displayQuantity(quantity);
    }

    public void increment(View view) {
        quantity += 1;
        displayQuantity(quantity);
    }

    public void displayQuantity(int quantity) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setMaxLines(10);
        tv.setText(String.valueOf(quantity));
    }
}
