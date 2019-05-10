package idanielsfree.profemale;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewpager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicia_elementos();

        //SendUserToSettingsActivity();

    }

    //Ações

    private void SendUserToSettingsActivity() {
        Intent settingsIntent = new Intent(MainActivity.this, Login.class);
        settingsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(settingsIntent);
        finish();
    }

    //Starters

    private void inicia_elementos() {

        tablayout = findViewById(R.id.tablayout);
        viewpager = findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new FragmentImagens(), "");
        adapter.AddFragment(new FragmentVideos(), "");
        adapter.AddFragment(new FragmentHistorias(), "");

        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);

        tablayout.getTabAt(0).setIcon(R.drawable.ic_photo);
        tablayout.getTabAt(1).setIcon(R.drawable.ic_video);
        tablayout.getTabAt(2).setIcon(R.drawable.ic_books);

        //

    }
}
