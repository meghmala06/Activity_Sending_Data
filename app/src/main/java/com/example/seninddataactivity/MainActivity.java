package com.example.seninddataactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button mbtnshownext;
    private EditText medt_number1,medt_number2;
    private TextView mlblResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtnshownext=findViewById(R.id.btnShowNext);
        medt_number1=findViewById(R.id.edit_number1);
        medt_number2=findViewById(R.id.edit_number2);
        mlblResult=findViewById(R.id.lblResult);

        mbtnshownext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(medt_number1.getText().toString().equals("") || medt_number2.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please enter the numbers",Toast.LENGTH_LONG).show();

                }
                else
                {
                    int number1=Integer.parseInt(medt_number1.getText().toString());
                    int number2=Integer.parseInt(medt_number2.getText().toString());

                    Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("number1",number1);
                    intent.putExtra("number2",number2);
                    startActivityForResult(intent,1);

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if(resultCode==RESULT_OK)
            {
                int result=data.getIntExtra("Add",0);

                mlblResult.setText(""+result);

            }

        }
    }
}