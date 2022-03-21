package com.example.semana_9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usu;
    EditText contra;
    ImageButton vamo;
    String Usuario;
    String contraseña;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usu= findViewById(R.id.editTextName);
        contra= findViewById(R.id.editTextPassword);
        vamo=findViewById(R.id.imgbtn_nexo);
        Usuario=usu.getText().toString();
        contraseña=contra.getText().toString();
        vamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(usu.getText().toString().equals("chamba") && contra.getText().toString().equals("2003")){
                    Intent intent = new Intent(MainActivity.this,correo.class);
                    startActivity(intent);
                    finish();



                }
                else{
                   Toast.makeText(getApplicationContext(),"ingresa bien los datos requeridos",Toast.LENGTH_SHORT).show();
                    Vibrator vibre=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibre.vibrate(500);
                }

            }
        });

    }
}