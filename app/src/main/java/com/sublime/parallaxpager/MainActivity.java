package com.sublime.parallaxpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.sublime.parallaxpager.utils.ParallaxPageTransformer;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.indicator)
    CircleIndicator circleIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ScreenSlidePagerAdapter mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

        ParallaxPageTransformer pageTransformer = new ParallaxPageTransformer()
                .addViewToParallax(new ParallaxPageTransformer.
                        ParallaxTransformInformation(R.id.iv_background_image, -1, -1))
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.tv_title,0.8f, 0.6f))
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.tv_changes_header,1f, 0.8f))
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.tv_changes,1.5f, 1.0f))
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.btn_continue,0.8f, 0.6f));
        mViewPager.setPageTransformer(true, pageTransformer);
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.addOnPageChangeListener(this);
        circleIndicator.setViewPager(mViewPager);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (position > 2)  circleIndicator.setAlpha(0);
        else circleIndicator.setAlpha(1);
    }

    @Override
    public void onPageSelected(int position) {
        //Do Nothing
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //Do Nothing
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        private static final int MAX_COUNT = 4;

        ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return MAX_COUNT;
        }
    }
}
