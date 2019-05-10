package idanielsfree.profemale;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentCategorias extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private List<Categorias> lst_categorias;

    public FragmentCategorias() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.categorias_fragment,container,false);
        recyclerView = v.findViewById(R.id.recyclerview_categorias);
        RecyclerViewAdapter recycler_dapter = new RecyclerViewAdapter(getContext(), lst_categorias);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycler_dapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lst_categorias = new ArrayList<>();
        lst_categorias.add(new Categorias("Imagens", R.drawable.imagens));
        lst_categorias.add(new Categorias("Vídeos", R.drawable.videos));
        lst_categorias.add(new Categorias("Histórias", R.drawable.historias));
        lst_categorias.add(new Categorias("Fanfics", R.drawable.fanfics));
    }
}
