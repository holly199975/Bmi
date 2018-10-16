package com.holly.bmi;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edWeight;
    private EditText edHeight;
    private Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        edWeight = findViewById(R.id.ed_weight);
        edHeight = findViewById(R.id.ed_height);
        help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity","help");
                new AlertDialog.Builder(MainActivity.this).setMessage(R.string.bmi_info)
                        .setPositiveButton(R.string.ok,null)
                        .show();
            }
        });
    }

    public void bmi(View view){
        Log.d("MainActivity","bmi");

        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        Log.d("MainActivity",w +"/"+ h);
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight/(height*height);
        Log.d("MainActivity",bmi +" ");
        Toast.makeText(this,getString(R.string.your_bmi_is) + bmi,Toast.LENGTH_LONG).show();  //漂浮字
        new AlertDialog.Builder(this).setMessage(getString(R.string.your_bmi_is)+ bmi)   //對話框
        .setTitle(R.string.bmi)
         .setPositiveButton(R.string.ok, null)
        .setNegativeButton(R.string.clear, new DialogInterface.OnClickListener() { // new 一個 OnclickLIstner執行完後清空
            @Override
            public void onClick(DialogInterface dialog, int which) {
                edWeight.setText(" ");  //執行後使Weight變空值
                edHeight.setText(" ");
            }
        })
        .show();
    }

}
