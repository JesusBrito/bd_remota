package com.example.jesus.bdremota;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String servidor="sql3.freemysqlhosting.net";
    String bd="sql3209485";
    String Usuario="sql3209485";
    String Clave="du12AZbRX5";
    boolean Validacion=false;
    dataBase db = new dataBase(servidor,bd ,Usuario,Clave);
    protected void onCreate(Bundle savedInstanceState) {

        if (!verificaConexion(this)) {
            Toast.makeText(getBaseContext(),
                    "Comprueba tu conexión a Internet. Saliendo ... ", Toast.LENGTH_SHORT)
                    .show();
            this.finish();
        }else{
            Toast.makeText(getBaseContext(),
                    "Se ha estabecido conexion a la red", Toast.LENGTH_SHORT)
                    .show();
            System.out.println("La conexión a internet fue exitosa ");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static boolean verificaConexion(Context ctx) {
        boolean bConectado = false;
        ConnectivityManager connec = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // No sólo wifi, también GPRS
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        // este bucle debería no ser tan ñapa
        for (int i = 0; i < 2; i++) {
            // ¿Tenemos conexión? ponemos a true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;
    }
}
