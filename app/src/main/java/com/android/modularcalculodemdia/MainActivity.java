package com.android.modularcalculodemdia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nota1, nota2, nota3, nota4, faltas;
    Button calcular;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nota1     = findViewById(R.id.nota1);
        nota2     = findViewById(R.id.nota2);
        nota3     = findViewById(R.id.nota3);
        nota4     = findViewById(R.id.nota4);
        faltas    = findViewById(R.id.numeroFaltas);
        calcular  = findViewById(R.id.btnCalcular);
        resultado = findViewById(R.id.resultado);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean retorno = validarCampos();
                if(retorno) {
                    int n1 = Integer.parseInt(nota1.getText().toString());
                    int n2 = Integer.parseInt(nota2.getText().toString());
                    int n3 = Integer.parseInt(nota3.getText().toString());
                    int n4 = Integer.parseInt(nota4.getText().toString());
                    int nFaltas = Integer.parseInt(faltas.getText().toString());

                    double media = (n1 + n2 + n3 + n4) / 4;

                    if (media >= 6 && nFaltas <= 20) {
                        resultado.setText("Aluno foi Aprovado com Media Final " + media);
                        resultado.setTextColor(getColor(R.color.green));
                    } else if (nFaltas > 20) {
                        resultado.setText("Aluno REPROVADO por faltas ");
                        resultado.setTextColor(getColor(R.color.red));
                    } else if (media < 6) {
                        resultado.setText("Aluno REPROVADO POR Nota Media final " + media);
                        resultado.setTextColor(getColor(R.color.red));
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validarCampos() {
        boolean camposValidados = true;

        if(nota1.getText().toString().isEmpty()){
            camposValidados = false;
            nota1.setError("Preencha o campo nota 1");
        }
        if(nota2.getText().toString().isEmpty()){
            camposValidados = false;
            nota1.setError("Preencha o campo nota 2");
        }
        if(nota3.getText().toString().isEmpty()){
            camposValidados = false;
            nota1.setError("Preencha o campo nota 3");
        }
        if(nota4.getText().toString().isEmpty()){
            camposValidados = false;
            nota1.setError("Preencha o campo nota 4");
        }
        if(faltas.getText().toString().isEmpty()){
            camposValidados = false;
            nota1.setError("Preencha o campo numero de faltas");
        }

        return camposValidados;
    }
}




