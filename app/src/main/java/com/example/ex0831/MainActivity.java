package com.example.ex0831;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    TextView lastName, firstName, birthday, phone;
    Spinner chosenClass;
    ListView students;
    ArrayAdapter<String> studentsAdp;

    int studClass;

    String[][] allStudents = {{""}, {"student 1", "student 2", "student 3", "student 4", "student 5", "student 6", "student 7", "student 8", "student 9", "student 10"},
                            {"student 11", "student 12", "student 13", "student 14", "student 15", "student 16", "student 17", "student 18", "student 19", "student 20"},
                            {"student 21", "student 22", "student 23", "student 24", "student 25", "student 26", "student 27", "student 28", "student 29", "student 30"},
                            {"student 31", "student 32", "student 33", "student 34", "student 35", "student 36", "student 37", "student 38", "student 39", "student 40"}};

    String[][][] studInfo = {{{"", "", "", ""}},
                            {{"last 1", "first 1", "birth 1", "phone 1"}, {"last 2", "first 2", "birth 2", "phone 2"}, {"last 3", "first 3", "birth 3", "phone 3"}, {"last 4", "first 4", "birth 4", "phone 4"}, {"last 5", "first 5", "birth 5", "phone 5"}, {"last 6", "first 6", "birth 6", "phone 6"}, {"last 7", "first 7", "birth 7", "phone 7"}, {"last 8", "first 8", "birth 8", "phone 8"}, {"last 9", "first 9", "birth 9", "phone 9"}, {"last 10", "first 10", "birth 10", "phone 10"} },
                            {{"last 11", "first 11", "birth 11", "phone 11"}, {"last 12", "first 12", "birth 12", "phone 12"}, {"last 13", "first 13", "birth 13", "phone 13"}, {"last 14", "first 14", "birth 14", "phone 14"}, {"last 15", "first 15", "birth 15", "phone 15"}, {"last 16", "first 16", "birth 16", "phone 16"}, {"last 17", "first 17", "birth 17", "phone 17"}, {"last 18", "first 18", "birth 18", "phone 18"}, {"last 19", "first 19", "birth 19", "phone 19"}, {"last 20", "first 20", "birth 20", "phone 20"}},
                            {{"last 21", "first 21", "birth 21", "phone 21"}, {"last 22", "first 22", "birth 22", "phone 22"}, {"last 23", "first 23", "birth 23", "phone 23"}, {"last 24", "first 24", "birth 24", "phone 24"}, {"last 25", "first 25", "birth 25", "phone 25"}, {"last 26", "first 26", "birth 26", "phone 26"}, {"last 27", "first 27", "birth 27", "phone 27"}, {"last 28", "first 28", "birth 28", "phone 28"}, {"last 29", "first 29", "birth 29", "phone 29"}, {"last 30", "first 30", "birth 30", "phone 30"}},
                            {{"last 31", "first 31", "birth 31", "phone 31"}, {"last 32", "first 32", "birth 32", "phone 32"}, {"last 33", "first 33", "birth 33", "phone 33"}, {"last 34", "first 34", "birth 34", "phone 34"}, {"last 35", "first 35", "birth 35", "phone 35"}, {"last 36", "first 36", "birth 36", "phone 36"}, {"last 37", "first 37", "birth 37", "phone 37"}, {"last 38", "first 38", "birth 38", "phone 38"}, {"last 39", "first 39", "birth 39", "phone 39"}, {"last 40", "first 40", "birth 40", "phone 40"}}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lastName = (TextView) findViewById(R.id.lastName);
        firstName = (TextView) findViewById(R.id.firstName);
        birthday = (TextView) findViewById(R.id.birthday);
        phone = (TextView) findViewById(R.id.phone);
        chosenClass = (Spinner) findViewById(R.id.chosenClass);
        students = (ListView) findViewById(R.id.students);

        chosenClass.setOnItemSelectedListener(this);
        students.setOnItemClickListener(this);
        students.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> classesAdp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.classes));
        chosenClass.setAdapter(classesAdp);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        studClass = position;

        lastName.setText("");
        firstName.setText("");
        birthday.setText("");
        phone.setText("");
        
        studentsAdp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, allStudents[position]);
        students.setAdapter(studentsAdp);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        lastName.setText(studInfo[studClass][position][0]);
        firstName.setText(studInfo[studClass][position][1]);
        birthday.setText(studInfo[studClass][position][2]);
        phone.setText(studInfo[studClass][position][3]);
    }
}