package com.example.seninddataactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView mtxtShowNo;
    private Button mbtnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Second Activity");

        Intent intent=getIntent();
        int number1=intent.getIntExtra("number1",0);
        int number2=intent.getIntExtra("number2",0);
        mbtnAdd=findViewById(R.id.btnAdd);

        mtxtShowNo=findViewById(R.id.txtshowNumbers);
        mtxtShowNo.setText("Numbers are:"+number1+".."+number2);

        mbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result= number1+number2;
                Intent resultIntent=new Intent();
                resultIntent.putExtra("Add",result);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });



    }
}