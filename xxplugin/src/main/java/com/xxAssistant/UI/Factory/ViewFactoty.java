package com.xxAssistant.UI.Factory;

import android.content.Context;
import android.view.View;

import com.xxAssistant.UI.Configs.Config;

public class ViewFactoty {

	public enum ViewType {
		First(0), Section(1), SwitchCell(2), EditCellBySeekBar(3);
		int price;

		ViewType(int p) {
			super.ordinal();
			price = p;
		}

		int showPrice() {
			return price;
		}
	}

	public ViewFactoty() {
		super();
	}

	public static View createView(Context context, float dp, ViewType type, String viewName, int viewId, String defaultValue) {
		View view = null;
		switch (type.ordinal()) {
		case 1: {
			view = new SectionView(context, dp, viewName, viewId);
			break;
		}
		case 2: {
			view = new SwitchCellView(context, dp, viewName, viewId, defaultValue);
			view.setOnClickListener(new Config());
			break;
		}
		case 3:
		case 4: {
			view = new EditCellView(context, dp, viewName, viewId, defaultValue);
			view.setOnClickListener(new Config());
			break;
		}
		case 5: {
			view = new ButtonCellView(context, dp, viewName, viewId, defaultValue);
			view.setOnClickListener(new Config());
			break;
		}
		default: {
			View v8 = null;
			break;
		}
		}

		return view;
	}
}
