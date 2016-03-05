package com.example.anderson.mycientifica;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    TextView tv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv= (TextView) findViewById(R.id.tv1);
        SharedPreferences prefe=getSharedPreferences("datos", Context.MODE_PRIVATE);
        tv.setText(prefe.getString("numero", ""));






    }

    public  void concatenar(View v){
        tv.setText(tv.getText().toString()+v.getTag().toString());
    }

    public  void borrar(View v){
        String cadena = tv.getText().toString();
        if (tv.length()>= 1){
            tv.setText(cadena.substring(0,tv.length()-1));
        }

    }

    public void ejecutar(View v) {
        SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("numero", tv.getText().toString());
        editor.commit();

        Toast.makeText(this, "Guardado...", Toast.LENGTH_LONG).show();
    }




    public void grabar(View v) {

        //almacenar en memoria con SharedPreference

        SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("numero", tv.getText().toString());
        editor.commit();

        ////______________________________

        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                    "notas.txt", Activity.MODE_APPEND));
            archivo.write(tv.getText().toString()+"\n");
            archivo.flush();
            archivo.close();
        } catch (IOException e) {
        }
        Toast t = Toast.makeText(this, "Los datos fueron grabados",
                Toast.LENGTH_SHORT);
        t.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id==R.id.opcion1) {
            Toast.makeText(this, "Aquí encontrara las especificaciones y funcionalidaades de la calculadora cientifica ", Toast.LENGTH_LONG).show();
            Intent i=new Intent(this,Ayuda.class);
            startActivity(i);
        }

        if (id==R.id.opcion2) {
            Intent i=new Intent(this,AcercaDe.class);
            startActivity(i);
        }

        if (id==R.id.opcion3) {
            Intent i=new Intent(this,Historial.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
