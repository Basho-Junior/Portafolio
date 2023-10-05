package com.example.primerparcial;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class ProductListAdapter  extends ListAdapter<Product, ProductListAdapter.ProductViewHolder> {
    ProductClickInterface productClickInterface;
    private Context context;


    protected ProductListAdapter(@NonNull DiffUtil.ItemCallback<Product> diffCallback, ProductClickInterface productClickInterface) {
        super(diffCallback);
        this.productClickInterface = productClickInterface;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = getItem(position);
        holder.bind(product);
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "ProductViewHolder";
        TextView artTextView, descTextView, precioTextView;
        ImageButton deleteButton, shareButton;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            artTextView = itemView.findViewById(R.id.articuloView);
            descTextView = itemView.findViewById(R.id.descView);
            precioTextView = itemView.findViewById(R.id.precioView);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            shareButton = itemView.findViewById(R.id.shareButton);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productClickInterface.onDelete(getAdapterPosition());
                    Snackbar mySnackbar = Snackbar.make(deleteButton,
                            "PRODUCTO ELIMINADO", Snackbar.LENGTH_SHORT);
                    mySnackbar.show();
                }
            });
            shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);

                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, artTextView.getText().toString()+ " " + descTextView.getText().toString() + " " + precioTextView.getText().toString());
                    v.getContext().startActivity(Intent.createChooser(intent, "Share"));
                }
            });
        }

        public void bind(Product product) {
            artTextView.setText(product.getArticulo());
            descTextView.setText(product.getDescripcion());
            precioTextView.setText(String.valueOf(product.getPrecio()));
        }
    }

    interface ProductClickInterface {
        public void onDelete(int position);
    }

}
