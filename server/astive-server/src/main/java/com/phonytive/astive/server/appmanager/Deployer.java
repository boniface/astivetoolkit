/* 
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://www.phonytive.com/astive
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
package com.phonytive.astive.server.appmanager;


import com.phonytive.astive.server.AstiveException;

/**
 *
 * @since 1.0.0
 */
public interface Deployer {

  /**
   * Adds app to the server index.
   *
   * @param app DOCUMENT ME!   
   * @throws AstiveException
   */
  void deploy(String file) throws AstiveException;

  /**
   * Discharge app from the server.
   *
   * @param deploymentId id for the app to undeploy.
   * @throws AstiveException if app dont exist.
   */
  void undeploy(String deploymentId) throws AstiveException;

}
