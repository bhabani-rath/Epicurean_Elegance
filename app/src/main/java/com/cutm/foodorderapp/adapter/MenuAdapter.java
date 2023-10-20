package com.cutm.foodorderapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cutm.foodorderapp.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private List<String> menuItems;
    private List<String> menuItemPrice;
    private List<Integer> menuImage;

    public MenuAdapter(List<String> menuItems, List<String> menuItemPrice, List<Integer> menuImage) {
        this.menuItems = menuItems;
        this.menuItemPrice = menuItemPrice;
        this.menuImage = menuImage;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView menufoodName;
        TextView menufoodPrice;
        ImageView menuImageView;

        public MenuViewHolder(View itemView) {
            super(itemView);
            menufoodName = itemView.findViewById(R.id.menufoodName);
            menufoodPrice = itemView.findViewById(R.id.menufoodPrice);
            menuImageView = itemView.findViewById(R.id.menuImageView);
        }

        public void bind(int position) {
            menufoodName.setText(menuItems.get(position));
            menufoodPrice.setText(menuItemPrice.get(position));
            menuImageView.setImageResource(menuImage.get(position));
        }
    }
}
