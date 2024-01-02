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

public class Conversor extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et1;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);

        et1 = (EditText)findViewById(R.id.txt_valor1);

        tv1 = (TextView) findViewById(R.id.tv_resultado);
        spinner1 = (Spinner) findViewById(R.id.spinner);

        String [] opciones ={"De Galeon a libras","De Galeon a Dolares Americanos","De Galeon a Euros","De Galeon a Pesos","De Galeon a Rublos","De Galeon a Dolar Canadiense","De Galeon a Yen"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_conversor, opciones);
        spinner1.setAdapter(adapter);
    }

    public void Sickle(View vista){
        Intent siguiente = new Intent(this, Conversor_Sickle.class);
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
        String valor1_String = et1.getText().toString();


        int valor1_int = Integer.parseInt(valor1_String);

        String seleccion = spinner1.getSelectedItem().toString();
        if (seleccion.equals("De Galeon a libras")){
            double libras = (double) (valor1_int * 4.93);
            String resultado = String.valueOf(libras);
            tv1.setText("£ " + resultado);
        }else  if (seleccion.equals("De Galeon a Dolares Americanos")){
            double dolar = (double) (valor1_int * 6.64);
            String resultado = String.valueOf(dolar);
            tv1.setText("USD " + resultado);
        } else  if (seleccion.equals("De Galeon a Euros")){
            double euro = (double) (valor1_int * 5.9);
            String resultado = String.valueOf(euro);
            tv1.setText("€ " + resultado);
        }else  if (seleccion.equals("De Galeon a Pesos")){
            double peso = (double) (valor1_int * 126.71);
            String resultado = String.valueOf(peso);
            tv1.setText("$ " + resultado);
        }else  if (seleccion.equals("De Galeon a Rublos")){
            double rublo = (double) (valor1_int * 1.16);
            String resultado = String.valueOf(rublo);
            tv1.setText("₽ " + resultado);
        }else  if (seleccion.equals("De Galeon a Dolar Canadiense")){
            double canadiense = (double) (valor1_int * 8.43);
            String resultado = String.valueOf(canadiense);
            tv1.setText("CAD " + resultado);
        }else  if (seleccion.equals("De Galeon a Yen")){
            double yen = (double) (valor1_int * 744.24);
            String resultado = String.valueOf(yen);
            tv1.setText("¥ " + resultado);
        }else{
            Toast.makeText(this,"Debes Introducir una cantidad", Toast.LENGTH_LONG).show();
        }
    }


}