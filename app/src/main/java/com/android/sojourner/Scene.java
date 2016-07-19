package com.android.sojourner;

/**
 * Created by Joseph on 7/18/16.
 */

public class Scene {
    private int mSceneNumber;
    private String mSlides;
    private String mSceneName;
    private String mChallenge;
    private String mPrayerTips;
    private boolean mIsUnlocked;

    public Scene(String scenePath) {

    }

    public Scene(int number) {
        mSceneNumber = number;
        mSceneName = "Scene " + number;
        mSlides = "This is the description for scene " + number;
        mChallenge = "This is the challenge for scene " + number;
        mPrayerTips = "These are the prayer tips for scene " + number;
    }

    public int getSceneNumber() {
        return mSceneNumber;
    }

    public String getSlides() {
        return mSlides;
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
