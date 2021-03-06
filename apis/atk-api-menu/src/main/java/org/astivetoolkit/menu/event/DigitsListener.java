/* 
 * Copyright (C) 2010-2014 by PhonyTive LLC (http://phonytive.com)
 * http://astivetoolkit.org
 *
 * This file is part of Astive Toolkit(ATK)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.astivetoolkit.menu.event;

/**
 * The listener interface for receiving {@link DigitsEvent}.
 *
 * @since 1.0.0
 * @see DigitsEvent
 */
public interface DigitsListener {

    /**
     * Callback triggered when digits are pressed.
     *
     * @param evt the event submitted.
     */
    abstract void digitsEnter(DigitsEvent evt);
}
