package com.meu.galeryteste;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class Cores extends AppCompatActivity {


    TextToSpeech textoFalado;//***
    Context contexto;//***

    Button sorteia,btVerde,btAmarelo,btRosa,btVermelho,btAzul,btMarrom,btPreto,btCinza, duvida;
    int sorteado, adivinhado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cores);
        Objects.requireNonNull(getSupportActionBar()).hide();

        String verde, amarelo, rosa, vermelho, azul,marrom, preto, cinza, acertar, errar;

        contexto = getApplicationContext();
        verde = "clique na cor verde";
        amarelo = "clique na cor amarelo";
        rosa = "clique na cor rosa";
        vermelho = "clique na cor vermelho";
        azul = "clique na cor azul";
        marrom = "clique na cor marrom";
        preto = "clique na cor preto";
        cinza = "clique na cor cinza";
        acertar ="Acertou, muito bem";
        errar = "errou, tente novamente";

        sorteia = findViewById(R.id.btSorteia);
        btVerde = findViewById(R.id.verdeId);
        btAmarelo = findViewById(R.id.amareloId);
        btRosa = findViewById(R.id.roxoId);
        btVermelho = findViewById(R.id.vermelhoId);
        btAzul = findViewById(R.id.azulId);
        btMarrom = findViewById(R.id.marromId);
        btPreto = findViewById(R.id.pretoId);
        btCinza = findViewById(R.id.cinzaId);
        duvida = findViewById(R.id.duvidaCores);
        textoFalado = new TextToSpeech(contexto, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR){
                    textoFalado.setLanguage(Locale.getDefault());//selecionada a linguage default do aparelho
                }
            }
        });
        sorteia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int cores;
                cores = random.nextInt(8);
                switch (cores){
                    case 1:
                        textoFalado.speak(verde, textoFalado.QUEUE_FLUSH,null);
                        sorteado = 1;
                        break;
                    case 2:
                        textoFalado.speak(amarelo, textoFalado.QUEUE_FLUSH,null);
                        sorteado = 2;
                        break;
                    case 3:
                        textoFalado.speak(rosa, textoFalado.QUEUE_FLUSH,null);
                        sorteado = 3;
                        break;
                    case 4:
                        textoFalado.speak(vermelho, textoFalado.QUEUE_FLUSH,null);
                        sorteado = 4;
                        break;
                    case 5:
                        textoFalado.speak(azul, textoFalado.QUEUE_FLUSH,null);
                        sorteado = 5;
                        break;
                    case 6:
                        textoFalado.speak(marrom, textoFalado.QUEUE_FLUSH,null);
                        sorteado = 6;
                        break;
                    case 7:
                        textoFalado.speak(preto, textoFalado.QUEUE_FLUSH,null);
                        sorteado = 7;
                        break;
                    case 0:
                        textoFalado.speak(cinza, textoFalado.QUEUE_FLUSH,null);
                        sorteado = 0;
                        break;
               }
            }
        });
        //********************cores***************
        btVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 adivinhado = 1;
                if(sorteado == adivinhado){
                    textoFalado.speak(acertar, textoFalado.QUEUE_FLUSH,null);
                }else{
                    textoFalado.speak(errar, textoFalado.QUEUE_FLUSH,null);
                }
            }
        });
        btAmarelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adivinhado = 2;
                if(sorteado == adivinhado){
                    textoFalado.speak(acertar, textoFalado.QUEUE_FLUSH,null);
                }else{
                    textoFalado.speak(errar, textoFalado.QUEUE_FLUSH,null);
                }
            }
        });
        btRosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adivinhado = 3;
                if(sorteado == adivinhado){
                    textoFalado.speak(acertar, textoFalado.QUEUE_FLUSH,null);
                }else{
                    textoFalado.speak(errar, textoFalado.QUEUE_FLUSH,null);
                }
            }
        });
        btVermelho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adivinhado = 4;
                if(sorteado == adivinhado){
                    textoFalado.speak(acertar, textoFalado.QUEUE_FLUSH,null);
                }else{
                    textoFalado.speak(errar, textoFalado.QUEUE_FLUSH,null);
                }
            }
        });
        btAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adivinhado = 5;
                if(sorteado == adivinhado){
                    textoFalado.speak(acertar, textoFalado.QUEUE_FLUSH,null);
                }else{
                    textoFalado.speak(errar, textoFalado.QUEUE_FLUSH,null);
                }
            }
        });
        btMarrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adivinhado = 6;
                if(sorteado == adivinhado){
                    textoFalado.speak(acertar, textoFalado.QUEUE_FLUSH,null);
                }else{
                    textoFalado.speak(errar, textoFalado.QUEUE_FLUSH,null);
                }
            }
        });
        btPreto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adivinhado = 7;
                if(sorteado == adivinhado){
                    textoFalado.speak(acertar, textoFalado.QUEUE_FLUSH,null);
                }else{
                    textoFalado.speak(errar, textoFalado.QUEUE_FLUSH,null);
                }
            }
        });
        btCinza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adivinhado = 0;
                if(sorteado == adivinhado){
                    textoFalado.speak(acertar, textoFalado.QUEUE_FLUSH,null);
                }else{
                    textoFalado.speak(errar, textoFalado.QUEUE_FLUSH,null);
                }
            }
        });

            Toast.makeText(this, "Clique em sortear", Toast.LENGTH_SHORT).show();

        //************************* fim cores ***************************

        duvida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //*********************diálogo de ajuda
                AlertDialog.Builder dialog = new AlertDialog.Builder(Cores.this);
                dialog.setTitle("Ajuda");
                dialog.setMessage("Clique em sortear cor.\n Será pedido para escolher uma, e o paciente com deficit de \n" +
                        "    cognição deve tentar acertar.");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dialog.create();
                dialog.show();
                //**********************diálogo de ajuda
            }
        });
    }
    public void onPause(){
        if(textoFalado != null){
            textoFalado.stop();
            textoFalado.shutdown();
        }
        super.onPause();
    }
}