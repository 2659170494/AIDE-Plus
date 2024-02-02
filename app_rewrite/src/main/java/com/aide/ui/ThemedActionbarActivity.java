package com.aide.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.aide.ui.rewrite.R;
import io.github.zeroaicy.aide.preference.ZeroAicySetting;

public class ThemedActionbarActivity extends Activity {


    @Override
    protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);

		enableFollowSystem(false);
		if (ZeroAicySetting.isLightTheme()) {
			setTheme(R.style.ActivityActionbarThemeLight);
		}
		else {
			setTheme(R.style.ActivityActionbarThemeDark);
		}
    }

	@Override
	protected void onResume() {
		super.onResume();
		enableFollowSystem(true);
	}

	@Override
	public void onConfigurationChanged(Configuration configuration) {
		super.onConfigurationChanged(configuration);
		//*
		enableFollowSystem(true);
		//*/
	}

	private void enableFollowSystem(boolean recreate) {
		if (ZeroAicySetting.enableFollowSystem()) {
			if (ZeroAicySetting.isNightMode(this)) {
				if (ZeroAicySetting.isLightTheme()) {
					//修改主题为暗主题
					ZeroAicySetting.setLightTheme(false);
					if( recreate ) recreate();
				}
			}
			else {
				if (!ZeroAicySetting.isLightTheme()) {
					//修改主题为亮主题
					ZeroAicySetting.setLightTheme(true);
					if( recreate ) recreate();
				}
			}
		}
	}

}

