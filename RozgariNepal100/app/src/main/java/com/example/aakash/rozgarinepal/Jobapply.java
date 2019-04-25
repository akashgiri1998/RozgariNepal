package com.example.aakash.rozgarinepal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Jobapply extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobapply);
        getSupportActionBar().hide();
    }


    /*
    Calls the submitApplication method
     */

    public void submitApplication(View view) {

        //creates the vairables for all the EditText items

        EditText nameTextField = (EditText) findViewById(R.id.name);
        String name = nameTextField.getText().toString();

        EditText ageTextField = (EditText) findViewById(R.id.age);
        String age = ageTextField.getText().toString();

        EditText nationalityTextField = (EditText) findViewById(R.id.nationality);
        String nationality = nationalityTextField.getText().toString();

        EditText phoneTextField = (EditText) findViewById(R.id.phone);
        String phone = phoneTextField.getText().toString();

        EditText emailTextField = (EditText) findViewById(R.id.email);
        String email = emailTextField.getText().toString();

        //creates the variables for the RadioGroup items

        RadioGroup genderRadioGroup = (RadioGroup) findViewById(R.id.gender_group);
        int genderButtonId = genderRadioGroup.getCheckedRadioButtonId();
        RadioButton genderButton = findViewById(genderButtonId);
        String gender = genderButton.getText().toString();

        //creates the variable for the checkbox items

        CheckBox nativeCheckBox = (CheckBox) findViewById(R.id.native_english);
        boolean isNativeSpeaker = nativeCheckBox.isChecked();

        CheckBox licenseCheckBox = (CheckBox) findViewById(R.id.license);
        boolean hasLicense = licenseCheckBox.isChecked();

        CheckBox degreeCheckBox = (CheckBox) findViewById(R.id.degree);
        boolean hasDegree = degreeCheckBox.isChecked();

        CheckBox experienceCheckBox = (CheckBox) findViewById(R.id.experience);
        boolean hasExperience = experienceCheckBox.isChecked();


        //Calls the method that summarizes all the info from the form

        String applicationSummary = messageSummary(name, age, nationality, phone, email, gender);



        if ((!isNativeSpeaker) && (!hasLicense) && (!hasDegree) && (!hasExperience)) {

            displaySummary(applicationSummary);//Calls the method that displays the summary

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, "charl@teflbright.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Job Application for " + name);
            intent.putExtra(Intent.EXTRA_TEXT, applicationSummary);
            if (intent.resolveActivity(getPackageManager()) != null ) {
                startActivity(intent);
            }

        } else {
            Toast.makeText(this, "You do not meet all of the requirements", Toast.LENGTH_SHORT).show();

        }

    }



    /*
    displays a summary of the application form
    */


    private void displaySummary(String message) {
        TextView applicationSummary = (TextView) findViewById(R.id.testMessage);
        applicationSummary.setText(message);

    }


    /*
    creates a summary message of the application form
     */
    private String messageSummary(String name, String age, String nationality, String phone, String email, String gender) {

        String message = "Name: " + name;
        message += "\nGender: " + gender;
        message += "\nAge: " + age;
        message += "\nNationality: " + nationality;
        message += "\nPhone : " + phone;
        message += "\nEmail: " + email;


        return message;
    }
}
