package com.example.a10_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends Activity {


    private String line = null;

    private String sID,sPW;
    private String fID,fPW;




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        1);
            }
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        1);
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText ID = (EditText)findViewById(R.id.editSigninID);
        final EditText PW = (EditText)findViewById(R.id.editPW);
        Button btnSignup = (Button) findViewById(R.id.btnSignup);
        final Button btnSignin = (Button) findViewById(R.id.btnSignin);

        ID.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == event.KEYCODE_SPACE) return true;
                return false;
            }
        });
        PW.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == event.KEYCODE_SPACE) return true;
                return false;
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
            }
        });


        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/user.txt");
                BufferedReader bufrd = null;

                sID = ID.getText().toString().replace(" ","");
                sPW = PW.getText().toString().replace(" ","");

                int flag =0;

                if(sID.length()==0 || sPW.length()==0) {
                    Toast.makeText(MainActivity.this, "로그인 정보가 없습니다.",Toast.LENGTH_LONG).show();
                }
                else {
                    try {
                        bufrd = new BufferedReader(new FileReader(file));
                    }
                    catch (FileNotFoundException e){
                        try {
                            FileWriter fw = new FileWriter(file);
                            fw.write("");
                            fw.close();
                            bufrd = new BufferedReader(new FileReader(file));
                        }
                        catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    while(true) {
                        try {
                            if(bufrd != null && (line=bufrd.readLine())==null) break;
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                            break;
                        }
                        String[] rLine= line.split("\\s");
                        fID=rLine[0];
                        fPW=rLine[1];
                        if(fID.equals(sID)&&fPW.equals(sPW)) {
                            Toast.makeText(MainActivity.this,rLine[2]+"님 환영합니다.",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(),ThirdActivity.class);
                            startActivity(intent);
                            flag=1;
                        }
                    }
                    if(flag==0) Toast.makeText(MainActivity.this,"잘못된 ID거나 PW입니다.",Toast.LENGTH_LONG).show();
                }


            }
        });

        ID.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                    btnSignin.performClick();
                    return true;
                }
                return false;
            }
        });
        PW.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                    btnSignin.performClick();
                    return true;
                }
                return false;
            }
        });



        PW.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        PW.setTransformationMethod(PasswordTransformationMethod.getInstance());









    }



}


