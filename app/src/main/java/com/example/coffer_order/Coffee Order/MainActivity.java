package com.example.zion.happy;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        quantity=quantity+1;
        display(quantity);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //Field for user name input
        EditText nameField =(EditText)findViewById(R.id.user_Name);
        String name = nameField.getText().toString();

        //check weather the user want wipped cream or not
        CheckBox wippedCreamCheckBox= (CheckBox) findViewById(R.id.cream_checkbox);
        boolean hasWippedCream=wippedCreamCheckBox.isChecked();

        //check weather the user want chocolate or not
        CheckBox chocolateBox=(CheckBox) findViewById(R.id.chocolate_box);
        boolean isChocolate = chocolateBox.isChecked();

        int price =calculatePrice(hasWippedCream,isChocolate);
        String priceMessage = createOrderSummery(price,hasWippedCream,name,isChocolate);
        displayMessage(priceMessage);
    }

    //calculate price
    //calculate price for chocolate adding and wipped added

    private int calculatePrice(boolean addWippped,boolean addChocolate){
        int basePrice=5;
        //if wipped is added

        if (addWippped){
            basePrice+=1;
        }

        //if chocolate is added
        if (addChocolate){
            basePrice+=2;
        }
        return quantity*basePrice;
    }

    private String createOrderSummery(int price,boolean addWippedCream,String name,boolean isChocolate){
        String priceMessage = "Name : "+name;
        priceMessage+="\nAdd Wipped Cream? "+addWippedCream;
        priceMessage+="\nAdd Wipped Cream? "+isChocolate;
        priceMessage+="\nQuantity=" + quantity;
        priceMessage+="\nTotal: $ "+ price;
        priceMessage+= "\nThank You";
        return priceMessage;
    }
    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        quantity=quantity-1;
        display(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given message value on the screen.
     */

    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.orderSummery_text_view);
        priceTextView.setText(message);
    }

}
