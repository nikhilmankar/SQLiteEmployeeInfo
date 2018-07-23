package com.example.nikhil.employeeinfodata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtSalary;
    Spinner spnDepartment;
    Button btnSave;
    TextView txtViewEmployees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edt_Name);
        edtSalary = findViewById(R.id.edt_Salary);
        spnDepartment = findViewById(R.id.spn_Department);
        btnSave = findViewById(R.id.btn_Save);
        txtViewEmployees = findViewById(R.id.txt_ViewEmployees);

        final DBHelper dbHelper = new DBHelper(this);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString().trim();
                String department = spnDepartment.getSelectedItem().toString();
                String salary = edtSalary.getText().toString().trim();


                if (name.isEmpty()) {
                    edtName.setError("Please enter a name");
                    edtName.requestFocus();
                    return;
                }
                if(TextUtils.isDigitsOnly(name)){
                    edtName.setError("Please enter a name in alphabets");
                    edtName.requestFocus();
                    return;
                }

                if (salary.isEmpty() || Integer.parseInt(salary) <= 0) {
                    edtSalary.setError("Please enter salary");
                    edtSalary.requestFocus();
                    return;
                }


         /*       Person person=new Person(name,phone,address);
                boolean isSuccess = dbHelper.addPerson(person);

                if (isSuccess){
                    showtoast("Data Stored");

                    txtname.setText("");
                    txtphone.setText("");
                    txtaddress.setText("");
                }
                else
                {
                    showtoast("Insertion failed");
                }*/

                Employee employee = new Employee(name, department, salary);
                boolean isSuccess = dbHelper.addEmployee(employee);
                if (isSuccess) {
                    showtoast("Associate Added Successfully");

                    edtName.setText("");
                    spnDepartment.setSelection(0);
                    edtSalary.setText("");

                } else {
                    showtoast("Insertion failed");
                }

            }

        });

        txtViewEmployees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GetAllActivity.class);
                startActivity(intent);
            }
        });

    }

    public void showtoast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}


