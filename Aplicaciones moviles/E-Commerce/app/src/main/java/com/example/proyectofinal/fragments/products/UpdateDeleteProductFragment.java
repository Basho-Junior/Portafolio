package com.example.proyectofinal.fragments.products;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectofinal.R;
import com.example.proyectofinal.helpers.FragmentHelper;
import com.example.proyectofinal.models.Category;
import com.example.proyectofinal.models.Product;
import com.example.proyectofinal.viewmodels.CategoryViewModel;
import com.example.proyectofinal.viewmodels.ProductViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdateDeleteProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateDeleteProductFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UpdateDeleteProductFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateDeleteProductFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateDeleteProductFragment newInstance(String param1, String param2) {
        UpdateDeleteProductFragment fragment = new UpdateDeleteProductFragment();
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
        View view = inflater.inflate(R.layout.fragment_update_delete_product, container, false);
        Spinner categorySpinner = view.findViewById(R.id.categorySpinner);

        Bundle bundle = getArguments();
        if(bundle != null && bundle.containsKey("PRODUCT_NAME")){
            TextView productNameTextView = view.findViewById(R.id.productNameTextView);
            productNameTextView.setText(bundle.getString("PRODUCT_NAME"));
        }

        if(bundle != null && bundle.containsKey("PRODUCT_PRICE")){
            TextView productPriceText = view.findViewById(R.id.productPriceTextView);
            productPriceText.setText(Double.toString(bundle.getDouble("PRODUCT_PRICE")));
        }

        if(bundle != null && bundle.containsKey("PRODUCT_DESCRIPTION")){
            TextView productDescriptionText = view.findViewById(R.id.productUpdateDescriptionText);
            productDescriptionText.setText(bundle.getString("PRODUCT_DESCRIPTION"));
        }

        //Llenando el spinner con las categorias
        CategoryViewModel cat = ViewModelProviders.of(UpdateDeleteProductFragment.this).get(CategoryViewModel.class);
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
        final TextView productDescriptionText = getView().findViewById(R.id.productUpdateDescriptionText);
        final Spinner categorySpinner = getView().findViewById(R.id.categorySpinner);
        Button addCategoryButton = getView().findViewById(R.id.addCategoryButton);
        Button updateProductButton = getView().findViewById(R.id.updateProductButton);
        Button deleteProductButton = getView().findViewById(R.id.deleteProductButton);

        addCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: SAUL LLAMA TU FORMA DE GUARDAR CATEGORIAS DESDE AQUI
            }
        });

        updateProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle receivedBundle = getArguments();
                String productName = productNameTextView.getText().toString();
                String productDescription = productDescriptionText.getText().toString();
                double productPrice = Double.parseDouble(productPriceText.getText().toString());

                //TODO: USE DATABASE
                CategoryViewModel cat = ViewModelProviders.of(UpdateDeleteProductFragment.this).get(CategoryViewModel.class);
                ProductViewModel prod = new ProductViewModel(getActivity().getApplication());
                cat.getCategoryByName(categorySpinner.getSelectedItem().toString()).observe(getActivity(), new Observer<Category>() {
                    @Override
                    public void onChanged(@Nullable Category category) {
                        Product product = new Product();
                        product.setId(receivedBundle.getInt("PRODUCT_ID"));
                        product.setName(productName);
                        product.setDescription(productDescription);
                        product.setPrice(productPrice);
                        product.setIdCatedory(category.getId());

                        prod.update(product);
                        FragmentHelper.AddFragment(new ListProductFragment(), getActivity());
                    }
                });
                //Product product = new Product(receivedBundle.getInt("PRODUCT_ID"), productName, productDescription, productPrice, category);
            }
        });

        deleteProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext())
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Borrar Producto")
                        .setMessage("Esta seguro que desea eliminar este producto?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Bundle receivedBundle = getArguments();
                                ProductViewModel prod = ViewModelProviders.of(UpdateDeleteProductFragment.this).get(ProductViewModel.class);
                                prod.deleteById(receivedBundle.getInt("PRODUCT_ID"));
                                FragmentHelper.AddFragment(new ListProductFragment(), getActivity());
                            }

                        })
                        .setNegativeButton("No", null)
                        .show();

            }
        });
    }
}