package idanielsfree.profemale;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<Categorias> data;

    public RecyclerViewAdapter(Context context, List<Categorias> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_categorias, parent, false);
        final MyViewHolder view_holder = new MyViewHolder(view);

        view_holder.item_categorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleciona_activity(view_holder.getAdapterPosition());
            }
        });

        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.descricao.setText(data.get(i).getDescricao());
        holder.foto.setImageResource(data.get(i).getFoto());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout item_categorias;
        private TextView descricao;
        private ImageView foto;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            item_categorias = itemView.findViewById(R.id.categoria_item);
            descricao = itemView.findViewById(R.id.descricao_categoria);
            foto = itemView.findViewById(R.id.img_categoria);
        }
    }

    private void seleciona_activity(int i) {
        if (i == 0) {
            Intent settingsIntent = new Intent(context, ImagensActivity.class);
            context.startActivity(settingsIntent);
        }
    }

}
