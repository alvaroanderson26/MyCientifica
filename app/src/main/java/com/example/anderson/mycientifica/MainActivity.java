package com.example.anderson.mycientifica;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {
    TextView tv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv= (TextView) findViewById(R.id.tv1);

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
        return super.onOptionsItemSelected(item);
    }
}
