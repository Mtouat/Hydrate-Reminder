package fr.univparis8.etud.hydratereminder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Notifs_sonores extends Fragment {


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

        return inflater.inflate(R.layout.fragment_notifs_sonores, container, false);
    }
}