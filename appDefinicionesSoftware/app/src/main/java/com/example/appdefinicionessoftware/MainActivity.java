package com.example.appdefinicionessoftware;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ListView lv_definicionesList;
    SearchView sv_buscar;
    DataBase db;
    ArrayAdapter definicionesArrayAdapter;

    ListaAdaptador adaptador;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_definicionesList = findViewById(R.id.lstv_definiciones);
        sv_buscar = findViewById(R.id.sv_buscar);

        db = new DataBase (MainActivity.this);

        adaptador = new ListaAdaptador(MainActivity.this, db);

        lv_definicionesList.setAdapter(adaptador);
        //------------------------------------------------------------------------------------------
        lv_definicionesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LinearLayout layout = (LinearLayout) MainActivity.this.getLayoutInflater().inflate(R.layout.mostrar_layout, null );

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                TextView txtNombre = layout.findViewById(R.id.txv_mostrarNombre);
                TextView txtSiglas = layout.findViewById(R.id.txv_mostrarSiglas);
                TextView txtDescripcion = layout.findViewById(R.id.txv_mostrarDescripcion);

                DefinicionesModel def = (DefinicionesModel) parent.getItemAtPosition(position);

                txtNombre.setText(def.getNombreDefinicion());
                txtSiglas.setText(def.getSiglasDefinicion());
                txtDescripcion.setText(def.getDescripcionDefinicion());

                builder.setView(layout).setPositiveButton("Regresar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).setNegativeButton("Editar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        LinearLayout layout = (LinearLayout) MainActivity.this.getLayoutInflater().inflate(R.layout.add_edit_layout, null );

                        EditText edtNombre = layout.findViewById(R.id.edt_nombreDefinición);
                        EditText edtSiglas = layout.findViewById(R.id.edt_siglasDefinicion);
                        EditText edtDescripcion = layout.findViewById(R.id.edt_descripciónDefinición);

                        edtNombre.setText(def.getNombreDefinicion());
                        edtSiglas.setText(def.getSiglasDefinicion());
                        edtSiglas.setText(def.getDescripcionDefinicion());

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                        builder.setView(layout).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                DefinicionesModel definicion;

                                String nombre = edtNombre.getText().toString();
                                String siglas = edtSiglas.getText().toString();
                                String descripcion = edtDescripcion.getText().toString();

                                try{
                                    definicion = new DefinicionesModel(-1, nombre, siglas, descripcion);
                                } catch (Exception e){
                                    definicion = new DefinicionesModel(-1, "error", "error", "error");
                                    Toast.makeText(MainActivity.this, "Es necesario rellenar todos los campos", Toast.LENGTH_SHORT).show();
                                }

                                if(definicion.getSiglasDefinicion().equals("error")){
                                    dialogInterface.cancel();
                                }

                                db.editOne(definicion);
                                lv_definicionesList.setAdapter(adaptador);

                            }
                        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Cancelación de editar", Toast.LENGTH_SHORT).show();
                            }
                        }).create().show();


                    }
                }).create().show();

            }
        });
        //------------------------------------------------------------------------------------------
        lv_definicionesList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("¿Deseas eliminar la definición?").setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DefinicionesModel def = (DefinicionesModel) parent.getItemAtPosition(position);
                        db.deleteOne(def);
                        lv_definicionesList.setAdapter(adaptador);
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
                return false;
            }
        });
        //------------------------------------------------------------------------------------------
        sv_buscar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adaptador.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adaptador.getFilter().filter(query);
                return false;
            }
        });

    }
    //----------------------------------------------------------------------------------------------
    public void btn_agregar (View v){
        LinearLayout layout = (LinearLayout) MainActivity.this.getLayoutInflater().inflate(R.layout.add_edit_layout, null );

        EditText edtNombre = layout.findViewById(R.id.edt_nombreDefinición);
        EditText edtSiglas = layout.findViewById(R.id.edt_siglasDefinicion);
        EditText edtDescripcion = layout.findViewById(R.id.edt_descripciónDefinición);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setView(layout).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DefinicionesModel definicion;

                String nombre = edtNombre.getText().toString();
                String siglas = edtSiglas.getText().toString();
                String descripcion = edtDescripcion.getText().toString();

                try{
                    definicion = new DefinicionesModel(-1, nombre, siglas, descripcion);
                } catch (Exception e){
                    definicion = new DefinicionesModel(-1, "error", "error", "error");
                    Toast.makeText(MainActivity.this, "Es necesario rellenar todos los campos", Toast.LENGTH_SHORT).show();
                }

                if(definicion.getSiglasDefinicion().equals("error")){
                    dialogInterface.cancel();
                }

                db.addOne(definicion);
                lv_definicionesList.setAdapter(adaptador);

            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Cancelación de registro", Toast.LENGTH_SHORT).show();
            }
        }).create().show();
    }
//--------------------------------------------------------------------------------------------------

}