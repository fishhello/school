package com.example.sha.fish03;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.sha.fish03.application.MyApplication;
import com.example.sha.fish03.entity.User;
import com.example.sha.fish03.utils.Dbutils;

import utils.MD5Utils;

public class MainActivity extends AppCompatActivity {

    private String userName,psw,spPsw;//获取的用户名，密码，加密密码
    private EditText login_edit_account,login_edit_pwd;//编辑框
    private CheckBox rememberPass;//记住密码复选框
    private MyApplication mApplication;

    /*private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件值
        //getMEditString();
        //数据库操作设计
        db();
        //注册使用
        resige();
        //登录使用
        init();
        //记住密码使用
        //remember();
    }
    private void db(){
        TextView db = (TextView)findViewById(R.id.db);
        db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DatebaseActivity.class));
                return;
            }
        });
    }

    private void resige(){
        TextView resign = (TextView)findViewById(R.id.resign);
        resign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ResignActivity.class));
                return;
            }
        });
    }

    private void init() {
        //如果登录成功则记住密码功能生效
       /* rememberPass=(CheckBox)findViewById(R.id.Login_Remember);
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);*/

        Button resign = (Button)findViewById(R.id.login_btn_login);
        resign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取输入
                login_edit_account = findViewById(R.id.login_edit_account);
                login_edit_pwd = findViewById(R.id.login_edit_pwd);
                userName = login_edit_account.getText().toString().trim();
                psw = login_edit_pwd.getText().toString().trim();

                //加密密码对比获取
                //对当前用户输入的密码进行MD5加密再进行比对判断, MD5Utils.md5( ); psw 进行加密判断是否一致
                String md5Psw= MD5Utils.md5(psw);

                //检验输入信息
                if(userName.isEmpty()){
                    Toast.makeText(MainActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }else if(psw.isEmpty()){
                    Toast.makeText(MainActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                    // 返回true则该用户名不存在数据库
                }else if (Dbutils.checkUnique(userName)) {
                    Toast.makeText(MainActivity.this, "此用户名不存在", Toast.LENGTH_SHORT).show();
                    return;
                }
                //获取存储密码
                spPsw= Dbutils.getPasswd(userName);

                if((spPsw!=""&&!md5Psw.equals(spPsw))){
                    Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    return;
                }else if(md5Psw.equals(spPsw)){
                    //一致登录成功
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

                    //Application记录用户信息
                    mApplication = (MyApplication) getApplication();
                    User user = new User();
                    user.setUsername(userName);
                    user.setId(Dbutils.getUserId(userName));
                    mApplication.userLogin(user);
                    //登录成功后关闭此页面进入主页
                    //销毁登录界面
                    MainActivity.this.finish();
                    //跳转到主界面，登录成功的状态传递到 IndexActivity 中
                    startActivity(new Intent(MainActivity.this, IndexActivity.class));
                    return;
                }else{
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     *保存登录状态和登录用户名到SharedPreferences中
     *//*
    private void saveLoginStatus(boolean status,String userName){
        //saveLoginStatus(true, userName);
        //loginInfo表示文件名  SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
        SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
        //获取编辑器
        SharedPreferences.Editor editor=sp.edit();
        //存入boolean类型的登录状态
        editor.putBoolean("isLogin", status);
        //存入登录状态时的用户名
        editor.putString("loginUserName", userName);
        //提交修改
        editor.commit();
    }*/

    /**
     * 获取控件中的字符串
     */
/*    private void getMEditString(){
        login_edit_account = findViewById(R.id.login_edit_account);
        login_edit_pwd = findViewById(R.id.login_edit_pwd);
        userName = login_edit_account.getText().toString().trim();
        psw = login_edit_pwd.getText().toString().trim();
    }*/

    /**
     * 记住密码功能
     */
/*    private  void remember(){
        //检查shared中是否指定remember
        boolean pang=sharedPreferences.getBoolean("remember_password",false);
        if(pang){
            //将账号和密码都设置到文本中
            String account=sharedPreferences.getString("account","");
            String password=sharedPreferences.getString("password","");
            login_edit_account.setText(account);
            login_edit_pwd.setText(password);
            rememberPass.setChecked(true);
        }
    }*/
}
