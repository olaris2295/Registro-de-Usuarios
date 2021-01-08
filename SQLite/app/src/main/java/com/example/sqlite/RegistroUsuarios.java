package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import entidades.ConexionSQLiteHelper;
import utilidades.Utilidades;

public class RegistroUsuarios extends AppCompatActivity {

    EditText id, nombreUsuario, telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        id = findViewById(R.id.idUsuario);
        nombreUsuario = findViewById(R.id.nombreUsuario);
        telefono = findViewById(R.id.telefono);

    }

    public void onClickRegistar(View view) {

        //registrarUsuarios();
          registrarUsuariosSQL();
    }

    private void registrarUsuariosSQL() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        //Insert into Usuario (id, nombre, telefono) values(123, 'Olaris', '3007045731')
        String insert= "INSERT INTO "+Utilidades.TABLA_USUARIO+"("+Utilidades.CAMPO_ID+",'"+Utilidades.CAMPO_NOMBRE+"','"+Utilidades.CAMPO_TELEFONO+"') VALUES ("+id.getText().toString()+", '"+nombreUsuario.getText().toString()+"', '"+telefono.getText().toString()+"')";
        db.execSQL(insert);

       // db.close();
    }

    //Otra manera de insertar datos
    private void registrarUsuarios() {

    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID, id.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE, nombreUsuario.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO, telefono.getText().toString());

        Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values);
        Toast.makeText(getApplicationContext(), "ID Registro: " +idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }
}