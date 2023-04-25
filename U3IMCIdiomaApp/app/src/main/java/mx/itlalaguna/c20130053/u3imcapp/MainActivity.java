/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2023    HORA: 08-09 HRS
:*
:*                  Activity principal de la app IMCIdiomaApp
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Carlos Antonio Madrigal Trejo 20130053
:*  Fecha       : 03/03/2023
:*  Compilador  : Android Studio Electric Eel 2022.1
:*  Descripci�n : Este activity despliega la pantalla principal para leer el peso y estatura de la
                  persona para poder calcular su indice de masa corporal, además determina su estado
                  de salud. Adicionado a esto este cuenta con una mejora en la presentación
                  con la versión en inglés.
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/
package mx.itlalaguna.c20130053.u3imcapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText edtPeso;
    private EditText edtEstatura;

    DecimalFormat df  = new DecimalFormat("####.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Obtiene las referencias de los edit text del layout
        edtPeso = findViewById(R.id.edt_Peso);
        edtEstatura = findViewById(R.id.edt_Estatura);

    }
    //----------------------------------------------------------------------------------------------
    public void btn_calcularIMC( View v ){
        try {
            String aceptar = getString(R.string.aceptar);
            double imc;
            double peso = Double.valueOf(edtPeso.getText().toString());
            double estatura = Double.valueOf(edtEstatura.getText().toString());

            imc = peso / Math.pow(estatura, 2);

            String rango = "";

            double arrIndice[] = { 15, 15.9, 18.4, 24.9, 29.9, 34.9, 39.9};

            String delgadezMuy = getString(R.string.delgadez_muy_severa);
            String delgadezSevera = getString(R.string.delgadez_severa);
            String delgadez = getString(R.string.delgadez);
            String pesoSaludable = getString(R.string.saludable);
            String sobrePeso = getString(R.string.sobrepreso);
            String obesidadModerada = getString(R.string.obesidad_moderada);
            String obesidadSevera = getString(R.string.obesidad_severa);
            String obesidadMuy = getString(R.string.obesidad_muysevera);

            String arrRango[] = {delgadezMuy, delgadezSevera, delgadez, pesoSaludable,
                    sobrePeso, obesidadModerada, obesidadSevera, obesidadMuy};
            int i = 0;
            while( i < arrIndice.length ){
                if( imc <= arrIndice[i] ){
                    rango = arrRango[i];
                    break;
                }
                i++;
            }
            String condicion = getString(R.string.condicion_salud);
            String imcString = getString(R.string.imc);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(imcString).setMessage(imcString + " = "+ String.valueOf(df.format(imc)) +
                            ", " + condicion +" "+ rango)
                    .setPositiveButton(aceptar, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();//Metodo para cerrar el alert
                        }
                    }).create().show();
        } catch( NumberFormatException ex){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String aviso = getString(R.string.aviso);
            String campos = getString(R.string.null_campos);
            builder.setTitle(aviso).setMessage(campos).create().show();
        }

    }
    //----------------------------------------------------------------------------------------------
    public void btn_acercaDe( View v ){
        String aceptar = getString(R.string.aceptar);
        //Muestra un alert dialog que contiene la información de la aplicación y el logo del tec
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String acerca = getString(R.string.about_app);
        String gracias = getString(R.string.gracias);
        String creado = getString(R.string.creado_por);
        builder.setTitle(acerca).setIcon(R.drawable.itl)
                .setMessage("U3IMCIdiomaApp v2.0 \n" +
                        creado + "Carlos Antonio Madrigal Trejo 20130053 \n" +
                        "Ene-Jun/2023\n").setPositiveButton(aceptar,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mostrarToast(gracias);
                                dialogInterface.dismiss();
                            }
                        }).create().show();
    }
    //----------------------------------------------------------------------------------------------
    public void mostrarToast (String mensaje){ //Función para mostrar un toast
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}