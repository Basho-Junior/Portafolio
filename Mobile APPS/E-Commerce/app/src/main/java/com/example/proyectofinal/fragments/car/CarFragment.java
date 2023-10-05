package com.example.proyectofinal.fragments.car;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.MainMenu;
import com.example.proyectofinal.R;
import com.example.proyectofinal.adapters.CarAdapter;
import com.example.proyectofinal.connection.CarItemInterface;
import com.example.proyectofinal.fragments.products.ListProductFragment;
import com.example.proyectofinal.helpers.FragmentHelper;
import com.example.proyectofinal.models.CarItem;
import com.example.proyectofinal.models.Product;
import com.example.proyectofinal.ui.notification.NotificationItem;
import com.example.proyectofinal.viewmodels.ProductViewModel;
import com.example.proyectofinal.viewmodels.UserViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarFragment extends Fragment implements CarItemInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static final String CHANNEL_ID = "channel 1";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CarFragment newInstance(String param1, String param2) {
        CarFragment fragment = new CarFragment();
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
        View view = inflater.inflate(R.layout.fragment_car, container, false);



        //List<CarItem> carItems = new ArrayList<>();
        //Category category = new Category(1, "Bebidas", null);
        //Product first_product = new Product(1, "Grappa con limon", "Esta es la real grappa", 100, category);
        //Manager.getInstance(getContext()).getCarItems().add(new CarItem(first_product, 20));
        //System.out.println("Los itemes del carrito de compra: " + Manager.getInstance(getContext()).getCarItems().size());
        //carItems.add();

        double totalPrice = 0;
        int quantity = 0;

        for(CarItem carItem : MainMenu.productsCart){
            totalPrice += (carItem.getProduct().getPrice() * carItem.getQuantity());
            quantity += carItem.getQuantity();
        }


        //Si confirmo la compra, elimino todos los elementos que se encuentran actualmente en el carrito.
        Button checkoutButton = view.findViewById(R.id.checkoutButton);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext())
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Realizar compra")
                        .setMessage("Esta seguro que desea realizar esta compra?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sendNotification(getContext());
                                NotificationItem notificationItem = new NotificationItem(MainMenu.productsCart);
                                //System.out.println(notificationItem.getAmount());
                                MainMenu.productsCart = new ArrayList<>();
                                MainMenu.notificationItems.add(notificationItem);
                                FragmentHelper.AddFragment(new ListProductFragment(), getActivity());
                            }

                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });

        TextView carInfoText = view.findViewById(R.id.carInfoText);
        carInfoText.setText("Sub total (" + Integer.toString(quantity) + " items): " + Double.toString(totalPrice));

        RecyclerView recyclerView = view.findViewById(R.id.carRecyclerView);
        CarAdapter carAdapter = new CarAdapter(this.getContext(), MainMenu.productsCart, carInfoText, getActivity());
        recyclerView.setAdapter(carAdapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        return view;
    }

    private void sendNotification(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Congratz!")
                .setContentText("Your purchase has been successful!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setAutoCancel(true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(1, builder.build());
    }

    @Override
    public void onClickIncrement(int position) {

    }

    @Override
    public void onClickDecrement(int position) {

    }

    @Override
    public void onClickDelete(int position) {

    }
}