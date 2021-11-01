package com.atividadefabio.f270ah7;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editNota1;
    private EditText editNota2;
    private TextView resultado;
    private Button botaoCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editNome);
        editNota1 = findViewById(R.id.editNota1);
        editNota2 = findViewById(R.id.editNota2);
        resultado = findViewById(R.id.resultado);
        botaoCalc = findViewById(R.id.botaoCalc);

        botaoCalc.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                String mensagem;

                double conta = (Double.parseDouble(String.valueOf(editNota1.getText())) + Double.parseDouble(String.valueOf(editNota2.getText()))) / 2;
                if (conta >= 6.0) {
                    mensagem = "Aluno(a) " + String.valueOf(editNome.getText()) +" aprovado(a) com média = " + String.valueOf(conta);
                } else {
                    mensagem = "Aluno(a) " + String.valueOf(editNome.getText()) +" reprovado(a) com média = " + String.valueOf(conta);
                }

                resultado.setText(mensagem);
            }
        });
    }
}