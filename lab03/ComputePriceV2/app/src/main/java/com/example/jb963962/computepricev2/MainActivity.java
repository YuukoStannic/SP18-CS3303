package com.example.jb963962.computepricev2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button compute, add_item, show_list;
    private EditText price_entry, quantity_entry, tax_entry, total_display, name_entry;
    private ArrayList<Item> items;
    private double tax_rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This will hold all the items entered.
        items = new ArrayList<>();

        //associate objects to the correct xml fields.
        name_entry = findViewById(R.id.item_name_entry);
        price_entry = findViewById(R.id.item_price_entry);
        quantity_entry = findViewById(R.id.item_qty_entry);
        tax_entry = findViewById(R.id.item_tax_entry);

        total_display = findViewById(R.id.item_total_entry);

        // associate button objects to their xml and set listeners
        compute = findViewById(R.id.compute_button);
        compute.setEnabled(true);
        compute.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (tryCalculate()) {
                    add_item.setEnabled(true);
                    show_list.setEnabled(true);
                    compute.setEnabled(false);
                }
            }
        });

        show_list = findViewById(R.id.show_list_button);
        show_list.setEnabled(false);
        show_list.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                // prepare  the items object to be sent over to the ListItems activity
                // send object and open the ListItems Activity
                Toast.makeText(MainActivity.this, "Show list clicked!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ListItemsActivity.class);
                intent.putExtra("ITEMS",items);
                startActivity(intent);

            }
        });

        add_item = findViewById(R.id.add_item_button);
        add_item.setEnabled(false);
        add_item.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                Item item = new Item(); // temp value
                // open the add item activity here
                Toast.makeText(MainActivity.this, "Add item clicked!", Toast.LENGTH_SHORT).show();


                //logic about opening activity above
                tryCalculateFromReturn(item);
            }
        });

    }

    // returns true if the calculation was successful
    private Boolean tryCalculate() {
        double total, price;
        int qty;

        try {
            // check for valid input ( kinda)
            price = Double.parseDouble(price_entry.getText().toString());
            tax_rate = Double.parseDouble(tax_entry.getText().toString());
            qty = Integer.parseInt(quantity_entry.getText().toString());

        } catch (NumberFormatException e) {
            invalidInputToast();
            return false;
        }

        total = (price * qty) + (price * qty * tax_rate) / 100;
        total_display.setText(String.format("$%.2f", total));

        //package data in to an item and store it.

        addToItems(new Item(
                name_entry.getText().toString(),
                String.format("$%.2f", price),
                quantity_entry.getText().toString()
        ));

        return true;
    }

    private void addToItems(Item item) {
        items.add(item);
    }

    private boolean tryCalculateFromReturn(Item item) {
        name_entry.setText(item.getIName());
        price_entry.setText(item.getPrice());
        quantity_entry.setText(item.getQty());
        return tryCalculate();

    }

    private void invalidInputToast() {
        Toast toast = Toast.makeText(this, "Invalid Input!", Toast.LENGTH_SHORT);
        TextView v = toast.getView().findViewById(android.R.id.message);
        v.setTextColor(Color.RED);
        toast.show();
    }
}
