package com.example.tp7_users;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> _MilistaUsuarios;

    public CustomAdapter (ArrayList<String> ListaDeUsuarios, Context ContextoAusar){
        _MilistaUsuarios=ListaDeUsuarios;
        context=ContextoAusar;
    }

    @Override
    public int getCount() {
        return _MilistaUsuarios.size();
    }

    @Override
    public String getItem(int position) {
        String NombreADevolver;
        NombreADevolver=_MilistaUsuarios.get(position);
        return NombreADevolver;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View VistaActual, ViewGroup GrupoActual) {
        View VistaAdevolver;
        VistaAdevolver =null;

        LayoutInflater InfladorDeLayouts;
        InfladorDeLayouts=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        VistaAdevolver=InfladorDeLayouts.inflate(R.layout.layout_lista, GrupoActual, false);

        TextView txtNombre;
        txtNombre=(TextView)VistaAdevolver.findViewById(R.id.nombre);

        String nombrePosicionActual;
        nombrePosicionActual= getItem(position);

        txtNombre.setText(nombrePosicionActual);

        TextView txtUserName;
        txtUserName=(TextView)VistaAdevolver.findViewById(R.id.username);

        String textoUsernamePosicionActual;
        textoUsernamePosicionActual= getItem(position);

        txtUserName.setText(textoUsernamePosicionActual);

        TextView txtEmail;
        txtEmail=(TextView)VistaAdevolver.findViewById(R.id.email);

        String emailPosicionActual;
        emailPosicionActual= getItem(position);

        txtEmail.setText(emailPosicionActual);

        /*ImageView imagenPoster;
        imagenPoster=(ImageView)VistaAdevolver.findViewById(R.id.imagen);

        String fotoPerfil;
        fotoPerfil=getItem(position);

        Log.d("Custom API", "Descargo la imagen");
        descargaPeliculas TareaDescargarImg=new descargaPeliculas(imagenPoster);
        TareaDescargarImg.execute(fotoPoster);*/

        //imagenPoster.setImageResource(position);

        return VistaAdevolver;
    }
}
