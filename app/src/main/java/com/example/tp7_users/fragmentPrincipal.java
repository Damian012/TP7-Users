package com.example.tp7_users;

        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;

        import android.app.Fragment;

        import com.google.gson.JsonArray;
        import com.google.gson.JsonObject;
        import com.google.gson.JsonParser;

        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;

public class fragmentPrincipal extends Fragment {
    String nombreUsuario;
    String username;
    String email;

    public View onCreateView(LayoutInflater infladorDeLayout, ViewGroup GrupoDeLaVista, Bundle datosRecibidos){
        View VistaADevolver;

        VistaADevolver=infladorDeLayout.inflate(R.layout.layout_principal, GrupoDeLaVista, false);

        tareaAsincronica miTarea=new tareaAsincronica();
        miTarea.execute();

        mostrar();

        return VistaADevolver;
    }

    private class tareaAsincronica extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids){
            try{
                URL miRuta;
                miRuta=new URL("https://jsonplaceholder.typicode.com/users/");
                HttpURLConnection miConexion=(HttpURLConnection) miRuta.openConnection();

                Log.d("Acceso APi", "Conexion OK");
                if(miConexion.getResponseCode()==200){
                    InputStream cuerpoRespuesta=miConexion.getInputStream();
                    InputStreamReader lectoRespuesta=new InputStreamReader(cuerpoRespuesta, "UTF-8");

                    Log.d("Acceso APi", "Me conecte ok");

                    procesarJson(lectoRespuesta);
                }
                else {
                    Log.d("Acceso API", "Error en la conexion");
                }
                miConexion.disconnect();
            } catch(Exception Error){
                Log.d("Acceso API","Hubo un error al conectarme "+Error.getMessage());

            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid){
            super.onPostExecute(aVoid);
            MainActivity miActivityAnfitriona;
            miActivityAnfitriona=(MainActivity)getActivity();
            miActivityAnfitriona.EnviarDatos(nombreUsuario, username, email);
        }
    }

    private void procesarJson(InputStreamReader lectoRespuesta) {
        JsonParser parseadorDeJson;
        parseadorDeJson = new JsonParser();

        JsonObject objetoJsonCrudo;
        objetoJsonCrudo = parseadorDeJson.parse(lectoRespuesta).getAsJsonObject();

        try {
            JsonArray arrUsuarios;
            arrUsuarios = objetoJsonCrudo.getAsJsonArray();

            for (int posicion = 0; posicion < arrUsuarios.size(); posicion++) {
                JsonObject objetoCadaUsuario;
                objetoCadaUsuario = arrUsuarios.get(posicion).getAsJsonObject();

                Log.d("Acceso API", "Estoy procesanso el array");

                String nombre;
                nombre = objetoCadaUsuario.get("name").getAsString();
                nombreUsuario = nombre;

                String userName;
                userName = objetoCadaUsuario.get("username").getAsString();
                username = userName;

                String correo;
                correo = objetoCadaUsuario.get("email").getAsString();
                email = correo;
                Log.d("Acceso API", "Nombre de usuario: "+nombreUsuario);
                Log.d("Acceso API", "Username: "+username);
                Log.d("Acceso API", "Email: "+email);

                Log.d("Acceso API", "Termine de recorrer el for");
            }

        } catch (Exception Error) {
            Log.d("Acceso API", "Hubo un error al procesar el json " + Error.getMessage());

        }
    }

    public void mostrar(){

    }

}
