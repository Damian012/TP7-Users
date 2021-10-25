package com.example.tp7_users;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    FragmentManager adminFragments;
    FragmentTransaction transcFragments;
    ArrayList<String> arrListaUsuarios;
    ListView milista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adminFragments = getFragmentManager();

        fragmentPrincipal frgIngreso;
        frgIngreso = new fragmentPrincipal();

        transcFragments = adminFragments.beginTransaction();
        transcFragments.replace(R.id.alojadorDeFragments, frgIngreso);
        transcFragments.commit();

        Log.d("onCreate", "Instancio la clase Pelicula ");
        Usuario Mispeliculas;
        Mispeliculas = new Usuario();

        Log.d("onCreate", "Lleno mi arraylist ");

        milista = findViewById(R.id.listaUsuarios);

        CustomAdapter miAdaptador;
        miAdaptador = new CustomAdapter(arrListaUsuarios, this);

        milista.setAdapter(miAdaptador);
    }

    public void EnviarDatos(String nombreUsuario, String userName, String email) {
        Log.d("ActividadPrincipal", "Se recibio:" +nombreUsuario+userName+email);
        Usuario Mispeliculas;
        Mispeliculas = new Usuario();
        arrListaUsuarios = Mispeliculas.ObtenerTodas(nombreUsuario, userName, email);
    }
}