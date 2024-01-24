        package fr.univparis8.etud.hydratereminder;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

import fr.univparis8.etud.hydratereminder.databinding.FragmentMenuPrincipalBinding;

public class Menu_Principal extends Fragment {

    FragmentMenuPrincipalBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMenuPrincipalBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        super.onViewCreated(view, savedInstanceState);

        //permet d'aller vers changement de gourde
        binding.btnChgmtGourde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Changement_de_gourde changement_de_gourde = new Changement_de_gourde();
                fragmentTransaction.replace(R.id.fragment_container_view, changement_de_gourde);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        // permet d'aller vers le menu des notifications
        binding.btnNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Notifications_menu notifications_menu = new Notifications_menu();
                fragmentTransaction.replace(R.id.fragment_container_view, notifications_menu);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        //permet d'aller vers la page des objectifs d'hydratation
        binding.btnDefObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Objectifs_hydratation objectifsHydratation = new Objectifs_hydratation();
                fragmentTransaction.replace(R.id.fragment_container_view, objectifsHydratation);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        //permet d'aller vers la page de test arduino


        binding.iVRetourMp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

    }
}