package com.example.naytonwilkerson.jogo;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class jogo extends Activity implements View.OnKeyListener {
    private int numeroSorteado;
    private TextView mensagem;
    private EditText entrada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        preparacaoInicial();
    }

    private void preparacaoInicial() {
        numeroSorteado = (int) (Math.random() * 101);
        mensagem = (TextView) findViewById(R.id.mensagem);
        entrada = (EditText) findViewById(R.id.entrada);
        entrada.setOnKeyListener(this);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent keyEvent) {
        if (keyCode == keyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_UP) {
            verificar();
            return true;
        }
        return false;
    }

    private void verificar() {
        int numero = Integer.parseInt(entrada.getText().toString());
        if (numero == numeroSorteado) {
            mensagem.setText("Acertou na mosca");
        } else if (numero > numeroSorteado) {
            mensagem.setText("Número acima do sorteado");
        } else {
            mensagem.setText("Número abaixo do sorteado");
        }
    }

}

