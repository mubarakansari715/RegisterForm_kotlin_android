package com.example.registerform_kotlin_android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var hobbies = arrayOf("Music", "Cricket", "Badminton")
    var strSp: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edt_email = findViewById<EditText>(R.id.edt_email)
        val edt_name = findViewById<EditText>(R.id.edt_name)
        val edt_number = findViewById<EditText>(R.id.edt_number)
        val edt_password = findViewById<EditText>(R.id.edt_pws)
        val btn_submit = findViewById<Button>(R.id.btn_submit)
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)
        val spinner = findViewById<Spinner>(R.id.selecte_spinner)

        val arrayAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, hobbies)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                strSp = adapterView.getItemAtPosition(i).toString()
                //Toast.makeText(MainActivity.this, "Selected : "+adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
        btn_submit.setOnClickListener {
            val strName: String = edt_name.text.toString()
            val strEmail: String = edt_email.text.toString()
            val strNumber: String = edt_number.text.toString()
            val strPasswords: String = edt_password.text.toString()
            val password = strPasswords.toInt()
            val number = strNumber.toInt()
            val selectedtradioButton =
                radioGroup.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
            //Toast.makeText(MainActivity.this, selectedtradioButton.getText(), Toast.LENGTH_SHORT).show();
            val intent = Intent(applicationContext, DataActivity::class.java)
            intent.putExtra("Name", strName)
            intent.putExtra("Email", strEmail)
            intent.putExtra("Number", number)
            intent.putExtra("Gender", selectedtradioButton.text)
            intent.putExtra("spineer", strSp)
            intent.putExtra("Password", password)
            startActivity(intent)
        }
    }
}