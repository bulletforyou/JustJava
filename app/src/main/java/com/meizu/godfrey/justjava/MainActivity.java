package com.meizu.godfrey.justjava;

import android.icu.util.IslamicCalendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  submitOrder(View view){
        CheckBox checkBox=(CheckBox)findViewById(R.id.checkbox_whipped_cream);
        boolean hasWhippedCream=checkBox.isChecked();
        Log.v("MainActivity","has Whipped Cream"+hasWhippedCream);
        int price= calculationPrice();
        String priceMessage=createOrderSummary(price,hasWhippedCream);
        displayMessage(priceMessage);
    }

    private void displayMessage(String price) {
    }

    private String createOrderSummary(int price,boolean addWhippedCream){
            String priceMessage="Name:Lyla the Labyrinth";
            priceMessage+="\n Add Whipped cream:"+addWhippedCream;
            priceMessage+="\n Quantity:"+quantity;
            priceMessage+="\n Total:"+quantity;
            priceMessage+="\n Thank you:"+quantity;
        return priceMessage;

    }

    private int calculationPrice(){
            return quantity*5;
    }

    private void decrement(){
        quantity-=1;
        displayQuantity(quantity);
    }
    private void increment(){
        quantity+=1;
        displayQuantity(quantity);
    }
    private void displayQuantity(View view){
        TextView tv=(TextView)findViewById(R.id.textView2);
        tv.setText(String.valueOf(quantity));
    }
}
