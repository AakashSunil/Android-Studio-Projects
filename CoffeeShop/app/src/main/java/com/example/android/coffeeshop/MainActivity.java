package com.example.android.coffeeshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int n =0;
    boolean hascheck;
    boolean isHascheck;
    String priceMessage;
    public void check(){
        CheckBox check = (CheckBox) findViewById(R.id.toppings);
        hascheck=check.isChecked();}
    public void check1(){
        CheckBox check = (CheckBox) findViewById(R.id.toppings1);
        isHascheck=check.isChecked();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
         /**
         * This method is called when the order button is clicked.
         */
    public void checkPrice(View view) {
        int price = calculatePrice();
        display1(price);
        check();
        check1();
        if (hascheck == true) {
            if (isHascheck == true) {
                priceMessage = "Rs." + price;
                priceMessage = "\nCoffee With Whipped Cream and Chocolate\n" + "Quantity= " + n + "\n" + priceMessage;


            } else {
                priceMessage = "Rs." + price;
                priceMessage = "\nCoffee with Whipped Cream\n" + "Quantity= " + n + "\n" + priceMessage;


            }
        } else {
            if (isHascheck == true) {
                priceMessage = "Rs." + price;
                priceMessage = "\nCoffee With Chocolate\n" + "Quantity= " + n + "\n" + priceMessage;

            } else {
                priceMessage = "Rs." + price;
                priceMessage = "\nCoffee\n" + "Quantity= " + n + "\n" + priceMessage;

            }

        }

        displayMessage(priceMessage);
    }
    public void submitOrder(View view) {
        // Get user's name
        EditText nameField = (EditText) findViewById(R.id.Name);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();

        EditText name_Field = (EditText) findViewById(R.id.ID);
        Editable name_Editable = name_Field.getText();
        String email = name_Editable.toString();

        // Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.toppings);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        // Figure out if the user wants chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.toppings1);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        // Calculate the price
        int price = calculatePrice();

        // Display the order summary on the screen
        String message = createOrderSummary(price,name);
        // Use an intent to launch an email app.
// Send the order summary in the email body.
        Uri emailuri = Uri.parse("mailto:"+ email);
        Intent intent = new Intent(Intent.ACTION_SENDTO, emailuri);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, message);


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

       /* displayMessage(message);*/
    }

    /*public void submitOrder(View view) {
        EditText text=(EditText) findViewById(R.id.Name);
        String text1=text.getText().toString();
        if(n!=0) {
            int price=calculatePrice();
            String priceMessage = createOrderSummary(price,text1);
            displayMessage(priceMessage);
        }
        else
        {
            return;
        }

    }*/
    public void increase(View view) {
        check();
        check1();
        n = n + 1;
        display(n);
        /*if(hascheck==true) {
            if (isHascheck == true) {
                String priceMessage = "Rs." + ((n * 25) + (n * 10) + (n * 15));
                displayMessage(priceMessage);
            } else {
                String priceMessage = "Rs." + ((n * 25) + (n * 10));
                displayMessage(priceMessage);
            }
        }
         else{
            if (isHascheck == true) {
                String priceMessage = "Rs." + ((n * 25) + (n * 15));
                displayMessage(priceMessage);
            } else {
                String priceMessage = "Rs." + (n * 25);
                displayMessage(priceMessage);
            }
        }*/
    }
    public void decrease(View view) {
        check();
        check1();
        n = n - 1;
        if(n<=0)
        {
            n=0;
            display(n);
        }
        else {
            display(n);

        }/*if(hascheck==true) {
            if (isHascheck == true) {
                String priceMessage = "Rs." + ((n * 25) + (n * 10) + (n * 15));
                displayMessage(priceMessage);
            } else {
                String priceMessage = "Rs." + ((n * 25) + (n * 10));
                displayMessage(priceMessage);
            }
        }
        else{
            if (isHascheck == true) {
                String priceMessage = "Rs." + ((n * 25) + (n * 15));
                displayMessage(priceMessage);
            } else {
                String priceMessage = "Rs." + (n * 25);
                displayMessage(priceMessage);
            }
        }*/
    }
    private void display1(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.Order_Summary_text_view);
        quantityTextView.setText("Rs." + number);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView OrderSummaryTextView = (TextView) findViewById(R.id.Order_Summary_text_view);
        OrderSummaryTextView.setText(message);
    }
    private int calculatePrice(){
        check();
        check1();
        int price;
        if(hascheck==true) {
            if (isHascheck == true) {
                price= ((n * 25) + (n * 10) + (n * 15));
            } else {
                price= ((n * 25) + (n * 10));
            }
        }
        else{
            if (isHascheck == true) {
                price= ((n * 25) + (n * 15));
            } else {
                price= (n * 25);
            }
        }
            return price;
        }
    private String createOrderSummary(int price,String name) {
            check();
            check1();
            if(hascheck==true)
            {
                if (isHascheck == true) {
                    String priceMessage = "Rs." + price;
                    priceMessage ="Name:"+name + "\nCoffee With Whipped Cream and Chocolate\n" +"Quantity= " + n + "\n" + priceMessage +  "\nThank You!" + "\nHope To See You Soon!";
                    return priceMessage;

            }   else {String priceMessage = "Rs." + price;
                    priceMessage ="Name:"+ name+"\nCoffee with Whipped Cream\n" + "Quantity= " + n + "\n" + priceMessage + "\nThank You!" + "\nHope To See You Soon!";
                    return priceMessage;

            }
            }
            else{
                if (isHascheck == true) {
                    String priceMessage = "Rs." + price;
                    priceMessage ="Name:"+ name+"\nCoffee With Chocolate\n" +"Quantity= " + n + "\n" + priceMessage +  "\nThank You!" + "\nHope To See You Soon!";
                    return priceMessage;
                }

        else{
            String priceMessage = "Rs." + price;
            priceMessage ="Name:"+ name+"\nCoffee\n" + "Quantity= " + n + "\n" + priceMessage + "\nThank You!" + "\nHope To See You Soon!";
            return priceMessage;
        }

    }
}
}