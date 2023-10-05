package com.example.practica3;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AddProductActivity extends AppCompatActivity {
    EditText nombre, descripcion, precio/*, image*/;
    Button add_button;

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
        setContentView(R.layout.activity_add);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        selectImageButton = findViewById(R.id.selectImageButton);
        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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

        productImageView = findViewById(R.id.imageView2);

        nombre = findViewById(R.id.title_input);
        descripcion = findViewById(R.id.author_input);
        precio = findViewById(R.id.pages_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> imagesId = new ArrayList<>();;
                ProductViewModel productViewModel = new ProductViewModel(getApplication());

                if(hayImagen){
                    for(Uri uri : imageUriSecondaries){
                        String imageId = uploadPic(uri);
                        imagesId.add(imageId);
                    }
                }
                Product product = new Product(nombre.getText().toString().trim(),
                        descripcion.getText().toString().trim(),
                        Double.valueOf(precio.getText().toString().trim()),idImagen);

                productViewModel.insert(product);

            }
        });
    }

    private String uploadPic(Uri imagen) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading image...");
        progressDialog.show();

        String randomkey = UUID.randomUUID().toString();
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
        } else if(requestCode == 200 && resultCode == RESULT_OK) {
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