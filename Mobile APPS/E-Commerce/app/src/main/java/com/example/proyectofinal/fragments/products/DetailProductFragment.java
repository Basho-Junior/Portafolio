package com.example.proyectofinal.fragments.products;

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

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectofinal.MainMenu;
import com.example.proyectofinal.R;
import com.example.proyectofinal.models.CarItem;
import com.example.proyectofinal.models.Category;
import com.example.proyectofinal.models.Product;
import com.example.proyectofinal.viewmodels.CategoryViewModel;
import com.example.proyectofinal.viewmodels.ProductViewModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.synnapps.carouselview.ImageListener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailProductFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailProductFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailProductFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailProductFragment newInstance(String param1, String param2) {
        DetailProductFragment fragment = new DetailProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_product, container, false);
        final Bundle bundle = getArguments();
        TextView productDetailDescription = view.findViewById(R.id.productDetailDescription);
        TextView productDetailPrice = view.findViewById(R.id.productDetailPrice);
        ImageView imafen = view.findViewById(R.id.imageView3);
        ProductViewModel prod = ViewModelProviders.of(DetailProductFragment.this).get(ProductViewModel.class);
        prod.getAllProducts().observe(getActivity(), new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {

                Product product = null;
                for(Product search : products){
                    if(search.getId() == bundle.getInt("PRODUCT_ID")){
                        //System.out.println("El size de search: " + search.getImages().size());
                        product = search;
                    }

                    //System.out.println("El size: " + product.getImages().size());
                    //Product product = Product.getProductById(getContext(), bundle.getInt("PRODUCT_ID"));
                    final List<Bitmap> images = new ArrayList<>();
                    //final CarouselView productDetailImages = view.findViewById(R.id.productPhotosCarousel);
                    final ImageListener imageListener = new ImageListener() {
                        @Override
                        public void setImageForPosition(int position, ImageView imageView) {
                            imageView.setImageBitmap(images.get(position));
                        }
                    };
                        String imagenes = bundle.getString("PRODUCT_IMAGE");
                        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("images/" + imagenes);
                        try {
                            final File localFile = File.createTempFile("Image" + imagenes, "jpg");
                            final Product finalProduct = product;
                            storageReference.getFile(localFile)
                                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                        @Override
                                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                                            Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                                            imafen.setImageBitmap(bitmap);
                                            images.add(bitmap);
                                            //productDetailImages.setImageListener(imageListener);
                                            //productDetailImages.setPageCount(images.size());

                                        }
                                    });
                        } catch (IOException e) {
                            System.out.println("guaaaay");
                        }

                }

                Button plusButton = view.findViewById(R.id.plusButton);
                Button minusButton = view.findViewById(R.id.minusButton);
                final Button addToCartButton = view.findViewById(R.id.addToCartButton);
                final TextView productQuantityText = view.findViewById(R.id.productQuantityText);

                productDetailDescription.setText(bundle.getString("PRODUCT_DESCRIPTION"));
                productDetailPrice.setText(Double.toString(bundle.getDouble("PRODUCT_PRICE")));

                plusButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int total = Integer.parseInt(productQuantityText.getText().toString());
                        total += 1;
                        productQuantityText.setText(Integer.toString(total));
                    }
                });

                minusButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int total = Integer.parseInt(productQuantityText.getText().toString());
                        if(total > 1){
                            total -= 1;
                            productQuantityText.setText(Integer.toString(total));
                        }
                    }
                });

                addToCartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CategoryViewModel cat = ViewModelProviders.of(DetailProductFragment.this).get(CategoryViewModel.class);
                        cat.getCategoryByName(bundle.getString("CATEGORY_NAME")).observe(getActivity(), new Observer<Category>() {
                            @Override
                            public void onChanged(@Nullable Category category) {
                                Product product = new Product();
                                product.setId(bundle.getInt("PRODUCT_ID"));
                                product.setName(bundle.getString("PRODUCT_NAME"));
                                product.setDescription(bundle.getString("PRODUCT_DESCRIPTION"));
                                product.setPrice(bundle.getDouble("PRODUCT_PRICE"));
                                product.setIdCatedory(category.getId());
                                product.setImage(bundle.getString("PRODUCT_IMAGE"));

                                int index = MainMenu.productInCart(product);

                                CarItem cartItem = new CarItem(product, Integer.parseInt(productQuantityText.getText().toString()));
                                if(index != -1){
                                    MainMenu.productsCart.set(index, cartItem);
                                }else{
                                    MainMenu.productsCart.add(cartItem);

                                }
                                Toast.makeText(getContext(),"Product added successfully", Toast.LENGTH_SHORT).show();

                                addToCartButton.setEnabled(false);
                                addToCartButton.setText("PRODUCT ALREADY IN CART");

                            }
                        });
                /*Product product = new Product(bundle.getInt("PRODUCT_ID"), bundle.getString("PRODUCT_NAME"), bundle.getString("PRODUCT_DESCRIPTION"),
                        bundle.getDouble("PRODUCT_PRICE"), category);*/
                    }
                });
            }
        });
        return view;
    }
}