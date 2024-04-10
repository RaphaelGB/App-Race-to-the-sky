package com.example.app_racetothesky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class Historia_jogo extends AppCompatActivity {
    private ImageView menu, voltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia_jogo);

        menu = (ImageView) findViewById(R.id.menu_hamb);
        voltar = (ImageView) findViewById(R.id.img_voltar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(Historia_jogo.this, Splash.class);
                startActivity(x);
                finish();
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Instanciando o Popmenu
                PopupMenu popup = new PopupMenu(Historia_jogo.this, menu);

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
        Intent intent = new Intent(Historia_jogo.this, Splash.class);
        startActivity(intent);
        finish();
    }
    private void mostrarHistoria() {
        Intent intent = new Intent(Historia_jogo.this, Historia_jogo.class);
        startActivity(intent);
        finish();
    }

    private void mostrarPersonagens() {
        Intent intent = new Intent(Historia_jogo.this, HistoriaPersonagens.class);
        startActivity(intent);
        finish();
    }

    private void mostrarAvaliacao() {
        Intent intent = new Intent(Historia_jogo.this, Avaliacao.class);
        startActivity(intent);
        finish();
    }
}
