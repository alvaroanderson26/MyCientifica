package com.example.anderson.mycientifica;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Historial extends AppCompatActivity {
    TextView tv2 ;
    int contador=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        tv2= (TextView) findViewById(R.id.tv2);
        String[] archivos = fileList();

        if (existe(archivos, "notas.txt"))
            try {
                InputStreamReader archivo = new InputStreamReader(
                        openFileInput("notas.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while (linea != null) {
                    todo = todo + linea + "\n";
                    linea = br.readLine();
                    contador=contador+1;
                }
                br.close();
                archivo.close();
                tv2.setText(todo);
            } catch (IOException e) {
            }
    }
    //-----------------------------------------------------------------
    private boolean existe(String[] archivos, String archbusca) {
        for (int f = 0; f < archivos.length; f++)
            if (archbusca.equals(archivos[f]))
                return true;
        return false;
    }
    //-----------------------------------------------------------------
    public void salir(View v) {
        finish();
    }
    //--------------------------------------------------------------
    public void borrar(View v) {


        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                    "notas.txt", Activity.MODE_PRIVATE));
            archivo.write("");
            archivo.flush();
            archivo.close();
        } catch (IOException e) {
        }
        Toast t = Toast.makeText(this, "Los datos fueron BORRADOS",
                Toast.LENGTH_SHORT);
        t.show();

        // iniciar nuevamente el activity
        Intent i=new Intent(this,Historial.class);
        startActivity(i);
    }

    public  void eliminar(View v){
        int contador2 = 1;
        String[] archivos = fileList();
        if (existe(archivos, "notas.txt"))
            try {
                InputStreamReader archivo = new InputStreamReader(
                        openFileInput("notas.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while (linea != null && contador != contador2) {
                    todo = todo + linea + "\n";
                    linea = br.readLine();
                    contador2=contador2+1;

                }
                br.close();
                archivo.close();
                tv2.setText(todo);
            } catch (IOException e) {
            }

        contador=contador-1;
    }
}
