package com.example.sha.fish03;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sha.fish03.adapter.ListAdapter;
import com.example.sha.fish03.application.MyApplication;
import com.example.sha.fish03.entity.EssayItem;
import com.example.sha.fish03.entity.User;
import com.example.sha.fish03.utils.Dbutils;
import com.example.sha.fish03.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IndexActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private EssayItem[] fruits;
    private List<EssayItem> fruitList=new ArrayList<>();
    private ListAdapter adapter;
    private DrawerLayout mDrawerLayout;
    private SwipeRefreshLayout swipeRefresh;
    private NavigationView navigationView;
    TextView nav_userName;
    private MyApplication myApplication = MyApplication.getInstance();
    //private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        //item数据源
        initItem();
        //menu头部显示
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
        }
        if(fruits.length>0){
            initFruits();
        }
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new ListAdapter(fruitList);
        recyclerView.setAdapter(adapter);

        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFruits();
            }
        });
        //添加活动
        inputContent();
        /*//test数据显示
        show();*/
        //菜单栏设置点击事件
        menu();
    }

    private void refreshFruits() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initFruits();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    public void initItem(){
        fruits= new EssayItem[Dbutils.getItemSize()];
        List<EssayItem> list = Dbutils.getAllItem();
        for(int i=0;i<list.size();i++) {
            fruits[i]=list.get((list.size()-1)-i);
        }
    }
    private void initFruits(){
        initItem();
        fruitList.clear();
        for (int i = 0; i <fruits.length ; i++) {
            fruitList.add(fruits[i]);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }

    public void inputContent(){
        FloatingActionButton input = (FloatingActionButton)findViewById(R.id.input);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, InputActivity.class));
            }
        });
    }

    private void menu(){
        navigationView = findViewById(R.id.nav_view);
        //获取头布局文件
        View headerView = navigationView.getHeaderView(0);
        TextView textview = (TextView)headerView.findViewById(R.id.username);
        textview.setText(myApplication.getLoginUser().getUsername());

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_logout:
                        myApplication.userLogout();
                        Intent intent=new Intent(IndexActivity.this,MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });

    }
}
