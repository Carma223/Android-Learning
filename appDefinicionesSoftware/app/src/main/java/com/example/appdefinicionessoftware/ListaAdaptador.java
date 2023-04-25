package com.example.appdefinicionessoftware;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListaAdaptador extends BaseAdapter implements Filterable {

    Activity mActivity;
    DataBase db;


    public ListaAdaptador(Activity mActivity, DataBase db) {
        this.mActivity = mActivity;
        this.db = db;
    }

    @Override
    public int getCount() {
        return db.getDefiniciones().size();
    }

    @Override
    public DefinicionesModel getItem(int position) {
        return db.getDefiniciones().get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View definicionesLinea;
        LayoutInflater inflater = (LayoutInflater)mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        definicionesLinea = inflater.inflate(R.layout.definiciones_una_linea, parent, false);

        TextView tv_nombreDefinicion = definicionesLinea.findViewById(R.id.tv_NombreDefinicion);
        TextView tv_siglasDefinicion = definicionesLinea.findViewById(R.id.tv_SiglasDefinicion);

        DefinicionesModel def = this.getItem(position);
        tv_nombreDefinicion.setText(def.getNombreDefinicion());
        tv_siglasDefinicion.setText(def.getSiglasDefinicion());

        return definicionesLinea;
    }


    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0){
                    filterResults.count = db.getDefiniciones().size();
                    filterResults.values = db.getDefiniciones();

                }else{
                    List<DefinicionesModel> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for(DefinicionesModel itemsModel:db.getDefiniciones()){
                        if(itemsModel.getNombreDefinicion().contains(searchStr)){
                            resultsModel.add(itemsModel);

                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }


                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                //db.getDefiniciones() = (List<DefinicionesModel>) results.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }
}
