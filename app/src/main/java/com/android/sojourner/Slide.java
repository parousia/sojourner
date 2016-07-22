package com.android.sojourner;

import android.content.res.AssetManager;

/**
 * Created by Joseph on 7/22/16.
 */

public class Slide {
    private String mContent;
    private String mTitle;
    private String mSubtitle;

    public Slide(String filePath, String title, AssetManager assets) {
        String[] titles = title.split("-");
        mTitle = titles[0];
        mSubtitle = titles[1];
        mContent = SceneLab.getStringFromFile(filePath, assets);
    }

    public String getContent() {
        return mContent;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSubtitle() {
        return mSubtitle;
    }
}
