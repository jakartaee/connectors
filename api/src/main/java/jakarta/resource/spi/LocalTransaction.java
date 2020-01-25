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

/** LocalTransaction interface provides support for transactions that
 *  are managed internal to an EIS resource manager, and do not require
 *  an external transaction manager.
 * 
 *  <p>A resource adapter implements the javax.resource.spi.LocalTransaction 
 *  interface to provide support for local transactions that are performed
 *  on the underlying resource manager.
 *
 *  <p>If a resource adapter supports the LocalTransaction interface, then 
 *  the application server can choose to perform local transaction 
 *  optimization (uses local transaction instead of a Jakarta&trade; Transactions transaction for
 *  a single resource manager case).
 *
 *  @version     0.5
 *  @author      Rahul Sharma
 *  @see         jakarta.resource.spi.ManagedConnection
 **/



public interface LocalTransaction {
  /** Begin a local transaction
   *  
   *  @throws  ResourceException   generic exception if operation fails
   *  @throws  LocalTransactionException  
   *                               error condition related 
   *                               to local transaction management
   *  @throws  ResourceAdapterInternalException
   *                               error condition internal to resource
   *                               adapter
   *  @throws  EISSystemException  EIS instance specific error condition        
  **/
  public 
  void begin() throws ResourceException;

  /** Commit a local transaction 
   *
   *  @throws  ResourceException   generic exception if operation fails
   *  @throws  LocalTransactionException  
   *                               error condition related 
   *                               to local transaction management
   *  @throws  ResourceAdapterInternalException
   *                               error condition internal to resource
   *                               adapter
   *  @throws  EISSystemException  EIS instance specific error condition        
  **/
  public
  void commit() throws ResourceException;
  
  /** Rollback a local transaction
   *  @throws  ResourceException   generic exception if operation fails
   *  @throws  LocalTransactionException  
   *                               error condition related 
   *                               to local transaction management
   *  @throws  ResourceAdapterInternalException
   *                               error condition internal to resource
   *                               adapter
   *  @throws  EISSystemException  EIS instance specific error condition        
  **/
  public
  void rollback() throws ResourceException;

}
