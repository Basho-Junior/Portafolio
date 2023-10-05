package com.example.proyectofinal.ui.notification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.MainMenu;
import com.example.proyectofinal.R;

import org.jetbrains.annotations.NotNull;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    public NotificationAdapter(){

    }

    @NonNull
    @NotNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NotificationViewHolder holder, int position) {
        NotificationItem notificationItem = MainMenu.notificationItems.get(position);

        holder.lblNotificationMessage.setText("The purchase of " + notificationItem.getAmount() + " items was successful" );
        holder.lblTotal.setText(String.format("Your purchase total was: $%.2f", notificationItem.getFinalTotal()));
    }

    @Override
    public int getItemCount() {
        if(MainMenu.notificationItems != null){
            return MainMenu.notificationItems.size();
        }
        return 0;
    }


    public class NotificationViewHolder extends RecyclerView.ViewHolder{
        private final TextView lblNotificationMessage;
        private final  TextView lblTotal;

        public NotificationViewHolder(View itemView){
            super(itemView);

            this.lblNotificationMessage = itemView.findViewById(R.id.lblNotificationMessage);
            this.lblTotal = itemView.findViewById(R.id.lblPurchseTotal);
        }


    }
}
