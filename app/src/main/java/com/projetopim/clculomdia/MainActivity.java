package com.projetopim.clculomdia;

import static java.util.Objects.isNull;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.xml.sax.Parser;

public class MainActivity extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtNota1;
    private EditText txtNota2;
    private TextView txtResultado;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.txtNome);
        txtNota1 = findViewById(R.id.txtNota1);
        txtNota2 = findViewById(R.id.txtNota2);
        txtResultado = findViewById(R.id.txtResultado);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                txtResultado.setText(calculo(v, txtNome, txtNota1, txtNota2));
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String calculo(View v, EditText nome, EditText nota1, EditText nota2) {
        if((nome.getText() != null && !String.valueOf(nome.getText()).trim().isEmpty()) &&
                (nota1.getText() != null && !String.valueOf(nota1.getText()).trim().isEmpty()) &&
                (nota2.getText() != null && !String.valueOf(nota2.getText()).trim().isEmpty())
        ) {

        String nota1Parse = String.valueOf(nota1.getText());
        double nota1ParseDouble = Double.parseDouble(nota1Parse);

        String nota2Parse = String.valueOf(nota2.getText());
        double nota2ParseDouble = Double.parseDouble(nota2Parse);

        double result = (nota1ParseDouble + nota2ParseDouble) / 2;
        String resultado = null;
        if(result >= 6.0){
            resultado = "Aluno(a) " + String.valueOf(nome.getText()) +" aprovado(a) com média = " + String.valueOf(result);
        } else {
            resultado = "Aluno(a) " + String.valueOf(nome.getText()) +" reprovado(a) com média = " + String.valueOf(result);
        }
        System.out.println("Resultado: " + resultado);
        return resultado;
        } else {
            Snackbar.make(
                    v,
                    "Favor preencha todos os campos",
                    Snackbar.LENGTH_SHORT
            ).show();
            return "Favor preencha todos os campos";
        }
    }
}