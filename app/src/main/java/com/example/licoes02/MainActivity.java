package com.example.licoes02; // Ajuste o package name conforme o seu projeto

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Conecta com o layout XML

        // Encontra os botões pelo ID
        Button buttonTela1 = findViewById(R.id.buttonTela1);
        Button buttonTela2 = findViewById(R.id.buttonTela2);
        Button buttonTela3 = findViewById(R.id.buttonTela3);
        Button buttonTela4 = findViewById(R.id.buttonTela4);

        // Define o que acontece quando cada botão é clicado
        buttonTela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria um Intent para ir para a TelaSecundaria1Activity
                Intent intent = new Intent(MainActivity.this, TelaSecundaria1Activity.class);
                startActivity(intent); // Inicia a nova Activity
            }
        });

        buttonTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TelaSecundaria2Activity.class);
                startActivity(intent);
            }
        });

        buttonTela3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TelaSecundaria3Activity.class);
                startActivity(intent);
            }
        });

        buttonTela4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TelaSecundaria4Activity.class);
                startActivity(intent);
            }
        });
    }
}