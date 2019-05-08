package idanielsfree.profemale;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private RecyclerView staggeredRv;
    private StaggeredRecyclerAdapter adapter;
    private StaggeredGridLayoutManager manager;
    private Context context;

    public NewsFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_news, container, false);

        staggeredRv = (RecyclerView) rootView.findViewById(R.id.staggered_rv_news);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredRv.setLayoutManager(manager);

        List<row> lst = new ArrayList<>();
        lst.add(new row(R.drawable.img1));
        lst.add(new row(R.drawable.img2));
        lst.add(new row(R.drawable.img3));
        lst.add(new row(R.drawable.img4));
        lst.add(new row(R.drawable.img5));
        lst.add(new row(R.drawable.img6));
        lst.add(new row(R.drawable.img7));
        lst.add(new row(R.drawable.img8));
        lst.add(new row(R.drawable.img9));
        lst.add(new row(R.drawable.img10));
        lst.add(new row(R.drawable.img3));
        lst.add(new row(R.drawable.img4));
        lst.add(new row(R.drawable.img5));
        lst.add(new row(R.drawable.img6));
        lst.add(new row(R.drawable.img7));
        lst.add(new row(R.drawable.img8));
        lst.add(new row(R.drawable.img9));
        lst.add(new row(R.drawable.img10));

        adapter = new StaggeredRecyclerAdapter(getContext(), lst);
        staggeredRv.setAdapter(adapter);

        return rootView;
    }

}
