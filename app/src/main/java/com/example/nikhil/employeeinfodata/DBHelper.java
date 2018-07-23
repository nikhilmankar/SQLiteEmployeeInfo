package com.example.nikhil.employeeinfodata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "felix.sqlite";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "employee";

    private static final String ID = "id";

    private static final String NAME = "name";

    private static final String DEPARTMENT = "department";

    private static final String SALARY = "salary";


    public DBHelper(Context context) {
        //DB creation
        super(context, DB_NAME, null, DB_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table TABLE_NAME (ID integer primary key autoincrement, NAME text, DEPARTMENT text, SALARY text);
        String createTableQuery =
                "create table " + TABLE_NAME + " ( "
                        + ID + " integer primary key autoincrement, "
                        + NAME + " text, "
                        + DEPARTMENT + " text, "
                        + SALARY + " double);";
        db.execSQL(createTableQuery);
    }

    public boolean addEmployee(Employee employee) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, employee.getName());
        values.put(DEPARTMENT, employee.getDepartment());
        values.put(SALARY, employee.getSalary());
        long no = db.insert(TABLE_NAME, null, values);


        if (no == 0) {
            return false;
        } else {

            return true;
        }
        // return no>0;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Employee> getEmployeeList() {

        List<Employee> employeeList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "select * from " + TABLE_NAME;
        Cursor result;
        result = db.rawQuery(query, null);

            if(result.moveToFirst()) {
                do {
                    String name=result.getString(result.getColumnIndex(NAME));
                    String department=result.getString(result.getColumnIndex(DEPARTMENT));
                    String salary=result.getString(result.getColumnIndex(SALARY));

                    Employee employee=new Employee(name,department,salary);
                    employeeList.add(employee);

                }while (result.moveToNext());

            }

        return employeeList;
    }
}
