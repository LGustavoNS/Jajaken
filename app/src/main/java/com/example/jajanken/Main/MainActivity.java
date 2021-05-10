package com.example.jajanken.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jajanken.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada (String escolhaUsuario) {

        ImageView img_resultado_jajanken = findViewById(R.id.img_resultado_jajanken);
        TextView txt_escolha_jajanken = findViewById(R.id.txt_escolha_jajanken);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes [ numero ];

        switch ( escolhaApp ) {
            case "pedra":
                img_resultado_jajanken.setImageResource(R.drawable.jajanken___pedra);
                break;
            case "papel":
                img_resultado_jajanken.setImageResource(R.drawable.jajanken___papel);
                break;
            case "tesoura":
                img_resultado_jajanken.setImageResource(R.drawable.jajanken___tesoura);
                break;
        }

        if(
                        (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                        (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                        (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ){ //App ganhador
            txt_escolha_jajanken.setText("Shounen LOSER");
        } else if (
                        (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
                        (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                        (escolhaUsuario == "pedra" && escolhaApp == "tesoura")
        ) { //Usuario ganhador
            txt_escolha_jajanken.setText(" CONGRATULATIONS shounen");
        } else { //Empate
            txt_escolha_jajanken.setText("GAME MUSUBARERU (Jogo Empatado)");

        }

        System.out.println("item clicado: " + escolhaApp);

    }

}