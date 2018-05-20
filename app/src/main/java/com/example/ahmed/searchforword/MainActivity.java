package com.example.ahmed.searchforword;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView text;
    EditText edit_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textView1);
        edit_search = (EditText) findViewById(R.id.edit_search);
    }


    public void btn_getText(View view) {

        try {
            InputStream inputStream = getAssets().open("myFile.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String x;
            StringBuffer stringBuffer = new StringBuffer();
            while ((x = bufferedReader.readLine()) != null) {
                stringBuffer.append(x + "\n");
            }
            text.setText(stringBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btn_search(View view) {
        int num = 0;
        String textA = text.getText().toString();

        if (edit_search.getText().toString().equals("")) {

        } else {
            String arr[] = textA.split(" ");

            StringBuffer stringBuffer = new StringBuffer();
            String word;
            for (int i = 0; i < arr.length; i++) {
                word = arr[i];
                if (word.contains(edit_search.getText().toString().trim())) {
                    stringBuffer.append("<b><font color = \"#ff000\"> " + word + "</font></b>");
                    num++;
                } else {
                    stringBuffer.append(word);
                }

                stringBuffer.append(" ");
            }
            text.setText(Html.fromHtml(stringBuffer + ""));
            Toast.makeText(this, "عدد الكلمات : " + num, Toast.LENGTH_SHORT).show();
        }

    }
}
