package com.meu.galeryteste;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

        TextToSpeech falaTexto;
        Context contexto;
        Button falar, duvida, btLimpaCampo;
        EditText textoFalar;
        String recebeTexto ;

        private ImageView imagem;
        private final int GALERIA_IMAGENS = 1;
        private final int PERMISSAO_REQUEST = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        falar = findViewById(R.id.falaMain);
        textoFalar = findViewById(R.id.editTextTextPersonName);
        contexto = getApplicationContext();
        duvida = findViewById(R.id.duvidaMain);
        btLimpaCampo = findViewById(R.id.buttonLimpar);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PERMISSAO_REQUEST);
            }
        }

        imagem = (ImageView) findViewById(R.id.ivImagem);
        Button galeria = (Button) findViewById(R.id.btnImage);
        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GALERIA_IMAGENS);
            }
        });

        //*********************************************************************************

        falaTexto = new TextToSpeech(contexto, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR){
                    falaTexto.setLanguage(Locale.getDefault());//selecionada a linguage default do aparelho
                }
            }
        });

        falar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recebeTexto = textoFalar.getText().toString();

                falaTexto.speak(recebeTexto, falaTexto.QUEUE_FLUSH,null);
            }
        });
        duvida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //*********************di??logo de ajuda
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Ajuda");
                dialog.setMessage("Selecione buscar imagem \n escolha uma foto que esteja na mam??ria e n??o online. \n" +
                        "Digite o nome da pessoa ou uma frase com o mesmo, como por exemplo 'Este ?? seu filho' seguido do nome. \n" +
                        "Mostre ao paciente e clique em falar \n\n Clicando em limpar, o campo de texto ?? resetado.");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dialog.create();
                dialog.show();
                //**********************di??logo de ajuda
            }
        });

        btLimpaCampo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoFalar.setText("");
                falaTexto.stop();
            }
        });

    }//onCreate



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == GALERIA_IMAGENS) {
            Uri selectedImage = data.getData();
            String[] filePath = { MediaStore.Images.Media.DATA };
            Cursor c = getContentResolver().query(selectedImage,filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
            imagem.setImageBitmap(thumbnail);
        }
    }//onActivityResult

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSAO_REQUEST) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
// A permiss??o foi concedida. Pode continuar
            } else {
// A permiss??o foi negada. Precisa ver o que deve ser desabilitado
            }
            return;
        }
    }//onRequestPermissionsResult
   }