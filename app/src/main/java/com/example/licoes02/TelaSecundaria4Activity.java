package com.example.licoes02; // Ajuste o package name conforme o seu projeto

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText; // Importe a classe EditText
import android.widget.TextView; // Importe a classe TextView
import android.widget.Toast; // Para exibir mensagens curtas (toast messages)

public class TelaSecundaria4Activity extends AppCompatActivity {

    // Declaramos as variáveis dos componentes
    private EditText editTextNumeroTabuada;
    private Button buttonGerarTabuada;
    private TextView textViewResultadosTabuada;
    private Button buttonVoltar; // O botão de voltar já existia

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_secundaria4); // Conecta com o layout XML

        // 1. Encontrar os elementos do layout pelo ID
        editTextNumeroTabuada = findViewById(R.id.editTextNumeroTabuada);
        buttonGerarTabuada = findViewById(R.id.buttonGerarTabuada);
        textViewResultadosTabuada = findViewById(R.id.textViewResultadosTabuada);
        buttonVoltar = findViewById(R.id.buttonVoltar4);

        // 2. Definir o que acontece quando o botão "Gerar Tabuada" é clicado
        buttonGerarTabuada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerarTabuada(); // Chama nosso novo método para gerar e exibir a tabuada
            }
        });

        // 3. Definir o que acontece quando o botão "Voltar" é clicado
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Encerra a Activity atual
            }
        });
    }

    // Método que contém a lógica de geração da tabuada
    private void gerarTabuada() {
        // Obter o texto do EditText
        String numeroStr = editTextNumeroTabuada.getText().toString();

        // Verificar se o campo não está vazio
        if (numeroStr.isEmpty()) {
            Toast.makeText(this, "Por favor, digite um número.", Toast.LENGTH_SHORT).show();
            textViewResultadosTabuada.setText(""); // Limpa resultados anteriores
            return; // Sai do método se o campo estiver vazio
        }

        try {
            // Converter o texto para um número inteiro
            int numero = Integer.parseInt(numeroStr);

            // StringBuilder é mais eficiente para construir strings longas em um loop
            StringBuilder tabuadaBuilder = new StringBuilder();

            // Loop para gerar a tabuada do 1 ao 10
            for (int i = 1; i <= 10; i++) {
                int resultado = numero * i;
                // Adiciona cada linha da tabuada ao StringBuilder
                tabuadaBuilder.append(numero).append(" x ").append(i).append(" = ").append(resultado).append("\n");
            }

            // Define o texto final no TextView
            textViewResultadosTabuada.setText(tabuadaBuilder.toString());

        } catch (NumberFormatException e) {
            // Captura um erro se o texto digitado não for um número inteiro válido
            Toast.makeText(this, "Por favor, digite um número inteiro válido.", Toast.LENGTH_SHORT).show();
            textViewResultadosTabuada.setText(""); // Limpa resultados anteriores
        }
    }
}