package com.example.proyectofinal.fragments.products;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.R;
import com.example.proyectofinal.adapters.ListProductAdapter;
import com.example.proyectofinal.helpers.FragmentHelper;
import com.example.proyectofinal.models.Product;
import com.example.proyectofinal.viewmodels.ProductViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListProductFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListProductFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListProductFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListProductFragment newInstance(String param1, String param2) {
        ListProductFragment fragment = new ListProductFragment();
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
        // Inflate the layout for this fragmentº
        View view = inflater.inflate(R.layout.fragment_list_product, container, false);

        //Floating button
        FloatingActionButton button = view.findViewById(R.id.callCreateProductButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHelper.ReplaceFragment(new AddProductFragment(), getActivity());
            }
        });

        //Obteniendo la informacion necesaria a traves de la base de datos
        //List<Product> productList = new ArrayList<>();//Product.getProducts(this.getContext());
        //Category category = new Category(1, "Bebidas", null);
        //Product first_product = new Product(1, "Grappa con limon", "Esta es la real grappa", 100, category);
        //first_product.getImages().add()
        //productList.add(first_product);
        //Product second_product = new Product(1, "Jabon", "The ultimate race has arrived", 300, category);
        //productList.add(second_product);
        //System.out.println("El size de productos es: " + productList.size());

        //Mostrando el float action button
        //ButtonHelper.SwitchCallCreateProductButton((FloatingActionButton) getActivity().findViewById(R.id.callCreateProductButton), false);

        ProductViewModel prod = ViewModelProviders.of(ListProductFragment.this).get(ProductViewModel.class);
        prod.getAllProducts().observe(getActivity(), new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> product) {
                RecyclerView recyclerView = view.findViewById(R.id.productRecyclerView);
                ListProductAdapter productListAdapter = new ListProductAdapter(getContext(), product, getActivity());
                recyclerView.setAdapter(productListAdapter);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(mLayoutManager);
            }
        });
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        //Mostrando el float action button
        //ButtonHelper.SwitchCallCreateProductButton((FloatingActionButton) getActivity().findViewById(R.id.callCreateProductButton), false);
    }
}