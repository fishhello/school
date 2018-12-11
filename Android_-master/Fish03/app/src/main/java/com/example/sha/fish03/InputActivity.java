package com.example.sha.fish03;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sha.fish03.application.MyApplication;
import com.example.sha.fish03.entity.User;
import com.example.sha.fish03.utils.Dbutils;

public class InputActivity extends AppCompatActivity {

    private MyApplication mApplication = MyApplication.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        //设置toolbar
        toolbar();
        //设置完成后按钮
        success();

    }
    private void toolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.c_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true); //设置返回键可用
        }
        //toolbar.setNavigationIcon(R.drawable.left_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputActivity.this.finish();
            }
        });
    }

    private void success(){
        TextView success = (TextView)findViewById(R.id.c_success);
        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入信息
                EditText title = findViewById(R.id.content_title_input);
                EditText text = findViewById(R.id.content_text_input);
                String contentTitle = title.getText().toString().trim();
                String contentText = text.getText().toString().trim();

                if(contentTitle.isEmpty()){
                    Toast.makeText(InputActivity.this, "请输入活动标题", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(contentText.isEmpty()){
                    Toast.makeText(InputActivity.this, "请输入活动内容", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(contentTitle.length()>15){
                    Toast.makeText(InputActivity.this, "简要输入标题", Toast.LENGTH_SHORT).show();
                    return;
                }

                User user = mApplication.getLoginUser();
                Dbutils.saveInput(user,contentTitle,contentText);
                Toast.makeText(InputActivity.this, "活动发布成功", Toast.LENGTH_SHORT).show();
                InputActivity.this.finish();
            }
        });
    }
}
