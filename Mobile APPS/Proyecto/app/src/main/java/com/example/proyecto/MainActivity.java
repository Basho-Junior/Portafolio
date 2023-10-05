package com.example.proyecto;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.proyecto.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    List<String> generos;
    Spinner generoSpinner;
    RadioGroup RadioGroup1;
    RadioButton Radio1;
    RadioButton Radio2;
    CheckBox checkJava;
    CheckBox checkPython;
    CheckBox checkJs;
    CheckBox checkgo;
    CheckBox checkCMas;
    CheckBox checkChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        savedInstanceState = null;
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initRadio();

        initDatePicker();

        dateButton = findViewById(R.id.datePickerButton);

        //System.out.println(getTodaysDate());
        //dateButton.setText(getTodaysDate());
        generoSpinner = findViewById(R.id.idGeneroSpinner);
        generos = new ArrayList<>();
        generos.add("Masculino");
        generos.add("Femenino");
        generos.add("Otro");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, generos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        generoSpinner.setAdapter(adapter);

        Button borrar = (Button) findViewById(R.id.button_first2);
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nombre = (EditText) findViewById(R.id.editTextTextPersonName);
                EditText apellido = (EditText) findViewById(R.id.editTextTextPersonName2);
                Button nacimiento = (Button) findViewById(R.id.datePickerButton);


                nombre.setText("");
                apellido.setText("");
                generoSpinner.setSelection(0);
                nacimiento.setText("");
                Radio1.setChecked(true);
                checkJava.setChecked(false);
                checkPython.setChecked(false);
                checkJs.setChecked(false);
                checkgo.setChecked(false);
                checkCMas.setChecked(false);
                checkChar.setChecked(false);

            }
        });

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        /*binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }

    private void initRadio() {
        RadioGroup1 = (RadioGroup) findViewById(R.id.radioGrp);
        Radio1 = (RadioButton) findViewById(R.id.radioS);
        Radio2 = (RadioButton) findViewById(R.id.radioN);
        checkJava = (CheckBox) findViewById(R.id.java);
        checkPython = (CheckBox) findViewById(R.id.python);
        checkJs = (CheckBox) findViewById(R.id.js);
        checkgo = (CheckBox) findViewById(R.id.goLand);
        checkCMas = (CheckBox) findViewById(R.id.cMas);
        checkChar = (CheckBox) findViewById(R.id.cChar);
        RadioGroup1.setOnCheckedChangeListener(this);
    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day,month,year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day,month,year);
                dateButton.setText(date);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }

    private String makeDateString(int day, int month, int year) {
        return month + "/" + day + "/" + year % 100;
    }

    public void openDatePicker(View view){
        datePickerDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // TODO Auto-generated method stub
        switch(checkedId){
            case R.id.radioN:
                checkJava.setEnabled(false);
                checkPython.setEnabled(false);
                checkJs.setEnabled(false);
                checkgo.setEnabled(false);
                checkCMas.setEnabled(false);
                checkChar.setEnabled(false);
                break;

            case R.id.radioS:
                checkJava.setEnabled(true);
                checkPython.setEnabled(true);
                checkJs.setEnabled(true);
                checkgo.setEnabled(true);
                checkCMas.setEnabled(true);
                checkChar.setEnabled(true);
                break;
        }
    }
    @Override
    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }
}