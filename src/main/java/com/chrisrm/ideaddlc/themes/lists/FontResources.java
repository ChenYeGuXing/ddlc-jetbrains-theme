/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Chris Magnussen and Elior Boukhobza
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *
 */

package com.chrisrm.ideaddlc.themes.lists;

import com.google.common.collect.Sets;
import org.jetbrains.annotations.NonNls;

import java.util.Collections;
import java.util.Set;

public enum FontResources {
  DEFAULT;
  @SuppressWarnings("DuplicateStringLiteralInspection")
  @NonNls
  public static final Set<String> FONT_RESOURCES = Collections.unmodifiableSet(
      Sets.newHashSet(
      "Button.font",
      "ToggleButton.font",
      "RadioButton.font",
      "CheckBox.font",
      "ColorChooser.font",
      "ComboBox.font",
      "Label.font",
      "List.font",
      "DesktopIcon.font",
      "MenuBar.font",
      "MenuItem.font",
      "MenuItem.acceleratorFont",
      "RadioButtonMenuItem.font",
      "RadioButtonMenuItem.acceleratorFont",
      "CheckBoxMenuItem.font",
      "CheckBoxMenuItem.acceleratorFont",
      "Menu.font",
      "PopupMenu.font",
      "OptionPane.font",
      "OptionPane.buttonFont",
      "OptionPane.messageFont",
      "Panel.font",
      "ProgressBar.font",
      "ScrollPane.font",
      "Viewport.font",
      "Slider.font",
      "IconButton.font",
      "TabbedPane.font",
      "TabbedPane.smallFont",
      "Table.font",
      "TableHeader.font",
      "TextField.font",
      "FormattedTextField.font",
      "Spinner.font",
      "PasswordField.font",
      "TextArea.font",
      "TextPane.font",
      "EditorPane.font",
      "TitledBorder.font",
      "ToolBar.font",
      "ToolTip.font",
      "Tree.font"
      ));
}