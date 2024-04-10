package com.example.app_racetothesky;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RatingBar;
import android.widget.Toast;

import java.nio.file.Files;

public class Avaliacao extends AppCompatActivity {
    private ImageView menu, voltar;
    private RatingBar stars;
    private EditText nome, comentario;
    private Button enviar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao);

        //Mapeando componentes
        menu = (ImageView) findViewById(R.id.menu_hamb);
        voltar = (ImageView) findViewById(R.id.img_voltar);
        stars = (RatingBar) findViewById(R.id.rtb_avaliar);
        nome = (EditText) findViewById(R.id.edt_avaliacao);
        comentario = (EditText) findViewById(R.id.edt_comentario);
        enviar = (Button) findViewById(R.id.btn_enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                String nomeTxt, comentarioTxt;
                Float starsDbl;
                nomeTxt = nome.getText().toString();
                comentarioTxt = comentario.getText().toString();
                starsDbl = stars.getRating();
                if(nomeTxt.isEmpty() || comentarioTxt.isEmpty()){
                    Toast.makeText(Avaliacao.this, "Você deve preencher todos os campos!", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(
                            Avaliacao.this,
                            "Comentário enviado com sucesso!",
                            Toast.LENGTH_SHORT).show();
                    nome.setText("");
                    comentario.setText("");
                    stars.setRating(0.0F);

                }} catch (Exception e){
                    Toast.makeText(Avaliacao.this, "Valores inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Click Icon voltar
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(Avaliacao.this, Splash.class);
                startActivity(x);
                finish();
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Instanciando o Popmenu
                PopupMenu popup = new PopupMenu(Avaliacao.this, menu);

                //Referenciando o arquivo de menu XML
                popup.getMenuInflater().inflate(R.menu.popupmenu, popup.getMenu());
                //Registrando o popup com menuItemclickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {



                        String tela2;
                        tela2 = item.getTitle().toString();
                        switch (tela2){
                            case "Home":
                                Handler home = new Handler();
                                home.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        mostrarHome();
                                    }
                                },3000);

                                break;
                            case "História":
                                Handler historia = new Handler();
                                historia.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        mostrarHistoria();
                                    }
                                },3000);
                                break;

                            case "Personagens":
                                Handler personagens = new Handler();
                                personagens.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        mostrarPersonagens();
                                    }
                                },3000);
                                break;


                            case "Avaliação":
                                Handler avaliacao = new Handler();
                                avaliacao.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        mostrarAvaliacao();
                                    }
                                },3000);
                                break;
                        }
                        return true;
                    }
                });
                popup.show();
            }
        });
    }
    private void mostrarHome() {
        Intent intent = new Intent(Avaliacao.this, Splash.class);
        startActivity(intent);
        finish();
    }
    private void mostrarHistoria() {
        Intent intent = new Intent(Avaliacao.this, Historia_jogo.class);
        startActivity(intent);
        finish();
    }

    private void mostrarPersonagens() {
        Intent intent = new Intent(Avaliacao.this, HistoriaPersonagens.class);
        startActivity(intent);
        finish();
    }

    private void mostrarAvaliacao() {
        Intent intent = new Intent(Avaliacao.this, Avaliacao.class);
        startActivity(intent);
        finish();
    }
}
