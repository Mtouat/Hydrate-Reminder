package fr.univparis8.etud.hydratereminder;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.john.waveview.WaveView;

import java.util.ArrayList;
import java.util.List;

import fr.univparis8.etud.hydratereminder.databinding.FragmentAccueilBinding;
/*
Nous avons utilisé les Fragment car nous nous sommes inspiré du cours d'Open Classroom qui les
 utilisait et aussi car nous trouvions ça plus simple
*/
public class Accueil extends Fragment {

    //Le binding permet de récupérer les variables présente dans le xml, il est équivalent finViewById
    private FragmentAccueilBinding binding;
    private ArrayList<Float> donnees_graph;

    public static Accueil newInstance() {
        Accueil fragment = new Accueil();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAccueilBinding.inflate(inflater,container, false);
        // Il s'agit des données traitées par le graphique
        ArrayList<BarEntry> entrees_barres = new ArrayList<>();
        this.donnees_graph = new ArrayList<>();
        this.donnees_graph.add( (float) 4.0);
        this.donnees_graph.add( (float) 1.3);
        this.donnees_graph.add( (float) 4.1);
        this.donnees_graph.add( (float) 1.8);
        this.donnees_graph.add( (float) 2.5);
        this.donnees_graph.add( (float) 3.2);
        this.donnees_graph.add( (float) 0.5);

        for (int i = 0; i<this.donnees_graph.size(); i++){
        //entrée d'une donnée convertie en barre sur le graph
            BarEntry barEntry = new BarEntry(i,this.donnees_graph.get(i));
            entrees_barres.add(barEntry);
        }

        //Paramètre de toute les barre du graph
        BarDataSet barDataSet = new BarDataSet(entrees_barres, "Consommation");

        barDataSet.setColors(Color.BLUE);
        barDataSet.setDrawValues(false);

        binding.graphSuivi.setData(new BarData(barDataSet));
        binding.graphSuivi.animateY(3000);
        binding.graphSuivi.getDescription().setText(getString(R.string.titre_graph));
        binding.graphSuivi.getDescription().setTextColor(R.color.texte_appli);



        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        //lien vers le menu principal quand on clique sur la molette des paramètre
        binding.btnParametres.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Menu_Principal menu = new Menu_Principal();
                fragmentTransaction.replace(R.id.fragment_container_view, menu);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();



            }
        });

        //lien vers la page des badges
        binding.badgeNiveauActuel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Badges badges = new Badges();
                fragmentTransaction.replace(R.id.fragment_container_view, badges);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void remplir_gourde (int niveau){

        int couleur_bleue = Color.argb(255,0,0,255);
    }
}