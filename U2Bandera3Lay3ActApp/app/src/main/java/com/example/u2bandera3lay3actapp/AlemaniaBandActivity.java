/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2023    HORA: 08-09 HRS
:*
:*            Activity que despliega la bandera de Alemania en una sola pantalla
:*
:*  Archivo     : AlemaniaBandActivity.java
:*  Autor       : Carlos Antonio Madrigal Trejo 20130053
:*  Fecha       : 23/02/2023
:*  Compilador  : Android Studio Electric Eel 2022.1
:*  Descripci�n : Este activity despliega la bandera de Alemania en una sola pantalla.
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/
package com.example.u2bandera3lay3actapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class AlemaniaBandActivity extends AppCompatActivity {
    //------------------------------------------------------------------------------------------------//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alemania_band);
    }
    //------------------------------------------------------------------------------------------------//
    public void btn_SalirClick( View v) { finish();}
    //------------------------------------------------------------------------------------------------//
}