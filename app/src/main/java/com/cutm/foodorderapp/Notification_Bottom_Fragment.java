package com.cutm.foodorderapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cutm.foodorderapp.adapter.NotificationAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class Notification_Bottom_Fragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification__bottom_, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.notificationRecyclerView);
        List<String> notifications = new ArrayList<>();
        notifications.add("Your Order has been Canceled Successfully");
        notifications.add("Order has been taken by the driver");
        notifications.add("Congrats your order has been placed");
        List<Integer> notificationImages = new ArrayList<>();
        notificationImages.add(R.drawable.sademoji);
        notificationImages.add(R.drawable.truck);
        notificationImages.add(R.drawable.congrats);

        NotificationAdapter adapter = new NotificationAdapter(notifications, notificationImages);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }
}
