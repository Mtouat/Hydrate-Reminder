package fr.univparis8.etud.hydratereminder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.univparis8.etud.hydratereminder.databinding.FragmentNotifsSonoresBinding;

public class Notifs_sonores extends Fragment {

    FragmentNotifsSonoresBinding binding;
    public static Notifs_sonores newInstance() {
        Notifs_sonores fragment = new Notifs_sonores();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotifsSonoresBinding.inflate(inflater, container, false);
        binding.groupeSons.setVisibility(View.INVISIBLE);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle SavedInstanceState){
        binding.btnOuiNotifVib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.groupeSons.setVisibility(View.VISIBLE);
            }
        });

        binding.btnNonNotifVib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.groupeSons.setVisibility(View.INVISIBLE);
            }
        });

        binding.btnValiderNotifsSons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Accueil accueil = new Accueil();
                fragmentTransaction.replace(R.id.fragment_container_view, accueil);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}