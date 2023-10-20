package com.cutm.foodorderapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cutm.foodorderapp.R;
import com.cutm.foodorderapp.adapter.MenuAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFragment extends Fragment {

    private RecyclerView recyclerViewMenu;
    private MenuAdapter adapter;
    private List<String> originalMenuFoodName;
    private List<String> originalFoodItemPrice;
    private List<Integer> originalMenuImage;
    private List<String> filteredMenuFoodName;
    private List<String> filteredMenuItemPrice;
    private List<Integer> filteredMenuImages;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerViewMenu = view.findViewById(R.id.recyclerView_Menu);

        originalMenuFoodName = Arrays.asList( "Truffle Risotto", "Lobster Bisque", "Foie Gras Pâté",
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
                "Lemon Tart with Raspberry Coulis");
        originalFoodItemPrice = Arrays.asList("$30", "$40", "$45", "$50", "$55", "$60", "$65", "$70",
                "$75", "$80", "$85", "$90", "$95", "$100", "$105", "$110",
                "$115", "$120", "$125", "$130", "$135", "$140", "$145", "$150",
                "$55", "$60", "$70", "$75", "$80", "$90", "$100");
        originalMenuImage = Arrays.asList(R.drawable.truffle_risotto,
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
                R.drawable.lemon_tart_with_raspberry_coulis);

        filteredMenuFoodName = new ArrayList<>(originalMenuFoodName);
        filteredMenuItemPrice = new ArrayList<>(originalFoodItemPrice);
        filteredMenuImages = new ArrayList<>(originalMenuImage);

        adapter = new MenuAdapter(filteredMenuFoodName, filteredMenuItemPrice, filteredMenuImages);
        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerViewMenu.setAdapter(adapter);

        SearchView searchView = view.findViewById(R.id.searchView_searchfragment);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterMenuItems(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterMenuItems(newText);
                return true;
            }
        });

        return view;
    }

    private void showAllMenu() {
        filteredMenuFoodName.clear();
        filteredMenuItemPrice.clear();
        filteredMenuImages.clear();
        filteredMenuFoodName.addAll(originalMenuFoodName);
        filteredMenuItemPrice.addAll(originalFoodItemPrice);
        filteredMenuImages.addAll(originalMenuImage);
        adapter.notifyDataSetChanged();
    }

    private void filterMenuItems(String query) {
        filteredMenuFoodName.clear();
        filteredMenuItemPrice.clear();
        filteredMenuImages.clear();
        String lowerCaseQuery = query.toLowerCase(); // Convert the query to lowercase

        for (int i = 0; i < originalMenuFoodName.size(); i++) {
            String foodName = originalMenuFoodName.get(i);
            if (foodName.toLowerCase().contains(lowerCaseQuery)) {
                filteredMenuFoodName.add(originalMenuFoodName.get(i));
                filteredMenuItemPrice.add(originalFoodItemPrice.get(i));
                filteredMenuImages.add(originalMenuImage.get(i));
            }
        }

        adapter.notifyDataSetChanged();
    }
}

