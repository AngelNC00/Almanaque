package com.example.almanaque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText et_codigo, et_nombre, et_descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et_codigo = (EditText) findViewById(R.id.txt_codigo);
        et_nombre = (EditText) findViewById(R.id.txt_nombre);
        et_descripcion = (EditText) findViewById(R.id.txt_descripcion);
    }
    //Metodo para regresar al menu opciones
    public void Anterior(View vista){
        Intent anterior = new Intent(this, Menu_Opciones.class);
        startActivity(anterior);
    }

    //Metodo para dar de alta a las criaturas
    public void Registro(View vista){
        Registros admin = new Registros(this, "Criatura", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String nombre = et_nombre.getText().toString();
        String descripcion = et_descripcion.getText().toString();


        if(!codigo.isEmpty() && !nombre.isEmpty() && !descripcion.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("nombre", nombre);
            registro.put("descripcion", descripcion);

            BaseDeDatos.insert("criaturas", null, registro);

            BaseDeDatos.close();
            et_codigo.setText("");
            et_nombre.setText("");
            et_descripcion.setText("");

            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();

        }
    }

    //metodo para consultar una criatura
    public void Buscar(View vista){
        Registros admin = new Registros(this, "Criatura", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery("select nombre, descripcion from criaturas where codigo =" + codigo, null);

            if(fila.moveToFirst()){
                et_nombre.setText(fila.getString(0));
                et_descripcion.setText(fila.getString(1));
                BaseDeDatos.close();

            }else {
                Toast.makeText(this, "No existe el articulo", Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }
        } else {
            Toast.makeText(this, "Debes introducir el codigo del articulo", Toast.LENGTH_SHORT).show();
        }
    }

    //MEtodo para eliminar un registro
    public void Eliminar(View vista){
        Registros admin = new Registros(this, "Criatura", null, 1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){
            int cantidad = BasedeDatos.delete("criaturas", "codigo=" + codigo, null);
            BasedeDatos.close();

            et_codigo.setText("");
            et_nombre.setText("");
            et_descripcion.setText("");

            if(cantidad == 1){
                Toast.makeText(this, "Articulo eliminado exitosamente", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "El articulo no existe", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this, "Debes de instroducir el codigo del articulo", Toast.LENGTH_SHORT).show();
        }
    }

    //metodo para modificar una criatura
    public void Modificar(View vista){
        Registros admin = new Registros(this, "Criatura", null, 1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String nombre = et_nombre.getText().toString();
        String descripcion = et_descripcion.getText().toString();

        if(!codigo.isEmpty() && !nombre.isEmpty() && !descripcion.isEmpty()){

            ContentValues registros = new ContentValues();
            registros.put("codigo", codigo);
            registros.put("nombre", nombre);
            registros.put("descripcion", descripcion);

            int cantidad = BasedeDatos.update("criaturas", registros, "codigo=" + codigo, null);
            BasedeDatos.close();

            if(cantidad == 1){
                Toast.makeText(this, "Articulo modificado correctamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "El articulo no existe", Toast.LENGTH_SHORT).show();

            }

        }else {
            Toast.makeText(this,"Debes de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }



}