package com.sdtechtop.ui.colorpicker;

import android.graphics.drawable.GradientDrawable;

public class BGColorDrawable extends GradientDrawable
{
	private int bgColor;
	public void setBGColor(int color){
		bgColor=color;
	}
	public int getBGColor(){
		return bgColor;
	}

	@Override
	public void setColor(int argb) {
		setBGColor(argb);
		super.setColor(argb);
	}
	
}
