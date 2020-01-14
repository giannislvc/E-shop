package com.nativeboys.eshop.john;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.nativeboys.eshop.R;
import com.nativeboys.eshop.john2.Category;
import com.nativeboys.eshop.john2.ClickListener;
import com.nativeboys.eshop.john2.Item;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends DialogFragment implements ClickListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton addItemButton;
    private Button editProfileButton;
    private FloatingActionButton settingsButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FadeFragmentTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayout = view.findViewById(R.id.profile_tab_layout);
        viewPager = view.findViewById(R.id.profile_view_pager);
        ProfileRVAdapter adapter = new ProfileRVAdapter(getChildFragmentManager());
        adapter.AddFragment(new MyProductsFragment(), "My Products");
        adapter.AddFragment(new MyFavoritesFragment(), "Favorites");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        settingsButton = view.findViewById(R.id.settingsFab);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SettingsActivity().show(getChildFragmentManager(), SettingsActivity.class.getSimpleName());
            }
        });

        addItemButton = view.findViewById(R.id.addItemFab);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AddItemActivity().show(getChildFragmentManager(), AddItemActivity.class.getSimpleName());
            }
        });

        editProfileButton = view.findViewById(R.id.edit_profile_button);
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EditProfileActivity().show(getChildFragmentManager(), EditProfileActivity.class.getSimpleName());
            }
        });

    }

    @Override
    public void onCategoryClick(Category category, ImageView categoryImageView) {

    }

    @Override
    public void onItemClick(Item item, ImageView itemImageView) {
        EditItemActivity.newInstance(item).show(getChildFragmentManager(), EditItemActivity.class.getSimpleName());
    }

    public class ProfileRVAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> FragmentListTitles = new ArrayList<>();

        public ProfileRVAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return FragmentListTitles.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return FragmentListTitles.get(position);
        }

        public void AddFragment(Fragment fragment, String Title) {
            fragmentList.add(fragment);
            FragmentListTitles.add(Title);
        }

    }

}
