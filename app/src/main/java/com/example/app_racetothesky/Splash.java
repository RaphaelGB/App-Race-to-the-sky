package com.example.app_racetothesky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Splash extends AppCompatActivity {
    private ImageView menu;
    private MenuItem histpers, aval, histjogo, home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        menu = (ImageView) findViewById(R.id.menu_hamb);
        //Adicionando click na imagem

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Instanciando o Popmenu
                PopupMenu popup = new PopupMenu(Splash.this, menu);

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
                               },500);
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
                               },10);
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
        Intent intent = new Intent(Splash.this, Splash.class);
        startActivity(intent);
        finish();
    }
    private void mostrarHistoria() {
        Intent intent = new Intent(Splash.this, Historia_jogo.class);
        startActivity(intent);
        finish();
    }

    private void mostrarPersonagens() {
        Intent intent = new Intent(Splash.this, HistoriaPersonagens.class);
        startActivity(intent);
        finish();
    }

    private void mostrarAvaliacao() {
        Intent intent = new Intent(Splash.this, Avaliacao.class);
        startActivity(intent);
        finish();
    }
}

