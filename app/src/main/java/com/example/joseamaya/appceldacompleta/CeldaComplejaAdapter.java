package com.example.joseamaya.appceldacompleta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by joseamaya on 5/3/16.
 */
public class CeldaComplejaAdapter extends ArrayAdapter<JSONObject> {
    public CeldaComplejaAdapter (Context context, int textViewResourseId){
        super(context, textViewResourseId);
    }
    public CeldaComplejaAdapter(Context context, int resourse, List<JSONObject>items){
        super(context,resourse,items);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View celda = convertView;
        if (celda==null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            celda= layoutInflater.inflate(R.layout.celdacompleta,null);
        }

        TextView titulo = (TextView) celda.findViewById(R.id.titulo);
        TextView subtitulo=(TextView) celda.findViewById(R.id.subTitulo);
        NetworkImageView niv= (NetworkImageView)celda.findViewById(R.id.imagen);

        JSONObject elemento=this.getItem(position);
        try {
            titulo.setText(elemento.getString("name"));
            subtitulo.setText(elemento.getString("use"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return celda;
    }


}
