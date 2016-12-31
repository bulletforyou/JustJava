package com.meizu.godfrey.justjava;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import static android.R.attr.name;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void submitOrder(View view) {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.whippedcreamcheckbox);
        final boolean hasWhippedCream = checkBox1.isChecked();
        Log.v("MainActivity", "has Whipped Cream" + hasWhippedCream);

        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkboxcheckbox);
        final boolean hasChocolate = checkBox2.isChecked();
        Log.v("MainActivity", "has Whipped Cream" + hasChocolate);

        EditText editText = (EditText) findViewById(R.id.name_field);
        String name = editText.getText().toString();
        Log.v("MainActivity", "Customer name" + name);
        int price = calculationPrice(hasChocolate,hasChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, name);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
//        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, name);
        intent.putExtra(intent.EXTRA_TEXT,priceMessage);
//        intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        displayMessage(priceMessage);
    }

    public void displayMessage(String price) {
        TextView tv = (TextView) findViewById(R.id.textView3);
        tv.setText(price);

    }

    /**
     * Create summary of the order.
     *
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate    is whether or not the user wants whipped cream topping
     * @param price           of the order
     * @return text summary
     */
    public String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String name) {
        String priceMessage = " Name:" + name;
        priceMessage += "\n Add Whipped cream?" + addWhippedCream;
        priceMessage += "\n Add Whipped cream?" + addChocolate;
        priceMessage += "\n Quantity:" + quantity;
        priceMessage += "\n Total:" + calculationPrice(addWhippedCream, addChocolate);
        priceMessage += "\n Thank you";
        return priceMessage;

    }

    public int calculationPrice(boolean addWhippedCream, boolean addChocolate) {
        int baseprice = 5;
        if (addWhippedCream) {
            baseprice += 1;
        }
        if (addChocolate) {
            baseprice += 2;
        }
        return baseprice * quantity;
    }

    public void decrement(View view) {
        if(quantity<=1){
            Toast.makeText(this,"不能小于1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity -= 1;
        displayQuantity(quantity);
    }

    public void increment(View view) {
        if (quantity>=100){
            Toast.makeText(this,"不能大于100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity += 1;
        displayQuantity(quantity);
    }

    public void displayQuantity(int quantity) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setMaxLines(10);
        tv.setText(String.valueOf(quantity));
    }






}
