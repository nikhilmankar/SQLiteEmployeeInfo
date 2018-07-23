package com.example.nikhil.employeeinfodata;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {

    TextView txtName, txtDepartment, txtSalary;

    public EmployeeViewHolder(View itemView) {
        super(itemView);
    txtName=itemView.findViewById(R.id.txt_Name);
    txtDepartment=itemView.findViewById(R.id.txt_Department);
    txtSalary=itemView.findViewById(R.id.txt_Salary);
    }
}
