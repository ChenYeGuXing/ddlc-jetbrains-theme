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
 */

package com.chrisrm.ideaddlc.tree;

import com.chrisrm.ideaddlc.MTConfig;
import com.chrisrm.ideaddlc.MTThemeManager;
import com.chrisrm.ideaddlc.icons.DirIcon;
import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.projectView.ProjectViewNode;
import com.intellij.ide.projectView.ProjectViewNodeDecorator;
import com.intellij.ide.projectView.impl.ProjectRootsUtil;
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx;
import com.intellij.openapi.fileEditor.impl.EditorWindow;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.packageDependencies.ui.PackageDependenciesNode;
import com.intellij.ui.ColorUtil;
import com.intellij.ui.ColoredTreeCellRenderer;
import com.intellij.util.PlatformIcons;
import icons.DDLCIcons;
import icons.MTIcons;

import javax.swing.*;
import java.util.Objects;

import static com.chrisrm.ideaddlc.config.MTFileColorsPage.DIRECTORIES;

/**
 * Created by eliorb on 09/04/2017.
 */
public final class DDLCProjectViewNodeDecorator implements ProjectViewNodeDecorator {

  private static Icon directory;

  public DDLCProjectViewNodeDecorator() {
  }

  public static void resetCache() {
    directory = null;
  }

  @Override
  public void decorate(final PackageDependenciesNode node, final ColoredTreeCellRenderer cellRenderer) {

  }

  @Override
  public void decorate(final ProjectViewNode node, final PresentationData data) {
    if(MTThemeManager.isDDLCActive()){
      final VirtualFile file = node.getVirtualFile();
      final Project project = node.getProject();

      // Color file status
      if (file != null) {
        if (MTConfig.getInstance().getIsStyledDirectories()) {
          // Color file status
          applyDirectoriesColor(data, file);
        }

        if (MTConfig.getInstance().isUseProjectViewDecorators()) {
          setOpenOrClosedIcon(data, file, project);
        }
      }
    }
  }

  /**
   * Try to mimic the "open or closed"  folder feature
   */
  private void setOpenOrClosedIcon(final PresentationData data, final VirtualFile file, final Project project) {
    if (!file.isDirectory()) {
      return;
    }

    final FileEditorManagerEx manager = FileEditorManagerEx.getInstanceEx(project);
    for (final EditorWindow editorWindow : manager.getWindows()) {
      final VirtualFile[] files = editorWindow.getFiles();
      for (final VirtualFile leaf : files) {
        if (leaf.getPath().contains(file.getPath())) {
          setOpenDirectoryIcon(data, file, project);
          colorOpenDirectories(data);
        }
      }
    }
  }

  private void colorOpenDirectories(final PresentationData data) {
    final String accentColor = MTConfig.getInstance().getAccentColor();
    data.setForcedTextForeground(ColorUtil.fromHex(accentColor));
  }

  private void setOpenDirectoryIcon(final PresentationData data, final VirtualFile file, final Project project) {
    if (data.getIcon(true) instanceof DirIcon) {
      final Icon openedIcon = ((DirIcon) Objects.requireNonNull(data.getIcon(true))).getOpenedIcon();
      data.setIcon(openedIcon);
    } else if (ProjectRootManager.getInstance(project).getFileIndex().isExcluded(file)) {
      data.setIcon(DDLCIcons.EXCLUDED);
    } else if (ProjectRootsUtil.isModuleContentRoot(file, project)) {
      data.setIcon(DDLCIcons.MODULE);
    } else if (ProjectRootsUtil.isInSource(file, project)) {
      data.setIcon(DDLCIcons.SOURCE);
    } else if (ProjectRootsUtil.isInTestSource(file, project)) {
      data.setIcon(DDLCIcons.TEST);
    } else if (Objects.equals(data.getIcon(false), PlatformIcons.PACKAGE_ICON)) {
      //      Looks like an open directory anyway
      data.setIcon(PlatformIcons.PACKAGE_ICON);
    } else {
      data.setIcon(getDirectoryIcon(data));
    }
  }

  private Icon getDirectoryIcon(final PresentationData data) {
    if (directory == null) {
      directory = MTIcons.Nodes2.FolderOpen;
    }

    return directory;
  }

  private void applyDirectoriesColor(final PresentationData data, final VirtualFile file) {
    if (file.isDirectory()) {
      data.setAttributesKey(DIRECTORIES);
    }
  }
}