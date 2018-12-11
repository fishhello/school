package com.example.sha.fish03;

import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.litepal.tablemanager.AssociationCreator;
import org.litepal.tablemanager.Connector;

import java.sql.Connection;

public class DatebaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datebase);
        Button createdb = (Button)findViewById(R.id.createdb);
        createdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = Connector.getDatabase();
            }
        });
    }
}
