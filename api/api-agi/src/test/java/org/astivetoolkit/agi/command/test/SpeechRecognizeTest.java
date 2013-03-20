/*
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://astive.phonytive.com
 *
 * This file is part of Astive Toolkit
 *
 * Astive is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Astive is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Astive.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.astivetoolkit.agi.command.test;

import org.astivetoolkit.agi.command.SpeechRecognize;
import org.astivetoolkit.agi.AgiException;
import org.astivetoolkit.agi.CommandProcessor;
import junit.framework.TestCase;

/**
 * DOCUMENT ME
 */
public class SpeechRecognizeTest extends TestCase {
  /**
   * Creates a new SpeechRecognizeTest object.
   *
   * @param testName DOCUMENT ME!
   */
  public SpeechRecognizeTest(String testName) {
    super(testName);
  }

  /**
   * DOCUMENT ME!
   *
   * @throws AgiException DOCUMENT ME!
   */
  public void testCommand() throws AgiException {
    String prompt = "Something to speech";
    int timeout = 0x3e8;
    int offset = 0x258;

    // Testing first constructor
    StringBuilder b = new StringBuilder("SPEECH RECOGNIZE");
    b.append(" ");
    b.append("\"");
    b.append(prompt);
    b.append("\"");
    b.append(" ");
    b.append(timeout);

    SpeechRecognize command = new SpeechRecognize(prompt, timeout);

    assertEquals(b.toString(), CommandProcessor.buildCommand(command));

    // Testing second constructor
    b.append(" ");
    b.append(offset);
    command = new SpeechRecognize(prompt, timeout, offset);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));
  }
}