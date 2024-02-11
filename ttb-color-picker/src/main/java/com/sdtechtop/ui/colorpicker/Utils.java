package com.sdtechtop.ui.colorpicker;

import android.app.Activity;

public class Utils
{
	private static Activity activity;
	public static void setActivity(Activity act){
		activity=act;
	}
	public static Activity getActivity(){
		return activity;
	}
}
