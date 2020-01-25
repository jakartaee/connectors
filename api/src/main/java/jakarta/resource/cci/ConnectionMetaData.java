/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package jakarta.resource.cci;


import jakarta.resource.ResourceException;

/** *  The interface <code>ConnectionMetaData provides information 
 *  about an EIS instance connected through a Connection instance. A
 *  component calls the method <code>Connection.getMetaData<code>ConnectionMetaData 
 *
 *  @version     0.8
 *  @author      Rahul Sharma
 *  @see         jakarta.resource.cci.Connection
 *  @see         jakarta.resource.cci.ResultSetInfo
**/

public interface ConnectionMetaData {

  /** Returns product name of the underlying EIS instance connected
   *  through the Connection that produced this metadata.
   *
   *  @return   Product name of the EIS instance
   *  @throws   ResourceException  Failed to get the information for
   *                               the EIS instance
  **/
  public
  String getEISProductName() throws ResourceException;

  /** Returns product version of the underlying EIS instance.
   *
   *  @return   Product version of an EIS instance. 
   *  @throws   ResourceException  Failed to get the information for
   *                               the EIS instance
  **/
  public
  String getEISProductVersion() throws ResourceException;

  /** Returns the user name for an active connection as known to 
   *  the underlying EIS instance. The name corresponds the resource
   *  principal under whose security context a connection to the
   *  EIS instance has been established.
   *
   *  @return   String representing the user name
   *  @throws   ResourceException  Failed to get the information for
   *                               the EIS instance           
  **/
  public
  String getUserName() throws ResourceException;
}
