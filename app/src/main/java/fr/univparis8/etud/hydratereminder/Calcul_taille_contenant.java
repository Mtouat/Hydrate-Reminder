package fr.univparis8.etud.hydratereminder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Calcul_taille_contenant extends Fragment {

    public static Calcul_taille_contenant newInstance() {
        Calcul_taille_contenant fragment = new Calcul_taille_contenant();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calcul_taille_contenant, container, false);
    }
}