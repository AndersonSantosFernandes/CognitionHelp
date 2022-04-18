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
import android.widget.ScrollView;
import java.util.Random;

public class CognitionHelp extends AppCompatActivity {
    private ScrollView fundo;
    MediaPlayer abertura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cognition_help);
         abertura = MediaPlayer.create(this, R.raw.silence);
         abertura.start();
         fundo = findViewById(R.id.mainFrame);



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
    }



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
    }
    //**************************menu inflavel*********************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // usamos aqui o inflae para inflar o menu > transformar o menú em uma view
        // Ir em res e criar u novo dire´torio cchamado menu

        getMenuInflater().inflate(R.menu.menu_principal,menu);

        return super.onCreateOptionsMenu(menu);
    }
    //onOptionsItemSelected(item) cria um evento de clique para o item selecionado do menú
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu0:
                Intent intent1 = new Intent(CognitionHelp.this, Cores.class);
                startActivity(intent1);
                break;

            case R.id.menu1:
                Intent intent2 = new Intent(CognitionHelp.this, Falador.class);
                startActivity(intent2);
                break;

            case R.id.menu2:
                Intent intent3 = new Intent(CognitionHelp.this, MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.menu3:
                Intent intent4 = new Intent(CognitionHelp.this, Informacoes.class);
                startActivity(intent4);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}
    /*public void onPause(){
        if(abertura.isPlaying()){
            abertura.stop();
        }
        super.onPause();
    }*/