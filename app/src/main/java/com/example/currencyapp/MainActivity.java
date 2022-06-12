package com.example.currencyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    TextView textView_1;
    TextView textView_2;
    Spinner spinner_1;
    Spinner spinner_2;

    String from[] = {"US-USD", "Vietnam-Dong", "Korea-Won"};
    String to[] = {"US-USD", "Vietnam-Dong", "Korea-Won"};
    //1Won = 18đ
    //1USD = 23177đ
    //1Kip = 1582d. Update 6/11/2022

    Button buttonNumber0;
    Button buttonNumber1;
    Button buttonNumber2;
    Button buttonNumber3;
    Button buttonNumber4;
    Button buttonNumber5;
    Button buttonNumber6;
    Button buttonNumber7;
    Button buttonNumber8;
    Button buttonNumber9;
    Button clear_all;
    Button clear;
    Button btn_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNumber0 = (Button) findViewById(R.id.button_0);
        buttonNumber1 = (Button) findViewById(R.id.button_1);
        buttonNumber2 = (Button) findViewById(R.id.button_2);
        buttonNumber3 = (Button) findViewById(R.id.button_3);
        buttonNumber4 = (Button) findViewById(R.id.button_4);
        buttonNumber5 = (Button) findViewById(R.id.button_5);
        buttonNumber6 = (Button) findViewById(R.id.button_6);
        buttonNumber7 = (Button) findViewById(R.id.button_7);
        buttonNumber8 = (Button) findViewById(R.id.button_8);
        buttonNumber9 = (Button) findViewById(R.id.button_9);
        clear_all = (Button) findViewById(R.id.button_clear_all);
        clear = (Button) findViewById(R.id.button_clear);
        btn_out = (Button) findViewById(R.id.button_out);
        textView_1 = (TextView) findViewById(R.id.editNumber1);
        textView_2 = (TextView) findViewById(R.id.editNumber2);
        spinner_1 = (Spinner) findViewById(R.id.spinner_1);
        spinner_2 = (Spinner) findViewById(R.id.spinner_2);

        buttonNumber0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView_1.setText(textView_1.getText()+ "0");
            }
        });
        buttonNumber1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView_1.setText(textView_1.getText()+ "1");
            }
        });
        buttonNumber2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView_1.setText(textView_1.getText()+ "2");
            }
        });
        buttonNumber3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView_1.setText(textView_1.getText()+ "3");
            }
        });

        buttonNumber4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView_1.setText(textView_1.getText()+ "4");
            }
        });

        buttonNumber5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView_1.setText(textView_1.getText()+ "5");
            }
        });

        buttonNumber6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView_1.setText(textView_1.getText()+ "6");
            }
        });

        buttonNumber7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView_1.setText(textView_1.getText()+ "7");
            }
        });

        buttonNumber8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView_1.setText(textView_1.getText()+ "8");
            }
        });

        buttonNumber9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView_1.setText(textView_1.getText()+ "9");
            }
        });

        clear_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_1.setText("0");
                textView_2.setText("0");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = textView_1.getText().toString();
                if(str.length()>1){
                    str = str.substring(0, str.length()-1);
                    textView_1.setText(str);
                }else textView_1.setText("0");
            }
        });
        btn_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double out = 0;
                double in = Double.parseDouble(textView_1.getText().toString());
                if(spinner_1.getSelectedItem().toString() == spinner_2.getSelectedItem().toString()){
                    out = in;
                    if(spinner_1.getSelectedItem().toString() == "US-USD") textView_2.setText(out + " $");
                    else if (spinner_1.getSelectedItem().toString() == "Vietnam-Dong") textView_2.setText(out + " đ");
                    else if (spinner_1.getSelectedItem().toString() == "Korea-Won") textView_2.setText(out + " K");
                }
                if(spinner_1.getSelectedItem().toString() == "US-USD" && spinner_2.getSelectedItem().toString() == "Vietnam-Dong")
                {
                    out = Math.round(in * 23177 * 1e6) / 1e6;
                    textView_2.setText(out + " đ");
                }
                else if(spinner_1.getSelectedItem().toString() == "US-USD" && spinner_2.getSelectedItem().toString() == "Korea-Won")
                {
                    out = Math.round(in * 1279 * 1e6) / 1e6 ;
                    textView_2.setText(out + " K");
                }
                else if(spinner_1.getSelectedItem().toString() == "Vietnam-Dong" && spinner_2.getSelectedItem().toString() == "US-USD")
                {
                    out = Math.round(in * 1/23177 * 1e6) / 1e6;
                    textView_2.setText(out + " $");
                }
                else if(spinner_1.getSelectedItem().toString() == "Vietnam-Dong" && spinner_2.getSelectedItem().toString() == "Korea-Won")
                {
                    out = Math.round(in * 1/18 * 1e6) / 1e6;
                    textView_2.setText(out + " K");
                }
                else if(spinner_1.getSelectedItem().toString() == "Korea-Won" && spinner_2.getSelectedItem().toString() == "US-USD")
                {
                    out = Math.round(in * 1/1279 * 1e6) / 1e6;
                    textView_2.setText(out + " $");
                }
                else if(spinner_1.getSelectedItem().toString() == "Korea-Won" && spinner_2.getSelectedItem().toString() == "Vietnam-Dong")
                {
                    out = Math.round(in * 18 * 1e6) / 1e6;
                    textView_2.setText(out + " K");
                }
            }
        });
        ArrayAdapter<String> adapter_1 = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                from);
        spinner_1.setAdapter(adapter_1);
        spinner_1.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                to);
        spinner_2.setAdapter(adapter_2);
        spinner_2.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        if(spinner_1.getSelectedItem().toString() == "US-USD") textView_1.setText(textView_1.getText()+ " $");
//        if(spinner_1.getSelectedItem().toString() == "Vietnam-Dong") textView_1.setText(textView_1.getText()+ " đ");
//        if(spinner_1.getSelectedItem().toString() == "Korea-Won") textView_1.setText(textView_1.getText()+ " K");
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}