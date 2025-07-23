package com.example.licoes02; // Ajuste o package name conforme o seu projeto

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView; // Importe a classe TextView

public class TelaSecundaria1Activity extends AppCompatActivity {

    // Declaramos as variáveis dos componentes fora do onCreate para que possam ser acessadas em outros métodos, se necessário.
    private Button buttonVoltar;
    private Button buttonMostrarOlaMundo;
    private TextView textViewOlaMundo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_secundaria1); // Conecta com o layout XML

        // 1. Encontrar os elementos do layout pelo ID
        buttonVoltar = findViewById(R.id.buttonVoltar1);
        buttonMostrarOlaMundo = findViewById(R.id.buttonMostrarOlaMundo);
        textViewOlaMundo = findViewById(R.id.textViewOlaMundo); // Encontra o TextView do "Olá, Mundo!"

        // 2. Definir o que acontece quando o botão "Voltar" é clicado
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // finish() encerra a Activity atual e volta para a anterior na pilha
                finish();
            }
        });

        // 3. Definir o que acontece quando o botão "Mostrar Olá, Mundo!" é clicado
        buttonMostrarOlaMundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Torna o TextView visível
                textViewOlaMundo.setVisibility(View.VISIBLE);
            }
        });
    }
}