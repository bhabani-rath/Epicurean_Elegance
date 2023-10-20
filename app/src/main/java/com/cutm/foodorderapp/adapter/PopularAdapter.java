package com.cutm.foodorderapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.cutm.foodorderapp.databinding.PopularItemBinding;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {
    private final List<String> items;
    private final List<String> price;
    private final List<Integer> image;

    public PopularAdapter(List<String> items, List<String> price, List<Integer> image) {
        this.items = items;
        this.price = price;
        this.image = image;
    }

    @Override
    public PopularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(PopularViewHolder holder, int position) {
        String item = items.get(position);
        String itemPrice = price.get(position);
        int itemImage = image.get(position);
        holder.bind(item, itemPrice, itemImage);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder {
        private final PopularItemBinding binding;
        private final ImageView imageView;

        public PopularViewHolder(PopularItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            imageView = binding.foodImageView;
        }

        public void bind(String item, String price, int imageResource) {
            binding.foodName.setText(item);
            binding.foodPrice.setText(price);
            imageView.setImageResource(imageResource);
        }
    }
}
