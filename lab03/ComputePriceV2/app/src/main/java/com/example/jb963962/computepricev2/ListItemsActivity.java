package com.example.jb963962.computepricev2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ListItemsActivity extends AppCompatActivity {

    private ArrayList<Item> items;
    private final String ITEMS = "ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);


        // get the items from the last activity;

        items = (ArrayList<Item>) getIntent().getSerializableExtra(ITEMS);
        TableLayout table = findViewById(R.id.item_table);


        for (Item item : items) {
            TableRow row = new TableRow(this);

            TextView name = new TextView(this);
            TextView price = new TextView(this);
            TextView qty = new TextView(this);

            name.setText(item.getIName());
            qty.setText(item.getQty());
            price.setText(item.getPrice());

            qty.setPadding(10, 0, 20, 0);
            name.setPadding(20, 0, 30, 0);
            price.setPadding(0, 0, 20, 0);

            row.addView(qty);
            row.addView(name);
            row.addView(price);

            table.addView(row);
        }


    }
}
