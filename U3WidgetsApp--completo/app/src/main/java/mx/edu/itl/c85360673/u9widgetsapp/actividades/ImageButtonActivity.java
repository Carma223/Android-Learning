/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*             Activity con ejemplo de uso del widget ImageButton
:*
:*  Archivo     : U3WidgetsApp.java
:*  Autor       : Luis Fernando Gil Vázquez
:*  Fecha       : 13/10/2022
:*  Compilador  : Android Studio Chipmunk 2021.2.1 + JDK 11
:*  Descripci�n: El ejemplo presenta un widget ImageButton, el cual es identico a un Button pero
:*                permite colocar una imagen dentro de él.
:*                En este ejemplo se usan 2 recursos drawables definidos en archivos XML, el primero
:*                (imagebutton_selector.xml) es un recurso "selector" que permite cambiar la imagen
:*                dependiendo del estado del boton; el segundo (imagebutton_esquinas_redondeadas.xml)
:*                define un recurso shape con determinado color y esquinas redondeadas.
:*                El recurso selector se configura en el atributo scrCompat del ImageButton y el
:*                recurso shape en el atributo background.
:*                Al ejecutar se verá el ImageButton con una imagen determinada por default, si toma
:*                el enfoque cambia la imagen, si se presiona cambia tambien a otra imagen.
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u9widgetsapp.actividades;

import androidx.appcompat.app.AppCompatActivity;
import mx.edu.itl.c85360673.u9widgetsapp.R;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ImageButtonActivity extends AppCompatActivity {

    private ImageButton imageBoton;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_button);

        imageBoton = findViewById ( R.id.imageButton );
        imageBoton.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean enfocado ) {
                if ( enfocado )
                    Toast.makeText ( ImageButtonActivity.this, "ImageButton enfocado",
                                       Toast.LENGTH_SHORT ).show ();
                else
                    Toast.makeText ( ImageButtonActivity.this, "ImageButton sin enfoque",
                                       Toast.LENGTH_SHORT ).show ();
            }
        });
    }

    //----------------------------------------------------------------------------------------------

    public void imgbtnCandadoClick ( View v ) {
        Toast.makeText ( this, "ImageButton presionado", Toast.LENGTH_SHORT ).show ();
    }

    //----------------------------------------------------------------------------------------------

}