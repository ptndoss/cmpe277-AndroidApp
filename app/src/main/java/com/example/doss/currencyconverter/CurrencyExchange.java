package com.example.doss.currencyconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class CurrencyExchange extends AppCompatActivity {

    private float dollar_amt;
    private String to_convert_to_currency,dollar_amt_string,result_str=null;
    private double converted_dollar_amnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currencu_converter_page2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView dollarAmnt = (TextView)findViewById(R.id.dymanicTextView);
        TextView currency = (TextView) findViewById(R.id.currency);

        dollarAmnt.setText(getIntent().getStringExtra("DYNAMIC_DOLLAR"));
        currency.setText(getIntent().getStringExtra("CURRENCY"));
        String curr = getIntent().getStringExtra("CURRENCY");
        Log.i("<DOSS>.....",curr);
    }


    public void confirm(View view)
    {
        CurrencyBroadCastReciever broadcast = new CurrencyBroadCastReciever();
        Intent intent = new Intent(this, CurrencyBroadCastReciever.class);


        dollar_amt =  Float.valueOf(getIntent().getStringExtra("DYNAMIC_DOLLAR"));
        to_convert_to_currency = getIntent().getStringExtra("CURRENCY");

        switch(to_convert_to_currency){
            case "British Pound":
                converted_dollar_amnt = dollar_amt * 0.88;
                break;
            case "Indian Rupees":
                converted_dollar_amnt = dollar_amt * 70;
                break;

            case "Euro":
                converted_dollar_amnt = dollar_amt * 0.76;
                break;
        }


        intent.setAction("cmpe277.assignment2.CUSTOM_INTENT");

        intent.putExtra("DOLLAR_AMOUNT", dollar_amt);
        intent.putExtra("CURRENCY", to_convert_to_currency);
        intent.putExtra("CONVERTED_DOLLAR_AMNT", converted_dollar_amnt);

        sendBroadcast(intent);

    }

    public void close(View view){
            finish();
    }
}
