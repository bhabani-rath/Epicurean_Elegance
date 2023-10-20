package com.cutm.foodorderapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.cutm.foodorderapp.R; // Make sure to replace with the correct R import for your project
import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<String> cartItems;
    private List<String> cartItemPrice;
    private List<Integer> CartImage;
    private int[] itemQuantities;

    public CartAdapter(List<String> cartItems, List<String> cartItemPrice, List<Integer> CartImage) {
        this.cartItems = cartItems;
        this.cartItemPrice = cartItemPrice;
        this.CartImage = CartImage;
        this.itemQuantities = new int[cartItems.size()];
        for (int i = 0; i < cartItems.size(); i++) {
            itemQuantities[i] = 1;
        }
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {

        private TextView foodNameCart;
        private TextView foodPriceCart;
        private ImageView cartImages;
        private TextView cartItemQuantity;
        private ImageView trash;
        private ImageView addButton;
        private ImageView subsButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            foodNameCart = itemView.findViewById(R.id.foodName_cart);
            foodPriceCart = itemView.findViewById(R.id.foodPrice_cart);
            cartImages = itemView.findViewById(R.id.cartImages);
            cartItemQuantity = itemView.findViewById(R.id.cartItemQuantity);
            trash = itemView.findViewById(R.id.trash);
            addButton = itemView.findViewById(R.id.addButton);
            subsButton = itemView.findViewById(R.id.subsButton);
        }

        public void bind(int position) {
            int quantity = itemQuantities[position];

            foodNameCart.setText(cartItems.get(position));
            foodPriceCart.setText(cartItemPrice.get(position));
            cartImages.setImageResource(CartImage.get(position));
            cartItemQuantity.setText(String.valueOf(quantity));

            // Delete Button Click Listener
            trash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deleteItem(getAdapterPosition());
                }
            });

            // Increase Button Click Listener
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    increaseQuantity(getAdapterPosition());
                }
            });

            // Decrease Button Click Listener
            subsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    decreaseQuantity(getAdapterPosition());
                }
            });
        }

        private void decreaseQuantity(int position) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--;
                cartItemQuantity.setText(String.valueOf(itemQuantities[position]));
            }
        }

        private void increaseQuantity(int position) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++;
                cartItemQuantity.setText(String.valueOf(itemQuantities[position]));
            }
        }

        private void deleteItem(int position) {
            List<String> mutableCartItems = new ArrayList<>(cartItems);
            List<String> mutableCartItemPrice = new ArrayList<>(cartItemPrice);
            List<Integer> mutableCartImage = new ArrayList<>(CartImage);

            mutableCartItems.remove(position);
            mutableCartItemPrice.remove(position);
            mutableCartImage.remove(position);

            cartItems = mutableCartItems;
            cartItemPrice = mutableCartItemPrice;
            CartImage = mutableCartImage;

            notifyItemRemoved(position);
            notifyItemRangeChanged(position, cartItems.size());
        }
    }
}
