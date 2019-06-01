package idanielsfree.profemale;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.net.URI;
import java.util.ArrayList;

public class FragmentPrincipal extends Fragment {

    View v;
    private static final int NUM_COLUMNS = 1;

    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();

    //

    private Button imagens_show;

    public FragmentPrincipal() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.principal_fragment,container,false);

        initElements();

        initImageBitmaps();

        //

        imagens_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsIntent = new Intent(getContext(), ImagensActivity.class);
                startActivity(settingsIntent);
            }
        });

        return v;
    }

    //

    private void initElements() {
        imagens_show = v.findViewById(R.id.principais_imagem_show);
    }

    //

    private void initRecyclerView() {
        RecyclerView recyclerView = v.findViewById(R.id.recyclerview_principais_imagens);
        StaggeredRecyclerViewAdapter staggeredRecyclerViewAdapter = new StaggeredRecyclerViewAdapter(v.getContext(), mNames, mImageUrls);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(staggeredRecyclerViewAdapter);
    }

    private void initImageBitmaps() {

        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/pro-female.appspot.com/o/p_1.png?alt=media&token=d49cf9d3-bbfb-4603-be2f-5445504ef1ec");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/pro-female.appspot.com/o/p_2.png?alt=media&token=48943435-f4bb-4e07-ad2d-b34f46d1fa75");
        mNames.add("Trondheim");

        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/pro-female.appspot.com/o/p_3.png?alt=media&token=61ccc4c1-1640-4df4-9c72-87f579eae0c9");
        mNames.add("Portugal");

        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/pro-female.appspot.com/o/p_4.png?alt=media&token=e8b7f68e-8945-42da-8dda-70294476cb69");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/pro-female.appspot.com/o/p_5.png?alt=media&token=ff94008b-8309-4701-9235-dc71f8f81fbb");
        mNames.add("Mahahual");

        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/pro-female.appspot.com/o/p_6.png?alt=media&token=b7e70331-26a4-4914-8a7a-eb35a68c142a");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/pro-female.appspot.com/o/p_7.png?alt=media&token=8f4b4f0e-277b-4205-b02d-62639f86df9d");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/pro-female.appspot.com/o/p_8.png?alt=media&token=c151037b-27b9-425e-9557-40258f72f217");
        mNames.add("Austrailia");

        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/pro-female.appspot.com/o/p_9.png?alt=media&token=c7a2c4c4-0ee7-4185-a3e3-d67cddbec909");
        mNames.add("Washington");

        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/pro-female.appspot.com/o/p_10.png?alt=media&token=1d623bd8-5d5f-4564-bfe3-4431d84de6ae");
        mNames.add("Washington");


        initRecyclerView();

    }

    //

    public class StaggeredRecyclerViewAdapter extends RecyclerView.Adapter<FragmentPrincipal.StaggeredRecyclerViewAdapter.ViewHolder> {

        private static final String TAG = "StaggeredRecyclerViewAd";
        private ArrayList<String> mNames = new ArrayList<>();
        private ArrayList<String> mImagensUrls = new ArrayList<>();
        private Context mContext;

        public StaggeredRecyclerViewAdapter(Context mContext, ArrayList<String> mNames, ArrayList<String> mImagensUrls) {
            this.mNames = mNames;
            this.mImagensUrls = mImagensUrls;
            this.mContext = mContext;
        }

        @NonNull
        @Override
        public FragmentPrincipal.StaggeredRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_rv_principais, viewGroup, false);
            return new StaggeredRecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull FragmentPrincipal.StaggeredRecyclerViewAdapter.ViewHolder viewHolder, final int i) {
            Log.d(TAG, "onBindViewHolder: Called.");

            RequestOptions requestOptions = new RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background);

            Glide.with(mContext)
                    .load(mImagensUrls.get(i))
                    .apply(requestOptions)
                    .into(viewHolder.image);

            viewHolder.descricao.setText(mNames.get(i));

            viewHolder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: clicked on: " + mNames.get(i));
                    Toast.makeText(mContext, mNames.get(i), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mImagensUrls.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView image;
            TextView descricao;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.image_principais);
                descricao = itemView.findViewById(R.id.descricao_principais);
            }
        }

    }

}
