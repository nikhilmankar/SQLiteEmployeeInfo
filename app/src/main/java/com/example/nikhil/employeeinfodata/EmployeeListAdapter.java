package com.example.nikhil.employeeinfodata;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {

    List<Employee> employeeList;

    public EmployeeListAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }


    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_emplyee_list, null);
        return new EmployeeViewHolder(view);
    }





    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
/* Person person = personList.get(position);
        holder.txtName.setText(person.getName());
        holder.txtAddress.setText(person.getAddress());
        holder.txtPhone.setText(person.getPhone());*/

        Employee employee = employeeList.get(position);
        holder.txtName.setText(employee.getName());
        holder.txtDepartment.setText(employee.getDepartment());
        holder.txtSalary.setText(employee.getSalary());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}

