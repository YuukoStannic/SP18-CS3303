package com.example.jecsan.mystore;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class StoreActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        String[] menu_items_txt = {
                "Dasani Water\n$2.00",
                "Fruit Maple Oatmeal\n$2.00",
                "Hotcakes\n$2.00",
                "Sausage Biscuit\n$1.99",
                "Bacon Egg Biscuit\n$2.00",
                "Egg Sausage Biscuit\n$2.00",
                "Sausage Burrito\n$1.75"
        };

        int[] images = {
                R.drawable.dasani_water,
                R.drawable.fruit_maple_oatmeal,
                R.drawable.hotcakes,
                R.drawable.sausage_biscuit_regular_size_biscuit,
                R.drawable.bacon_egg_cheese_biscuit,
                R.drawable.biscuit_with_egg_regular_size_biscuit,
                R.drawable.sausage_burrito
        };
        TextView[] menu_items_tv = new TextView[menu_items_txt.length];

        ImageButton[] menu_buttons = new ImageButton[menu_items_txt.length];

        TableLayout menu_table = findViewById(R.id.menu_table);
        int i;
        for (i = 0 ; i < menu_buttons.length; i++) {
            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            menu_buttons[i] = new ImageButton(this);
            menu_buttons[i].setImageResource(images[i]);
            menu_buttons[i].setOnClickListener(this);
            menu_buttons[i].setTag(i);
            menu_buttons[i].setId(i);

            menu_items_tv[i] = new TextView(this);
            menu_items_tv[i].setText(menu_items_txt[i]);
            menu_items_tv[i].setTypeface(null, Typeface.BOLD);
            menu_items_tv[i].setTextSize(20);
            menu_items_tv[i].setTextColor(Color.GRAY);


            row.addView(menu_buttons[i]);
            row.addView(menu_items_tv[i]);
            menu_table.addView(row, i);


        }
        TableRow row = new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(lp);

        Button processButton = new Button(this);
        processButton.setOnClickListener(this);
        processButton.setText("Process Order");
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.span = 2;
        processButton.setLayoutParams(params);
        processButton.setTypeface(null, Typeface.BOLD);
        processButton.setTextSize(20);
        processButton.setTextColor(Color.GRAY);
        row.addView(processButton);
        menu_table.addView(row,i);
    }

    @Override
    public void onClick(View v) {

    }
}
