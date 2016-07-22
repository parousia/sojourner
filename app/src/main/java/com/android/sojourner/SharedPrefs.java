package com.android.sojourner;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by Joseph on 7/19/16.
 */

public class SharedPrefs {
    private static final String PREF_SCENE_NUM = "current_scene";

    public static void setCurrentScene(int i, Context context) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putInt(PREF_SCENE_NUM, i)
                .apply();
    }

    public static Scene getCurrentScene(Context context) {
        int curNum = PreferenceManager.getDefaultSharedPreferences(context)
                .getInt(PREF_SCENE_NUM, 0);
        return SceneLab.get(context).getScene(curNum);
    }
}
