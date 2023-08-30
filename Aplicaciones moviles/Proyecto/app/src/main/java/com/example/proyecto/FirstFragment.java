package com.example.proyecto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (view == null)
            view = inflater.inflate(R.layout.fragment_first,
                    container, false
            );
        Button send = view.findViewById(R.id.button_first3);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nombre = view.findViewById(R.id.editTextTextPersonName);
                EditText apellido = view.findViewById(R.id.editTextTextPersonName2);
                Spinner genero = view.findViewById(R.id.idGeneroSpinner);
                Button nacimiento = view.findViewById(R.id.datePickerButton);
                RadioGroup RadioGroup1 = view.findViewById(R.id.radioGrp);
                int id = RadioGroup1.getCheckedRadioButtonId();
                RadioButton rbc = (RadioButton) view.findViewById(id);
                String radioText = rbc.getText().toString();
                CheckBox checkJava = (CheckBox) view.findViewById(R.id.java);
                CheckBox checkPython = (CheckBox) view.findViewById(R.id.python);
                CheckBox checkJs = (CheckBox) view.findViewById(R.id.js);
                CheckBox checkgo = (CheckBox) view.findViewById(R.id.goLand);
                CheckBox checkCMas = (CheckBox) view.findViewById(R.id.cMas);
                CheckBox checkChar = (CheckBox) view.findViewById(R.id.cChar);
                List<String> lenguajes;
                if(nombre.getText().toString().equalsIgnoreCase("") || apellido.getText().toString().equalsIgnoreCase("") || nacimiento.getText().toString().equalsIgnoreCase("")){
                    AlertDialog ad = new AlertDialog.Builder(getActivity())
                            .create();
                    ad.setCancelable(false);
                    ad.setTitle("ERROR");
                    ad.setMessage("VERIFICAR SI LLENO TODA LA FORMA");
                    ad.setButton(getActivity().getString(R.string.next), new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    ad.show();
                }else if(radioText.equalsIgnoreCase("No")){
                    Bundle result = new Bundle();
                    result.putString("name",nombre.getText().toString());
                    result.putString("lastName",apellido.getText().toString());
                    result.putString("gender",genero.getSelectedItem().toString());
                    result.putString("birth",nacimiento.getText().toString());
                    result.putString("deci",radioText);
                    getParentFragmentManager().setFragmentResult("informacion",result);
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment);
                }
                else if(checkJava.isChecked() == false && checkPython.isChecked() == false && checkJs.isChecked() == false && checkgo.isChecked() == false && checkCMas.isChecked() == false && checkChar.isChecked() == false && radioText.equalsIgnoreCase("Si")){
                    AlertDialog ad = new AlertDialog.Builder(getActivity())
                            .create();
                    ad.setCancelable(false);
                    ad.setTitle("ERROR");
                    ad.setMessage("FAVOR DE SELECCIONAR AUNQUE SEA 1 LENGUAJE DE PROGRAMACION");
                    ad.setButton(getActivity().getString(R.string.next), new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    ad.show();
                }
                else{
                    lenguajes = new ArrayList<>();
                    if(checkJava.isChecked() == true)
                        lenguajes.add(checkJava.getText().toString());
                    if(checkPython.isChecked() == true)
                        lenguajes.add(checkPython.getText().toString());
                    if(checkJs.isChecked() == true)
                        lenguajes.add(checkJs.getText().toString());
                    if(checkgo.isChecked() == true)
                        lenguajes.add(checkgo.getText().toString());
                    if(checkCMas.isChecked() == true)
                        lenguajes.add(checkCMas.getText().toString());
                    if(checkChar.isChecked() == true)
                        lenguajes.add(checkChar.getText().toString());
                    String listString = String.join(", ", lenguajes);
                    Bundle result = new Bundle();
                    result.putString("name",nombre.getText().toString());
                    result.putString("lastName",apellido.getText().toString());
                    result.putString("gender",genero.getSelectedItem().toString());
                    result.putString("birth",nacimiento.getText().toString());
                    result.putString("deci",radioText);
                    result.putString("lista",listString);
                    getParentFragmentManager().setFragmentResult("informacion",result);
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment);
                }
            }
        });
        return view;
    }

}