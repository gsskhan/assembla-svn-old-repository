package com.citi.risk.dashboard.test.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.citi.risk.dashboard.util.ColorPicker;
import com.citi.risk.dashboard.util.ConstantsUtil;

public class ColorPickerTest {
	
	@Test
	@Ignore
	public void getMaxColorTest(){
		ColorPicker picker = new ColorPicker();
		List<String> colorList = new ArrayList<String>();
		colorList.add("#AB0098");
		colorList.add(ConstantsUtil.COL_AMBER.getConstants());
		colorList.add(ConstantsUtil.COL_GREEN.getConstants());	
		
		String retColor = picker.getMaxColor(colorList);
		Assert.assertEquals(ConstantsUtil.COL_AMBER.getConstants(), retColor);
		Assert.assertEquals(ConstantsUtil.COL_GREEN.getConstants(), picker.getMaxColor(null));
		Assert.assertEquals(ConstantsUtil.COL_GREEN.getConstants(), picker.getMaxColor(new ArrayList<String>()));
		
		colorList.clear();
		colorList.add(ConstantsUtil.COL_GREY.getConstants());
		colorList.add(ConstantsUtil.COL_GREEN.getConstants());
		colorList.add(ConstantsUtil.COL_YELLOW.getConstants());
		System.out.println("Color list = "+ colorList);
		Assert.assertEquals("#FFFF00", picker.getMaxColor(colorList));
		
		System.out.println("test end.");
	}

}
