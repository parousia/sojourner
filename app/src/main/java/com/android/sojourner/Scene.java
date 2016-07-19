package com.android.sojourner;

import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;

/**
 * Created by Joseph on 7/18/16.
 */

public class Scene {
    private static final String TAG = "Scene";
    private static final String CHALLENGE = "challenge";
    private static final String SCENE_TEXT = "scene_text";
    private static final String PRAYER_TIP = "prayer_tip";

    private String mAssetPath;
    private int mSceneNumber;
    private String mContents;
    private String mSceneName;
    private String mChallenge;
    private String mPrayerTips;
    private boolean mIsUnlocked = true;

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
                String txt = SceneLab.getStringFromFile(mAssetPath + "/" + file, assets);
                switch (file) {
                    case CHALLENGE:
                        mChallenge = txt;
                        break;
                    case SCENE_TEXT:
                        mContents = txt;
                        break;
                    case PRAYER_TIP:
                        mPrayerTips = txt;
                        break;
                }
            }
        } catch (IOException e) {
            // Log exception
            Log.e(TAG, "Error fetching scene contents: " + scenePath);
        }
    }

    public Scene(int number) {
        mSceneNumber = number;
        mSceneName = "Scene " + number;
        mContents = "This is the description for scene " + number;
        mChallenge = "This is the challenge for scene " + number;
        mPrayerTips = "These are the prayer tips for scene " + number;
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

    public String getContents() {
        return mContents;
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
}
