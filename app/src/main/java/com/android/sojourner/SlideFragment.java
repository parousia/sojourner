package com.android.sojourner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Joseph on 7/22/16.
 */

public class SlideFragment extends Fragment {
    private static final String ARG_SLIDE_NUMBER = "arg_slide_number";

    private SlideContainer mSlideContainer;
    private Slide mSlide;
    private TextView mTitleTextView;
    private TextView mSubtitleTextView;
    private TextView mContentTextView;

    /********
     * Interface to get slides from scene
     ********/
    public interface SlideContainer {
        Slide getSlideFromContainer(int slideNum);
    }

    public void setSlideContainer(SlideContainer container) {
        mSlideContainer = container;
    }

    /*****
     * New Intent method
     *****/
    public static SlideFragment newInstance(int slideNum) {
        Bundle args = new Bundle();
        args.putInt(ARG_SLIDE_NUMBER, slideNum);

        SlideFragment fragment = new SlideFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /*****
     * Public Activity Methods
     *****/
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve current slide
        Bundle args = getArguments();
        int slideNum = 0;
        if (args != null) {
            slideNum = args.getInt(ARG_SLIDE_NUMBER);
        }
        mSlide = mSlideContainer.getSlideFromContainer(slideNum);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_slide, container, false);

        mTitleTextView = (TextView) v.findViewById(R.id.slide_title);
        mTitleTextView.setText(mSlide.getTitle());

        mSubtitleTextView = (TextView) v.findViewById(R.id.slide_subtitle);
        mSubtitleTextView.setText(mSlide.getSubtitle());

        mContentTextView = (TextView) v.findViewById(R.id.slide_content);
        mContentTextView.setText(mSlide.getContent());

        return v;
    }
}
