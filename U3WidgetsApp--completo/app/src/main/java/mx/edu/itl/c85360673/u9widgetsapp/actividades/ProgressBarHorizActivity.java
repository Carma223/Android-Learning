/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 10-11 HRS
:*
:*         Esta clase contiene un progressBar para mostrar un proceso de carga
:*
:*  Archivo     : ProgressBarHorizActivity.java
:*  Autor       : Luis Javier Domínguez Reyes    17130021
:*                Edgar Abraham Pedrueza Duran   17130056
:*  Fecha       : 08/11/2021
:*  Compilador  : Android Studio Artic Fox 2020.3.1 + JDK 11
:*  Descripci�n : por medio del ingreso de los dtaos de usuario y contraseña se comprueba si estos
:*                para posteriormente cargar el proceso del inicio de sesion en caso de que sean
:*                correctos sino solo mostrara que son incorrectas las credenciales
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u9widgetsapp.actividades;

import androidx.appcompat.app.AppCompatActivity;
import mx.edu.itl.c85360673.u9widgetsapp.R;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class ProgressBarHorizActivity extends AppCompatActivity {
    //Se inicializan los componentes que se utilizan en el layout crando objetos sin referencia
    private ProgressBar progressBar;
    private TextView edtUsu, edtCargado;
    private EditText edtCon;
    //Se crea una instancia del objeto Handler
    Handler handler = new Handler();
    //Se inicializa la variable que va registrando el progreso de carga
    int progreso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_horiz);
        //Se le asigna la referencia a los objetos globales con su respectivo id en el layout
        progressBar = findViewById(R.id.progressBar);
        edtUsu = findViewById(R.id.edtUsuario);
        edtCon = findViewById(R.id.edtContrasena);
        edtCargado = findViewById(R.id.edtProgreso);


    }

    public void btnAceptarClick(View v){
        //Se obtiene el texto de los edit text y se guardan en las variables usuario y contrasena
        String usuario = edtUsu.getText().toString();
        String contrasena = edtCon.getText().toString();

        if(usuario.equals("ejemplo")) {//Si usuario y contrasena coinciden con ejemplo se ejecuta un hilo
            if (contrasena.equals("ejemplo")) {
                //Iniciamos el hilo con la accion del progress bar
                new Thread(new Runnable() {
                    @Override
                    public void run() {//Dentro del metodo run se pone el código que ejecutará el hilo
                        while (progreso < 100) { //Mientras que el progreso sea menor que 100 el progreso irá aumentando de 3 en 3
                            progreso = progreso + 3;
                            handler.post(new Runnable() {//Se utiliza el handler post para poder realizar cambios en el UI
                                @Override
                                public void run() {
                                    progressBar.setProgress(progreso);//Se le asigna el progreso actual
                                    if (progreso == 99) { //Si el progreso es igual a 99 se muestra un toast.
                                        progreso = 100;
                                        Toast.makeText(ProgressBarHorizActivity.this, "Inicio de sesion correcta", Toast.LENGTH_LONG).show();
                                    }
                                    edtCargado.setText(progreso + " / " + progressBar.getMax()); //En un edit text se va mostrando el progreso con numeros
                                }
                            });

                            try {
                                //Duerme el hilo por 200 milisegundos (2 segundos)
                                Thread.sleep(200);
                            } catch (InterruptedException e) { //Si se interrumpe el sleep se atrapa la excepcion
                                e.printStackTrace();
                            }
                        }

                    }
                }).start(); //Se inicia el thread con el metodo .start()
            }else{ //Si las credenciales no coinciden se muestra un toast.
                Toast.makeText(ProgressBarHorizActivity.this, "Credenciales Incorrectas", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(ProgressBarHorizActivity.this, "Credenciales Incorrectas", Toast.LENGTH_LONG).show();
        }
    }
}