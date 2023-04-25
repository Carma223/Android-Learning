/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2023    HORA: 08-09 HRS
:*
:*                Activity que despliega una pantalla de bienvenida (splash)
:*
:*  Archivo     : SplashActivity.java
:*  Autor       : Carlos Antonio Madrigal Trejo 20130053
:*  Fecha       : 23/02/2023
:*  Compilador  : Android Studio Electric Eel 2022.1
:*  Descripci�n : Esta pantalla despliega una pantalla de bienvenida y después de
                  3 segundos invoca al activity principal de la app.
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/
package com.example.u2bandera3lay3actapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    //------------------------------------------------------------------------------------------------//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
    //------------------------------------------------------------------------------------------------//
}