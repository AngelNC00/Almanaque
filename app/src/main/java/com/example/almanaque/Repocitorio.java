package com.example.almanaque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Repocitorio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repocitorio);
    }

    //metodo boton siguiente
    public void Clasificacionx(View vista){
        Intent siguiente = new Intent(this,Clasificacion_x.class);
        startActivity(siguiente);
    }
    //metodo boton siguiente
    public void Clasificacionxx(View vista){
        Intent siguiente = new Intent(this,Clasificacion_xx.class);
        startActivity(siguiente);
    }
    //metodo boton siguiente
    public void Clasificacionxxx(View vista){
        Intent siguiente = new Intent(this,Clasificacion_xxx.class);
        startActivity(siguiente);
    }
    //metodo boton siguiente
    public void Clasificacionxxxx(View vista){
        Intent siguiente = new Intent(this,Clasificacion_xxxx.class);
        startActivity(siguiente);
    }
    //metodo boton siguiente
    public void Clasificacionxxxxx(View vista){
        Intent siguiente = new Intent(this,Clasificacion_xxxxx.class);
        startActivity(siguiente);
    }
}