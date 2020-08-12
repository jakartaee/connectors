/*
 * Copyright (c) 1997, 2020 Oracle and/or its affiliates. All rights reserved.
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

package jakarta.resource.spi;

import jakarta.resource.ResourceException;

/** The ManagedConnectionMetaData interface provides information about the 
 *  underlying EIS instance associated with a ManagedConnection instance.
 *  An application server uses this information to get runtime information
 *  about a connected EIS instance.
 *
 *  <p>The method ManagedConnection.getMetaData returns a 
 *  ManagedConnectionMetaData instance.
 *  
 *  @version     0.8
 *  @author      Rahul Sharma
 *  @see         jakarta.resource.spi.ManagedConnection
**/

public interface ManagedConnectionMetaData {

  /** Returns Product name of the underlying EIS instance connected 
   *  through the ManagedConnection.
   *  @throws ResourceException if an error occurs
   *  @return  Product name of the EIS instance.
  **/
  public
  String getEISProductName() throws ResourceException;

  /** Returns product version of the underlying EIS instance connected 
   *  through the ManagedConnection.
   *  @throws ResourceException if an error occurs
   *  @return  Product version of the EIS instance
  **/
  public
  String getEISProductVersion() throws ResourceException;

  /** Returns maximum limit on number of active concurrent connections 
   *  that an EIS instance can support across client processes. If an EIS 
   *  instance does not know about (or does not have) any such limit, it 
   *  returns a 0.
   *  @throws ResourceException if an error occurs
   *  @return  Maximum limit for number of active concurrent connections
  **/
  public
  int getMaxConnections() throws ResourceException;
  
  /** Returns name of the user associated with the ManagedConnection
   *  instance. The name corresponds to the resource principal under whose
   *  whose security context, a connection to the EIS instance has been
   *  established.
   *  @throws ResourceException if an error occurs
   *  @return  name of the user
  **/
  public
  String getUserName() throws ResourceException;
}
