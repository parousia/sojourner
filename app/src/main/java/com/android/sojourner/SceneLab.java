package com.android.sojourner;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joseph on 7/18/16.
 */

public class SceneLab {
    private static final String TAG = "SceneLab";
    private static final String SCENES_FOLDER = "scenes";
    private static SceneLab sSceneLab;

    private Context mContext;
    private AssetManager mAssetManager;

    public static SceneLab get(Context context) {
        if (sSceneLab == null) {
            sSceneLab = new SceneLab(context);
        }

        return sSceneLab;
    }

    private SceneLab(Context context) {
        mContext = context;
        mAssetManager = context.getAssets();
    }

    public List<Scene> getScenes() {
        return loadScenes();

        /*List<Scene> scenes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Scene s = new Scene(i);
            if (i < 4) {
                s.setUnlocked(true);
            }
            scenes.add(s);
        }
        return scenes;*/
    }

    private List<Scene> loadScenes() {
        List<Scene> scenes = new ArrayList<>();
        try {
            String[] sceneNames = mAssetManager.list(SCENES_FOLDER);
            for (String scenePath : sceneNames) {
                Scene scene = new Scene(scenePath, mAssetManager);
                scenes.add(scene);
            }
        } catch (IOException e) {
            Log.e(TAG, "Error loading scenes");
        }

        return scenes;
    }

    /** Static helper methods **/
    public static String getStringFromFile(String filePath, AssetManager assetManager) {
        String str = "";
        try {
            StringBuilder builder = new StringBuilder();
            InputStream file = assetManager.open(filePath);
            BufferedReader in = new BufferedReader(new InputStreamReader(file, "UTF-8"));

            while ((str = in.readLine()) != null) {
                builder.append(str);
            }
            in.close();

        } catch (IOException e) {
            // Do nothing
        }

        return str;
    }
}
