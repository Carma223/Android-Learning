/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2023    HORA: 08-09 HRS
:*
:*                Activity que despliega un menu para acceder a las banderas
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Carlos Antonio Madrigal Trejo 20130053
:*  Fecha       : 23/02/2023
:*  Compilador  : Android Studio Electric Eel 2022.1
:*  Descripci�n : Este activity despliega un menú de botones para acceder a las banderas de
		  Méxito, Alemania, Perú.
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/
package com.example.u2bandera3lay3actapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //------------------------------------------------------------------------------------------------//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrarToast("[Main] onCreate()");
    }
    //--------------------------------------------------------------------------------------------//
    public void btn_Mexico (View v){
        startActivity( new Intent(this, MexicoBandActivity.class));
    }
    //--------------------------------------------------------------------------------------------//
    public void btn_Alemania (View v){
        startActivity( new Intent( this,  AlemaniaBandActivity.class));
    }
    //--------------------------------------------------------------------------------------------//
    public void btn_Chile (View v){
        startActivity( new Intent( this, ChileBandActivity.class));
    }
    //--------------------------------------------------------------------------------------------//
    public void btn_salir (View v){
        finish();
    }
    //--------------------------------------------------------------------------------------------//
    //Metodos del ciclo de vida de un activity
    @Override
    protected void onStart() {
        super.onStart();
        mostrarToast("[Main] onStart()");
    }
    //--------------------------------------------------------------------------------------------//
    @Override
    protected void onResume() {
        super.onResume();
        mostrarToast("[Main] onResume()");
    }
    //--------------------------------------------------------------------------------------------//
    @Override
    protected void onStop() {
        super.onStop();
        mostrarToast("[Main] onStop()");
    }
    //--------------------------------------------------------------------------------------------//
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mostrarToast("[Main] onDestroy()");
    }
    //--------------------------------------------------------------------------------------------//
    @Override
    protected void onPause() {
        super.onPause();
        mostrarToast("[Main] onPause()");
    }
    //--------------------------------------------------------------------------------------------//
    @Override
    protected void onRestart() {
        super.onRestart();
        mostrarToast("[Main] onRestart()");
    }
    //--------------------------------------------------------------------------------------------//
    public void mostrarToast(String mensaje){
        Toast.makeText(this,  mensaje , Toast.LENGTH_SHORT).show();
    }
    //------------------------------------------------------------------------------------------------//
}