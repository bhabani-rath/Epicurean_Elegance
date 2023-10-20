package com.cutm.foodorderapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cutm.foodorderapp.R;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private List<String> history_foodname;
    private List<String> history_foodprice;
    private List<Integer> history_foodImages;
    private Context context;

    public HistoryAdapter(Context context, List<String> history_foodname, List<String> history_foodprice, List<Integer> history_foodImages) {
        this.context = context;
        this.history_foodname = history_foodname;
        this.history_foodprice = history_foodprice;
        this.history_foodImages = history_foodImages;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.foodnameHistory.setText(history_foodname.get(position));
        holder.foodpriceHistory.setText(history_foodprice.get(position));
        holder.foodImageHistory.setImageResource(history_foodImages.get(position));
    }

    @Override
    public int getItemCount() {
        return history_foodname.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {

        private TextView foodnameHistory;
        private TextView foodpriceHistory;
        private ImageView foodImageHistory;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            foodnameHistory = itemView.findViewById(R.id.foodname_history);
            foodpriceHistory = itemView.findViewById(R.id.foodprice_history);
            foodImageHistory = itemView.findViewById(R.id.foodImage_history);
        }
    }
}
