# ttb-color-picker
A list of material design colors dialog for android
<img src="image/ttb-color-picker-screenshot.png" alt="Screenshot"/>
# Simple Get the Selected Color
```java
new ColorPickerDialog(this)
  .setTitle("Select A Text Color")
  .setOnColorSelectListener(new OnColorSelectedListener(){
      @Override
      public void onColorSelected(int color, String hexColor, int[] rgb){
         text.setTextColor(color);
    }
}).show();
```
