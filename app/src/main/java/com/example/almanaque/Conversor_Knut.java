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

public class Conversor_Knut extends AppCompatActivity {

    private Spinner spinner3;
    private EditText et3;
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_knut);

        et3 = (EditText)findViewById(R.id.txt_valor3);

        tv3 = (TextView) findViewById(R.id.tv_resultado3);
        spinner3 = (Spinner) findViewById(R.id.spinner3);

        String [] opciones ={"De Knut a libras","De Knut a Dolares Americanos","De Knut a Euros","De Knut a Pesos","De Knut a Rublos","De Knut a Dolar Canadiense","De Knut a Yen"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_conversor, opciones);
        spinner3.setAdapter(adapter);
    }
    public void Galeon(View vista){
        Intent siguiente = new Intent(this, Conversor.class);
        startActivity(siguiente);
    }
    public void Sickle(View vista){
        Intent siguiente = new Intent(this, Conversor_Sickle.class);
        startActivity(siguiente);
    }
    public void Menu(View vista){
        Intent siguiente = new Intent(this, Menu_Opciones.class);
        startActivity(siguiente);
    }

    //metodo del boton
    public void Calcular(View vista){
        String valor1_String = et3.getText().toString();


        int valor1_int = Integer.parseInt(valor1_String);

        String seleccion = spinner3.getSelectedItem().toString();
        if (seleccion.equals("De Knut a libras")){
            double libras = (double) (valor1_int * 0.01);
            String resultado = String.valueOf(libras);
            tv3.setText("£ " + resultado);
        }else  if (seleccion.equals("De Knut a Dolares Americanos")){
            double dolar = (double) (valor1_int * 0.02);
            String resultado = String.valueOf(dolar);
            tv3.setText("USD " + resultado);
        } else  if (seleccion.equals("De Knut a Euros")){
            double euro = (double) (valor1_int * 5.9);
            String resultado = String.valueOf(euro);
            tv3.setText("€ " + resultado);
        }else  if (seleccion.equals("De Knut a Pesos")){
            double peso = (double) (valor1_int * 0.23);
            String resultado = String.valueOf(peso);
            tv3.setText("$ " + resultado);
        }else  if (seleccion.equals("De Knut a Rublos")){
            double rublo = (double) (valor1_int * 0.52);
            String resultado = String.valueOf(rublo);
            tv3.setText("₽ " + resultado);
        }else  if (seleccion.equals("De Knut a Dolar Canadiense")){
            double canadiense = (double) (valor1_int * 0.02);
            String resultado = String.valueOf(canadiense);
            tv3.setText("CAD " + resultado);
        }else  if (seleccion.equals("De Knut a Yen")){
            double yen = (double) (valor1_int * 2.36);
            String resultado = String.valueOf(yen);
            tv3.setText("¥ " + resultado);
        }else{
            Toast.makeText(this,"Debes Introducir una cantidad", Toast.LENGTH_LONG).show();
        }
    }


}