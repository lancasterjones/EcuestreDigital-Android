package com.example.io.vende.ecuestre;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    static final int segundos = 2;
    static final int milisegundos = segundos*1000;
    static final int delay = 1;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        pb = (ProgressBar)findViewById(R.id.pb);
        pb.setMax(maximo_progreso());
        animacion();
    }

    public void animacion() {
        new CountDownTimer(milisegundos,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                pb.setProgress(progreso(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                Intent login = new Intent(SplashScreen.this,MenuPrincipal.class);
                startActivity(login);
                finish();
            }
        }.start();
    }

    public int progreso(long miliseconds){
        return (int) ((milisegundos-miliseconds)/1000);
    }

    public int maximo_progreso(){
        return segundos-delay;
    }

}
