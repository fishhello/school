package com.example.sha.fish03;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sha.fish03.entity.User;
import com.example.sha.fish03.utils.Dbutils;

import org.litepal.LitePal;

import java.util.List;

import utils.MD5Utils;

public class ResignActivity extends AppCompatActivity {

    //用户名，密码，再次输入的密码的控件
    private EditText et_user_name,et_psw,et_psw_again;
    //用户名，密码，再次输入的密码的控件的获取值
    private String userName,psw,pswAgain;
    User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resign);
        //init();
        back();
        //Toast.makeText(ResignActivity.this,"你好呀",Toast.LENGTH_LONG).show();
        Button registerButton = (Button)findViewById(R.id.btn_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEditString();
                //Toast.makeText(ResignActivity.this,userName+" "+psw+" "+pswAgain,Toast.LENGTH_LONG).show();
                init();
            }
        });
    }

    /**
     * 点击注册执行初始化方法
     */
    private  void init() {
        Button registerButton = (Button)findViewById(R.id.btn_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEditString();
                //Toast.makeText(ResignActivity.this,userName+" "+psw+" "+pswAgain,Toast.LENGTH_LONG).show();
                //判断输入框内容
                if(userName.isEmpty()){
                    Toast.makeText(ResignActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }else if(psw.isEmpty()){
                    Toast.makeText(ResignActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }else if(pswAgain.isEmpty()){
                    Toast.makeText(ResignActivity.this, "请再次输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }else if(!psw.equals(pswAgain)){
                    Toast.makeText(ResignActivity.this, "输入两次的密码不一样", Toast.LENGTH_SHORT).show();
                    return;
                }else if(!Dbutils.checkUnique(userName)){
                    Toast.makeText(ResignActivity.this, "此账户名已经存在", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    /**
                     * 用户密码格式没错
                     */
                    Toast.makeText(ResignActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    /**
                     * 保存账号和密码到SharedPreferences中
                     */
                    user.setUsername(userName);
                    user.setUserPass(MD5Utils.md5(psw));
                    user.save();
                    ResignActivity.this.finish();
                }
            }
        });
    }

    /**
     * 获取控件中的字符串
     */
    private void getEditString(){
        et_user_name = findViewById(R.id.et_user_name);
        et_psw = findViewById(R.id.et_psw);
        et_psw_again = findViewById(R.id.et_psw_again);
        userName=et_user_name.getText().toString().trim();
        psw=et_psw.getText().toString().trim();
        pswAgain=et_psw_again.getText().toString().trim();
    }

    private void back(){
        TextView back = findViewById(R.id.goback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResignActivity.this.finish();
            }
        });
    }

}
