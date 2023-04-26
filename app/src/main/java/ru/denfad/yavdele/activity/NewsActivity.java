package ru.denfad.yavdele.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

import ru.denfad.yavdele.R;
import ru.denfad.yavdele.ui.EventsFragment;
import ru.denfad.yavdele.ui.TeamsFragment;
import ru.denfad.yavdele.ui.UsersFragment;

public class NewsActivity extends AppCompatActivity {

    private final List<String> pages = List.of("События", "Команды", "Люди");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ViewPager2 pager = findViewById(R.id.pager);
        pager.setAdapter(new DemoCollectionAdapter(this));
        TabLayout tab = findViewById(R.id.news_tab);
        new TabLayoutMediator(tab, pager,
                (tabLayout, position) -> tabLayout.setText(pages.get(position))
        ).attach();


    }

    public class DemoCollectionAdapter extends FragmentStateAdapter {


        public DemoCollectionAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            // Return a NEW fragment instance in createFragment(int)
            switch (position) {
                case 0:
                    return new EventsFragment();
                case 1:
                    return new TeamsFragment();
                case 2:
                    return new UsersFragment();
                default:
                    return new EventsFragment();
            }

        }

        @Override
        public int getItemCount() {
            return pages.size();
        }
    }

    // Instances of this class are fragments representing a single
// object in our collection.

}