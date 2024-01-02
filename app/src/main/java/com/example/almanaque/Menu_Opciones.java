package com.example.almanaque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu_Opciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);
    }

    public void Repocitorio(View vista){
        Intent siguiente = new Intent(this, Repocitorio.class);
        startActivity(siguiente);
    }
    public void Registro(View vista){
        Intent siguiente = new Intent(this, Registro.class);
        startActivity(siguiente);
    }
    public void Conversor(View vista){
        Intent siguiente = new Intent(this, Conversor.class);
        startActivity(siguiente);
    }
}