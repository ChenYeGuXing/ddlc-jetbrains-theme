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
 */

package com.chrisrm.ideaddlc.ui;

import com.chrisrm.ideaddlc.MTConfig;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.wm.impl.status.StatusBarUI;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import java.awt.*;

import static com.chrisrm.ideaddlc.ui.MTStatusBarBorder.DEFAULT_PADDING;

public class MTStatusBarUI extends StatusBarUI {

  public static ComponentUI createUI(final JComponent c) {
    return new MTStatusBarUI();
  }


  @Override
  public void installUI(final JComponent c) {
    super.installUI(c);
    final Border border = UIManager.getBorder("IdeStatusBar.border");
    if (border != null) {
      c.setBorder(border);
    }
  }

  @Override
  public Dimension getPreferredSize(final JComponent c) {
    if (super.getPreferredSize(c) == null && !SystemInfo.isWindows) {
      return null;
    }
    final boolean compactStatusBar = MTConfig.getInstance().isCompactStatusBar();

    final int padding = compactStatusBar ? 0 : DEFAULT_PADDING;
    return new Dimension(c.getWidth(), 20 + padding * 2);
  }
}