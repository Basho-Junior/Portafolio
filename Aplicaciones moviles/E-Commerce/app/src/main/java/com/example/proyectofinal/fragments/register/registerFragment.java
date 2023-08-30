package com.example.proyectofinal.fragments.register;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectofinal.MainMenu;
import com.example.proyectofinal.R;
import com.example.proyectofinal.fragments.forgotpass.forgotPasswordFragment;
import com.example.proyectofinal.fragments.login.loginFragment;
import com.example.proyectofinal.models.User;
import com.example.proyectofinal.viewmodels.UserViewModel;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class registerFragment extends Fragment {
    Button btnRegister;
    TextView txtPass,txtLogin,name,user,mail,pass,cPass;
    ImageView view;
    String url;
    UserViewModel userViewModel;
    ArrayList<TextView> views = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_register, container, false);
        btnRegister = root.findViewById(R.id.btnregister);
        txtPass = root.findViewById(R.id.txtforgotpassR);
        txtLogin = root.findViewById(R.id.txtloginR);
        view = root.findViewById(R.id.imageRegister);
        name = root.findViewById(R.id.txtname);
        views.add(name);
        user = root.findViewById(R.id.txtuser);
        views.add(user);
        mail = root.findViewById(R.id.txtmailR);
        views.add(mail);
        pass = root.findViewById(R.id.txtpassR);
        views.add(pass);
        cPass = root.findViewById(R.id.txtconfim);
        views.add(cPass);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean existUsername = true;
                Boolean existMail = true;

                userViewModel = ViewModelProviders.of(registerFragment.this).get(UserViewModel.class);
                System.out.println(userViewModel.getSingleUser(mail.getText().toString()).getValue());

                if(userViewModel.getSingleUserByUsername(user.getText().toString()).getValue() == null){
                    existUsername = false;
                }

                if(userViewModel.getSingleUser(mail.getText().toString()).getValue() == null){

                    existMail = false;
                }


             //   Boolean existUsername =  Manager.getInstance(getActivity()).userExistByUsername(user.getText().toString().trim()),
             //   existMail = Manager.getInstance(getActivity()).userExistByEmail(mail.getText().toString().trim());

                if(!(isEmpty()) && pass.getText().toString().equals(cPass.getText().toString()) && !(existMail) && !(existUsername) ){

                    view.buildDrawingCache();
                    Bitmap bmap = view.getDrawingCache();
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byte[] byteArray = stream.toByteArray();
                    bmap.recycle();
                    User userAux = new User();
                    userAux.setPp(byteArray);
                    userAux.setName(name.getText().toString());
                    userAux.setUsername(user.getText().toString());
                    userAux.setMail(mail.getText().toString());
                    userAux.setPassword(pass.getText().toString());
                    userViewModel.insert(userAux);
                    userViewModel.setAuth(userAux);

                   // Manager.getInstance(getActivity()).createUser(bmap,name.getText().toString().trim(),user.getText().toString().trim(),mail.getText().toString().trim(),pass.getText().toString().trim());
                    //Manager.getInstance(getActivity()).setAuth(Manager.getInstance(getActivity()).findUserByUsername(user.getText().toString().trim()));
                    Intent intent = new Intent(getActivity(), MainMenu.class);
                    intent.putExtra("Editing", userAux);
                    startActivity(intent);
                    getActivity().finish();
                }
                else if( !(pass.getText().toString().equals(cPass.getText().toString()))){
                    pass.setError("Las contraseñas deben ser iguales");
                }
                else if(existUsername){
                    user.setError("username alredy exist");

                }
                else if (existMail){
                    mail.setError("mail alredy taken");
                }

            }
        });

        txtPass.setOnClickListener(new View.OnClickListener() {
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

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment;
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                newFragment = new loginFragment();
                transaction.replace(R.id.nav_host_outside_fragment, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getGallery();
            }
        });

        return root;
    }

    private void getGallery(){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Seleccione la aplicacion"),200);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Uri patch = data.getData();
            url = patch.toString();
            view.setImageURI(patch);
        }
    }

    private Boolean isEmpty(){
        int num = 0;
        for (TextView view:views){
            if(view.getText().toString().isEmpty()){
                view.setError("Este campo es obligatorio");
                num++;
            }
        }
        return num == 0?false:true;
    }



}
