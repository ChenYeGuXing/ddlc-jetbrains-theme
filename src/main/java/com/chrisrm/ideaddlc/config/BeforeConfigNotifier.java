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

package com.chrisrm.ideaddlc.config;

import com.chrisrm.ideaddlc.MTConfig;
import com.chrisrm.ideaddlc.config.ui.MTForm;
import com.intellij.util.messages.Topic;

/**
 * Before Configuration Save Events
 */
public interface BeforeConfigNotifier {
  /**
   * Topic for Material Theme Settings changes
   */
  Topic<BeforeConfigNotifier> BEFORE_CONFIG_TOPIC = Topic.create("Material Theme Before Config save", BeforeConfigNotifier.class);

  /**
   * Called before config is changed
   *
   * @param mtConfig
   * @param form
   */
  void beforeConfigChanged(MTConfig mtConfig, MTForm form);

  class Adapter implements BeforeConfigNotifier {

    @Override
    public void beforeConfigChanged(final MTConfig mtConfig, final MTForm form) {

    }
  }
}
