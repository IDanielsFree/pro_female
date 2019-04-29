package idanielsfree.profemale;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsAccessorAdapter extends FragmentPagerAdapter {
    public TabsAccessorAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch(i){
            case 0:
                NewsFragment newsFragment = new NewsFragment();
                return newsFragment;
            case 1:
                VideoFragment videoFragment = new VideoFragment();
                return videoFragment;
            case 2:
                ImageFragment imageFragment = new ImageFragment();
                return imageFragment;
            case 3:
                LoreFragment loreFragment = new LoreFragment();
                return loreFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "Principais";
            case 1:
                return "Vídeos";
            case 2:
                return "Imagens";
            case 3:
                return "Histórias";
            default:
                return null;
        }
    }
}
