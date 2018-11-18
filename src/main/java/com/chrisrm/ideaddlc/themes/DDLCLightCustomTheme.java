/*
 *  The MIT License (MIT)
 *
 *  Copyright (c) 2018 Chris Magnussen and Elior Boukhobza
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 *
 *
 */

package com.chrisrm.ideaddlc.themes;

import io.acari.DDLC.DDLCAbstractTheme;
import com.chrisrm.ideaddlc.MTConfig;
import com.chrisrm.ideaddlc.MTCustomThemeConfig;
import org.jetbrains.annotations.NotNull;

public class DDLCLightCustomTheme extends DDLCAbstractTheme {
  public static final String BACKGROUND = "FAFAFA"; // 250, 250, 250
  public static final String FOREGROUND = "A7ADB0"; // 167, 173, 176
  public static final String TEXT = "A7ADB0"; // 167, 173, 176
  public static final String SELECTION_BACKGROUND = "80CBC4";
  public static final String SELECTION_FOREGROUND = "FFFFFF";
  public static final String LABEL = "546E7A"; // 84, 110, 122
  public static final String DISABLED = "eae8e8";

  public DDLCLightCustomTheme() {
    super("mt.light_custom", "Material Light Custom", false, "Light Custom", "/iconsddlc/actions/themes/light_custom.svg");
  }

  @NotNull
  @Override
  public String getClubMember() {
    return "just_monika.png";
  }

  @NotNull
  @Override
  public String joyfulClubMember() {
    return "just_monika_joy.png";
  }

  @NotNull
  @Override
  public String getSelectionBackground() {
    return DDLCLightCustomTheme.SELECTION_BACKGROUND;
  }

  @NotNull
  @Override
  public String getDisabled() {
    return DDLCLightCustomTheme.DISABLED;
  }

  @Override
  public String getEditorTabColorString() {
    return null;
  }

  @Override
  public String getNotificationsColorString() {
    return MTCustomThemeConfig.getInstance().getNotificationsColorString();
  }

  public String getTreeSelectionColorString() {
    return MTCustomThemeConfig.getInstance().getTreeSelectionColorString();
  }

  @Override
  public String getHighlightColorString() {
    return MTCustomThemeConfig.getInstance().getHighlightColorString();
  }

  @Override
  public String getTreeSelectionBackgroundColorString() {
    return "CCCCCC";
  }

  @Override
  public String getTreeSelectionForegroundColorString() {
    return "CCCCCC";
  }

  @Override
  public String getSecondBorderColorString() {
    return MTCustomThemeConfig.getInstance().getSecondBorderColorString();
  }

  @Override
  public String getTableSelectedColorString() {
    return MTCustomThemeConfig.getInstance().getTableSelectedColorString();
  }

  @Override
  public String getContrastColorString() {
    return MTCustomThemeConfig.getInstance().getContrastColorString();
  }

  @Override
  public String getDisabledColorString() {
    return MTCustomThemeConfig.getInstance().getDisabledColorString();
  }

  @Override
  public String getSecondaryBackgroundColorString() {
    return MTCustomThemeConfig.getInstance().getSecondaryBackgroundColorString();
  }

  public String getButtonColorString() {
    return MTCustomThemeConfig.getInstance().getButtonColorString();
  }

  @Override
  public String getSelectionForegroundColorString() {
    return MTCustomThemeConfig.getInstance().getSelectionForegroundColorString();
  }

  @Override
  public String getMenuBarSelectionForegroundColorString() {
    return null;
  }

  @Override
  public String getMenuBarSelectionBackgroundColorString() {
    return null;
  }

  @Override
  public String getInactiveColorString() {
    return null;
  }

  @Override
  public String getSelectionBackgroundColorString() {
    return MTCustomThemeConfig.getInstance().getSelectionBackgroundColorString();
  }

  @Override
  public String getTextColorString() {
    return MTCustomThemeConfig.getInstance().getTextColorString();
  }

  @Override
  public String getForegroundColorString() {
    return MTCustomThemeConfig.getInstance().getForegroundColorString();
  }

  @Override
  public String getBackgroundColorString() {
    return MTCustomThemeConfig.getInstance().getBackgroundColorString();
  }

  @Override
  public boolean isCustom() {
    return true;
  }

  @Override
  public String getAccentColor() {
    return MTConfig.getInstance().getAccentColor();
  }

  @Override
  public String getExcludedColor() {
    return DISABLED;
  }

  @Override
  public int getOrder() {
    return 10;
  }

  @Override
  public String getNonProjectFileScopeColor() {
    return null;
  }

  @Override
  public String getTestScope() {
    return null;
  }
}
