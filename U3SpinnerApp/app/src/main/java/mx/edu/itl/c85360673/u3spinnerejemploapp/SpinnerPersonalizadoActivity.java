package mx.edu.itl.c85360673.u3spinnerejemploapp;

import androidx.appcompat.app.AppCompatActivity;
import modelo.Club;
import modelo.SpinnerClubesAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SpinnerPersonalizadoActivity extends AppCompatActivity {

    private Spinner spnClubes;
    private ArrayList<Club> clubes;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_personalizado);

        spnClubes = findViewById ( R.id.spnClubes );

        // Inicializar el ArrayList de clubes
        inicializarClubes ();

        // Crear el adapter del tipo SpinnerClubesAdapter y establecer el layout con  setDropDownViewResource ()
        SpinnerClubesAdapter adaptador = new SpinnerClubesAdapter( this, clubes);
        adaptador.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spnClubes.setAdapter( adaptador );

        // Establecer el adaptador para el spinner

    }

    //----------------------------------------------------------------------------------------------

    private void inicializarClubes () {
        clubes = new ArrayList<> ( );
        clubes.add( new Club ("Squat", R.drawable.squat));
        clubes.add( new Club ("Deadlift", R.drawable.deadlift));
        clubes.add( new Club ("Legpress", R.drawable.legpress));
        clubes.add( new Club ("Bulgarian Squat", R.drawable.bulgariansquat));
        clubes.add( new Club ("Leg Extension", R.drawable.legextension));
    }

    //----------------------------------------------------------------------------------------------

    public void btnAceptarClick ( View w ) {
        // Recuperar el elemento seleccionado del Spinner y mostrar el nombre del club en un Toast
        Club club = (Club) spnClubes.getSelectedItem();
        Toast.makeText(this, "Ejercicio seleccionado: " + club.getNombre(), Toast.LENGTH_SHORT).show();
    }

    //----------------------------------------------------------------------------------------------
}