package com.meu.galeryteste;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;
import java.util.Objects;

public class Falador extends AppCompatActivity {

    TextToSpeech textoFalado;
    Button btFalando, btLimpaCampo, duvida;
    EditText editText;
    Context contexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_falador);
        Objects.requireNonNull(getSupportActionBar()).hide();

        contexto = getApplicationContext();
        btLimpaCampo = findViewById(R.id.limpaTexto);
        editText = findViewById(R.id.praFalar);
        btFalando = findViewById(R.id.falador);
        duvida = findViewById(R.id.duvidaFalador);

        textoFalado = new TextToSpeech(contexto, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR){
                    textoFalado.setLanguage(Locale.getDefault());//selecionada a linguage default do aparelho
                }
            }
        });
        //este botão chama o o metodo qu epega o texto e e transforma em voz
        btFalando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String texto = editText.getText().toString();
               textoFalado.speak(texto, textoFalado.QUEUE_FLUSH,null);
            }
        });
        //este botao limpa o campo de texto
        btLimpaCampo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                textoFalado.stop();
            }
        });
        //***********************duvida falador***********
        duvida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //*********************diálogo de ajuda
                AlertDialog.Builder dialog = new AlertDialog.Builder(Falador.this);
                dialog.setTitle("Ajuda");
                dialog.setMessage("Aqui é muito simples.\n Basta digitar um texto e clicar em 'falar' para ouvir em viva voz" +
                        "Você também pode colar um texto que quer ouvir.\n O botão limpar reseta o campo de texto.");
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
        //***********************duvida falador***********
    }
        /*Este trecho de codigo da uma pausa ou um shutdown no falador para que se preciso
         utlilalo em outra janela ou outro app nao dar conflito*/
    public void onPause(){
        if(textoFalado != null){
            textoFalado.stop();
            textoFalado.shutdown();
        }
        super.onPause();
    }

}