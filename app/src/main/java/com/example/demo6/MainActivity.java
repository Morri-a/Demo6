package com.example.demo6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private Button button1, button2, button3;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        editText = (EditText)findViewById(R.id.editTextTextPersonName);
        final DocumentTool dt = new DocumentTool();
        final String[] folderName = {""};
        //final String folderName = "test00000001";

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                folderName[0] = String.valueOf(editText.getText());
                Log.i("TAG:","状态"+folderName[0]);
                dt.addFolder(folderName[0]);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                folderName[0] = "";
                folderName[0] = String.valueOf(editText.getText());
                dt.addFileText(folderName[0]);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dt.exit();
            }
        });





    }



}