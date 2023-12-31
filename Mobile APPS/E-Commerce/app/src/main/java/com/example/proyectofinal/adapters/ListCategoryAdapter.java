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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.R;
import com.example.proyectofinal.fragments.category.UpdateDeleteCategoryFragment;
import com.example.proyectofinal.helpers.FragmentHelper;
import com.example.proyectofinal.models.Category;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class ListCategoryAdapter extends RecyclerView.Adapter<ListCategoryAdapter.MyViewHolder> implements Serializable {

    private final Context context;
    private ClickOnRowListener clickOnRowListener;
    private List<Category> elements;
    private StorageReference storageReference;
    private static FragmentActivity activity;

    public ListCategoryAdapter(Context context, List<Category> elements, FragmentActivity activity)
    {
        this.context = context;
        this.elements = elements;
        this.activity = activity;
    }

    public void setNotes(List<Category> notes) {
        this.elements = notes;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombreCategoria;
        ImageView image_categoria;
        Button categoryHandler;
        ClickOnRowListener clickOnRowListener;

        public MyViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            txtNombreCategoria = itemView.findViewById(R.id.txtNombreCategoria);
            image_categoria = itemView.findViewById(R.id.img_categoria);
            categoryHandler = itemView.findViewById(R.id.categoryhandlerbutton);

//            categoryHandler.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    AddCategoryFragment addCategoryFragment = new AddCategoryFragment();
//                    FragmentManager fragmentManager = addCategoryFragment.getParentFragmentManager();
//                    fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, addCategoryFragment, null).commit();
//                }
//            });
        }

    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull final MyViewHolder holder, int position) {
        final Category element = elements.get(position);
        holder.txtNombreCategoria.setText(String.valueOf(element.getName()));

        storageReference = FirebaseStorage.getInstance().getReference().child("images/" + element.getImage());

        try {
            final File localFile = File.createTempFile("Image" + element.getImage(), "jpg");
            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            holder.image_categoria.setImageBitmap(bitmap);
                        }
                    });
        } catch (IOException e) {
            Toast.makeText(context, "Error image" + element.getName(), Toast.LENGTH_SHORT).show();
        }

        holder.categoryHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("CATEGORY_NAME", holder.txtNombreCategoria.getText().toString());
                bundle.putString("CATEGORY_PHOTO", element.getImage());
                bundle.putInt("CATEGORY_ID", element.getId());

                UpdateDeleteCategoryFragment updateDeleteCategoryFragment = new UpdateDeleteCategoryFragment();
                updateDeleteCategoryFragment.setArguments(bundle);
                FragmentHelper.ReplaceFragment(updateDeleteCategoryFragment, activity);

//                // Aqui es donde cambias el fragmento desde el boton
//                ((MainMenu) context).ChangeToUpdateDeleteCategoryFragment();
            }
        });
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public interface ClickOnRowListener {
        void ClickOnRow(int position);
    }

}
