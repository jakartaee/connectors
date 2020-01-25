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

package jakarta.resource.spi;


import jakarta.resource.ResourceException;

/** *  <p>ConnectionManager interface provides a hook for the resource adapter to
 *  pass a connection request to the application server. 
 *  
 *  <p>An application server provides implementation of the ConnectionManager
 *  interface. This implementation is not specific to any particular type of
 *  the resource adapter or connection factory interface.
 * 
 *  <p>The ConnectionManager implementation delegates to the application 
 *  server to enable latter to provide quality of services (QoS) - security,
 *  connection pool management, transaction management and error 
 *  logging/tracing. 
 * 
 *  <p>An application server implements these services in a generic manner, 
 *  independent of any resource adapter and EIS specific mechanisms. The 
 *  connector architecture does not specify how an application server 
 *  implements these services; the implementation is specific to an 
 *  application server.
 *  
 *  <p>After an application server hooks-in its services, the connection 
 *  request gets delegated to a ManagedConnectionFactory instance either 
 *  for the creation of a new physical connection or for the matching of 
 *  an already existing physical connection.
 *  
 *  <p>An implementation class for ConnectionManager interface is
 *  required to implement the <code>java.io.Serializable</code> interface.
 *  
 *  <p>In the non-managed application scenario, the ConnectionManager 
 *  implementation class can be provided either by a resource adapter (as
 *  a default ConnectionManager implementation) or by application 
 *  developers. In both cases, QOS can be provided as components by third
 *  party vendors.</p>
 *
 *  @since       0.6
 *  @author      Rahul Sharma
 *  @see         jakarta.resource.spi.ManagedConnectionFactory
**/

public interface ConnectionManager 
                    extends java.io.Serializable {

  /** <p>The method allocateConnection gets called by the resource adapter's
   *  connection factory instance. This lets connection factory instance 
   *  (provided by the resource adapter) pass a connection request to 
   *  the ConnectionManager instance.</p>
   *  
   *  <p>The connectionRequestInfo parameter represents information specific
   *  to the resource adapter for handling of the connection request.</p>
   *
   *  @param   mcf
   *                       used by application server to delegate
   *                       connection matching/creation
   *  @param   cxRequestInfo     
   *                       connection request Information
   *
   *  @return  connection handle with an EIS specific connection interface.
   * 
   *
   *  @throws  ResourceException     Generic exception
   *  @throws  ApplicationServerInternalException 
   *                                 Application server specific exception
   *  @throws  SecurityException     Security related error
   *  @throws  ResourceAllocationException
   *                                 Failed to allocate system resources for
   *                                 connection request
   *  @throws  ResourceAdapterInternalException
   *                                 Resource adapter related error condition
  **/
  public  
  Object allocateConnection(ManagedConnectionFactory mcf,
			    ConnectionRequestInfo cxRequestInfo)
                               throws ResourceException;

}
