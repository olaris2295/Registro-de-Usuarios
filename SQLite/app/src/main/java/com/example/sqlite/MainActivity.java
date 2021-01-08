package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import entidades.ConexionSQLiteHelper;

public class MainActivity extends AppCompatActivity {
    Button RegisUusario, ConsulUsuario, UsuarioSpinner, UsuarioListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RegisUusario = findViewById(R.id.btnRegistroUsuario);
        ConsulUsuario = findViewById(R.id.btnConsulUsuario);
        UsuarioSpinner = findViewById(R.id.btnUsuarioSpinner);
        UsuarioListview = findViewById(R.id.btnUsuarioListview);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);
    }

    public void onClickSQLite(View view) {

        Intent miIntent = null;

        switch (view.getId())
        {
            case R.id.btnRegistroUsuario:

            miIntent = new Intent(MainActivity.this, RegistroUsuarios.class);
            break;
        }

        if(miIntent != null)
        {

            startActivity(miIntent);
        }
    }
}