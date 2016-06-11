package com.xxAssistant.UI.Configs;

import com.xxAssistant.UI.Factory.ViewFactoty.ViewType;

public class CellConfig {
	public String mChineseText;
	public int mCmdValueType;
	public String mDefault;
	public String mEnglishText;
	public int mMax;
	public int mMin;
	public int mViewId;
	public ViewType mViewType;
	private int mCmd;

	public CellConfig(Object[] values) {
		super();
		this.mViewId = 0;
		this.mCmd = 0;
		this.mCmdValueType = 0;
		this.mEnglishText = "";
		this.mChineseText = "";
		this.mViewType = ViewType.Section;
		this.mMin = 0;
		this.mMax = 1000000;
		this.mDefault = "0";
		this.mViewId = Integer.valueOf(values[0].toString());
		this.mCmd = Integer.valueOf(values[1].toString());
		this.mCmdValueType = Integer.valueOf(values[2].toString());
		this.mEnglishText = values[3].toString();
		this.mChineseText = values[4].toString();
		this.mViewType = (ViewType) values[5];
		this.mMin = Integer.valueOf(values[6].toString());
		this.mMax = Integer.valueOf(values[7].toString());
		this.mDefault = (String) values[8];
	}
}
