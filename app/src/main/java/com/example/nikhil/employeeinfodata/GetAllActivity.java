package com.example.nikhil.employeeinfodata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class GetAllActivity extends AppCompatActivity {



    DBHelper dbHelper;
    RecyclerView rvEmployeeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all);



        rvEmployeeList = findViewById(R.id.rv_EmployeeList);
        dbHelper = new DBHelper(this);

       List<Employee> employeeList=dbHelper.getEmployeeList();


        rvEmployeeList.setLayoutManager(new LinearLayoutManager(this));

        EmployeeListAdapter adapter = new EmployeeListAdapter(employeeList);

        rvEmployeeList.setAdapter(adapter);




    }
}
