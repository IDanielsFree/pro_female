package idanielsfree.profemale;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Layout;
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

import java.util.ArrayList;

public class ImagensActivity extends AppCompatActivity {

    private static final String TAG = "FragmentPrincipal";
    private static final int NUM_COLUMNS = 2;

    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();

    //

    private ArrayList<String> categories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagens);

        initImageBitmaps();
        initCategories();

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: preparing staggered recyclerview.");

        RecyclerView recyclerView = findViewById(R.id.recyclerview_imagens);
        StaggeredRecyclerViewAdapter staggeredRecyclerViewAdapter = new StaggeredRecyclerViewAdapter(this, mNames, mImageUrls);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(staggeredRecyclerViewAdapter);

    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

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

    private void initRecyclerViewCategories() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview_categorias_imagens);
        RecyclerViewAdapterCategories RecyclerViewAdapter = new RecyclerViewAdapterCategories(this, categories);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(RecyclerViewAdapter);
    }

    private void initCategories() {
        categories.add("Quente");
        categories.add("Ultra sensuais");
        categories.add("Friozinho");
        categories.add("Daniel");
        categories.add("Oloco meu!");
        categories.add("WTF!");
        categories.add("My Love...");
        categories.add("I want you");
        categories.add("Sexy");
        categories.add("Fucked");

        initRecyclerViewCategories();
    }

    //

    public class StaggeredRecyclerViewAdapter extends RecyclerView.Adapter<StaggeredRecyclerViewAdapter.ViewHolder> {

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
        public StaggeredRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_rv_imagens, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull StaggeredRecyclerViewAdapter.ViewHolder viewHolder, final int i) {
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
                image = itemView.findViewById(R.id.image_imagens);
                descricao = itemView.findViewById(R.id.descricao_imagens);
            }
        }

    }

    ////

    public class RecyclerViewAdapterCategories extends RecyclerView.Adapter<RecyclerViewAdapterCategories.ViewHolderCategories> {

        private ArrayList<String> categories = new ArrayList<>();
        private Context context;

        public RecyclerViewAdapterCategories(Context context, ArrayList<String> categories) {
            this.categories = categories;
            this.context = context;
        }

        @NonNull
        @Override
        public ViewHolderCategories onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_rv_imagens_categorias, viewGroup, false);
            return new ViewHolderCategories(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolderCategories holder, int i) {
            holder.botao_categoria.setText(categories.get(i));

            holder.botao_categoria.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, holder.botao_categoria.getText(), Toast.LENGTH_LONG).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return categories.size();
        }

        public class ViewHolderCategories extends RecyclerView.ViewHolder {

            Button botao_categoria;

            public ViewHolderCategories(View itemView) {
                super(itemView);
                botao_categoria = itemView.findViewById(R.id.categorias_imagens_button);
            }

        }

    }

}
