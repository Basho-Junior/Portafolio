package com.example.proyectofinal.fragments.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectofinal.MainMenu;
import com.example.proyectofinal.R;
import com.example.proyectofinal.fragments.forgotpass.forgotPasswordFragment;
import com.example.proyectofinal.fragments.register.registerFragment;
import com.example.proyectofinal.models.User;
import com.example.proyectofinal.viewmodels.UserViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class loginFragment extends Fragment {
    Button btnLogin;
    TextView txtForgotPass,txtRegister,txtMail,txtPass;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        btnLogin = root.findViewById(R.id.btnlogin);
        UserViewModel auth =  ViewModelProviders.of(this).get(UserViewModel.class);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtMail.getText().toString().isEmpty() || txtPass.getText().toString().isEmpty()){
                    Snackbar.make(view,"Debe llenar todos los campos",Snackbar.LENGTH_LONG).show();
                }
                else{
                    auth.getLiveData(txtMail.getText().toString(),txtPass.getText().toString()).observe(getActivity(), new Observer<User>() {
                        @Override
                        public void onChanged(@Nullable User aux) {
                            if(aux == null){
                                txtMail.setError("User not exist");
                            }
                            else if(aux.getName().equals("Bad Credentials")){
                                txtMail.setError("Email or Password wrong");
                            }
                            else{
                                Intent intent = new Intent(getActivity(), MainMenu.class);
                                intent.putExtra("Editing", aux);
                                startActivity(intent);
                                getActivity().finish();
                            }
                        }
                    });
                }
                }
        });
        txtForgotPass = root.findViewById(R.id.txtforgotpass);
        txtForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment;
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                newFragment = new forgotPasswordFragment();
                transaction.replace(R.id.nav_host_outside_fragment, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        txtRegister = root.findViewById(R.id.txtregister);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment;
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                newFragment = new registerFragment();
                transaction.replace(R.id.nav_host_outside_fragment, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        txtMail = root.findViewById(R.id.txtmail);
        txtPass = root.findViewById(R.id.txtpass);

        return root;
    }


}
