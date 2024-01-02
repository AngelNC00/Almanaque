package com.example.almanaque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //metodo para el icono del action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.libro_foreground);

    }

    //metodo boton siguiente
    public void Siguiente(View vista){
        Intent siguiente = new Intent(this, Menu_Opciones.class);
        startActivity(siguiente);
    }
}