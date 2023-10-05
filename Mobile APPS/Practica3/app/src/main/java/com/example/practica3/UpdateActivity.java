package com.example.practica3;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UpdateActivity extends AppCompatActivity {

    EditText nombre_input, descripcion_input, precio_input;
    Button update_button, delete_button, clear_button;

    String id, nombre, descripcion, precio, imagensita;

    ImageButton selectImageButton;
    ImageView productImageView;
    private boolean hayImagen = false;
    public Uri imageUriPrincipal;
    public List<Uri> imageUriSecondaries = new ArrayList<>();
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private String idImagen;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        nombre_input = findViewById(R.id.title_input2);
        descripcion_input = findViewById(R.id.author_input2);
        precio_input = findViewById(R.id.pages_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);
        clear_button = findViewById(R.id.clear_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(nombre);
        }

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        selectImageButton = findViewById(R.id.selectImageButton2);
        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(UpdateActivity.this);
                builder.setTitle("Add Photo!");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (options[item].equals("Take Photo"))
                        {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, 1);
                            intent.setType("image/");
                            hayImagen = true;
                        }
                        else if (options[item].equals("Choose from Gallery"))
                        {
                            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                            intent.setType("image/");
                            hayImagen = true;
                            startActivityForResult(intent.createChooser(intent,"Seleccione la aplicacion"),200);
                        }
                        else if (options[item].equals("Cancel")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            }
        });
        productImageView = findViewById(R.id.imageView3);

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this

                String imageId = null;
                nombre = nombre_input.getText().toString().trim();
                descripcion = descripcion_input.getText().toString().trim();
                precio = precio_input.getText().toString().trim();
                if(hayImagen){
                    for(Uri uri : imageUriSecondaries){
                        imageId = uploadPic(uri);
                    }
                }

                if(nombre.isEmpty() && descripcion.isEmpty() && precio.isEmpty() && !hayImagen){
                    confirmDialog();
                }else{
                    if(!hayImagen){
                        imagensita = getIntent().getStringExtra("image");
                        ProductViewModel productViewModel = new ProductViewModel(getApplication());
                        Product product = new Product(nombre, descripcion, Double.parseDouble(precio), imagensita);
                        product.setId(Integer.parseInt(id));
                        productViewModel.update(product);
                        Toast.makeText(getApplicationContext(), "Product Updated", Toast.LENGTH_SHORT).show();

                    }else{
                        ProductViewModel productViewModel = new ProductViewModel(getApplication());
                        Product product = new Product(nombre, descripcion, Double.parseDouble(precio), imageId);
                        product.setId(Integer.parseInt(id));
                        productViewModel.update(product);
                        Toast.makeText(getApplicationContext(), "Product Updated", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre_input.setText("");
                descripcion_input.setText("");
                precio_input.setText("");
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("nombre") &&
                getIntent().hasExtra("descripcion") && getIntent().hasExtra("precio")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            nombre = getIntent().getStringExtra("nombre");
            descripcion = getIntent().getStringExtra("descripcion");
            precio = getIntent().getStringExtra("precio");

            //Setting Intent Data
            nombre_input.setText(nombre);
            descripcion_input.setText(descripcion);
            precio_input.setText(precio);
            Log.d("stev", nombre+" "+descripcion+" "+precio);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + nombre + " ?");
        builder.setMessage("Are you sure you want to delete " + nombre + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ProductViewModel productViewModel = new ProductViewModel(getApplication());
                productViewModel.deleteById(Integer.parseInt(id));
                Toast.makeText(getApplicationContext(), "Product Deleted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    private String uploadPic(Uri imagen) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading image...");
        progressDialog.show();

        String randomkey = getIntent().getStringExtra("image");;
        idImagen = randomkey;
        StorageReference riversRef = storageReference.child("images/" + randomkey);
        UploadTask uploadTask = riversRef.putFile(imagen);

        // Register observers to listen for when the download is done or if it fails
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Failed to Upload", Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Uploaded image", Toast.LENGTH_LONG).show();
            }
        });
        return randomkey;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageUriPrincipal = getImageUri(this, photo);
            imageUriSecondaries.add(getImageUri(this, photo));
            productImageView.setImageURI(imageUriPrincipal);
            productImageView.setVisibility(View.VISIBLE);
            selectImageButton.setVisibility(View.INVISIBLE);
        } else if (requestCode == 200 && resultCode == RESULT_OK) {
            assert data != null;
            if (data.getClipData() != null) {
                imageUriPrincipal = data.getClipData().getItemAt(0).getUri();
                for (int i = 0; i < data.getClipData().getItemCount(); i++) {
                    imageUriSecondaries.add(data.getClipData().getItemAt(i).getUri());
                }
                productImageView.setImageURI(imageUriPrincipal);
                productImageView.setVisibility(View.VISIBLE);
                selectImageButton.setVisibility(View.INVISIBLE);
            } else {
                imageUriPrincipal = data.getData();
                productImageView.setImageURI(imageUriPrincipal);
                productImageView.setVisibility(View.VISIBLE);
                selectImageButton.setVisibility(View.INVISIBLE);
            }
        }
    }
        public Uri getImageUri(Context inContext, Bitmap inImage) {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
            return Uri.parse(path);
        }
}
