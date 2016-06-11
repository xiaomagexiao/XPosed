package com.xxAssistant.UI.Configs;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;

import com.xx.XXPlugin;
import com.xx.ui.IXXPluginDialogClickListener;
import com.xxAssistant.UI.Factory.SwitchCellView;
import com.xxAssistant.UI.Factory.ViewFactoty.ViewType;

public class Config implements View.OnClickListener {
    public static final int CHINESE = 0;
    public static final int ENGLISH = 1;
    public static final int ID_AUTOSKILL = 3;
    public static final int ID_FASTTALK = 2;
    public static final int ID_SHOWSPEED = 1;
    public static final String SOCKEET_BASE_NAME = "xxp_gjqt";
    private static final String TAG = "Config";
    public static int XXIPCKey_Set_AutoSkill = 0;
    public static int XXIPCKey_Set_FastTalk = 0;
    public static int XXIPCKey_Set_Speed = 0;
    public static int XXIPCKey_Set_dohook = 0;
    public static int XXLANGUAGE_NOW = 0;
    public static SparseArray mCellConfigMap = null;
    public static int xxAboutContentTextSize = 0;
    public static int xxAfterEditTextColor = 0;
    public static int xxBeforeEditTextColor = 0;
    public static String[] xxCancel = null;
    public static int xxCellHeight = 0;
    public static int xxCellTextColor = 0;
    public static int xxCellTextSize = 0;
    public static Object[][] xxCells_Configs = null;
    public static int[][] xxCells_ID = null;
    public static String[] xxDescription = null;
    public static String[] xxFloatIconName = null;
    public static int[] xxFloatIconSize = null;
    public static String[] xxHideView = null;
    public static String[] xxHideViewTip = null;
    public static final boolean xxIsShowAbout = false;
    public static String[] xxOff = null;
    public static int xxOffButtonColor = 0;
    public static String[] xxOk = null;
    public static String[] xxOn = null;
    public static int xxOnButtonColor = 0;
    public static int xxSectionHeight = 0;
    public static int xxSectionTextColor = 0;
    public static int xxSectionTextSize = 0;
    public static String[] xxSections_CH = null;
    public static String[] xxSections_EN = null;
    public static final int xxSwitchOffValue = 0;
    public static final int xxSwitchOnValue = 1;
    public static String[] xxTittle;
    public static int xxTittleTextColor;
    public static int xxTittleTextSize;

    static {
        Config.XXLANGUAGE_NOW = 1;
        Config.xxSections_EN = new String[]{"set"};
        Config.xxSections_CH = new String[]{"设置"};
        Config.XXIPCKey_Set_dohook = 101;
        Config.XXIPCKey_Set_Speed = 102;
        Config.XXIPCKey_Set_FastTalk = 103;
        Config.XXIPCKey_Set_AutoSkill = 104;
        Config.xxCells_ID = new int[][]{new int[]{1, 2, 3}};
        Config.xxCells_Configs = new Object[][]{
                new Object[]{Integer.valueOf(1), Integer.valueOf(Config.XXIPCKey_Set_Speed), Integer.valueOf(1), "Speed up",
                        "战斗加速", ViewType.EditCellBySeekBar, Integer.valueOf(1), Integer.valueOf(5), "1"},
                new Object[]{Integer.valueOf(2), Integer.valueOf(Config.XXIPCKey_Set_FastTalk), Integer.valueOf(1),
                        "Fast Talk", "快捷对话", ViewType.SwitchCell, Integer.valueOf(0), Integer.valueOf(1), "0"},
                new Object[]{Integer.valueOf(3), Integer.valueOf(Config.XXIPCKey_Set_AutoSkill), Integer.valueOf(1),
                        "Auto Skill", "自动释放技能", ViewType.SwitchCell, Integer.valueOf(0), Integer.valueOf(1), "0"}};
        Config.mCellConfigMap = new SparseArray();
        Config.xxFloatIconName = new String[]{"叉叉", "X"};
        Config.xxFloatIconSize = new int[]{13, 22};
        Config.xxTittle = new String[]{"叉叉助手", "XMODGAMES"};
        Config.xxCancel = new String[]{"取消", "Cancel"};
        Config.xxOk = new String[]{"确定", "Ok"};
        Config.xxOn = new String[]{"�?��", "ON"};
        Config.xxOff = new String[]{"关闭", "OFF"};
        Config.xxHideView = new String[]{"隐藏悬浮", "Hide Mod"};
        Config.xxHideViewTip = new String[]{"警告：界面隐藏后，只能在下次游戏启动时再次出现，请确认是否执行该操作",
                "If you hide the sidebar, you can\'t see it anymore at this game time, but the mod is valid."};
        Config.xxDescription = new String[]{
                "1、一键探险：去除VIP3限制。\n2、自动无尽深渊�?\n 使用方法选择�?��或正常或困难后，再输入勇气�?累加数，进入副本-无尽深渊即可自动战斗至设定的勇气值才结束（注意：请勿设置�?，否则会无限战斗至生命�?尽）\n\n3.免战：跳过战斗画面�?",
                "Mod Description"};
        Config.xxOnButtonColor = -16711935;
        Config.xxOffButtonColor = -4210753;
        Config.xxAfterEditTextColor = -16711935;
        Config.xxBeforeEditTextColor = -4210753;
        Config.xxCellTextColor = -1;
        Config.xxCellTextSize = 17;
        Config.xxCellHeight = 45;
        Config.xxSectionTextColor = -4210753;
        Config.xxSectionTextSize = 16;
        Config.xxSectionHeight = 38;
        Config.xxTittleTextColor = -1;
        Config.xxTittleTextSize = 20;
        Config.xxAboutContentTextSize = 18;
    }

    public Config() {
        super();
    }

    public static void autoSetLanguage(Context context) {
        Config.XXLANGUAGE_NOW = context.getResources().getConfiguration().locale.getLanguage().endsWith("zh") ? 0 : 1;
    }

    public static void loadCellConfig() {
        Config.mCellConfigMap.clear();
        int v0;
        for (v0 = 0; v0 < Config.xxCells_Configs.length; ++v0) {
            Config.mCellConfigMap.put(Integer.valueOf(Config.xxCells_Configs[v0][0].toString()), new CellConfig(
                    Config.xxCells_Configs[v0]));
        }

        System.out.println(Config.mCellConfigMap.toString());
    }

    public void onClick(final View view) {

    }

    public void sendCmdAndValueToServerByViewId(int viewId, int value) {
        // XXPlugin.getInstance().getIpcController().send(Config.mCellConfigMap.get(viewId).mCmd,
        // value);
    }
}
