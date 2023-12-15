package fr.univparis8.etud.hydratereminder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Objectifs_hydratation extends Fragment {


    public static Objectifs_hydratation newInstance(String param1, String param2) {
        Objectifs_hydratation fragment = new Objectifs_hydratation();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_objectifs_hydratation, container, false);
    }
}