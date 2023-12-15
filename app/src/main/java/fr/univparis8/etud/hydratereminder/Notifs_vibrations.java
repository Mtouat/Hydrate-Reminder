package fr.univparis8.etud.hydratereminder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Notifs_vibrations extends Fragment {


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
        return inflater.inflate(R.layout.fragment_notifs_vibrations, container, false);
    }
}