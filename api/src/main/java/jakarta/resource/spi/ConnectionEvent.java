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
import java.util.EventObject;

/** *  The ConnectionEvent class provides information about the source of 
 *  a connection related event.A ConnectionEvent instance contains the 
 *  following information: 
 *  <UL>
 *    <LI>Type of the connection event
 *    <LI>ManagedConnection instance that generated the connection event.
 *        A ManagedConnection instance is returned from the method
 *        ConnectionEvent.getSource.
 *    <LI>Connection handle associated with the ManagedConnection instance; 
 *        required for the CONNECTION_CLOSED event and optional for the 
 *        other event types.
 *    <LI>Optionally, an exception indicating the connection related error. 
 *        Note that exception is used for CONNECTION_ERROR_OCCURRED.
 *  <p>This class defines following types of event notifications:
 *  <UL>
 *     <LI>CONNECTION_CLOSED
 *     <LI>LOCAL_TRANSACTION_STARTED
 *     <LI>LOCAL_TRANSACTION_COMMITTED
 *     <LI>LOCAL_TRANSACTION_ROLLEDBACK
 *     <LI>CONNECTION_ERROR_OCCURRED
 *
 *  @version     0.5
 *  @author      Rahul Sharma
 *  @see         jakarta.resource.spi.ConnectionEventListener
 */

public class ConnectionEvent extends java.util.EventObject {

  /** Event notification that an application component has closed the 
   *  connection
  **/
  public static final int CONNECTION_CLOSED = 1;

  /** Event notification that a Resource Manager Local Transaction was
   *  started on the connection
  **/
  public static final int LOCAL_TRANSACTION_STARTED = 2;

  /** Event notification that a Resource Manager Local Transaction was
   *  committed on the connection
  **/
  public static final int LOCAL_TRANSACTION_COMMITTED = 3;

  /** Event notification that a Resource Manager Local Transaction was
   *  rolled back on the connection
  **/
  public static final int LOCAL_TRANSACTION_ROLLEDBACK = 4;

  /** Event notification that an error occurred on the connection. 
   *  This event indicates that the ManagedConnection instance is
   *  now invalid and unusable.
  **/
  public static final int CONNECTION_ERROR_OCCURRED = 5;


  /** Exception associated with the <code>ConnectionEvent</code>
   *  instance.
   *
   *  @serial
  **/
  private Exception exception;

  /** Type of the event
  **/
  protected int id;

  private Object connectionHandle;    
  
  /**
   * Construct a ConnectionEvent object. Exception defaults to null.
   *
   * @param    source      ManagedConnection that is the
   *                       source of the event
   * @param    eid         type of the Connection event
   */
  public ConnectionEvent(ManagedConnection source, int eid) {
    super(source);         
    this.id = eid;
  }

  /**
   * Construct a ConnectionEvent object.
   *
   * @param    source      ManagedConnection that is the
   *                       source of the event
   * @param    exception   exception about to be thrown to the application
   * @param    eid         type of the Connection event
   */
  public ConnectionEvent(ManagedConnection source, int eid,
			 Exception exception) {
    super(source);  
    this.exception = exception;
    this.id = eid;
  }

  /**Get the connection handle associated with the Managed
   * Connection instance. Used for CONNECTION_CLOSED event.
   *
   * @return the connection handle. May be null
   */
  public Object getConnectionHandle() {
    return connectionHandle;
  }

  /**
   * Set the connection handle. Used for CONNECTION_CLOSED event
   */
  public void setConnectionHandle(Object connectionHandle) {
    this.connectionHandle = connectionHandle;
  }

 
  /**
   * Get the exception. May be null.
   *
   * @return the exception about to be thrown.
   */
  public Exception getException() {
    return exception;
  }

  /**
   * Get the type of event
   */
  public
  int getId() {
    return id;
  }
} 





