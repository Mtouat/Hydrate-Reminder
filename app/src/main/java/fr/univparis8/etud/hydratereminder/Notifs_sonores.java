package fr.univparis8.etud.hydratereminder;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.univparis8.etud.hydratereminder.databinding.FragmentNotifsSonoresBinding;

public class Notifs_sonores extends Fragment {

    MediaPlayer mediaPlayer1;
    MediaPlayer mediaPlayer2;
    MediaPlayer mediaPlayer3;

    private String mode_sonnerie="";
    private String instruction = "";
    private boolean sonnerie = false;

    FragmentNotifsSonoresBinding binding;
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

        binding = FragmentNotifsSonoresBinding.inflate(inflater, container, false);

        binding.groupeAudios.setVisibility(View.INVISIBLE);

        binding.btnNonNotifSon.setStrokeWidth(10);
        binding.btnNonNotifSon.setStrokeColorResource(R.color.texte_appli);

        //on lie les chansons aux variables
        this.mediaPlayer1 = MediaPlayer.create(getContext(), R.raw.warriors);
        this.mediaPlayer2 = MediaPlayer.create(getContext(), R.raw.jinglebellrock);
        this.mediaPlayer3 = MediaPlayer.create(getContext(), R.raw.sonneriesamsung);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle SavedInstanceState){
        binding.btnOuiNotifSon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sonnerie = true;
                binding.btnNonNotifSon.setStrokeWidth(0);
                binding.btnOuiNotifSon.setStrokeWidth(10);
                binding.btnOuiNotifSon.setStrokeColorResource(R.color.texte_appli);

               binding.groupeAudios.setVisibility(View.VISIBLE);

            }
        });

        // Si on appuie sur "non", les boutons deviennent invisible et la musique s'arrete
        binding.btnNonNotifSon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sonnerie = false;
                mode_sonnerie = "0";

                binding.btnOuiNotifSon.setStrokeWidth(0);
                binding.btnNonNotifSon.setStrokeWidth(10);
                binding.btnNonNotifSon.setStrokeColorResource(R.color.texte_appli);

                binding.groupeAudios.setVisibility(View.INVISIBLE);

                if(mediaPlayer1.isPlaying()){
                    mediaPlayer1.pause();
                    mediaPlayer1.seekTo(0);
                }
                
                if(mediaPlayer2.isPlaying()){
                    mediaPlayer2.pause();
                    mediaPlayer2.seekTo(0);
                }

                if(mediaPlayer3.isPlaying()){
                    mediaPlayer3.pause();
                    mediaPlayer3.seekTo(0);
                }

            }
        });

        //Si on appuie sur "valider", on revient vers l'accueil et la musique s'arrete
        binding.btnValiderNotifsSons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sonnerie) {
                    int RadioID = binding.groupeAudios.getCheckedRadioButtonId();

                    if (RadioID == binding.rBAudio1.getId()) {
                        mode_sonnerie = "1" + binding.rBAudio1.getText();
                        instruction = "" + binding.rBAudio1.getText();
                    } else if (RadioID == binding.rBAudio2.getId()) {
                        mode_sonnerie = "1" + binding.rBAudio2.getText();
                        instruction = "" + binding.rBAudio2.getText();
                    } else if (RadioID == binding.rBAudio3.getId()) {
                        mode_sonnerie = "1" + binding.rBAudio3.getText();
                        instruction = "" + binding.rBAudio3.getText();
                    }

                    ((MainActivity) getActivity()).sendData(instruction);
                }

                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Accueil accueil = new Accueil();
                fragmentTransaction.replace(R.id.fragment_container_view, accueil);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                /*mediaPlayer1.stop();
                mediaPlayer2.stop();
                mediaPlayer3.stop();*/


            }
        });

        //Si on appuie sur la croix, on revient sur la dernière page et la musique s'arrete
        binding.ivRetourNs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().popBackStackImmediate();

                /*mediaPlayer1.stop();
                mediaPlayer2.stop();
                mediaPlayer3.stop();*/
            }
        });

        //Si on appuis sur la première image, le media se lance et les autres se mettent sur pause s'ils ont été lancé
    /*    binding.iVNotifSon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer2.isPlaying()){
                    mediaPlayer2.pause();
                    mediaPlayer2.seekTo(0);
                }

                if(mediaPlayer3.isPlaying()){
                    mediaPlayer3.pause();
                    mediaPlayer3.seekTo(0);
                }

                mediaPlayer1.start();
            }


        });
        instruction = ""+binding.rBAudio1.getText();
        instruction = ""+binding.rBAudio2.getText();
        instruction = ""+binding.rBAudio3.getText();


        //Si on appuis sur la deuxième image, le media se lance et les autres se mettent sur pause s'ils ont été lancé
        binding.iVNotifSon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer1.isPlaying()){
                    mediaPlayer1.pause();
                    mediaPlayer1.seekTo(0);
                }
                if(mediaPlayer3.isPlaying()){
                    mediaPlayer3.pause();
                    mediaPlayer3.seekTo(0);
                }
                mediaPlayer2.start();
            }
        });

        //Si on appuis sur la troisième image, le media se lance et les autres se mettent sur pause s'ils ont été lancé
        binding.iVNotifSon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer1.isPlaying()){
                    mediaPlayer1.pause();
                    mediaPlayer1.seekTo(0);
                }

                if(mediaPlayer2.isPlaying()){
                    mediaPlayer2.pause();
                    mediaPlayer2.seekTo(0);
                }

                mediaPlayer3.start();
            }
        }); */
    }
}