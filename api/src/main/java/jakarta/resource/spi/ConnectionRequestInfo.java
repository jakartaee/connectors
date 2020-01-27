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

/** <p>The ConnectionRequestInfo interface enables a resource adapter to 
 *  pass its own request specific data structure across the connection
 *  request flow. A resource adapter extends the empty interface to
 *  supports its own data structures for connection request.
 *  
 *  <p>A typical use allows a resource adapter to handle 
 *  application component specified per-connection request properties
 *  (example - client ID, language). The application server passes these 
 *  properties back across to match/createManagedConnection calls on 
 *  the resource adapter. These properties remain opaque to the 
 *  application server during the connection request flow. 
 *
 *  <p>Once the ConnectionRequestInfo reaches match/createManagedConnection
 *  methods on the ManagedConnectionFactory instance, resource adapter
 *  uses this additional per-request information to do connection 
 *  creation and matching.
 *
 *  @version     0.8
 *  @author      Rahul Sharma
 *  @see         jakarta.resource.spi.ManagedConnectionFactory
 *  @see         jakarta.resource.spi.ManagedConnection
**/

public interface ConnectionRequestInfo {

  /** 
   * Checks whether this instance is equal to another.Since
   * connectionRequestInfo is defined specific to a resource
   * adapter, the resource adapter is required to implement
   * this method. The conditions for equality are specific
   * to the resource adapter.
   *
   * @param other
   * @return True if the two instances are equal.
  **/
  public boolean equals(Object other);

  /** Returns the hashCode of the ConnectionRequestInfo.
   *
   *  @return hash code os this instance
  **/
  public int hashCode();
  
}
