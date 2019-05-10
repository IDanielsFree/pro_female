package idanielsfree.profemale;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentPrincipal extends Fragment {

    View v;
    RecyclerView recycler_view;

    public FragmentPrincipal() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.principal_fragment,container,false);

        recycler_view = v.findViewById(R.id.recyclerview_principais);
        Bitmap[] bitmaps = getBitmaps();
        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(bitmaps);
        recycler_view.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recycler_view.setAdapter(myRecyclerAdapter);
        return v;
    }

    private Bitmap[] getBitmaps() {
        Bitmap[] tempBitMaps = new Bitmap[10];
        tempBitMaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.p_1);
        tempBitMaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.p_2);
        tempBitMaps[2] = BitmapFactory.decodeResource(getResources(), R.drawable.p_3);
        tempBitMaps[3] = BitmapFactory.decodeResource(getResources(), R.drawable.p_4);
        tempBitMaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.p_5);
        tempBitMaps[5] = BitmapFactory.decodeResource(getResources(), R.drawable.p_6);
        tempBitMaps[6] = BitmapFactory.decodeResource(getResources(), R.drawable.p_7);
        tempBitMaps[7] = BitmapFactory.decodeResource(getResources(), R.drawable.p_8);
        tempBitMaps[8] = BitmapFactory.decodeResource(getResources(), R.drawable.p_9);
        tempBitMaps[9] = BitmapFactory.decodeResource(getResources(), R.drawable.p_10);

        return tempBitMaps;
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<GridHolder> {

        Bitmap[] bitmaps;

        public MyRecyclerAdapter(Bitmap[] bitmaps) {
            this.bitmaps = bitmaps;
        }

        @NonNull
        @Override
        public GridHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.grid_rv, viewGroup, false);
            return new GridHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull GridHolder gridHolder, int i) {
            gridHolder.image_view.setImageBitmap(bitmaps[i]);
            gridHolder.text_view.setText("Putaria: " + i);
        }

        @Override
        public int getItemCount() {
            return bitmaps.length;
        }
    }

    private class GridHolder extends RecyclerView.ViewHolder{
        ImageView image_view;
        TextView text_view;
        public GridHolder(@NonNull View itemView) {
            super(itemView);
            image_view = itemView.findViewById(R.id.image);
            text_view = itemView.findViewById(R.id.descricao);
        }
    }
}
