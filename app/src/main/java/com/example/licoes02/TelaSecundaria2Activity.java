package com.example.licoes02; // Ajuste o package name conforme o seu projeto

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText; // Importe a classe EditText
import android.widget.TextView; // Importe a classe TextView
import android.widget.Toast; // Para exibir mensagens curtas (toast messages)

public class TelaSecundaria2Activity extends AppCompatActivity {

    // Declaramos as variáveis dos componentes
    private EditText editTextNumero1;
    private EditText editTextNumero2;
    private Button buttonCalcular;
    private TextView textViewSoma;
    private TextView textViewSubtracao;
    private TextView textViewMultiplicacao;
    private TextView textViewDivisao;
    private Button buttonVoltar; // O botão de voltar já existia

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_secundaria2); // Conecta com o layout XML

        // 1. Encontrar os elementos do layout pelo ID
        editTextNumero1 = findViewById(R.id.editTextNumero1);
        editTextNumero2 = findViewById(R.id.editTextNumero2);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewSoma = findViewById(R.id.textViewSoma);
        textViewSubtracao = findViewById(R.id.textViewSubtracao);
        textViewMultiplicacao = findViewById(R.id.textViewMultiplicacao);
        textViewDivisao = findViewById(R.id.textViewDivisao);
        buttonVoltar = findViewById(R.id.buttonVoltar2);

        // 2. Definir o que acontece quando o botão "Calcular" é clicado
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularOperacoes(); // Chama nosso novo método para fazer os cálculos
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

    // Método que contém a lógica de cálculo
    private void calcularOperacoes() {
        // Obter os textos dos EditText
        String num1Str = editTextNumero1.getText().toString();
        String num2Str = editTextNumero2.getText().toString();

        // Verificar se os campos não estão vazios
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Por favor, digite ambos os números.", Toast.LENGTH_SHORT).show();
            return; // Sai do método se algum campo estiver vazio
        }

        try {
            // Converter os textos para números decimais (double)
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);

            // Realizar as operações
            double soma = num1 + num2;
            double subtracao = num1 - num2;
            double multiplicacao = num1 * num2;

            // Exibir os resultados nos TextViews
            textViewSoma.setText("Soma: " + String.format("%.2f", soma)); // Formata para 2 casas decimais
            textViewSubtracao.setText("Subtração: " + String.format("%.2f", subtracao));
            textViewMultiplicacao.setText("Multiplicação: " + String.format("%.2f", multiplicacao));

            // Tratamento para divisão por zero
            if (num2 != 0) {
                double divisao = num1 / num2;
                textViewDivisao.setText("Divisão: " + String.format("%.2f", divisao));
            } else {
                textViewDivisao.setText("Divisão: Erro (divisão por zero)");
            }

        } catch (NumberFormatException e) {
            // Captura um erro se o texto digitado não for um número válido
            Toast.makeText(this, "Por favor, digite números válidos.", Toast.LENGTH_SHORT).show();
        }
    }
}