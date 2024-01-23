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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import fr.univparis8.etud.hydratereminder.databinding.FragmentNotifsVibrationsBinding;

public class Notifs_vibrations extends Fragment {

    private FragmentNotifsVibrationsBinding binding;
    private boolean vibration = false;
    private String mode_vibration = "";
    private String instruction = "";
    private String filename = this.getClass().getSimpleName();
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

                vibration = true;

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

                vibration = false;

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

                int RadioID = binding.groupeVibrations.getCheckedRadioButtonId();

                if (RadioID==binding.rBFaible.getId()) {
                    mode_vibration = "1" + binding.rBFaible.getText();
                    instruction = "" + binding.rBFaible.getText();
                } else if (RadioID==binding.rBMoyen.getId()) {
                    mode_vibration = "1" + binding.rBMoyen.getText();
                    instruction = "" + binding.rBMoyen.getText();
                } else if (RadioID==binding.rBFort.getId()) {
                    mode_vibration = "1" + binding.rBFort.getText();
                    instruction = "" + binding.rBFort.getText();
                }

                if (vibration) {
                    ((MainActivity) getActivity()).AddData(filename, mode_vibration);
                    ((MainActivity) getActivity()).sendData(instruction);

                } else {
                    mode_vibration="0";
                    ((MainActivity) getActivity()).AddData(filename, mode_vibration);

                }
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