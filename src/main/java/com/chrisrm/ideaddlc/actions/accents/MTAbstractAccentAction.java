/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Chris Magnussen and Elior Boukhobza
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

package com.chrisrm.ideaddlc.actions.accents;

import com.chrisrm.ideaddlc.MTAnalytics;
import com.chrisrm.ideaddlc.MTConfig;
import com.chrisrm.ideaddlc.MTThemeManager;
import com.chrisrm.ideaddlc.icons.IconReplacer;
import com.chrisrm.ideaddlc.ui.indicators.MTSelectedTreeIndicatorImpl;
import com.chrisrm.ideaddlc.utils.UIReplacer;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.impl.ActionToolbarImpl;

public abstract class MTAbstractAccentAction extends AnAction {

  @Override
  public final void actionPerformed(final AnActionEvent e) {
    setAccentToTheme();
  }

  public void setAccentToTheme() {
    MTSelectedTreeIndicatorImpl.resetCache();
    final String accentColor = getAccentColor();
    MTConfig.getInstance().setAccentColor(accentColor);
    MTThemeManager.getInstance().applyAccents();
    UIReplacer.patchUI();

    IconReplacer.replaceIcons(AllIcons.class, "/iconsddlc");
    ActionToolbarImpl.updateAllToolbarsImmediately();
    MTAnalytics.getInstance().track(MTAnalytics.ACCENT, accentColor);

    MTConfig.getInstance().fireChanged();
  }

  /**
   * The Accent Color String
   */
  public abstract String getAccentColor();
}
