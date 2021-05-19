package com.cursoandroid.apppedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void escolherPedra(View view) {
        this.iniciarPartida("pedra");
    }

    public void escolherPapel(View view) {
        this.iniciarPartida("papel");
    }

    public void escolherTesoura(View view) {
        this.iniciarPartida("tesoura");
    }

    public void iniciarPartida(String escolhaUsuario) {
        ImageView imagemEscolhaApp = findViewById(R.id.escolhaApp);
        TextView resultadoPartida = findViewById(R.id.resultadoPartida);
        int n = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[n];

        switch (escolhaApp) {
            case "pedra":
                imagemEscolhaApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemEscolhaApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemEscolhaApp.setImageResource(R.drawable.tesoura);
                break;
        }

        // Usuario vence
        if ((escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                (escolhaUsuario == "tesoura" && escolhaApp == "papel")
        ) {
            resultadoPartida.setText("Você ganhou :)");
            // App vence
        } else if ((escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                (escolhaApp == "tesoura" && escolhaUsuario == "papel")
        ) {
            resultadoPartida.setText("Você perdeu :(");
        } else {
            resultadoPartida.setText("Empate!");
        }
    }
}