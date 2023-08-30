package com.example.practica3;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    private List<Product> products = new ArrayList<>();
    private Activity activity;
    private static StorageReference storageReference;
    private Context context;

    public ProductAdapter() {
    }

    public ProductAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_row, parent, false);
        return new ProductHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        System.out.println("Añadiendo en la posicion: " + position);
        holder.bindData(products.get(position), holder.itemView);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setNotes(List<Product> notes) {
        this.products = notes;
        notifyDataSetChanged();
    }

    public Product getNoteAt(int position) {
        return products.get(position);
    }

    class ProductHolder extends RecyclerView.ViewHolder {
        TextView Product_id_txt, Product_title_txt, Product_author_txt, Product_pages_txt;
        ImageView productImage;
        Button productSaveButton;
        LinearLayout mainLayout;

        public ProductHolder(View itemView) {
            super(itemView);
            Product_id_txt = itemView.findViewById(R.id.Product_id_txt);
            Product_title_txt = itemView.findViewById(R.id.Product_name_txt);
            Product_author_txt = itemView.findViewById(R.id.Product_descripcion_txt);
            Product_pages_txt = itemView.findViewById(R.id.Product_prize_txt);
            productImage = itemView.findViewById(R.id.imageView);
            productSaveButton = itemView.findViewById(R.id.button);


            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            //Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            //mainLayout.setAnimation(translate_anim);
        }
        public void bindData(final Product product, View view){
            System.out.println("Este es el id de la imagen! " + product.getImages());
            final String image = product.getImages();
            final ProgressDialog progressDialog = new ProgressDialog(view.getContext());
            progressDialog.setMessage("Please wait...");
            progressDialog.show();
            storageReference = FirebaseStorage.getInstance().getReference().child("images/" + image);
            try {
                final File localFile = File.createTempFile("Image" + product.getName(), "jpg");
                storageReference.getFile(localFile)
                        .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                                Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                                productImage.setImageBitmap(bitmap);
                                progressDialog.dismiss();
                            }
                        });
            } catch (IOException e) {
                System.out.println("guaaaay");
            }

            Product_id_txt.setText(Integer.toString(product.getId()));
            Product_title_txt.setText(product.getName());
            Product_author_txt.setText(product.getDescription());
            Product_pages_txt.setText(Double.toString(product.getPrice()));

            productSaveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, UpdateActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("nombre", Product_title_txt.getText().toString());
                    bundle.putString("precio", Product_pages_txt.getText().toString());
                    bundle.putString("descripcion", Product_author_txt.getText().toString());
                    bundle.putString("image", image);
                    bundle.putString("id", Product_id_txt.getText().toString());

                    intent.putExtras(bundle);
                    context.startActivity(intent, bundle);
                }
            });

        }
    }
}