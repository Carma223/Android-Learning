package mx.edu.itl.c85360673.u3listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MiAdaptador extends ArrayAdapter {

    private Context context;
    private String [] clubes;
    private String [] descripciones;
    private int [] logos;

    public MiAdaptador (Context c, String [] clubes, String [] descripciones, int [] logos){
        super( c, R.layout.list_fila_texto_imagen, R.id.txtvTitulo, clubes);
        context = c;
        this.clubes = clubes;
        this.descripciones = descripciones;
        this.logos = logos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //layoutinflater = LayoutInflater.from(context); otra forma

            convertView = layoutinflater.inflate(R.layout.list_fila_texto_imagen, parent, false);
        }

        ImageView logo = convertView.findViewById(R.id.imgvLogo);
        TextView titulo = convertView.findViewById(R.id.txtvTitulo);
        TextView subtitulo = convertView.findViewById(R.id.txtvSubtitulo);

        logo.setImageResource(logos[position]);
        titulo.setText(clubes[position]);
        subtitulo.setText(descripciones[position]);

        return convertView;
    }
}
