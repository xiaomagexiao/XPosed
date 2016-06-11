package com.game.util;

import android.view.View;

import com.game.ui.index.MainApplication;
import com.xx.XXPluginViewController;
import com.xxAssistant.UI.Configs.Config;

/**
 * power by 小马哥  2016/5/31 21:21
 */
public class StartPlugin {

    public static View getView() {
        Config.loadCellConfig();
        Config.XXLANGUAGE_NOW = 0;
        XXPluginViewController controller = new XXPluginViewController(MainApplication.getInstance(), null, 3f);
        return controller.getPluginParentView();
    }

}
