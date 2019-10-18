package com.example.myapplication;
// Add your package below
/* package com.example.myapplication; */

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Queue;
import java.util.jar.Attributes;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameeidtText =(EditText)findViewById(R.id.name_editText);
        String name = nameeidtText.getText().toString();
         CheckBox whippedCreamCheckbox=(CheckBox)findViewById(R.id.whipped_cream_checkbox);
         boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
         CheckBox chocolateCheckbox =(CheckBox)findViewById(R.id.chocolate_checkbox);
         boolean hasChocolate = chocolateCheckbox.isChecked();

        int price = calculatesPrise(hasWhippedCream,hasChocolate);
        String priceMessage = createOrderSummary (name,price , hasWhippedCream, hasChocolate);
        displayMessage (priceMessage);
    }


    /**

     * This method is called when the plus button is clicked.
     */
    public void incremrnt(View view) {
        if (quantity ==100){
            Toast.makeText(this, "you cannot have more the 100 coffee",Toast.LENGTH_SHORT).show();
            return;

        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }
    /**
     * This method is called when the miuns button is clicked.
     */
    public void decrement(View view) {
        if (quantity<2){
            Toast.makeText(this, "you  cannot have less than 1 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);

    }

    /**
     * creat summary in the order
     *

     * @return  text summary
     * @
     * * @param addWhippedCream is whether or not the user wants whipped cream topping
     *  * @param addChocolate is whether or not the user wants chocolate topping
     */
    private int calculatesPrise(boolean addwhippedCream , boolean addchocolate){
        int baseprice = 5;
      if (addwhippedCream ){
          baseprice = baseprice + 1 ;
        }

      if (addchocolate) {
          baseprice = baseprice + 2;

        }
        return (quantity*baseprice);

    }

     private String createOrderSummary( String name ,int price , boolean addwhippedCream, boolean addchocolate){
         String priceMessage = "name: "+ name;
         priceMessage += "\nadd whipped cream?" +addwhippedCream;
         priceMessage += "\nadd chocolate?"+addchocolate;
         priceMessage += "\nQuantity: " + quantity;
         priceMessage += "\nTotal: " + "$" + price;
         priceMessage += "\nthank you";
         return priceMessage;


     }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity (int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_view);
        orderSummaryTextView.setText(message);
    }
}