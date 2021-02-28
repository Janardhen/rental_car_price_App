package com.zybooks.rentalcarcharges;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity  {
    private TextView outputText;
    private Spinner typeSpinner;
    private EditText days;
    private HashMap<String, Double> priceMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeSpinner = (Spinner) findViewById(R.id.attendEditText);
        days = findViewById(R.id.attendEditText1);
        outputText = findViewById(R.id.answerTextView);

        addAdapterToSpinner(typeSpinner,R.array.type);
        createPriceMap();
    }

    private void addAdapterToSpinner(Spinner s,int Array) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(Array));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }

    private void createPriceMap() {
        priceMap = new HashMap<String, Double>();
        priceMap.put("Economy", 24.99);
        priceMap.put("Compact", 29.99);
        priceMap.put("Intermediate", 39.99);
        priceMap.put("Standard", 44.99);
        priceMap.put("Fullsize",49.99);
    }

    public void calculateClick(View view) {
        String type = typeSpinner.getSelectedItem().toString();
        String daysString = days.getText().toString();

        outputText.setText("Your Total due cost : " + calculateCost());
    }

    private double calculateCost() {
        String serviceString = typeSpinner.getSelectedItem().toString();
        String daysString = days.getText().toString();


        int days = Integer.parseInt(daysString);

        double price = priceMap.get(serviceString);
        price *=  days;


        return price; // TODO
    }
}
