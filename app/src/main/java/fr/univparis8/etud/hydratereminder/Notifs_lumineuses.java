package fr.univparis8.etud.hydratereminder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.univparis8.etud.hydratereminder.databinding.FragmentNotifsLumineusesBinding;

public class Notifs_lumineuses extends Fragment {

    FragmentNotifsLumineusesBinding binding;
    public static Notifs_lumineuses newInstance() {
        Notifs_lumineuses fragment = new Notifs_lumineuses();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotifsLumineusesBinding.inflate(inflater, container, false);
        binding.groupeCouleurs.setVisibility(View.INVISIBLE);
        binding.couleurChoisie.setVisibility(View.INVISIBLE);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        binding.btnOuiNotifLum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.groupeCouleurs.setVisibility(View.VISIBLE);
                binding.couleurChoisie.setVisibility(View.VISIBLE);
            }
        });

        binding.btnNonNotifLum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.groupeCouleurs.setVisibility(View.INVISIBLE);
                binding.couleurChoisie.setVisibility(View.INVISIBLE);
            }
        });
    }

}