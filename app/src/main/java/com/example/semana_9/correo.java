package com.example.semana_9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class correo extends AppCompatActivity {
public EditText adress,asunto,mensaje;
public ImageButton compartir,nombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correo);
        adress= findViewById(R.id.edt_user);
        asunto= findViewById(R.id.edt_quepasa);
        mensaje= findViewById(R.id.edt_mensaje);
        compartir= findViewById(R.id.imgb_ir);
        nombre=findViewById(R.id.imgb_nombresito);


        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!adress.getText().toString().isEmpty()&&!asunto.getText().toString().isEmpty()&&!mensaje.getText().toString().isEmpty()){

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[]{adress.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, asunto.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT,mensaje.getText().toString());
                    startActivity(Intent.createChooser(intent, "SELECCIONA UNA APLICACION"));

                }
                else{
                    Toast.makeText(correo.this, "Verifique que todos los campos esten llenos", Toast.LENGTH_SHORT).show();
                    Vibrator chapa=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    chapa.vibrate(500);
                }

            }
        });

        nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(correo.this,nombre.class);
                startActivity(intento);
                finish();
            }
        });

    }



}