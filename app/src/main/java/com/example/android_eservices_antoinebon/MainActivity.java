package com.example.android_eservices_antoinebon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import data.api.CharacterApi;
import data.api.dependencyInjection.DependencyInjection;
import data.api.model.CharacterSearchResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.charDisplay.fragment.CharListFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Things to do on onCreate when launching main activity of the app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init the view pager
        initViewPager();

        /*
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DisposableSingleObserver<CharacterSearchResponse> characterApi = DependencyInjection.getRetrofit().create(CharacterApi.class).getBookSearchResult("rick")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<CharacterSearchResponse>() {

                            @Override
                            public void onSuccess(@NonNull CharacterSearchResponse characterSearchResponse) {
                                System.out.println(characterSearchResponse.getCharacterRmList().get(0));
                            }

                            @Override
                            public void onError(Throwable e) {
                                // handle the error case
                                //Yet, do not do nothing in this app
                                System.out.println(e.toString());
                            }
                        });

            }
        });

         */

    }

    private void initViewPager() {
        viewPager = findViewById(R.id.main_view_pager);

        CharListFragment charListFragmentInstance = CharListFragment.newInstance();
        CharListFragment charListFragmentInstanceGrid = CharListFragment.newInstance();

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            // Need to create a new instance for each tabs (here 2 instance because 2 tabs)
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return charListFragmentInstance;
                }
                return charListFragmentInstanceGrid;
            }

            // I made tab name available in strings to make replace or traduction easier
            @Override
            public CharSequence getPageTitle(int position) {
                if (position == 0) {
                    return getString(R.string.tab_title_linear);
                }
                return getString(R.string.tab_title_grid);
            }


            @Override
            public int getCount() {
                return 2;
            }
        });
    }
}