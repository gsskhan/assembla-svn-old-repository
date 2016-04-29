package com.citi.risk.dashboard.util;

import java.util.List;

public class ColorPicker {

    public String getMaxColor(List<String> colorList) {
        if (colorList != null && colorList.size() > 0) {
            if (colorList.contains(ConstantsUtil.COL_RED.getConstants())) {
                return ConstantsUtil.COL_RED.getConstants();
            } else if (colorList.contains(ConstantsUtil.COL_AMBER
                    .getConstants())) {
                return ConstantsUtil.COL_AMBER.getConstants();
            } else if (colorList.contains(ConstantsUtil.COL_YELLOW
                    .getConstants())) {
                return ConstantsUtil.COL_YELLOW.getConstants();
            } else {
                return ConstantsUtil.COL_GREEN.getConstants();
            }
        }
        return ConstantsUtil.COL_GREEN.getConstants();
    }
}
