package fr.univparis8.etud.hydratereminder;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Tests_arduino extends Fragment {


    public Tests_arduino() {
    }


    public static Tests_arduino newInstance() {
        Tests_arduino fragment = new Tests_arduino();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        BluetoothAdapter btnConnection = BluetoothAdapter.getDefaultAdapter();
        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        System.out.println(btnConnection.getBondedDevices());

        BluetoothDevice sp32 = btnConnection.getRemoteDevice("0c:8b:95:96:c1:b0");
        System.out.println(sp32.getName());

       
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_tests_arduino, container, false);
    }
}