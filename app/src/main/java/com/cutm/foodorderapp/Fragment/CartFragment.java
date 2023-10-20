package com.cutm.foodorderapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cutm.foodorderapp.R;
import com.cutm.foodorderapp.adapter.CartAdapter;

import java.util.Arrays;
import java.util.List;

public class CartFragment extends Fragment {
    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView = view.findViewById(R.id.cartRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<String> cartItems = Arrays.asList(
                "Truffle Risotto", "Lobster Bisque", "Foie Gras Pâté",
                "Champagne Shrimp", "Caviar Blini", "Escargot Bourguignon",
                "Quail à l'Orange", "Coq au Vin", "Tiramisu Soufflé",
                "Peking Duck", "Oysters Rockefeller", "Champagne Sorbet",
                "Crab Ravioli", "Venison Medallions", "Truffle Macaroni",
                "Lemon Chiffon Tart", "Stuffed Portobello Mushrooms", "Lobster Thermidor",
                "Seared Ahi Tuna", "Pistachio Crème Brûlée",
                "Grilled Artichoke Hearts", "Saffron Infused Risotto",
                "Chocolate Ganache Tart", "Raspberry Mousse Cake",
                "Duck à l'Orange", "Lobster Bisque with Truffle Oil",
                "Salmon en Croûte", "Caviar and Champagne",
                "Seared Scallops with Saffron Cream",
                "Foie Gras Mousse with Fig Compote",
                "Lemon Tart with Raspberry Coulis"
        );
        List<String> cartItemPrice = Arrays.asList(
                "$30", "$40", "$45", "$50", "$55", "$60", "$65", "$70",
                "$75", "$80", "$85", "$90", "$95", "$100", "$105", "$110",
                "$115", "$120", "$125", "$130", "$135", "$140", "$145", "$150",
                "$55", "$60", "$70", "$75", "$80", "$90", "$100"
        );
        List<Integer> cartImages = Arrays.asList(
                R.drawable.truffle_risotto,
                R.drawable.lobster_bisque,
                R.drawable.foie_gras_pate,
                R.drawable.champagne_shrimp,
                R.drawable.caviar_blini,
                R.drawable.escargot_bourguignon,
                R.drawable.quail_lorange,
                R.drawable.coq_au_vin,
                R.drawable.tiramisu_souffle,
                R.drawable.peking_duck,
                R.drawable.oysters_rockefeller,
                R.drawable.champagne_sorbet,
                R.drawable.crab_ravioli,
                R.drawable.venison_medallions,
                R.drawable.truffle_macaroni,
                R.drawable.lemon_chiffon_tart,
                R.drawable.stuffedportobellomushrooms,
                R.drawable.lobster_thermidor,
                R.drawable.seared_ahi_tuna,
                R.drawable.pistachio_creme_brulee,
                R.drawable.grilled_artichoke_hearts,
                R.drawable.saffron_infused_risotto,
                R.drawable.chocolate_ganache_tart,
                R.drawable.raspberry_mousse_cake,
                R.drawable.duck_lorange,
                R.drawable.lobster_bisque_with_truffle_oil,
                R.drawable.salmon_en_croute,
                R.drawable.caviar_and_champagne,
                R.drawable.seared_scallops_with_saffron_cream,
                R.drawable.foie_gras_mousse_with_fig_compote,
                R.drawable.lemon_tart_with_raspberry_coulis
        );

        cartAdapter = new CartAdapter(cartItems, cartItemPrice, cartImages);
        recyclerView.setAdapter(cartAdapter);

        return view;
    }
}