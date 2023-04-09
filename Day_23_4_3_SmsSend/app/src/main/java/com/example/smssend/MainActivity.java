package com.example.smssend;

import androidx.appcompat.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import java.util.ArrayList;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText numET;
    private EditText contentET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numET = (EditText) findViewById(R.id.numET);
        contentET = (EditText) findViewById(R.id.contentET);

    }
    public void Send(View view){
        //获取号码和内容
        String num = numET.getText().toString();
        String content = contentET.getText().toString();
        //获取短信管理器，静态方法
        SmsManager smsManager = SmsManager.getDefault();
        //将短内容分段，装入ArryList
        ArrayList<String> list = smsManager.divideMessage(content);
        for(String sms : list){
            smsManager.sendTextMessage(num,null,sms,null,null);
        }
        Toast.makeText(getApplicationContext(),"发送成功",Toast.LENGTH_SHORT).show();
    }
}