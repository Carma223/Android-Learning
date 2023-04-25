/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2023    HORA: 08-09 HRS
:*
:*     Activity que muetra los cuadros de mensaje mediente Toast, Snackbar y AlertDialog
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Carlos Antonio Madrigal Trejo 20130053
:*  Fecha       : 23/02/2023
:*  Compilador  : Android Studio Electric Eel 2022.1
:*  Descripci�n : Este activity despliega un menú de botones, cada uno de los botones muestra
		  diferentes cuadros de texto, entre los cuales se encuentran:
			1.Toast corto
			2.Toast largo
			3.Snackbar corto
			4.Alert simple
			5.Alert con botón OK
			6.Alert con botones OK y Cancel
			7.Alert con lista de opciones (botones de radio), selección unica
			8.Alert con lista de opciones (checkboxes), selección multiple
			9.Alert Acerca De
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/
package mx.itlalaguna.c20130053.u2cuadrosdemensajesapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //----------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //----------------------------------------------------------------------------------------------
    //Toast de duración corta
    public void btn_ToastCortoClick (View v)
    {
        Toast.makeText(this, "Este es un toast corto", Toast.LENGTH_SHORT).show();
    }
    //----------------------------------------------------------------------------------------------
    public void btn_ToastLargoClick (View v)
    {
        Toast.makeText( this, "Este es un toast largo man", Toast.LENGTH_LONG).show();
    }
    //----------------------------------------------------------------------------------------------
    public void btn_AlertSimpleClick (View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder ( this);
        builder.setMessage("Esta es una alerta de conchesumare")
                .create()
                .show();
    }
    //----------------------------------------------------------------------------------------------
    public void btn_SnackBarClick (View v)
    {
        Snackbar barraDeBotanas = Snackbar.make( v, "Soy una barra de botanas", Snackbar.LENGTH_LONG);
        barraDeBotanas.show();
    }
    //----------------------------------------------------------------------------------------------
    //Mensaje de alert con botón OK
    public void btn_AlertSimpleOk (View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Android").setMessage("Alert con botón OK").setPositiveButton("OK",
                new DialogInterface.OnClickListener() { //Se crea un nuevo DialogInterface que estará a la espera de una acción
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Se especifica la acción que realizará al presionar OK
                mostrarToast("Diste clic en ok");
                dialogInterface.dismiss();//Metodo para cerrar el alert
            }
        }).setCancelable(false).create().show();
    }
    //----------------------------------------------------------------------------------------------
    public void btn_AlertSimpleOkCancel (View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Android").setMessage("Alert con botón OK y Cancel").setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mostrarToast("Diste clic en ok");
                        dialogInterface.dismiss();
                    }
                }).setNegativeButton("Canel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mostrarToast("Diste clic en cancel");
                        dialogInterface.dismiss();
                    }
                }).setCancelable(false).create().show();
                //.setCancelable impide que se cierre el dialogo al momento de clickear fuera de el
    }
    //----------------------------------------------------------------------------------------------
    private CharSequence [] opciones = {"Verde", "Blanco", "Rojo"};
    public void btn_AlertListaOpcionesSimple (View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona una opción").setItems(opciones,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mostrarToast("Seleccionó: " + opciones[i]);
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }
    //----------------------------------------------------------------------------------------------
    //Mensaje de alert con lista de opciones radio button
    private int opcionSeleccionada = 2;//Opcion default Rojo
    public void btn_AlertListaOpcionesRadio (View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona una opción: ").setSingleChoiceItems(opciones, opcionSeleccionada,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        opcionSeleccionada = i;
                        mostrarToast("Seleccionó: " + opciones[i]);
                    }
                }).setPositiveButton("Aceptar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mostrarToast("Color Seleccionado: " +
                                opciones[opcionSeleccionada]);
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }
    //----------------------------------------------------------------------------------------------
    //Mensaje con lista de casillas de verificacion seleccion multiple
    private boolean [] default_seleccionados = {true,false,true};
    private ArrayList<String> coloresFavoritos = new ArrayList<>();
    public void btn_ListaChkboxSelecMultiple( View v )
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Select favorite colors").setMultiChoiceItems(
                opciones, //Opciones que se desplegaran
                default_seleccionados,//Arreglos de booleans con opciones seleccionadas
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {//boolean represents if an item is selected by the user
                        if ( b ){
                            //The option was selected as favorite
                            coloresFavoritos.add(opciones[i].toString());
                            mostrarToast("Marcado: " + opciones[i] );
                        } else {
                            coloresFavoritos.remove(opciones[i].toString());
                            mostrarToast("Desmarcado: " + opciones[i] );
                        }
                    }
                }
        ).setPositiveButton("Aceptar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        coloresFavoritos.clear();
                        for( int j = 0; j < default_seleccionados.length; j++){
                            if( default_seleccionados[j] == true) coloresFavoritos.add(opciones[j].toString());
                        }
                        mostrarToast("Colores favoritos: " + coloresFavoritos );
                        dialogInterface.dismiss();
                    }
                }).setNegativeButton("Cancelar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //just closes
                    }
                }).create().show();
    }
    //----------------------------------------------------------------------------------------------
    public void btn_alertLayoutIncrustado (View v){

        LinearLayout layout = (LinearLayout)this.getLayoutInflater().inflate(R.layout.login_layout, null);

        EditText edtUsuario = layout.findViewById(R.id.edt_Usuario);//Encuentra un elemento por el ID dentro del layout
        EditText edtContrasena = layout.findViewById(R.id.edt_Contraseña);//Encuentra un elemento por el ID dentro del layout

        AlertDialog.Builder builder = new AlertDialog.Builder (this);

        builder.setView(layout).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Recuperar el usuario y contrasena capturados por el usuario y mostrarlo en un toast
                String usuario = edtUsuario.getText().toString();
                String contrasena = edtContrasena.getText().toString();

                mostrarToast("Bienvenido: " + usuario + "[" + contrasena + "]");
                dialogInterface.dismiss();


            }
        }).setNegativeButton("Canelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mostrarToast("Se cancelo el login");
            }
        }).create().show();
    }
    //----------------------------------------------------------------------------------------------
    public void btn_acercaDe( View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("ACERCA DE LA APP").setIcon(R.drawable.logotec)
                .setMessage("U2CuadrosDeMensajeApp v1.0 \n" +
                        "por: Carlos Antonio Madrigal Trejo 20130053 \n" +
                        "Ene-Jun/2023\n").setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mostrarToast("Gracias por usar la app!");
                                dialogInterface.dismiss();
                            }
                        }).create().show();
    }
    public void mostrarToast (String mensaje){ //Función para mostrar un toast
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
    //----------------------------------------------------------------------------------------------
}
