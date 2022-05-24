package com.meu.galeryteste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import java.util.Random;

public class CognitionHelp extends AppCompatActivity {
    private ScrollView fundo;
    private MediaPlayer abertura;
             ImageView pPause;
             Button duvida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cognition_help);

         duvida = findViewById(R.id.duvidaCognition);
         pPause = findViewById(R.id.playPause);
         abertura = MediaPlayer.create(this, R.raw.audio1);
         abertura.start();
         fundo = findViewById(R.id.mainFrame);

         pPause.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (abertura.isPlaying()){
                     abertura.pause();
                     pPause.setImageResource(R.drawable.ic_smartf);
                 }else{
                     abertura.start();
                     pPause.setImageResource(R.drawable.ic_play);
                 }
             }
         });

        Random random = new Random();
        int escolha;
        escolha = random.nextInt(5);
        switch(escolha){
            case 0:
                fundo.setBackgroundResource(R.drawable.cerebro6);
                break;
            case 1:
                fundo.setBackgroundResource(R.drawable.cerebro3);
                break;
            case 2:
                fundo.setBackgroundResource(R.drawable.cerebro4);
                break;
            case 3:
                fundo.setBackgroundResource(R.drawable.cerebro);
                break;
            case 4:
                fundo.setBackgroundResource(R.drawable.neuronio);
                break;
            default:
                fundo.setBackgroundResource(R.drawable.anime);
                break;
        }

        duvida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //*********************diálogo de ajuda
                AlertDialog.Builder dialog = new AlertDialog.Builder(CognitionHelp.this);
                dialog.setTitle("Ajuda");
                dialog.setMessage("Selecione as opções no menú situado na barra superior e escolha a tela desejada...");
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

    }//onCreate



    //******************************dialogo para o botão voltar********************************************************
    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(CognitionHelp.this);
        dialog.setTitle("Selecione");
        dialog.setMessage("Deseja sair da aplicação?");
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //abertura.stop();
                finish();
            }
        });
        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.create();
        dialog.show();
    }//onBackPressed
    //**************************menu inflavel*********************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // usamos aqui o inflar para inflar o menu > transformar o menú em uma view
        // Ir em res e criar um novo diretorio chamado menu

        getMenuInflater().inflate(R.menu.menu_principal,menu);

        return super.onCreateOptionsMenu(menu);
    }//onCreateOptionsMenu

    //onOptionsItemSelected(item) cria um evento de clique para o item selecionado do menú
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//onOptionsItemSelected

        switch (item.getItemId()){
            case R.id.menu0:
                Intent cores = new Intent(CognitionHelp.this, Cores.class);
                startActivity(cores);
                abertura.pause();
                break;

            case R.id.menu1:
                Intent falador = new Intent(CognitionHelp.this, Falador.class);
                startActivity(falador);
                abertura.pause();
                break;

            case R.id.menu2:
                Intent principal = new Intent(CognitionHelp.this, MainActivity.class);
                startActivity(principal);
                abertura.pause();
                break;
            case R.id.menu3:
                Intent informacoes = new Intent(CognitionHelp.this, Informacoes.class);
                startActivity(informacoes);
                abertura.pause();
                break;

        }
        return super.onOptionsItemSelected(item);
    }//onOptionsItemSelected

}
    /*public void onPause(){
        if(abertura.isPlaying()){
            abertura.stop();
        }
        super.onPause();
    }*/