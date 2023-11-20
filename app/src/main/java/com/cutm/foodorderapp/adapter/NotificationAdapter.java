package com.cutm.foodorderapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cutm.foodorderapp.R;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    List<String> notification;
    List<Integer> notificationImage;

    public NotificationAdapter(List<String> notification, List<Integer> notificationImage) {
        this.notification = notification;
        this.notificationImage = notificationImage;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        holder.notificationTextView.setText(notification.get(position));
        holder.notificationImageView.setImageResource(notificationImage.get(position));
    }

    @Override
    public int getItemCount() {
        return notification.size();
    }

    public static class NotificationViewHolder extends RecyclerView.ViewHolder {
        TextView notificationTextView;
        ImageView notificationImageView;

        public NotificationViewHolder(View itemView) {
            super(itemView);
            notificationTextView = itemView.findViewById(R.id.notificationtextView);
            notificationImageView = itemView.findViewById(R.id.notificationImageView);
        }
    }
}
