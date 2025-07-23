package com.example.licoes02; // Ajuste o package name conforme o seu projeto

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText; // Importe a classe EditText
import android.widget.TextView; // Importe a classe TextView
import android.widget.Toast; // Para exibir mensagens curtas (toast messages)

public class TelaSecundaria3Activity extends AppCompatActivity {

    // Declaramos as variáveis dos componentes
    private EditText editTextNota1;
    private EditText editTextNota2;
    private EditText editTextNota3;
    private Button buttonCalcularMedia;
    private TextView textViewMedia;
    private TextView textViewStatus;
    private Button buttonVoltar; // O botão de voltar já existia

    // Média necessária para aprovação
    private static final double NOTA_APROVACAO = 7.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_secundaria3); // Conecta com o layout XML

        // 1. Encontrar os elementos do layout pelo ID
        editTextNota1 = findViewById(R.id.editTextNota1);
        editTextNota2 = findViewById(R.id.editTextNota2);
        editTextNota3 = findViewById(R.id.editTextNota3);
        buttonCalcularMedia = findViewById(R.id.buttonCalcularMedia);
        textViewMedia = findViewById(R.id.textViewMedia);
        textViewStatus = findViewById(R.id.textViewStatus);
        buttonVoltar = findViewById(R.id.buttonVoltar3);

        // 2. Definir o que acontece quando o botão "Calcular Média" é clicado
        buttonCalcularMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularMedia(); // Chama nosso novo método para fazer o cálculo e verificar o status
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

    // Método que contém a lógica de cálculo da média e verificação do status
    private void calcularMedia() {
        // Obter os textos dos EditText
        String nota1Str = editTextNota1.getText().toString();
        String nota2Str = editTextNota2.getText().toString();
        String nota3Str = editTextNota3.getText().toString();

        // Verificar se os campos não estão vazios
        if (nota1Str.isEmpty() || nota2Str.isEmpty() || nota3Str.isEmpty()) {
            Toast.makeText(this, "Por favor, digite todas as três notas.", Toast.LENGTH_SHORT).show();
            return; // Sai do método se algum campo estiver vazio
        }

        try {
            // Converter os textos para números decimais (double)
            double nota1 = Double.parseDouble(nota1Str);
            double nota2 = Double.parseDouble(nota2Str);
            double nota3 = Double.parseDouble(nota3Str);

            // Validar se as notas estão em um intervalo razoável (ex: 0 a 10)
            if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10 || nota3 < 0 || nota3 > 10) {
                Toast.makeText(this, "As notas devem estar entre 0 e 10.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Calcular a média
            double media = (nota1 + nota2 + nota3) / 3.0;

            // Exibir a média
            textViewMedia.setText("Média: " + String.format("%.2f", media)); // Formata para 2 casas decimais

            // Verificar o status de aprovação
            if (media >= NOTA_APROVACAO) {
                textViewStatus.setText("Status: APROVADO! 🎉");
                textViewStatus.setTextColor(getResources().getColor(android.R.color.holo_green_dark)); // Cor verde para aprovado
            } else {
                textViewStatus.setText("Status: REPROVADO! 😢");
                textViewStatus.setTextColor(getResources().getColor(android.R.color.holo_red_dark)); // Cor vermelha para reprovado
            }

        } catch (NumberFormatException e) {
            // Captura um erro se o texto digitado não for um número válido
            Toast.makeText(this, "Por favor, digite notas válidas.", Toast.LENGTH_SHORT).show();
        }
    }
}