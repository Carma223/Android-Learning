/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*             Activity con ejemplo de uso del widget RatingBar
:*
:*  Archivo     : U3WidgetsApp.java
:*  Autor       : Luis Fernando Gil Vázquez
:*  Fecha       : 13/10/2022
:*  Compilador  : Android Studio Chipmunk 2021.2.1 + JDK 11
:*  Descripci�n: Este activity presenta un ejemplo de RatingBar. Desde diseño el RatinBar esta
:*                inicializado para mostrar 7 estrellas y una estrella marcada, tambien esta
:*                personalizado el color con el que se pintan las estrellas al marcarlas, esto se
:*                logra con los atributos numStars, rating y progressTint respectivamente. Tambien
:*                se configura el atributo stepSize en 0.25 lo que significa que los valores de
:*                rating cambian de 0.25 en 0.25.
:*                El ejemplo permite al usuario inicializar el ratingBar para mostrar determinado
:*                numero de estrellas y marcar una cierta calificacion inicial.
:*                El boton Enviar permite conocer el valor numerico correspondiente al rating marcado.
:*
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/


package mx.edu.itl.c85360673.u9widgetsapp.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import mx.edu.itl.c85360673.u9widgetsapp.R;

public class RatingBarActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private EditText  edtNumEstrellas;
    private EditText  edtValorInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        ratingBar = findViewById (R.id.rbarCalificacion);
        edtNumEstrellas = findViewById ( R.id.edtNumEstrellas );
        edtValorInicial = findViewById ( R.id.edtValorInicial );
    }

    public void btnInicializarClick ( View v ) {
        int numEstrellas = Integer.parseInt ( edtNumEstrellas.getText().toString() );
        float valorInicial = Float.parseFloat ( edtValorInicial.getText().toString() );
        ratingBar.setRating ( valorInicial );
        ratingBar.setNumStars ( numEstrellas );
    }

    public void btnEnviarClick ( View v ) {
        float valRatinBar = ratingBar.getRating();
        Toast.makeText ( this, "Calificacion: " + valRatinBar, Toast.LENGTH_SHORT ).show();
    }
}