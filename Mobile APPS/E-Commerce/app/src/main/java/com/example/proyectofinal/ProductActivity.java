package com.example.proyectofinal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

       /** FloatingActionButton button = findViewById(R.id.callCreateProductButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHelper.ReplaceFragment(new AddProductFragment(), ProductActivity.this);
            }
        });
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ListProductFragment listProductFragment = new ListProductFragment();
        fragmentTransaction.replace(R.id.fragment_container, listProductFragment);
        fragmentTransaction.commit();**/
    }
}