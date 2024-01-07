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

import fr.univparis8.etud.hydratereminder.databinding.FragmentNotifsVibrationsBinding;

public class Notifs_vibrations extends Fragment {

    private FragmentNotifsVibrationsBinding binding;
    public static Notifs_vibrations newInstance() {
        Notifs_vibrations fragment = new Notifs_vibrations();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentNotifsVibrationsBinding.inflate(inflater, container, false);
        // quand on arrive sur la page on ne voit pas le groupe de bouton
        binding.groupeVibrations.setVisibility(View.INVISIBLE);

        binding.btnNonNotifVib.setStrokeWidth(10);
        binding.btnNonNotifVib.setStrokeColorResource(R.color.texte_appli);

        return binding.getRoot();
    }

    //si on clique sur "oui", ils apparaissent
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle SavedInstanceState){
        binding.btnOuiNotifVib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.btnNonNotifVib.setStrokeWidth(0);
                binding.btnOuiNotifVib.setStrokeWidth(10);
                binding.btnOuiNotifVib.setStrokeColorResource(R.color.texte_appli);

                binding.groupeVibrations.setVisibility(View.VISIBLE);
            }
        });

        //si on appuie sur "non", ils disparraissent
        binding.btnNonNotifVib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.btnOuiNotifVib.setStrokeWidth(0);
                binding.btnNonNotifVib.setStrokeWidth(10);
                binding.btnNonNotifVib.setStrokeColorResource(R.color.texte_appli);

                binding.groupeVibrations.setVisibility(View.INVISIBLE);
            }
        });

        // quand on appuie sur "valider", on est renvoyé vers l'accueil
        binding.btnValiderNotifVib.setOnClickListener(new View.OnClickListener() {
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

        //en appuyant sur la croix on revient à la page précédente
        binding.iVRetourNv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });
    }

}