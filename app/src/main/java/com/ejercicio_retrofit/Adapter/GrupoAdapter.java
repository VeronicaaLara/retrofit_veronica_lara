package com.ejercicio_retrofit.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ejercicio_retrofit.Grupo.Result;
import com.ejercicio_retrofit.R;

import java.util.ArrayList;
import java.util.List;

public class GrupoAdapter extends RecyclerView.Adapter<GrupoAdapter.GrupoViewHolder> {

    private List<Result> list;
    private Context context;

    public GrupoAdapter(Context context, ArrayList<Result> list) {

        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public GrupoViewHolder onCreateViewHolder( ViewGroup viewGroup, int type) {

        return new GrupoViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_grupo, viewGroup, false));
    }

    @Override
    public void onBindViewHolder( GrupoViewHolder holder, int position) {

        final Result pokemon = list.get(position);
        holder.gname.setText(pokemon.getNombre());

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class GrupoViewHolder extends RecyclerView.ViewHolder {
        TextView gname;


        public GrupoViewHolder(View itemView){
            super(itemView);
            gname = itemView.findViewById(R.id.gruponame);

        }
    }
}
