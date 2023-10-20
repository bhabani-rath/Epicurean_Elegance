package com.cutm.foodorderapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cutm.foodorderapp.MenuBottomSheetFragment;
import com.cutm.foodorderapp.R;
import com.cutm.foodorderapp.adapter.PopularAdapter;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {
    ImageSlider imageSlider;
    RecyclerView recyclerView;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider = view.findViewById(R.id.image_slider);
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));
        imageSlider.setImageList(imageList, ScaleTypes.FIT);
        // Set up the Popular RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);

        List<String> foodName = Arrays.asList(
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
        List<String> price = Arrays.asList(
                "$30", "$40", "$45", "$50", "$55", "$60", "$65", "$70",
                "$75", "$80", "$85", "$90", "$95", "$100", "$105", "$110",
                "$115", "$120", "$125", "$130", "$135", "$140", "$145", "$150",
                "$55", "$60", "$70", "$75", "$80", "$90", "$100"
        );
        List<Integer> populerFoodImages = Arrays.asList(
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

        PopularAdapter adapter = new PopularAdapter(foodName, price, populerFoodImages);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);
        textView = view.findViewById(R.id.textView16);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuBottomSheetFragment bottomSheetDialog = new MenuBottomSheetFragment();
                bottomSheetDialog.show(getParentFragmentManager(), "Test");
            }
        });
        return view;
        }

    }