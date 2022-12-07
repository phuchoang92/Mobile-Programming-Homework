package com.example.zahuy;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class RegistrationActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    RadioGroup radioGroupGender;
    RadioButton radioButtonMale;
    RadioButton radioButtonFemale;
    CheckBox agreeBox;
    TextView firstName;
    TextView lastName;
    TextView address;
    TextView email;
    TextView birthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_form);

        firstName = findViewById(R.id.firstNameText);
        lastName = findViewById(R.id.lastNameText);
        address = findViewById(R.id.addressText);
        email = findViewById(R.id.emailText);
        birthday = findViewById(R.id.birthdayText);

        agreeBox = findViewById(R.id.agreeCheckBox);
        radioGroupGender = findViewById(R.id.genderRadioGroup);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);

        findViewById(R.id.selectBirButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        findViewById(R.id.registerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkText();
            }
        });
    }

    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }


    public void checkText(){
        String emptyField = new String("");
        if (firstName.getText().toString().equals("")){
            emptyField = "First Name";
        }
        else {
            if (lastName.getText().toString().equals("")){
                emptyField = ("Last Name");
            }
            else{
                if(radioGroupGender.getCheckedRadioButtonId() == -1)
                    Toast.makeText(this,"You must choose your gender",Toast.LENGTH_LONG).show();
                else{
                    if (birthday.getText().toString().equals("")){
                        emptyField = "Birthday";
                    }else{
                        if (address.getText().toString().equals("")){
                            emptyField = ("Address");
                        }
                        else if (email.getText().toString().equals("")){
                            emptyField = ("Email");
                        }
                    }
                }
            }
        }
        if (!emptyField.toString().equals("")){
            String message =  "Field at "+emptyField + " is empty";
            Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        }
        else {
            if(!agreeBox.isChecked())
                Toast.makeText(this,"You must agree with our terms",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this,"You have registered successfully",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = ""+ dayOfMonth + "/" + month + "/" + year;
        birthday.setText(date);
    }
}
