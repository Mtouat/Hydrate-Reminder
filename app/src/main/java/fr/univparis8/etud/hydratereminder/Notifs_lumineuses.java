package fr.univparis8.etud.hydratereminder;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

        binding.btnNonNotifLum.setStrokeWidth(10);
        binding.btnNonNotifLum.setStrokeColorResource(R.color.texte_appli);

        binding.groupeCouleurs.setVisibility(View.INVISIBLE);
        binding.choixCouleur.setVisibility(View.INVISIBLE);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        binding.btnOuiNotifLum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.btnNonNotifLum.setStrokeWidth(0);
                binding.btnOuiNotifLum.setStrokeWidth(10);
                binding.btnOuiNotifLum.setStrokeColorResource(R.color.texte_appli);

                binding.groupeCouleurs.setVisibility(View.VISIBLE);
                binding.choixCouleur.setVisibility(View.VISIBLE);
            }
        });

        binding.btnNonNotifLum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.btnOuiNotifLum.setStrokeWidth(0);
                binding.btnNonNotifLum.setStrokeWidth(10);
                binding.btnNonNotifLum.setStrokeColorResource(R.color.texte_appli);

                binding.groupeCouleurs.setVisibility(View.INVISIBLE);
                binding.choixCouleur.setVisibility(View.INVISIBLE);
            }
        });

        binding.btnValiderNotifLum.setOnClickListener(new View.OnClickListener() {
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

        binding.iVRetourNl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

        binding.btnBleu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tVCouleurChoisie.setText(binding.btnBleu.getText());
                binding.tVCouleurChoisie.setTextColor(binding.btnBleu.getTextColors());
                binding.tVCouleurChoisie.setBackgroundColor(Color.TRANSPARENT);

            }
        });

        binding.btnOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tVCouleurChoisie.setText(binding.btnOrange.getText());
                binding.tVCouleurChoisie.setTextColor(binding.btnOrange.getTextColors());
                binding.tVCouleurChoisie.setBackgroundColor(Color.TRANSPARENT);


            }
        });

        binding.btnVert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tVCouleurChoisie.setText(binding.btnVert.getText());
                binding.tVCouleurChoisie.setTextColor(binding.btnVert.getTextColors());
                binding.tVCouleurChoisie.setBackgroundColor(Color.TRANSPARENT);

            }
        });

        binding.btnRouge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tVCouleurChoisie.setText(binding.btnRouge.getText());
                binding.tVCouleurChoisie.setTextColor(binding.btnRouge.getTextColors());
                binding.tVCouleurChoisie.setBackgroundColor(Color.TRANSPARENT);

            }
        });

        binding.btnViolet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tVCouleurChoisie.setText(binding.btnViolet.getText());
                binding.tVCouleurChoisie.setTextColor(binding.btnViolet.getTextColors());
                binding.tVCouleurChoisie.setBackgroundColor(Color.TRANSPARENT);
            }
        });

        binding.btnJaune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tVCouleurChoisie.setText(binding.btnJaune.getText());
                binding.tVCouleurChoisie.setTextColor(binding.btnJaune.getTextColors());
                binding.tVCouleurChoisie.setBackgroundColor(Color.BLACK);
            }
        });
    }

}