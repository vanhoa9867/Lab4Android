package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String value;

    private List<Restaurant> restaurantList = new ArrayList<Restaurant>();
    private ArrayAdapter<Restaurant>adapter = null;
    //private Restaurant restaurant = new Restaurant();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button save = findViewById(R.id.btnSave);
        save.setOnClickListener(onSave);

        ListView list = (ListView) findViewById(R.id.restaurants);

        adapter = new ArrayAdapter<Restaurant>(this, android.R.layout.simple_list_item_1,restaurantList);

        list.setAdapter(adapter);
    }

    public void showMe(View v) {
        String msg;
        EditText et1 = findViewById(R.id.name);
        EditText et2 = findViewById(R.id.addr);

        msg = "Name: " + et1.getText().toString() + " Address: " + et2.getText().toString() + " Type: " + value;

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private View.OnClickListener onSave = new View.OnClickListener() {
        public void onClick(View v) {
            Restaurant restaurant = new Restaurant();

            EditText name = findViewById(R.id.name);
            EditText address = findViewById(R.id.addr);

            restaurant.setName(name.getText().toString());
            restaurant.setAddress(address.getText().toString());

            RadioGroup type = findViewById(R.id.type);
            switch (type.getCheckedRadioButtonId()) {
                case R.id.take_out:
                    restaurant.setType("Take out");
                    break;
                case R.id.sit_down:
                    restaurant.setType("Sit down");
                    break;
                case R.id.delivery:
                    restaurant.setType("Delivery");
                    break;
            }
            value = ((RadioButton) findViewById(type.getCheckedRadioButtonId())).getText().toString();
            showMe(v);
            restaurantList.add(restaurant);
        }
    };
}
