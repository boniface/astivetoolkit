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
package org.astivetoolkit.menu.test;

import java.util.TimeZone;
import junit.framework.TestCase;
import org.astivetoolkit.agi.AgiException;
import org.astivetoolkit.agi.CommandProcessor;
import org.astivetoolkit.menu.VoiceComposer;
import org.astivetoolkit.menu.VoiceComposition;

/**
 *
 * @since 1.0
 */
public class VoiceComposerTest extends TestCase {

    public VoiceComposerTest(String testName) {
        super(testName);
    }

    public void testVoiceComposer() throws AgiException {
        VoiceComposition vc =
                VoiceComposer.withEscapeDigits("12345").withFormat("").withTimeZone(TimeZone.getDefault())
                .streamFile("file1").addSilence(1).withEscapeDigits("").sayAlpha("abcd").create();
        assertEquals("STREAM FILE \"file1\" \"12345\" 0",
                CommandProcessor.buildCommand(vc.getCommands().get(0)));
        assertEquals("STREAM FILE \"silence/1\" \"12345\" 0",
                CommandProcessor.buildCommand(vc.getCommands().get(1)));
        assertEquals("SAY ALPHA \"abcd\" \"\"", CommandProcessor.buildCommand(vc.getCommands().get(2)));
    }
}
