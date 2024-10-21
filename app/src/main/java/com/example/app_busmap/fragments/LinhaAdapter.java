package com.example.app_busmap.fragments;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.app_busmap.Linha;
import com.example.app_busmap.dtos.LinhaDTO;
import com.example.app_busmap.fragments.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.app_busmap.databinding.FragmentItemLinhaBinding;

import java.util.List;

public class LinhaAdapter extends RecyclerView.Adapter<LinhaAdapter.ViewHolder> {

    private final List<LinhaDTO> mValues;
    private final Context context;

    public LinhaAdapter(Context context, List<LinhaDTO> items) {
        mValues = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemLinhaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        LinhaDTO linha = mValues.get(position);
        holder.mItem = mValues.get(position);
        holder.numero.setText(linha.getNumero());
        holder.empresa.setText(linha.getEmpresa());
        holder.nomeIda.setText(linha.getNomeIda());
        holder.ver.setOnClickListener((v) -> {
            Intent intent = new Intent(context, Linha.class);
            intent.putExtra("numero", linha.getNumero());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView numero;

        TextView empresa;

       TextView nomeIda;
        LinhaDTO mItem;

        Button ver;

        public ViewHolder(FragmentItemLinhaBinding binding) {
            super(binding.getRoot());
            empresa = binding.empresa;
            nomeIda = binding.nomeId;
            numero = binding.numero;
            ver = binding.verDetalhes;
        }

    }
}