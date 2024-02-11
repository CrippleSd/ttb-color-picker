package com.sdtechtop.ui.colorpicker.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.sdtechtop.ui.colorpicker.ColorPickerDialog;
import com.sdtechtop.ui.colorpicker.OnColorSelectedListener;

public class MainActivity extends Activity{
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
	}
		public void pickColor(View v){
			new ColorPickerDialog(this)
			//.setTitle("Select Background Color")
			.setOnColorSelectListener(new OnColorSelectedListener(){
				@Override
				public void onColorSelected(int color, String hexColor, int[] rgb) {
					((View)findViewById(R.id.mainLinearLayout)).setBackgroundColor(color);
				}
			}).show();
		}
	
}
