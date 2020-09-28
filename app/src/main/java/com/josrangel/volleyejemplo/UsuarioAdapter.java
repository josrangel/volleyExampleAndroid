package com.josrangel.volleyejemplo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UsuarioAdapter extends BaseAdapter {

    Context context;
    ArrayList<Usuario> usuarios;
    static final String EXTRA_USUARIO="usuario";

    UsuarioAdapter(Context context, ArrayList<Usuario> usuarios){
        this.context = context;
        this.usuarios = usuarios;

    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int position) {
        return usuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_alumno,parent,false);
        }
        TextView tvUserId = convertView.findViewById(R.id.tvUserId);
        TextView tvId = convertView.findViewById(R.id.tvId);
        TextView tvCompletado = convertView.findViewById(R.id.tvCompletado);
        TextView tvTitulo = convertView.findViewById(R.id.tvTitulo);

        int userId=usuarios.get(position).getUserId();
        int id=usuarios.get(position).getId();
        String title =usuarios.get(position).getTitle();
        Boolean completado =usuarios.get(position).isCompletado();

        tvUserId.setText(String.valueOf(userId));
        tvId.setText(String.valueOf(id));
        tvTitulo.setText(title);
        tvCompletado.setText(completado.toString());

        final int posicion = position;

        tvUserId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,UsuarioDetalleActivity.class);
                i.putExtra(EXTRA_USUARIO,usuarios.get(posicion));
                context.startActivity(i);
            }
        });

        return convertView;
    }
}
