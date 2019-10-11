package com.example.a10_01;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class SecondActivity extends Activity {


    private String line = null;
    private String rLine[]=new String[3];
    private String sID,sPW,sPWC;
    private String fID;
    int flag =1;
    private int ID_CHECK=0,check_PW=0,check_PWC=0;

    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/user.txt");
    BufferedReader bufrd = null;




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
        setContentView(R.layout.test);



        final Button btnSignupCheckID = (Button) findViewById(R.id.btnSignupCheckID);
        final EditText ID = (EditText)findViewById(R.id.editSignup_ID);

        ID.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == event.KEYCODE_SPACE) return true;
                return false;
            }
        });
        ID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                btnSignupCheckID.setEnabled(false);
                ID_CHECK=0;
                flag=1;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnSignupCheckID.setEnabled(true);
                ID_CHECK=0;
                flag=1;
            }

            @Override
            public void afterTextChanged(Editable s) {
                btnSignupCheckID.setEnabled(true);
                ID_CHECK=0;
                flag=1;
            }
        });

        btnSignupCheckID.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                ID_CHECK=0;

                sID = ID.getText().toString().replace(" ","");
                if(sID.length()==0){
                    btnSignupCheckID.setEnabled(false);
                    Toast.makeText(SecondActivity.this,"사용할 ID를 입력해주세요.",Toast.LENGTH_LONG).show();
                    flag=1;
                }
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
                    if(fID.equals(sID)) {
                        Toast.makeText(SecondActivity.this,"이미 사용중인 ID입니다.",Toast.LENGTH_LONG).show();
                        flag=1;
                        break;
                    }
                    else flag=0;
                }
                if(flag==0) {
                    Toast.makeText(SecondActivity.this,"사용가능한 ID입니다.",Toast.LENGTH_LONG).show();
                    ID_CHECK=1;
                }
            }
        });


        final String specail_c = "^[a-zA-Z0-9]*$";
        final String number = ".*[0-9].*";

        final EditText PW = (EditText)findViewById(R.id.editSignup_PW);
        final TextView textPW = (TextView)findViewById(R.id.textSignupPW);
        final EditText PW_check = (EditText)findViewById(R.id.editSignup_PWCheck);
        final TextView textPWC = (TextView)findViewById(R.id.textSignupPW_pass);
        PW.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        PW.setTransformationMethod(PasswordTransformationMethod.getInstance());
        PW.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == event.KEYCODE_SPACE) return true;
                return false;
            }
        });
        PW.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                textPW.setTextColor(Color.parseColor("#FF0000"));
                check_PW=0;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textPW.setTextColor(Color.parseColor("#FF0000"));
                check_PW=0;
                sPW=PW.getText().toString();
                if(sPW.length()>8 && !Pattern.matches(specail_c,sPW) && sPW.matches(number)){
                    textPW.setTextColor(Color.parseColor("#00FF00"));
                    check_PW=1;
                }
                sPWC=PW_check.getText().toString();
                if(sPWC.equals(sPW)){
                    textPWC.setTextColor(Color.parseColor("#00FF00"));
                    textPWC.setText("비밀번호가 일치합니다.");
                    textPWC.setVisibility(View.VISIBLE);
                    check_PWC=1;
                }
                else {
                    textPWC.setText("비밀번호가 일치하지 않습니다.");
                    textPWC.setTextColor(Color.parseColor("#FF0000"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        PW_check.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        PW_check.setTransformationMethod(PasswordTransformationMethod.getInstance());
        PW_check.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == event.KEYCODE_SPACE) return true;
                return false;
            }
        });
        PW_check.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                textPWC.setText("비밀번호가 일치하지 않습니다.");
                textPWC.setTextColor(Color.parseColor("#FF0000"));
                check_PWC=0;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textPWC.setVisibility(View.VISIBLE);
                textPWC.setTextColor(Color.parseColor("#FF0000"));
                check_PWC=0;
                sPWC=PW_check.getText().toString();
                if(sPWC.equals(sPW)){
                    textPWC.setTextColor(Color.parseColor("#00FF00"));
                    textPWC.setText("비밀번호가 일치합니다.");
                    textPWC.setVisibility(View.VISIBLE);
                    check_PWC=1;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        final EditText Name = (EditText)findViewById(R.id.editName);
        final EditText Phone = (EditText)findViewById(R.id.editPhone);
        final EditText Address = (EditText)findViewById(R.id.editAddress);
        final RadioButton Agree = (RadioButton)findViewById(R.id.radioAgree);
        final RadioButton DisAgree = (RadioButton)findViewById(R.id.radioDisAgree);


        Name.setInputType(InputType.TYPE_CLASS_TEXT);
        Phone.setInputType(InputType.TYPE_CLASS_NUMBER);
        Address.setInputType(InputType.TYPE_CLASS_TEXT);
        Name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == event.KEYCODE_SPACE) return true;
                return false;
            }
        });
        Phone.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == event.KEYCODE_SPACE) return true;
                return false;
            }
        });

        Button btnSignupCancle = (Button) findViewById(R.id.btnSignupCancle);
        btnSignupCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnSignupFinish = (Button) findViewById(R.id.btnSignupFinish);
        btnSignupFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(Name.getText().toString().length() == 0 || Phone.getText().length() == 0 || Address.getText().toString().length() == 0) {
                    Toast.makeText(SecondActivity.this,"빈칸을 채워주세요.",Toast.LENGTH_LONG).show();
                }
                else if(ID_CHECK==0) {
                    Toast.makeText(SecondActivity.this,"ID 중복확인을 해주세요",Toast.LENGTH_LONG).show();
                }
                else if(check_PW==0) {
                    Toast.makeText(SecondActivity.this,"조건에 맞는 PW를 입력해주세요.",Toast.LENGTH_LONG).show();
                }
                else if(check_PWC==0) {
                    Toast.makeText(SecondActivity.this,"PW를 일치시켜주세요.",Toast.LENGTH_LONG).show();
                }
                else if(Agree.isChecked()) {

                    BufferedWriter bufwr = null;
                    try {
                        bufwr = new BufferedWriter(new FileWriter(file,true));
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    rLine[0]=Name.getText().toString().replace(" ","");
                    rLine[1]=Phone.getText().toString().replace(" ","");
                    rLine[2]=Address.getText().toString().replace(" ","");
                    PrintWriter writer = new PrintWriter(bufwr);
                    writer.write(sID +" ");
                    writer.write(sPW +" ");
                    writer.write( rLine[0] +" ");
                    writer.write( rLine[1]+" ");
                    writer.write( rLine[2]+"\n");
                    writer.flush();
                    writer.close();
                    finish();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(SecondActivity.this,"개인정보수집에 동의해주세요.",Toast.LENGTH_LONG).show();
                }





            }
        });

    }


}

