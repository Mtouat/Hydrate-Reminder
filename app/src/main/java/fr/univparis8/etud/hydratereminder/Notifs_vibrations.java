package fr.univparis8.etud.hydratereminder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
        binding.groupeVibrations.setVisibility(View.INVISIBLE);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle SavedInstanceState){
        binding.btnOuiNotifVib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.groupeVibrations.setVisibility(View.VISIBLE);
            }
        });

        binding.btnNonNotifVib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.groupeVibrations.setVisibility(View.INVISIBLE);
            }
        });
    }
}