package com.example.proyectofinal.fragments.products;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectofinal.MainMenu;
import com.example.proyectofinal.R;
import com.example.proyectofinal.fragments.category.AddCategoryFragment;
import com.example.proyectofinal.helpers.FragmentHelper;
import com.example.proyectofinal.models.Category;
import com.example.proyectofinal.models.ImageProduct;
import com.example.proyectofinal.models.Product;
import com.example.proyectofinal.models.User;
import com.example.proyectofinal.viewmodels.CategoryViewModel;
import com.example.proyectofinal.viewmodels.ImgProductViewModel;
import com.example.proyectofinal.viewmodels.ProductViewModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddProductFragment extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Components
    ImageButton selectImageButton;
    ImageView productImageView;
    private boolean hayImagen = false;
    public Uri imageUriPrincipal;
    public List<Uri> imageUriSecondaries = new ArrayList<>();
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private String idImagen;

    public AddProductFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddProductFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddProductFragment newInstance(String param1, String param2) {
        AddProductFragment fragment = new AddProductFragment();
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
        View view = inflater.inflate(R.layout.fragment_add_product, container, false);


        Bundle bundle = getArguments();
        if(bundle != null && bundle.containsKey("PRODUCT_NAME")){
            TextView productNameTextView = view.findViewById(R.id.productNameTextView);
            productNameTextView.setText(bundle.getString("PRODUCT_NAME"));
        }

        if(bundle != null && bundle.containsKey("PRODUCT_PRICE")){
            TextView productPriceText = view.findViewById(R.id.productPriceTextView);
            productPriceText.setText(bundle.getString("PRODUCT_PRICE"));
        }

        //Llenando el spinner con las categorias
        Spinner categorySpinner = view.findViewById(R.id.categorySpinner);
        CategoryViewModel cat = ViewModelProviders.of(AddProductFragment.this).get(CategoryViewModel.class);
        cat.getAllCategories().observe(getActivity(), new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable List<Category> categoryList) {
                List<String> categoryName = new ArrayList<>();
                for(Category category : categoryList){
                    categoryName.add(category.getName());
                }
                System.out.println(categoryName.size());
                //TODO: Llenar categoria con base de datos - Marcos
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        getContext(), android.R.layout.simple_spinner_item, categoryName);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                categorySpinner.setAdapter(adapter);

                if(bundle != null && bundle.containsKey("CATEGORY_NAME")){
                    int position = adapter.getPosition(bundle.getString("CATEGORY_NAME"));
                    categorySpinner.setSelection(position);
                }
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        final TextView productNameTextView = getView().findViewById(R.id.productNameTextView);
        final TextView productPriceText = getView().findViewById(R.id.productPriceTextView);
        final TextView productDescriptionText = getView().findViewById(R.id.productDescriptionTextView);
        final Button saveProductButton = getView().findViewById(R.id.saveProductButton);
        Button addCategoryButton = getView().findViewById(R.id.addCategoryButton);
        final Spinner categorySpinner = getView().findViewById(R.id.categorySpinner);
        saveProductButton.setEnabled(false);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        selectImageButton = getView().findViewById(R.id.selectImageButton);
        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getGallery();
            }
        });

        productImageView = getView().findViewById(R.id.productImageView);



        productNameTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(productNameTextView.getText().toString().length() > 0 && productPriceText.getText().toString().length() > 0
                        && productDescriptionText.getText().toString().length() > 0){
                    saveProductButton.setEnabled(true);
                }
                else{
                    saveProductButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        productPriceText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(productNameTextView.getText().toString().length() > 0 && productPriceText.getText().toString().length() > 0
                && productDescriptionText.getText().toString().length() > 0){
                    saveProductButton.setEnabled(true);
                }
                else{
                    saveProductButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        productDescriptionText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(productNameTextView.getText().toString().length() > 0 && productPriceText.getText().toString().length() > 0
                        && productDescriptionText.getText().toString().length() > 0){
                    saveProductButton.setEnabled(true);
                }
                else{
                    saveProductButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        saveProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryViewModel cat = new CategoryViewModel(getActivity().getApplication());
                cat.getCategoryByName(categorySpinner.getSelectedItem().toString()).observe(getActivity(), new Observer<Category>() {
                    @Override
                    public void onChanged(@Nullable Category category) {
                        List<String> imagesId = new ArrayList<>();
                        String productName = productNameTextView.getText().toString();
                        String productDescription = productDescriptionText.getText().toString();
                        double productPrice = Double.parseDouble(productPriceText.getText().toString());
                        ProductViewModel prod = new ProductViewModel(getActivity().getApplication());
                        ImgProductViewModel ima =  new ImgProductViewModel(getActivity().getApplication());
                        Product product = new Product();
                        if(hayImagen){
                            for(Uri uri : imageUriSecondaries){
                                String imageId = uploadPic(uri);
                                imagesId.add(imageId);
                                ImageProduct imag = new ImageProduct(imageId,product.getId());
                                ima.insert(imag);
                            }
                        }
                        product.setName(productName);
                        product.setDescription(productDescription);
                        product.setPrice(productPrice);
                        product.setImage(idImagen);
                        product.setIdCatedory(category.getId());

                        prod.insert(product);

                        //NicoluSystem.out.println(product.getImages().get(0));

                        //long id = Product.saveProduct(v.getContext(), product, idImagen);
                        //Product.saveImages(getContext(), imagesId, id);
                        FragmentHelper.AddFragment(new ListProductFragment(), getActivity());
                    }
                });
            }
        });

        addCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHelper.AddFragment(new AddCategoryFragment(), getActivity());
            }
        });
    }

    private String uploadPic(Uri imagen) {

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
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
                Toast.makeText(getContext(), "Failed to Upload", Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Uploaded image", Toast.LENGTH_LONG).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull @NotNull UploadTask.TaskSnapshot snapshot) {
                double progressPercent = (100.00 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                progressDialog.setMessage("Progress: " + (int) progressPercent + "%");
            }
        });
        return randomkey;
    }

    private void getGallery(){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setType("image/");
        hayImagen = true;
        startActivityForResult(intent.createChooser(intent,"Seleccione la aplicacion"),200);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data != null;
        if(data.getClipData() != null){
            imageUriPrincipal = data.getClipData().getItemAt(0).getUri();
            for(int i = 0; i < data.getClipData().getItemCount(); i++){
                imageUriSecondaries.add(data.getClipData().getItemAt(i).getUri());
            }
            productImageView.setImageURI(imageUriPrincipal);
            productImageView.setVisibility(View.VISIBLE);
            selectImageButton.setVisibility(View.INVISIBLE);
        }
        else{
            imageUriPrincipal = data.getData();
            productImageView.setImageURI(imageUriPrincipal);
            productImageView.setVisibility(View.VISIBLE);
            selectImageButton.setVisibility(View.INVISIBLE);
        }
    }
}