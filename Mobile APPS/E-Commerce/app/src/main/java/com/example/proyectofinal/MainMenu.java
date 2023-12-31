package com.example.proyectofinal;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.proyectofinal.fragments.car.CarFragment;
import com.example.proyectofinal.fragments.category.AddCategoryFragment;
import com.example.proyectofinal.fragments.category.ListCategoryFragment;
import com.example.proyectofinal.fragments.category.UpdateDeleteCategoryFragment;
import com.example.proyectofinal.fragments.products.ListProductFragment;
import com.example.proyectofinal.fragments.profile.profileFragment;
import com.example.proyectofinal.helpers.FragmentHelper;
import com.example.proyectofinal.models.CarItem;
import com.example.proyectofinal.models.Product;
import com.example.proyectofinal.models.User;
import com.example.proyectofinal.ui.home.HomeFragment;
import com.example.proyectofinal.ui.notification.NotificationFragment;
import com.example.proyectofinal.ui.notification.NotificationItem;
import com.example.proyectofinal.viewmodels.UserViewModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Objects;

public class MainMenu extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ImageView view;
    private ActionBarDrawerToggle drawerToggle;
    private TextView mail;
    UserViewModel userVM;
    public static ArrayList<CarItem> productsCart;
    public static ArrayList<NotificationItem> notificationItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(navigationView);
        productsCart = new ArrayList<>();
        notificationItems = new ArrayList<>();

        drawerToggle = setupDrawerToggle();

        // Setup toggle to display hamburger icon with nice animation
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();

        // Tie DrawerLayout events to the ActionBarToggle
        drawer.addDrawerListener(drawerToggle);



        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_category, R.id.nav_product)
//                .setDrawerLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.

        return new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open,  R.string.drawer_close);

    }

    public static int productInCart(Product product){
        for(int i = 0; i < productsCart.size(); i++){
            if(productsCart.get(i).getProduct().getId() == product.getId()){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                drawer.openDrawer(GravityCompat.START);
//                return true;
//        }

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch(item.getItemId()){
            case R.id.icono_cart:
                FragmentHelper.ReplaceFragment(new CarFragment(), this);
                return true;
            case R.id.icono_notification:
                FragmentHelper.ReplaceFragment(new NotificationFragment(), this);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        User model = (User) getIntent().getSerializableExtra("Editing");
        Bundle bundle = new Bundle();
        bundle.putSerializable("edttext", model);
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.nav_home:
                fragmentClass = HomeFragment.class;
                break;

            case R.id.nav_category:
                fragmentClass = ListCategoryFragment.class;
                break;

            case R.id.nav_product:
                fragmentClass = ListProductFragment.class;
                break;
            case R.id.menu_Profile:
                fragmentClass = profileFragment.class;
                break;
            default:
                fragmentClass = HomeFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
            fragment.setArguments(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);

        // Set action bar title
        setTitle(menuItem.getTitle());

        // Close the navigation drawer
        drawer.closeDrawers();
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        User model = (User) getIntent().getSerializableExtra("Editing");
        userVM = ViewModelProviders.of(MainMenu.this).get(UserViewModel.class);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        view = findViewById(R.id.imageView);
        Bitmap bitmap = BitmapFactory.decodeByteArray(model.getPp(), 0, model.getPp().length);
        view.setImageBitmap(bitmap);
        mail = findViewById(R.id.txtMailMenu);
        mail.setText(model.getMail());
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void ChangeToAddCategoryFragment() {
        AddCategoryFragment addCategoryFragment = new AddCategoryFragment();
        FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();
        fragmentManager.replace(R.id.nav_host_fragment, addCategoryFragment, null).commit();
    }

    public void ChangeToUpdateDeleteCategoryFragment() {
        UpdateDeleteCategoryFragment updateDeleteCategoryFragment = new UpdateDeleteCategoryFragment();
        FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();
        fragmentManager.replace(R.id.nav_host_fragment, updateDeleteCategoryFragment, null).commit();
    }

    // `onPostCreate` called when activity start-up is complete after `onStart()`
    // NOTE 1: Make sure to override the method with only a single `Bundle` argument
    // Note 2: Make sure you implement the correct `onPostCreate(Bundle savedInstanceState)` method.
    // There are 2 signatures and only `onPostCreate(Bundle state)` shows the hamburger icon.
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
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