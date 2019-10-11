package com.example.a10_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends Activity {

    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
    private Button buttonadd,buttonsub,buttonmul,buttondiv,buttonresult,buttonclear;

    private TextView input_text;
    private TextView result_text;

    private int number[]=new int[2];
    private int i=0,result_flag=0;
    private int flag=0,count=0,tmp=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        button1 = (Button)findViewById(R.id.btnCal_1);
        button2 = (Button)findViewById(R.id.btnCal_2);
        button3 = (Button)findViewById(R.id.btnCal_3);
        button4 = (Button)findViewById(R.id.btnCal_4);
        button5 = (Button)findViewById(R.id.btnCal_5);
        button6 = (Button)findViewById(R.id.btnCal_6);
        button7 = (Button)findViewById(R.id.btnCal_7);
        button8 = (Button)findViewById(R.id.btnCal_8);
        button9 = (Button)findViewById(R.id.btnCal_9);
        button0 = (Button)findViewById(R.id.btnCal_0);
        buttonadd = (Button)findViewById(R.id.btnCal_Add);
        buttonmul = (Button)findViewById(R.id.btnCal_Mul);
        buttonsub = (Button)findViewById(R.id.btnCal_Sub);
        buttondiv = (Button)findViewById(R.id.btnCal_Div);
        buttonresult = (Button)findViewById(R.id.btnCal_Equ);
        buttonclear = (Button)findViewById(R.id.btnCal_Clear);


        input_text = (TextView)findViewById(R.id.input_text);

        //결과표시창
        result_text = (TextView)findViewById(R.id.result_text);


        number[0]=0;

        OnClickListener cl = new OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (v == button1) {
                    tmp=1;
                    if(result_flag==1) {
                        number[0]=0;
                        result_flag=0;
                    }
                    if(count==1){
                        number[count]=0;
                        count=0;
                    }
                    number[i] = number[i] * 10 + tmp;

                    result_text.setText(Integer.toString(number[i]));
                }
                else if (v == button2) {
                    tmp = 2;
                    if(result_flag==1) {
                        number[0]=0;
                        result_flag=0;
                    }
                    if(count==1){
                        number[count]=0;
                        count=0;
                    }
                    number[i] = number[i] * 10 + tmp;

                    result_text.setText(Integer.toString(number[i]));
                }
                else if (v == button3) {
                    tmp = 3;
                    if(result_flag==1) {
                        number[0]=0;
                        result_flag=0;
                    }
                    if(count==1){
                        number[count]=0;
                        count=0;
                    }
                    number[i] = number[i] * 10 + tmp;

                    result_text.setText(Integer.toString(number[i]));
                }
                else if (v == button4) {
                    tmp = 4;
                    if(result_flag==1) {
                        number[0]=0;
                        result_flag=0;
                    }
                    if(count==1){
                        number[count]=0;
                        count=0;
                    }
                    number[i] = number[i] * 10 + tmp;

                    result_text.setText(Integer.toString(number[i]));
                }
                else if (v == button5) {
                    tmp = 5;
                    if(result_flag==1) {
                        number[0]=0;
                        result_flag=0;
                    }
                    if(count==1){
                        number[count]=0;
                        count=0;
                    }
                    number[i] = number[i] * 10 + tmp;

                    result_text.setText(Integer.toString(number[i]));
                }
                else if (v == button6) {
                    tmp = 6;
                    if(result_flag==1) {
                        number[0]=0;
                        result_flag=0;
                    }
                    if(count==1){
                        number[count]=0;
                        count=0;
                    }
                    number[i] = number[i] * 10 + tmp;

                    result_text.setText(Integer.toString(number[i]));
                }
                else if (v == button7) {
                    tmp = 7;
                    if(result_flag==1) {
                        number[0]=0;
                        result_flag=0;
                    }
                    if(count==1){
                        number[count]=0;
                        count=0;
                    }
                    number[i] = number[i] * 10 + tmp;

                    result_text.setText(Integer.toString(number[i]));
                }
                else if (v == button8) {
                    tmp = 8;
                    if(result_flag==1) {
                        number[0]=0;
                        result_flag=0;
                    }
                    if(count==1){
                        number[count]=0;
                        count=0;
                    }
                    number[i] = number[i] * 10 + tmp;

                    result_text.setText(Integer.toString(number[i]));
                }
                else if (v == button9) {
                    tmp = 9;
                    if(result_flag==1) {
                        number[0]=0;
                        result_flag=0;
                    }
                    if(count==1){
                        number[count]=0;
                        count=0;
                    }
                    number[i] = number[i] * 10 + tmp;

                    result_text.setText(Integer.toString(number[i]));
                }
                else if (v == button0) {
                    tmp = 0;
                    if(result_flag==1) {
                        number[0]=0;
                        result_flag=0;
                    }
                    if(count==1){
                        number[count]=0;
                        count=0;
                    }
                    number[i] = number[i] * 10;
                    result_text.setText(Integer.toString(number[i]));
                }
                else if (v == buttonadd) {
                    // 더하기 부분
                    if(result_flag==1) result_flag=0;
                    if(tmp==-1) {
                        input_text.setText(Integer.toString(number[i]) + "+");
                        result_text.setText(Integer.toString(number[i]));
                        tmp=0;
                        i=1;
                    }
                    else {
                        input_text.setText(input_text.getText().toString()+result_text.getText().toString() + '+');
                        if(i==0){
                            i = 1;
                        }
                        else if(i==1){
                            if(count==1)number[1]=number[0];
                            if(flag==1) number[0]+=number[1];
                            else if(flag==2) number[0]-=number[1];
                            else if(flag==3) number[0]*=number[1];
                            else if(flag==4) number[0]/=number[1];
                            result_text.setText(Integer.toString(number[0]));
                        }
                    }
                    flag = 1;
                    count=1;

                }
                else if (v == buttonsub) {
                    // 빼기 부분
                    if(result_flag==1) result_flag=0;
                    if(tmp==-1) {
                        input_text.setText(Integer.toString(number[i]) + "-");
                        result_text.setText(Integer.toString(number[i]));
                        tmp=0;
                        i=1;
                    }
                    else {
                        input_text.setText(input_text.getText().toString()+result_text.getText().toString() + '-');
                        if(i==0){
                            i = 1;
                        }
                        else if(i==1){
                            if(count==1)number[1]=number[0];
                            if(flag==1) number[0]+=number[1];
                            else if(flag==2) number[0]-=number[1];
                            else if(flag==3) number[0]*=number[1];
                            else if(flag==4) number[0]/=number[1];
                            result_text.setText(Integer.toString(number[0]));
                        }
                    }
                    flag = 2;
                    count=1;
                }
                else if (v == buttonmul) {
                    // 곱하기 부분
                    if(result_flag==1) result_flag=0;
                    if(tmp==-1) {
                        input_text.setText(Integer.toString(number[i]) + 'x');
                        result_text.setText(Integer.toString(number[i]));
                        tmp=0;
                        i=1;
                    }
                    else {
                        input_text.setText(input_text.getText().toString()+result_text.getText().toString() + 'x');
                        if(i==0){
                            i = 1;
                        }
                        else if(i==1){
                            if(count==1)number[1]=number[0];
                            if(flag==1) number[0]+=number[1];
                            else if(flag==2) number[0]-=number[1];
                            else if(flag==3) number[0]*=number[1];
                            else if(flag==4) number[0]/=number[1];
                            result_text.setText(Integer.toString(number[0]));
                        }
                    }
                    flag = 3;
                    count=1;
                }
                else if (v == buttondiv) {
                    // 나누기 부분
                    if(result_flag==1) result_flag=0;
                    if(tmp==-1) {
                        input_text.setText(Integer.toString(number[i]) + "/");
                        result_text.setText(Integer.toString(number[i]));
                        tmp=0;
                        i=1;
                    }
                    else {
                        input_text.setText(input_text.getText().toString()+result_text.getText().toString() + '/');
                        if(i==0){
                            i = 1;
                        }
                        else if(i==1){
                            if(count==1)number[1]=number[0];
                            if(flag==1) number[0]+=number[1];
                            else if(flag==2) number[0]-=number[1];
                            else if(flag==3) number[0]*=number[1];
                            else if(flag==4) number[0]/=number[1];
                            result_text.setText(Integer.toString(number[0]));
                        }
                    }
                    flag = 4;
                    count=1;
                }

                //결과부분
                else if (v == buttonresult) {
                    input_text.setText("");
                    if(i==1){
                        if(count==1)number[1]=number[0];
                        if(flag==1) number[0]+=number[1];
                        else if(flag==2) number[0]-=number[1];
                        else if(flag==3) number[0]*=number[1];
                        else if(flag==4) number[0]/=number[1];
                        result_text.setText(Integer.toString(number[0]));
                    }
                    else result_text.setText("");
                    i=0;
                    tmp=-1;
                    result_flag=1;
                    flag=-1;
                    number[1]=0;
                    count=0;
                }

                //edittext 클리어
                else if(v==buttonclear){
                    result_text.setText("");
                    input_text.setText("");
                    i=0;
                    tmp=-1;
                    flag=0;
                    number[0]=0;
                    number[1]=0;
                    count=0;
                }
            }
        };

        button1.setOnClickListener(cl);
        button2.setOnClickListener(cl);
        button3.setOnClickListener(cl);
        button4.setOnClickListener(cl);
        button5.setOnClickListener(cl);
        button6.setOnClickListener(cl);
        button7.setOnClickListener(cl);
        button8.setOnClickListener(cl);
        button9.setOnClickListener(cl);
        button0.setOnClickListener(cl);
        buttonadd.setOnClickListener(cl);
        buttonmul.setOnClickListener(cl);
        buttonsub.setOnClickListener(cl);
        buttondiv.setOnClickListener(cl);
        buttonresult.setOnClickListener(cl);
        buttonclear.setOnClickListener(cl);

        Button Logout = (Button) findViewById(R.id.btnLogout);
        Logout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }

}