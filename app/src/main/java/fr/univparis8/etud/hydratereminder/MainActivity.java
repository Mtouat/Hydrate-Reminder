package fr.univparis8.etud.hydratereminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.util.Log;
import android.widget.Toast;

import android.content.pm.PackageManager;
import android.os.Bundle;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendData(String message){


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Connect to the ESP32's IP address and port
                    Log.d("Sending Data", "Button Pressed, connecting to ESP32.....");
                    Socket socket = new Socket("192.168.4.1", 80);
                    PrintWriter out = new PrintWriter(socket.getOutputStream());

                    // Send the data
                    out.println(message);
                    out.flush();
                    Log.d("Sending Data", "Data Sent!");

                    // Close the connection
                    out.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("Sending Data", "Error Sending Data: "+e.getMessage());
                }
            }
        }).start();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, you can perform the network operation here
                Log.d("Permission", "Granted");
            } else {
                // Permission denied, show a message to the user
                Log.d("Permission", "Denied");
                Toast.makeText(this, "Permission denied, you cannot perform network operations", Toast.LENGTH_SHORT).show();
            }
        }

    }
}