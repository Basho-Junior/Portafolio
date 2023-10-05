package com.example.proyectofinal.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.R;
import com.example.proyectofinal.fragments.products.DetailProductFragment;
import com.example.proyectofinal.fragments.products.UpdateDeleteProductFragment;
import com.example.proyectofinal.helpers.ButtonHelper;
import com.example.proyectofinal.helpers.FragmentHelper;
import com.example.proyectofinal.models.Category;
import com.example.proyectofinal.models.Product;
import com.example.proyectofinal.viewmodels.CategoryViewModel;
import com.example.proyectofinal.viewmodels.ImgProductViewModel;
import com.example.proyectofinal.viewmodels.ProductViewModel;
import com.example.proyectofinal.viewmodels.UserViewModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.ProductViewHolder> {
    private Context context;
    private List<Product> products = new ArrayList<>();
    private static StorageReference storageReference;
    private static FragmentActivity activity;


    public ListProductAdapter(Context context, List<Product> products, FragmentActivity activity) {
        this.context = context;
        this.products = products;
        this.activity = activity;
    }

    public ListProductAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view  = inflater.inflate(R.layout.product_row, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
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

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView productNameText, productDescriptionText, productPriceText, productCategoryText, productIdText;
        ImageView productImage;
        Button productHandlerButton;
        CardView mainLayout;
        private CategoryViewModel cato;

        public ProductViewHolder(@NonNull final View itemView) {
            super(itemView);
            productNameText = itemView.findViewById(R.id.productNameText);
            productDescriptionText = itemView.findViewById(R.id.productDescriptionText);
            productPriceText = itemView.findViewById(R.id.productPriceText);
            productCategoryText = itemView.findViewById(R.id.productCategoryText);
            productIdText = itemView.findViewById(R.id.productIdText);
            productImage = itemView.findViewById(R.id.productImage);
            productHandlerButton = itemView.findViewById(R.id.productHandlerButton);

            mainLayout = itemView.findViewById(R.id.mainLayout);


        }

        public void bindData(final Product product, View view){
            //productImage.setImageResource(R.drawable.soap);
            //productImage.setImageBitmap(BitmapFactory.decodeByteArray(valueDecoded, 0, valueDecoded.length));
            productNameText.setText(product.getName());
            productDescriptionText.setText(product.getDescription());
            productPriceText.setText(Double.toString(product.getPrice()));
            CategoryViewModel cat = ViewModelProviders.of(activity).get(CategoryViewModel.class);
            cat.getCategoryById(product.getIdCatedory()).observe(activity, new Observer<Category>() {
                @Override
                public void onChanged(Category category) {

                    productCategoryText.setText(category.getName());
                }
            });
            productIdText.setText(Integer.toString(product.getId()));
                    System.out.println("Este es el id de la imagen! " + product.getImage());
                    final String image = product.getImage();
                    storageReference = FirebaseStorage.getInstance().getReference().child("images/" + image);
                    try {
                        final File localFile = File.createTempFile("Image" + product.getName(), "jpg");
                        storageReference.getFile(localFile)
                                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                    @Override
                                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                                        Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                                        productImage.setImageBitmap(bitmap);
                                    }
                                });
                    } catch (IOException e) {
                        System.out.println("guaaaay");
                    }

            productHandlerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("PRODUCT_NAME", productNameText.getText().toString());
                    bundle.putDouble("PRODUCT_PRICE", Double.parseDouble(productPriceText.getText().toString()));
                    bundle.putString("CATEGORY_NAME", productCategoryText.getText().toString());
                    bundle.putString("PRODUCT_DESCRIPTION", productDescriptionText.getText().toString());
                    bundle.putString("PRODUCT_IMAGE", image);
                    bundle.putInt("PRODUCT_ID", Integer.parseInt(productIdText.getText().toString()));

                    UpdateDeleteProductFragment updateDeleteProductFragment = new UpdateDeleteProductFragment();
                    updateDeleteProductFragment.setArguments(bundle);
                    FragmentHelper.ReplaceFragment(updateDeleteProductFragment, activity);
                }
            });

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Ocultando el float action button
                    ButtonHelper.SwitchCallCreateProductButton((FloatingActionButton) activity.findViewById(R.id.callCreateProductButton), true);
                    Bundle bundle = new Bundle();
                    bundle.putString("PRODUCT_NAME", productNameText.getText().toString());
                    bundle.putDouble("PRODUCT_PRICE", Double.parseDouble(productPriceText.getText().toString()));
                    bundle.putString("CATEGORY_NAME", productCategoryText.getText().toString());
                    bundle.putString("PRODUCT_IMAGE", image);
                    bundle.putString("PRODUCT_DESCRIPTION", productDescriptionText.getText().toString());
                    bundle.putInt("PRODUCT_ID", Integer.parseInt(productIdText.getText().toString()));

                    DetailProductFragment productDetailFragment = new DetailProductFragment();
                    productDetailFragment.setArguments(bundle);
                    FragmentHelper.ReplaceFragment(productDetailFragment, activity);
                }
            });


        }
    }
}
