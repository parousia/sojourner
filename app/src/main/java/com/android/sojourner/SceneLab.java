package com.android.sojourner;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joseph on 7/18/16.
 */

public class SceneLab {
    private static SceneLab sSceneLab;
    private Context mContext;

    public static SceneLab get(Context context) {
        if (sSceneLab == null) {
            sSceneLab = new SceneLab(context);
        }

        return sSceneLab;
    }

    private SceneLab(Context context) {
        mContext = context;
    }

    public List<Scene> getScenes() {
        List<Scene> scenes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Scene s = new Scene(i);
            if (i < 4) {
                s.setUnlocked(true);
            }
            scenes.add(s);
        }
        return scenes;
    }
}
