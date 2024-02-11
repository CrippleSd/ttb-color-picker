package com.sdtechtop.ui.colorpicker;

import android.app.Activity; 
import android.app.AlertDialog; 
import android.content.Context; 
import android.content.DialogInterface; 
import android.content.res.Resources; 
import android.graphics.Color; 
import android.graphics.drawable.ColorDrawable; 
import android.graphics.drawable.GradientDrawable; 
import android.text.ClipboardManager;
import android.view.Gravity;
import android.view.LayoutInflater; 
import android.view.View; 
import android.view.ViewGroup; 
import android.view.ViewParent; 
import android.widget.Button; 
import android.widget.TableRow; 
import android.widget.Toast;
import com.sdtechtop.ui.colorpicker.BGColorDrawable; 
import com.sdtechtop.ui.colorpicker.COLORS; 
import com.sdtechtop.ui.colorpicker.OnColorSelectedListener; 
import com.sdtechtop.ui.colorpicker.R;
import com.sdtechtop.ui.colorpicker.Utils; 
import com.sdtechtop.utils.ColorUtil; 



public class ColorPickerDialog extends Object implements View.OnClickListener {
	private Activity mActivity;
	private String mHexColor;
	private View mColorView;
	private String mTitle="";
	private int sltColorId,mainSltId;
	private View[] mColors;
	private String[] mainColorsHex;
	private View[] mainColors;
	private TableRow A_Colors_Row;
	private View.OnClickListener colorClickHandler;
	private OnColorSelectedListener mlistener;
	private AlertDialog.Builder mDialog;
	private View.OnLongClickListener colorLongClickHandler;
	public ColorPickerDialog(Activity activity) {
		this.mActivity = activity;
		mColorView = mActivity.getLayoutInflater().inflate(R.layout.color_picker, null, false);
		Utils.setActivity(activity);
		mDialog = new AlertDialog.Builder(mActivity);
		initView();
	}

	private void initView() {
		mainColorsHex = COLORS.redColors;
		A_Colors_Row = mColorView.findViewById(R.id.main_colors_A_Row);
		colorClickHandler = new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				mainSltId = v.getId();
				checkMainColors(mainColors);
				checkMainSelected(mainColors);
				mHexColor = ColorUtil.asHexColor(( (BGColorDrawable)v.getBackground() ).getBGColor()).toUpperCase();
			}
		};
		colorLongClickHandler = new View.OnLongClickListener(){

			@Override
			public boolean onLongClick(View v) {
				String color = ColorUtil.asHexColor(( (BGColorDrawable)v.getBackground() ).getBGColor()).toUpperCase();
				ClipboardManager cm = (ClipboardManager) mActivity.getSystemService(Context.CLIPBOARD_SERVICE);
				cm.setText(color);
				Toast toast = Toast.makeText(mActivity,color +" Copied to Clipboard!",0);
				toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL,0,0);
				toast.show();
				return true;
			}
		};
		setUpColors();
		setUpMainColors();
		mHexColor = ColorUtil.asHexColor(( (BGColorDrawable)mainColors[5].getBackground() ).getBGColor()).toUpperCase();
		
	}

	public ColorPickerDialog setTitle(String title) {
		mTitle = title;
		return this;
	}
	public ColorPickerDialog setOnColorSelectListener(OnColorSelectedListener listener) {
		this.mlistener = listener;
		return this;
	}
	public ColorPickerDialog show() {
		if (mTitle.length() < 2) {
			mTitle="TTB Color Picker";
		}
		
		mDialog.setTitle(mTitle);
		mDialog.setView(mColorView);
		mDialog.setCancelable(false);
		mDialog.setNegativeButton("Cancel", null);
		mDialog.setPositiveButton("Select", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int whichButton) {
				if (mlistener != null) {
					mlistener.onColorSelected(ColorUtil.asColor(mHexColor), mHexColor, ColorUtil.asRGB(mHexColor));
				}
				dialog.dismiss();
			}
		});
		mDialog.show();
		return this;
	}
	private void setUpColors() {
		Button 
		blue = mColorView.findViewById(R.id.head_color_blue),
		amber = mColorView.findViewById(R.id.head_color_amber),
		blueGrey = mColorView.findViewById(R.id.head_color_blue_grey),
		brown = mColorView.findViewById(R.id.head_color_brown),
		cyan = mColorView.findViewById(R.id.head_color_cyan),
		deepOrange = mColorView.findViewById(R.id.head_color_deep_orange),
		deepPurple = mColorView.findViewById(R.id.head_color_deep_purple),
		grey = mColorView.findViewById(R.id.head_color_grey),
		green = mColorView.findViewById(R.id.head_color_green),
		indigo = mColorView.findViewById(R.id.head_color_indigo),
		lightBlue = mColorView.findViewById(R.id.head_color_light_blue),
		lightGreen = mColorView.findViewById(R.id.head_color_light_green),
		lime = mColorView.findViewById(R.id.head_color_lime),
		orange = mColorView.findViewById(R.id.head_color_orange),
		pink = mColorView.findViewById(R.id.head_color_pink),
		purple = mColorView.findViewById(R.id.head_color_purple),
		red = mColorView.findViewById(R.id.head_color_red),
		teal = mColorView.findViewById(R.id.head_color_teal),
		yellow = mColorView.findViewById(R.id.head_color_yellow);
		blue.setBackgroundColor(asColor(R.color.blue_500));
		amber.setBackgroundColor(asColor(R.color.amber_500));
		blueGrey.setBackgroundColor(asColor(R.color.blue_grey_500));
		brown.setBackgroundColor(asColor(R.color.brown_500));
		cyan.setBackgroundColor(asColor(R.color.cyan_500));
		deepOrange.setBackgroundColor(asColor(R.color.deep_orange_500));
		deepPurple.setBackgroundColor(asColor(R.color.deep_purple_500));
		grey.setBackgroundColor(asColor(R.color.grey_500));
		green.setBackgroundColor(asColor(R.color.green_500));
		indigo.setBackgroundColor(asColor(R.color.indigo_500));
		lightBlue.setBackgroundColor(asColor(R.color.light_blue_500));
		lightGreen.setBackgroundColor(asColor(R.color.light_green_500));
		lime.setBackgroundColor(asColor(R.color.lime_500));
		orange.setBackgroundColor(asColor(R.color.orange_500));
		pink.setBackgroundColor(asColor(R.color.pink_500));
		purple.setBackgroundColor(asColor(R.color.purple_500));
		red.setBackgroundColor(asColor(R.color.red_500));
		teal.setBackgroundColor(asColor(R.color.teal_500));
		yellow.setBackgroundColor(asColor(R.color.yellow_500));
		sltColorId = red.getId();
		mColors = new View[]{amber,blue,blueGrey,brown,cyan,deepOrange,deepPurple,grey,green,red,yellow,indigo,lightBlue,lightGreen,lime,orange,pink,purple,red,teal};
		setUpCircle(amber, blue, blueGrey, brown, cyan, deepOrange, deepPurple, grey, green, red, yellow, indigo, lightBlue, lightGreen, lime, orange, pink, purple, red, teal);
	}
	private int asColor(int id) {
		return mActivity.getResources().getColor(id);
	}
	private void setUpCircle(View... colors) {
		for (View v : colors) {
			v.setBackground(asColorDrawable(v));
			v.setOnClickListener(this);
			if (v.getId() == sltColorId) {
				setSelectedBg(v);
			} else {
				rmBackground(v);
			}
		}
	}
	private BGColorDrawable asColorDrawable(View view) {
		int color = Color.parseColor("#F44336");
		if (view.getBackground() instanceof ColorDrawable) {
			color = ( (ColorDrawable)view.getBackground() ).getColor();
		} else if (view.getBackground() instanceof BGColorDrawable) {
			color = ( (BGColorDrawable)view.getBackground() ).getBGColor();
		}
		BGColorDrawable bgcolor = new BGColorDrawable();
		bgcolor.setColor(color);
		bgcolor.setShape(GradientDrawable.OVAL);
		bgcolor.setStroke(1, Color.BLACK);
		return bgcolor;
	}

	@Override
	public void onClick(View v) {
		sltColorId = v.getId();
		checkSelected(mColors);
		checkSltMainColors(sltColorId);
		checkMainColors(mainColors);
		View slt = mColorView.findViewById(mainSltId);
		slt.performClick();
	}
	private void setUpMainCircle(View... colors) {
		for (View v : colors) {
			v.setBackground(asColorDrawable(v));
			v.setOnClickListener(colorClickHandler);
			if (v.getId() == mainSltId) {
				setSelectedBg(v);
			} else {
				rmBackground(v);
			}
		}
	}
	private BGColorDrawable asSelectedColor(View view) {
		int color = Color.parseColor("#F44336");
		if (view.getBackground() instanceof ColorDrawable) {
			color = ( (ColorDrawable)view.getBackground() ).getColor();
		} else if (view.getBackground() instanceof BGColorDrawable) {
			color = ( (BGColorDrawable)view.getBackground() ).getBGColor();
		}
		BGColorDrawable bgcolor = new BGColorDrawable();
		bgcolor.setBGColor(color);
		bgcolor.setStroke(4, color);
		bgcolor.setShape(GradientDrawable.OVAL);
		return bgcolor;
	}
	private void rmBackground(View v) {
		if (v.getParent() instanceof ViewGroup) {
			View view = ( (ViewGroup)v.getParent() );
			view.setBackgroundColor(asColor(android.R.color.transparent));
		}
	}
	private void setSelectedBg(View v) {
		if (v.getParent() instanceof ViewGroup) {
			View view = ( (ViewGroup)v.getParent() );
			view.setBackground(asColorDrawable(v));
			view.setBackground(asSelectedColor(view));
		}
	}
	private void checkSelected(View... views) {
		for (View v : views) {
			if (v.getId() == sltColorId) {
				setSelectedBg(v);
			} else {
				rmBackground(v);
			}
		}
	}
	private void checkMainSelected(View... views) {
		for (View v : views) {
			if (v.getId() == mainSltId) {
				setSelectedBg(v);
			} else {
				rmBackground(v);
			}
		}
	}
	private int asColor(String hex) {
		return Color.parseColor(hex);
	}
	private void setUpMainColors() {
		Button
		C50=mColorView.findViewById(R.id.main_color_50),
		C100=mColorView.findViewById(R.id.main_color_100),
		C200=mColorView.findViewById(R.id.main_color_200),
		C300=mColorView.findViewById(R.id.main_color_300),
		C400=mColorView.findViewById(R.id.main_color_400),
		C500=mColorView.findViewById(R.id.main_color_500),
		C600=mColorView.findViewById(R.id.main_color_600),
		C700=mColorView.findViewById(R.id.main_color_700),
		C800=mColorView.findViewById(R.id.main_color_800),
		C900=mColorView.findViewById(R.id.main_color_900),
		CA100=mColorView.findViewById(R.id.main_color_a100),
		CA200=mColorView.findViewById(R.id.main_color_a200),
		CA400=mColorView.findViewById(R.id.main_color_a400),
		CA700=mColorView.findViewById(R.id.main_color_a700);
		checkMainColors(C50, C100, C200, C300, C400, C500, C600, C700, C800, C900, CA100, CA200, CA400, CA700);
		mainSltId = C500.getId();
		mainColors = new View[]{C50,C100,C200,C300,C400,C500,C600,C700,C800,C900,CA100,CA200,CA400,CA700};
		checkMainSelected(mainColors);

	}
	private void checkMainColors(View... mainColors) {
		for (int i = 0; i < mainColorsHex.length; i++) {
			mainColors[i].setBackgroundColor(asColor(mainColorsHex[i]));
			mainColors[i].setOnClickListener(colorClickHandler);
			mainColors[i].setOnLongClickListener(colorLongClickHandler);
		}
		setUpMainCircle(mainColors);
	}
	private void checkSltMainColors(int sltId) {
		A_Colors_Row.setVisibility(View.VISIBLE);
		if (sltId == R.id.head_color_amber) { mainColorsHex = COLORS.amberColors; 
		} else if (sltId == R.id.head_color_blue) { mainColorsHex = COLORS.blueColors; 
		} else if (sltId == R.id.head_color_brown) { mainColorsHex = COLORS.brownColors;A_Colors_Row.setVisibility(View.INVISIBLE); 
		} else if (sltId == R.id.head_color_blue_grey) { mainColorsHex = COLORS.blueGreyColors;A_Colors_Row.setVisibility(View.INVISIBLE); 
		} else if (sltId == R.id.head_color_cyan) { mainColorsHex = COLORS.cyanColors;
		} else if (sltId == R.id.head_color_deep_orange) {mainColorsHex = COLORS.deepOrangeColors;
		} else if (sltId == R.id.head_color_deep_purple) {mainColorsHex = COLORS.deepPurpleColors;
		} else if (sltId == R.id.head_color_green) {mainColorsHex = COLORS.greenColors;
		} else if (sltId == R.id.head_color_grey) {mainColorsHex = COLORS.greyColors;A_Colors_Row.setVisibility(View.INVISIBLE); 
		} else if (sltId == R.id.head_color_indigo) {mainColorsHex = COLORS.indigoColors;
		} else if (sltId == R.id.head_color_light_blue) {mainColorsHex = COLORS.lightBlueColors;
		} else if (sltId == R.id.head_color_light_green) {mainColorsHex = COLORS.lightGreenColors;
		} else if (sltId == R.id.head_color_lime) {mainColorsHex = COLORS.limeColors;
		} else if (sltId == R.id.head_color_orange) {mainColorsHex = COLORS.orangeColors;
		} else if (sltId == R.id.head_color_pink) {mainColorsHex = COLORS.pinkColors;
		} else if (sltId == R.id.head_color_purple) {mainColorsHex = COLORS.purpleColors;
		} else if (sltId == R.id.head_color_red) {mainColorsHex = COLORS.redColors;
		} else if (sltId == R.id.head_color_teal) {mainColorsHex = COLORS.tealColors;
		} else if (sltId == R.id.head_color_yellow) {mainColorsHex = COLORS.yellowColors;
		}
	}
}
