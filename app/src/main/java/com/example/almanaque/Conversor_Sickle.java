package com.example.almanaque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Conversor_Sickle extends AppCompatActivity {

    private Spinner spinner2;
    private EditText et2;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_sickle);

        et2 = (EditText)findViewById(R.id.txt_valor2);

        tv2 = (TextView) findViewById(R.id.tv_resultado2);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        String [] opciones ={"De Sickle a libras","De Sickle a Dolares Americanos","De Sickle a Euros","De Sickle a Pesos","De Sickle a Rublos","De Sickle a Dolar Canadiense","De Sickle a Yen"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_conversor, opciones);
        spinner2.setAdapter(adapter);
    }

    public void Galeon(View vista){
        Intent siguiente = new Intent(this, Conversor.class);
        startActivity(siguiente);
    }
    public void Knut(View vista){
        Intent siguiente = new Intent(this, Conversor_Knut.class);
        startActivity(siguiente);
    }
    public void Menu(View vista){
        Intent siguiente = new Intent(this, Menu_Opciones.class);
        startActivity(siguiente);
    }

    //metodo del boton
    public void Calcular(View vista){
        String valor1_String = et2.getText().toString();


        int valor1_int = Integer.parseInt(valor1_String);

        String seleccion = spinner2.getSelectedItem().toString();
        if (seleccion.equals("De Sickle a libras")){
            double libras = (double) (valor1_int * 0.29);
            String resultado = String.valueOf(libras);
            tv2.setText("£ " + resultado);
        }else  if (seleccion.equals("De Sickle a Dolares Americanos")){
            double dolar = (double) (valor1_int * 0.59);
            String resultado = String.valueOf(dolar);
            tv2.setText("USD " + resultado);
        } else  if (seleccion.equals("De Sickle a Euros")){
            double euro = (double) (valor1_int * 5.9);
            String resultado = String.valueOf(euro);
            tv2.setText("€ " + resultado);
        }else  if (seleccion.equals("De Sickle a Pesos")){
            double peso = (double) (valor1_int * 6.57);
            String resultado = String.valueOf(peso);
            tv2.setText("$ " + resultado);
        }else  if (seleccion.equals("De Sickle a Rublos")){
            double rublo = (double) (valor1_int * 15.20);
            String resultado = String.valueOf(rublo);
            tv2.setText("₽ " + resultado);
        }else  if (seleccion.equals("De Sickle a Dolar Canadiense")){
            double canadiense = (double) (valor1_int * 0.63);
            String resultado = String.valueOf(canadiense);
            tv2.setText("CAD " + resultado);
        }else  if (seleccion.equals("De Sickle a Yen")){
            double yen = (double) (valor1_int * 68.55);
            String resultado = String.valueOf(yen);
            tv2.setText("¥ " + resultado);
        }else{
            Toast.makeText(this,"Debes Introducir una cantidad", Toast.LENGTH_LONG).show();
        }
    }
}