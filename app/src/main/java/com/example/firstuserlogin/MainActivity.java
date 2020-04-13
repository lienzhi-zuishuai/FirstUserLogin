package com.example.firstuserlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private UserManager mUserManager;         //用户数据管理类
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        tv=(TextView) findViewById(R.id.tv);
    }

    public   void   click(View v){
        mUserManager = new UserManager(this);  //实例化
        SQLiteDatabase db=null;
        mUserManager.onCreate(db);  //创建库
        mUserManager.createTable();
        mUserManager.onOpen(db);
         mUserManager.insertData("Insert into users(user_name,user_pwd) values('admin','123456')");

        int result=mUserManager.findUserByNameAndPwd("admin","123456");

        if(result==1)
            tv.setText("登录成功");
        else
            tv.setText("登录失败");



        mUserManager.close();
        mUserManager = null;


    }
}
