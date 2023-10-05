package com.example.practica2;

import static android.content.ContentValues.TAG;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.security.Permissions;

public class MainActivity extends AppCompatActivity {
    Switch storage;
    Switch location;
    Switch camara;
    Switch phone;
    Switch contacts;
    TextView continuar;
    TextView cancelar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storage = (Switch) findViewById(R.id.switch1);
        location = (Switch) findViewById(R.id.switch2);
        camara = (Switch) findViewById(R.id.switch3);
        phone = (Switch) findViewById(R.id.switch4);
        contacts = (Switch) findViewById(R.id.switch5);
        SharedPreferences sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
        Intent intente = getIntent();

        storage.setChecked(sharedPreferences.getBoolean("value1",false));
        location.setChecked(sharedPreferences.getBoolean("value2",false));
        camara.setChecked(sharedPreferences.getBoolean("value3",false));
        phone.setChecked(sharedPreferences.getBoolean("value4",false));
        contacts.setChecked(sharedPreferences.getBoolean("value5",false));


        storage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_DENIED) {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
                         SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                         editor.putBoolean("value1",ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                                 == PackageManager.PERMISSION_DENIED);
                         editor.apply();
                         storage.setChecked(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                                 == PackageManager.PERMISSION_DENIED);
                    }
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value1",ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED);
                    editor.apply();
                    storage.setChecked(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED);
                }
                else {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED) {
                        SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                        editor.putBoolean("value1",ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                                == PackageManager.PERMISSION_GRANTED);
                        editor.apply();
                        storage.setChecked(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                                == PackageManager.PERMISSION_GRANTED);
                        storage.setClickable(false);
                    }
                }
            }
        });
        location.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_DENIED) {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
                        SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                        editor.putBoolean("value2",ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                                == PackageManager.PERMISSION_DENIED);
                        editor.apply();
                        location.setChecked(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                                == PackageManager.PERMISSION_DENIED);
                    }
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value2",ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED);
                    editor.apply();
                    location.setChecked(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED);
                }
                else {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
                        SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                        editor.putBoolean("value2",ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                                == PackageManager.PERMISSION_GRANTED);
                        editor.apply();
                        location.setChecked(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                                == PackageManager.PERMISSION_GRANTED);
                        location.setClickable(false);
                    }
                }
            }
        });
        camara.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_DENIED) {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.CAMERA},1);
                        SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                        editor.putBoolean("value3",ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                                == PackageManager.PERMISSION_DENIED);
                        editor.apply();
                        camara.setChecked(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                                == PackageManager.PERMISSION_DENIED);
                    }
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value3",ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_GRANTED);
                    editor.apply();
                    camara.setChecked(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_GRANTED);
                }
                else {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_GRANTED) {
                        SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                        editor.putBoolean("value3",ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                                == PackageManager.PERMISSION_GRANTED);
                        editor.apply();
                        camara.setChecked(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                                == PackageManager.PERMISSION_GRANTED);
                        camara.setClickable(false);
                    }
                }
            }
        });
        phone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
                            == PackageManager.PERMISSION_DENIED) {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE},1);
                        SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                        editor.putBoolean("value4",ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
                                == PackageManager.PERMISSION_DENIED);
                        editor.apply();
                        phone.setChecked(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
                                == PackageManager.PERMISSION_DENIED);
                    }
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value4",ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
                            == PackageManager.PERMISSION_GRANTED);
                    editor.apply();
                    phone.setChecked(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
                            == PackageManager.PERMISSION_GRANTED);
                }
                else {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
                            == PackageManager.PERMISSION_GRANTED) {
                        SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                        editor.putBoolean("value4",ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
                                == PackageManager.PERMISSION_GRANTED);
                        editor.apply();
                        phone.setChecked(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
                                == PackageManager.PERMISSION_GRANTED);
                        phone.setClickable(false);
                    }
                }
            }
        });
        contacts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS)
                            == PackageManager.PERMISSION_DENIED) {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.READ_CONTACTS},1);
                        SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                        editor.putBoolean("value5",ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS)
                                == PackageManager.PERMISSION_DENIED);
                        editor.apply();
                        contacts.setChecked(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS)
                                == PackageManager.PERMISSION_DENIED);
                    }
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value5",ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS)
                            == PackageManager.PERMISSION_GRANTED);
                    editor.apply();
                    contacts.setChecked(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS)
                            == PackageManager.PERMISSION_GRANTED);
                }
                else {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS)
                            == PackageManager.PERMISSION_GRANTED) {
                        SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                        editor.putBoolean("value5",ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS)
                                == PackageManager.PERMISSION_GRANTED);
                        editor.apply();
                        contacts.setChecked(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS)
                                == PackageManager.PERMISSION_GRANTED);
                        contacts.setClickable(false);
                    }
                }
            }
        });

        continuar = (TextView) findViewById(R.id.textView);
        continuar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("almacenamiento",storage.isChecked());
                intent.putExtra("ubicacion",location.isChecked());
                intent.putExtra("media",camara.isChecked());
                intent.putExtra("telefono",phone.isChecked());
                intent.putExtra("contactos",contacts.isChecked());
                startActivity(intent);
            }
        });

        cancelar = (TextView) findViewById(R.id.textView2);
        cancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

    }


}