package mx.edu.itl.c85360673.gridviewejemplo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnGridViewSencilloClick ( View v ) {
        Intent intent = new Intent( this, GridViewActivity.class );
        startActivity ( intent );
    }

    public void btnAcercaDeClick( View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acerca De")
                .setMessage("U3 GridViewApp v1.0\npor:\nCarlos Antonio Madrigal Trejo 20130053\nene-jun/2023")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }


}
