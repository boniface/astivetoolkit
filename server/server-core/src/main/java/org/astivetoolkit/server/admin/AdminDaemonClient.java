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
package org.astivetoolkit.server.admin;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.log4j.Logger;
import org.astivetoolkit.util.AppLocale;

/**
 *
 * @since 1.0.0
 */
public class AdminDaemonClient extends Socket {
  private static final Logger LOG = Logger.getLogger(AdminDaemonClient.class);
  private BufferedReader reader;
  private PrintWriter writer;

  /**
   * Creates a new AdminDaemonClient object.
   *
   * @param addr DOCUMENT ME!
   * @param port DOCUMENT ME!
   *
   * @throws IOException DOCUMENT ME!
   */
  public AdminDaemonClient(InetAddress addr, int port)
                    throws IOException {
    super(addr, port);
    reader = new BufferedReader(new InputStreamReader(getInputStream()));
    writer = new PrintWriter(new OutputStreamWriter(getOutputStream()));
  }

  /**
   * DOCUMENT ME!
   *
   * @param app DOCUMENT ME!
   *
   * @throws IOException DOCUMENT ME!
   */
  public void deploy(String app) throws IOException {
    send(AdminCommand.DEPLOY, app);
  }

  private BufferedReader getReader() throws IOException {
    return reader;
  }

  private PrintWriter getWriter() throws IOException {
    return writer;
  }

  private void send(AdminCommand cmd, String arg) throws IOException {
    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("sendingCmd", new Object[] { cmd, arg }));
    }

    getWriter().println(cmd.toString());

    if ((arg != null) && !arg.isEmpty()) {
      getWriter().println(arg);
    }

    getWriter().flush();

    if (LOG.isDebugEnabled()) {
      LOG.debug(AppLocale.getI18n("done"));
    }
  }

  /**
   * DOCUMENT ME!
   *
   * @throws IOException DOCUMENT ME!
   */
  public void stop() throws IOException {
    send(AdminCommand.STOP, null);
  }

  /**
   * DOCUMENT ME!
   *
   * @param app DOCUMENT ME!
   *
   * @throws IOException DOCUMENT ME!
   */
  public void undeploy(String app) throws IOException {
    send(AdminCommand.UNDEPLOY, app);
  }
}