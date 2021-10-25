package com.example.tp7_users;

import java.util.ArrayList;

public class Usuario {
    public ArrayList<String> ObtenerTodas(String nombreUsuario, String userName, String email) {
        ArrayList<String> arrListaUsuarios;
        arrListaUsuarios = new ArrayList<>();

        arrListaUsuarios.add(nombreUsuario);
        arrListaUsuarios.add(userName);
        arrListaUsuarios.add(email);

        return arrListaUsuarios;
    }
}
