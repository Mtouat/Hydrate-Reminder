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
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import fr.univparis8.etud.hydratereminder.databinding.FragmentRecalibrage2Binding;


public class Recalibrage2 extends Fragment {

    FragmentRecalibrage2Binding binding;

    public static Recalibrage2 newInstance() {
        Recalibrage2 fragment = new Recalibrage2();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecalibrage2Binding.inflate(inflater, container, false);
        return binding.getRoot();
        
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        // quand on appuie sur "valider", on est renvoyé vers l'accueil
        binding.btnValider.setOnClickListener(new View.OnClickListener() {
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
        binding.iVRetourR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

    /*    Spinner spinner = (Spinner) binding.listeLGourde;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                binding.,
                 android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner.
        spinner.setAdapter(adapter);
    }*/
    }
}