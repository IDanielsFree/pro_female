package idanielsfree.profemale;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> lst_fragment = new ArrayList<>();
    private final List<String> lst_titles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return lst_fragment.get(i);
    }

    @Override
    public int getCount() {
        return lst_titles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lst_titles.get(position);
    }

    public void AddFragment(Fragment fragment, String title) {
        lst_fragment.add(fragment);
        lst_titles.add(title);
    }
}
