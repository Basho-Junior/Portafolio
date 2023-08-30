package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.snackbar.Snackbar;

public class SecondActivity extends AppCompatActivity {

    TextView STORAGE;
    TextView LOCATION;
    TextView CAMARA;
    TextView PHONE;
    TextView CONTACTS;
    FusedLocationProviderClient mFusedLocationClient;
    private static final int PICK_PDF_FILE = 2;
    int PERMISSION_ID = 44;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        STORAGE = (TextView) findViewById(R.id.textView3);
        LOCATION = (TextView) findViewById(R.id.textView4);
        CAMARA = (TextView) findViewById(R.id.textView5);
        PHONE = (TextView) findViewById(R.id.textView6);
        CONTACTS = (TextView) findViewById(R.id.textView7);
        Intent intent = getIntent();
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        boolean almacenamiento = intent.getBooleanExtra("almacenamiento", false);
        boolean ubicacion = intent.getBooleanExtra("ubicacion", false);
        boolean media = intent.getBooleanExtra("media", false);
        boolean telefono = intent.getBooleanExtra("telefono", false);
        boolean contactos = intent.getBooleanExtra("contactos", false);

        if (almacenamiento) {
            STORAGE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar mySnackbar = Snackbar.make(STORAGE,
                            "TIENE PERMISO HABILITADO", Snackbar.LENGTH_SHORT);
                    mySnackbar.setAction("ACCEDER", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Uri pickerInitialUri = null;
                            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                            intent.addCategory(Intent.CATEGORY_OPENABLE);
                            intent.setType("application/pdf");

                            // Optionally, specify a URI for the file that should appear in the
                            // system file picker when it loads.
                            intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, pickerInitialUri);

                            startActivityForResult(intent, PICK_PDF_FILE);
                        }
                    });
                    mySnackbar.show();
                }
            });

        }else{
            STORAGE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar mySnackbar = Snackbar.make(STORAGE,
                            "DEBE DE DARLE ESTE PERMISO A LA APP", Snackbar.LENGTH_SHORT);
                    mySnackbar.setAction("PERMITIR", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intente = new Intent(SecondActivity.this,MainActivity.class);
                            startActivity(intente);
                            finish();
                        }
                    });
                    mySnackbar.show();
                }
            });
        }

        if (ubicacion) {
            LOCATION.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar mySnackbar = Snackbar.make(STORAGE,
                            "TIENE PERMISO HABILITADO", Snackbar.LENGTH_SHORT);
                    mySnackbar.setAction("ACCEDER", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
                            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                            mapIntent.setPackage("com.google.android.apps.maps");
                            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                                startActivity(mapIntent);
                            }
                        }
                    });
                    mySnackbar.show();
                }
            });

        }else{
            LOCATION.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar mySnackbar = Snackbar.make(STORAGE,
                            "DEBE DE DARLE ESTE PERMISO A LA APP", Snackbar.LENGTH_SHORT);
                    mySnackbar.setAction("PERMITIR", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intente = new Intent(SecondActivity.this,MainActivity.class);
                            startActivity(intente);
                            finish();
                        }
                    });
                    mySnackbar.show();
                }
            });
        }

        if (media) {
            CAMARA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {Snackbar mySnackbar = Snackbar.make(STORAGE,
                        "TIENE PERMISO HABILITADO", Snackbar.LENGTH_SHORT);
                    mySnackbar.setAction("ACCEDER", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivity(intent);
                        }
                    });
                    mySnackbar.show();
                }
            });

        }else{
            CAMARA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar mySnackbar = Snackbar.make(STORAGE,
                            "DEBE DE DARLE ESTE PERMISO A LA APP", Snackbar.LENGTH_SHORT);
                    mySnackbar.setAction("PERMITIR", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intente = new Intent(SecondActivity.this,MainActivity.class);
                            startActivity(intente);
                            finish();
                        }
                    });
                    mySnackbar.show();
                }
            });
        }

        if (telefono) {
            PHONE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "Your Phone_number"));
                    Snackbar mySnackbar = Snackbar.make(STORAGE,
                            "TIENE PERMISO HABILITADO", Snackbar.LENGTH_SHORT);
                    mySnackbar.setAction("ACCEDER", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(Intent.ACTION_DIAL);// Initiates the Intent
                            intent.setData(Uri.parse("tel: 8090001111"));
                            startActivity(intent);
                        }
                    });
                    mySnackbar.show();
                }
            });
        }else{
            PHONE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar mySnackbar = Snackbar.make(STORAGE,
                            "DEBE DE DARLE ESTE PERMISO A LA APP", Snackbar.LENGTH_SHORT);
                    mySnackbar.setAction("PERMITIR", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intente = new Intent(SecondActivity.this,MainActivity.class);
                            startActivity(intente);
                            finish();
                        }
                    });
                    mySnackbar.show();
                }
            });
        }

        if (contactos) {
            CONTACTS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar mySnackbar = Snackbar.make(STORAGE,
                            "TIENE PERMISO HABILITADO", Snackbar.LENGTH_SHORT);
                    mySnackbar.setAction("ACCEDER", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                            startActivityForResult(intent, 1);
                        }
                    });
                    mySnackbar.show();
                }
            });

        }else{
            CONTACTS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar mySnackbar = Snackbar.make(STORAGE,
                            "DEBE DE DARLE ESTE PERMISO A LA APP", Snackbar.LENGTH_SHORT);
                    mySnackbar.setAction("PERMITIR", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intente = new Intent(SecondActivity.this,MainActivity.class);
                            startActivity(intente);
                            finish();
                        }
                    });
                    mySnackbar.show();
                }
            });
        }


    }
    public View.OnClickListener checkPermission(String permission, int requestCode)
    {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(SecondActivity.this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(SecondActivity.this, new String[] { permission }, requestCode);
        }
        return null;
    }
}