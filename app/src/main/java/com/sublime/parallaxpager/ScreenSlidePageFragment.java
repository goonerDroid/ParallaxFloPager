package com.sublime.parallaxpager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScreenSlidePageFragment extends Fragment {

    public static final String POSITION = "position";
    private int currentPos;
    private Activity mActivity;

    private int[] imageArray = new int[]{R.drawable.android_oreo, R.drawable.android_nougat,
            R.drawable.android_marshmallow, R.drawable.android_lollipop};

    private String[] titleArray = new String[]{"Android Oreo","Android Nougat","Android Marshmallow",
            "Android Lollipop"};

    private String[] subTitleArray = new String[]{"Released on 21st August,2017","Released on 22nd August,2016","Released on 5th October,2015",
            "Released on 12th November,2014"};


    private String[] changesArray = new String[]{"Picture in Picture support for video","Doze power saving mode","New permissions architecture",
            "Material design"};

    @BindView(R.id.iv_background_image)
    ImageView ivBackgroundImage;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_sub_title)
    TextView tvSubTitle;
    @BindView(R.id.tv_changes)
    TextView tvChanges;
    @BindView(R.id.btn_continue)
    Button btnKnowMore;


    public static ScreenSlidePageFragment newInstance(int position) {
        ScreenSlidePageFragment fragmentFirst = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentPos =  getArguments().getInt(POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivBackgroundImage.setImageResource(imageArray[currentPos]);
        tvTitle.setText(titleArray[currentPos]);
        tvSubTitle.setText(subTitleArray[currentPos]);
        tvChanges.setText("\u2022  ".concat(changesArray[currentPos]));

        if (currentPos == 3)btnKnowMore.setVisibility(View.VISIBLE);
        else btnKnowMore.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.btn_continue)
    public void onKnowMoreClick(){
        Toast.makeText(mActivity,"Your feedback is noted.",Toast.LENGTH_LONG).show();
    }
}