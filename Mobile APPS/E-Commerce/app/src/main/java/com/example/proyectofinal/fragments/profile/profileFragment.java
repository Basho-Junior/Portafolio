package com.example.proyectofinal.fragments.profile;

import static android.app.Activity.RESULT_OK;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectofinal.R;
import com.example.proyectofinal.models.User;
import com.example.proyectofinal.viewmodels.UserViewModel;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class profileFragment extends Fragment {

    private TextView name;
    private TextView mail;
    private TextView username;
    private Button btnEdit,btnCancel;
    private ImageView view;
    private Boolean editable = false;
    private View myview;
    ArrayList<TextView> views = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        myview = root;
        name = root.findViewById(R.id.txtnameProfile);
        views.add(name);
        mail = root.findViewById(R.id.txtmailProfile);

        username = root.findViewById(R.id.txtuserProfile);
        btnEdit = root.findViewById(R.id.btnEditUser);
        btnCancel = root.findViewById(R.id.btnCancelP);
        UserViewModel userVM = ViewModelProviders.of(profileFragment.this).get(UserViewModel.class);
        User model = (User) getArguments().getSerializable("edttext");
        //name.setText(Manager.getInstance(getActivity()).getAuth().getName());
        //mail.setText(Manager.getInstance(getActivity()).getAuth().getMail());
       // username.setText(Manager.getInstance(getActivity()).getAuth().getUsername());
        name.setText(model.getName());
        mail.setText(model.getMail());
        username.setText(model.getUsername());
        view = root.findViewById(R.id.imagePP);
        //view.setImageBitmap(Manager.getInstance(getActivity()).getAuth().getPp());
        Bitmap bitmap = BitmapFactory.decodeByteArray(model.getPp(), 0, model.getPp().length);
        view.setImageBitmap(bitmap);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editable){
                    getGallery();
                }

            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editable){
                    /*Boolean mailExtist = Manager.getInstance(getActivity()).userExistByEmail(mail.getText().toString().trim()),
                            usernameExist = Manager.getInstance(getActivity()).userExistByUsername(username.getText().toString().trim());*/

                    Boolean usernameExist = true;
                    Boolean mailExtist = true;
                    User user1 = userVM.getSingleUser(mail.getText().toString()).getValue();
                    User user2 = userVM.getSingleUserByUsername(username.getText().toString()).getValue();

                    if(user1 == null){
                        mailExtist = false;
                    }

                    if(user2 == null){
                        usernameExist = false;
                    }
                    if(mailExtist){
                        mailExtist = mail.getText().toString().trim().equals(model.getMail())?false:true;

                    }
                    if(usernameExist){
                        usernameExist = username.getText().toString().trim().equals(model.getUsername())?false:true;
                    }

                    if( !(isEmpty()) && !(mailExtist) && !(usernameExist)  ){
                        view.buildDrawingCache();
                        Bitmap bmap = view.getDrawingCache();

                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        bmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                        byte[] byteArray = stream.toByteArray();
                        bmap.recycle();

                        User myuser = new User();
                        myuser.setPp(byteArray);
                        myuser.setName(name.getText().toString().trim());
                        myuser.setUsername(username.getText().toString().trim());
                        myuser.setMail(mail.getText().toString().trim());
                        userVM.update(myuser);
                      //  Manager.getInstance(getActivity()).updateUser(bmap,name.getText().toString().trim(),username.getText().toString().trim(),mail.getText().toString().trim());
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Actualizado")
                                .setMessage(name.getText().toString()+" se actualizo con exito")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                }).show();
                        name.setText(myuser.getName());
                        mail.setText(myuser.getMail());
                        username.setText(myuser.getUsername());
                        Bitmap bitmap = BitmapFactory.decodeByteArray(myuser.getPp(), 0, myuser.getPp().length);
                        view.setImageBitmap(bitmap);

                    }
                    else if(mailExtist){
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Email Existe")
                                .setMessage("Este correo ya existe ")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                }).show();
                        name.setText(model.getName());
                        mail.setText(model.getMail());
                        username.setText(model.getUsername());
                        Bitmap bitmap = BitmapFactory.decodeByteArray(model.getPp(), 0, model.getPp().length);
                        view.setImageBitmap(bitmap);
                    }
                    else if(usernameExist){
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Username Existe")
                                .setMessage("Este nombre de usuario ya existe ")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                }).show();
                        name.setText(model.getName());
                        mail.setText(model.getMail());
                        username.setText(model.getUsername());
                        Bitmap bitmap = BitmapFactory.decodeByteArray(model.getPp(), 0, model.getPp().length);
                        view.setImageBitmap(bitmap);

                    }

                }
                editProfile();

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editProfile();
                name.setText(model.getName());
                mail.setText(model.getMail());
                username.setText(model.getUsername());
                Bitmap bitmap = BitmapFactory.decodeByteArray(model.getPp(), 0, model.getPp().length);
                view.setImageBitmap(bitmap);
            }
        });

        return root;
    }


    public void editProfile(){

        editable = !editable;
        btnEdit.setText(editable?"Update":"Start Editing");
        if(editable){

            name.setEnabled(true);
            username.setEnabled(true);
            mail.setEnabled(true);
            btnCancel.setVisibility(View.VISIBLE);
        }
        else {
            name.setEnabled(false);
            username.setEnabled(false);
            mail.setEnabled(false);
            btnCancel.setVisibility(View.INVISIBLE);

        }

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
            view.setImageURI(patch);
        }
    }

    public boolean isEmpty(){
        ViewGroup viewgroup= (ViewGroup) myview;

        int v = viewgroup.getChildCount();
        for (int i=0;i<viewgroup.getChildCount();i++) {
            View aux=viewgroup.getChildAt(i);

            if(aux instanceof EditText){
               if( ((EditText) aux).getText().toString().isEmpty() ) {
                   ((EditText) aux).setError("This cannot be empty");
                   return true;
               }
            }

        }
        return false;

    }

    public Bitmap StringToBitMap(String encodedString){
        try{
            byte [] encodeByte = Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }
        catch(Exception e){
            e.getMessage();
            return null;
        }
    }


}
