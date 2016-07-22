package com.android.sojourner;

import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joseph on 7/18/16.
 */

public class Scene {
    private static final String TAG = "Scene";
    private static final String CHALLENGE = "challenge";
    private static final String SCENE_TEXTS = "scene_texts";
    private static final String PRAYER_TIP = "prayer_tip";

    private String mAssetPath;
    private List<Slide> mSlides;
    private int mSceneNumber;
    private String mSceneName;
    private String mChallenge;
    private String mPrayerTips;
    private boolean mIsUnlocked = true;

    /***
     * Constructor for Scene from asset path
     */
    public Scene(String scenePath, AssetManager assets) {
        // Get name and number
        mAssetPath = "scenes/" + scenePath;
        String[] names = scenePath.split("-");
        mSceneNumber = Integer.parseInt(names[0]);
        mSceneName = names[1];

        // Get scene contents
        try {
            String[] sceneContents = assets.list(mAssetPath);
            for (String file : sceneContents) {
                String assetPath = mAssetPath + "/" + file;
                switch (file) {
                    case SCENE_TEXTS:
                        // Create slides from each of the slides
                        mSlides = new ArrayList<>();
                        String[] slides = assets.list(assetPath);
                        for (String slidePath : slides) {
                            Slide slide = new Slide(assetPath + "/" + slidePath, slidePath, assets);
                            mSlides.add(slide);
                        }
                        break;
                    case CHALLENGE:
                        // Get challenge
                        mChallenge = SceneLab.getStringFromFile(assetPath, assets);
                        break;
                    case PRAYER_TIP:
                        // Get prayer tips
                        mPrayerTips = SceneLab.getStringFromFile(assetPath, assets);
                        break;
                }
            }
        } catch (IOException e) {
            // Log exception
            Log.e(TAG, "Error fetching scene contents: " + scenePath);
        }
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public void setAssetPath(String assetPath) {
        mAssetPath = assetPath;
    }

    public int getSceneNumber() {
        return mSceneNumber;
    }

    public String getSceneName() {
        return mSceneName;
    }

    public String getChallenge() {
        return mChallenge;
    }

    public String getPrayerTips() {
        return mPrayerTips;
    }

    public void setUnlocked(boolean unlocked) {
        mIsUnlocked = unlocked;
    }

    public boolean isUnlocked() {
        return mIsUnlocked;
    }

    public List<Slide> getSlides() {
        return mSlides;
    }

    public void setSlides(List<Slide> slides) {
        mSlides = slides;
    }
}
