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

package io.acari.DDLC.wizard;

import com.chrisrm.ideaddlc.MTConfig;
import com.chrisrm.ideaddlc.MTThemeManager;
import com.intellij.ide.customize.AbstractCustomizeWizardStep;
import com.intellij.ide.customize.CustomizeIDEWizardDialog;
import com.intellij.openapi.ui.popup.util.PopupUtil;
import com.intellij.util.ui.JBUI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class DDLCWizardDialog extends CustomizeIDEWizardDialog implements ActionListener {

  public static final String MT_IS_SHOWN_WIZARD = "ddlc.isShownWizard.v2.0";
  private Field myNextButtonField;
  private Field myIndexField;
  private Field myStepsField;

  public DDLCWizardDialog(final DDLCWizardStepsProvider stepsProvider) {
    super(stepsProvider);
    setTitle("DDLC Theme Wizard");
    getPeer().setAppIcons();

    extractPrivateFields();
    initCurrentStep();
  }

  @Override
  public void actionPerformed(@NotNull final ActionEvent e) {
    super.actionPerformed(e);
    initCurrentStep();
  }

  @Override
  protected JComponent createCenterPanel() {
    final JComponent centerPanel = super.createCenterPanel();
    centerPanel.setPreferredSize(JBUI.size(1200, 700));
    return centerPanel;
  }

  @Override
  public void doCancelAction() {
    super.doCancelAction();
//    todo: dis
//    MTConfig.getInstance().copyFrom(configCopy);
    MTThemeManager.activate();
  }

  private void extractPrivateFields() {
    final Field[] fields = CustomizeIDEWizardDialog.class.getDeclaredFields();
    final Object[] buttons = Arrays.stream(fields)
                                   .filter(f -> f.getType().equals(JButton.class))
                                   .toArray();


    myNextButtonField = (Field) buttons[0];
    Field myBackButtonField = (Field) buttons[1];
    Field mySkipButtonField = (Field) buttons[2];
    myIndexField = fields[7];
    Field myCardLayoutField = fields[5];
    myStepsField = fields[6];
    Field myContentPanelField = fields[13];

    myNextButtonField.setAccessible(true);
    myBackButtonField.setAccessible(true);
    mySkipButtonField.setAccessible(true);
    myIndexField.setAccessible(true);
    myCardLayoutField.setAccessible(true);
    myStepsField.setAccessible(true);
    myContentPanelField.setAccessible(true);
  }

  private void initCurrentStep() {
    try {
      final JButton myNextButton = (JButton) myNextButtonField.get(this);
      final int myIndex = (int) myIndexField.get(this);
      //noinspection unchecked
      final List<AbstractCustomizeWizardStep> mySteps = (List<AbstractCustomizeWizardStep>) myStepsField.get(this);

      if (myIndex == mySteps.size() - 1) {
        myNextButton.setText("Finish");
      }
    } catch (final IllegalAccessException e) {
      e.printStackTrace();
    }
  }


  @Nullable
  @Override
  protected ActionListener createCancelAction() {
    return e -> {
      if (!PopupUtil.handleEscKeyEvent()) {
        doCancelAction(e);
      }
    };
  }

}
