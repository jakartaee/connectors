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

import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;
import jakarta.resource.ResourceException;

/** ManagedConnection instance represents a physical connection
 *  to the underlying EIS.
 *
 *  <p>A ManagedConnection instance provides access to a pair of 
 *  interfaces: <code>javax.transaction.xa.XAResource</code> and 
 *  <code>jakarta.resource.spi.LocalTransaction</code>.
 *
 *  <p><code> XAResource</code> interface is used by the transaction 
 *  manager to associate and dissociate a transaction with the underlying 
 *  EIS resource manager instance and to perform two-phase commit 
 *  protocol. The ManagedConnection interface is not directly used 
 *  by the transaction manager. More details on the XAResource 
 *  interface are described in the Jakarta&trade; Transactions specification.
 *
 *  <p>The LocalTransaction interface is used by the application server
 *  to manage local transactions.
 *
 *  @version     0.5
 *  @author      Rahul Sharma
 *  @see         jakarta.resource.spi.ManagedConnectionFactory
 *  @see         javax.transaction.xa.XAResource
 *  @see         jakarta.resource.spi.LocalTransaction
**/

public interface ManagedConnection {
  
  /** Creates a new connection handle for the underlying physical connection 
   *  represented by the ManagedConnection instance. This connection handle
   *  is used by the application code to refer to the underlying physical 
   *  connection. This connection handle is associated with its 
   *  ManagedConnection instance in a resource adapter implementation 
   *  specific way.</P>
   *
   *  <P>The ManagedConnection uses the Subject and additional ConnectionRequest
   *  Info (which is specific to resource adapter and opaque to application
   *  server) to set the state of the physical connection.</p>
   *
   *  @param        subject        security context as JAAS subject
   *  @param        cxRequestInfo  ConnectionRequestInfo instance
   *  @return       generic Object instance representing the connection 
   *                handle. For CCI, the connection handle created by a 
   *                ManagedConnection instance is of the type 
   *                jakarta.resource.cci.Connection.
   *
   *  @throws  ResourceException     generic exception if operation fails
   *  @throws  ResourceAdapterInternalException
   *                                 resource adapter internal error condition
   *  @throws  SecurityException     security related error condition
   *  @throws  CommException         failed communication with EIS instance
   *  @throws  EISSystemException    internal error condition in EIS instance
   *                                 - used if EIS instance is involved in
   *                                   setting state of ManagedConnection
   *
   **/
  public 
  Object getConnection(Subject subject, 
		       ConnectionRequestInfo cxRequestInfo) 
                 throws ResourceException;

  /** Destroys the physical connection to the underlying resource manager.
   *
   *  <p>To manage the size of the connection pool, an application server can 
   *  explictly call ManagedConnection.destroy to destroy a  
   *  physical connection. A resource adapter should destroy all allocated 
   *  system resources for this ManagedConnection instance when the method 
   *  destroy is called.
   *  
   *  @throws    ResourceException     generic exception if operation failed
   *  @throws    IllegalStateException illegal state for destroying connection
   **/

  public 
  void destroy() throws ResourceException;

  /** Application server calls this method to force any cleanup on the 
   *  ManagedConnection instance.
   *  
   *  <p>The method ManagedConnection.cleanup initiates a cleanup of the
   *  any client-specific state as maintained by a ManagedConnection instance.
   *  The cleanup should invalidate all connection handles that had been 
   *  created using this ManagedConnection instance. Any attempt by an application 
   *  component to use the connection handle after cleanup of the underlying
   *  ManagedConnection should result in an exception.
   *
   *  <p>The cleanup of ManagedConnection is always driven by an application
   *  server. An application server should not invoke ManagedConnection.cleanup
   *  when there is an uncompleted transaction (associated with a 
   *  ManagedConnection instance) in progress. 

   *  <p>The invocation of ManagedConnection.cleanup method on an already 
   *  cleaned-up connection should not throw an exception.
   *
   *  <p>The cleanup of ManagedConnection instance resets its client specific
   *  state and prepares the connection to be put back in to a connection
   *  pool. The cleanup method should not cause resource adapter to close
   *  the physical pipe and reclaim system resources associated with the
   *  physical connection.
   *  
   *  @throws    ResourceException     generic exception if operation fails
   *  @throws    ResourceAdapterInternalException
   *                                   resource adapter internal error condition
   *  @throws    IllegalStateException Illegal state for calling connection
   *                                   cleanup. Example - if a localtransaction 
   *                                   is in progress that doesn't allow 
   *                                   connection cleanup
   *
   **/
  public 
  void cleanup() throws ResourceException;  

  /** 
   *  Used typically by the container to change the association of an 
   *  application-level connection handle with a ManagedConnection 
   *  instance. The container should find the right ManagedConnection 
   *  instance and call the associateConnection method.
   *  In order to set a Connection Handle as the active connection 
   *  handle, the container may also use the <code>associateConnection</code> 
   *  method to set the same <code>ManagedConnection</code> associated 
   *  with the Connection handle.
   *
   *  <p>The resource adapter is required to implement the associateConnection
   *  method. The method implementation for a ManagedConnection should 
   *  dissociate the connection handle (passed as a parameter) from its 
   *  currently associated ManagedConnection and associate the new 
   *  connection handle with itself. 
   *
   *  @param   connection  Application-level connection handle
   *
   *  @throws  ResourceException     Failed to associate the connection
   *                                 handle with this ManagedConnection
   *                                 instance
   *  @throws  IllegalStateException Illegal state for invoking this
   *                                 method
   *  @throws  ResourceAdapterInternalException
   *                                 Resource adapter internal error 
   *                                 condition
   *                  
  **/
  public
  void associateConnection(Object connection)
                 throws ResourceException;



  /** Adds a connection event listener to the ManagedConnection 
   *  instance.
   *
   *  <p>The registered ConnectionEventListener instances are notified of
   *  connection close and error events, also of local transaction related
   *  events on the Managed Connection.
   *
   *  @param  listener   a new ConnectionEventListener to be registered
  **/
  public 
  void addConnectionEventListener(ConnectionEventListener listener);

  /** Removes an already registered connection event listener from the 
   *  ManagedConnection instance.
   *
   *  @param  listener   already registered connection event listener to be 
   *                     removed
  **/
  public 
  void removeConnectionEventListener(
			 ConnectionEventListener listener);

  /** Returns an <code>javax.transaction.xa.XAresource</code> instance. 
   *  An application server enlists this XAResource instance with the
   *  Transaction Manager if the ManagedConnection instance is being used
   *  in a Jakarta Transactions transaction that is being coordinated by the Transaction 
   *  Manager.
   *
   *  @return     XAResource instance
   *
   *  @throws     ResourceException     generic exception if operation fails
   *  @throws     NotSupportedException if the operation is not supported
   *  @throws     ResourceAdapterInternalException
   *                                    resource adapter internal error condition
  **/
  public 
  XAResource getXAResource() throws ResourceException;

  /** Returns an <code>jakarta.resource.spi.LocalTransaction</code> instance. 
   *  The LocalTransaction interface is used by the container to manage
   *  local transactions for a RM instance.
   *
   *  @return     LocalTransaction instance
   *
   *  @throws     ResourceException     generic exception if operation fails
   *  @throws     NotSupportedException if the operation is not supported
   *  @throws     ResourceAdapterInternalException
   *                                    resource adapter internal error condition
  **/
  public 
  LocalTransaction getLocalTransaction() throws ResourceException;

  /** <p>Gets the metadata information for this connection's underlying 
   *  EIS resource manager instance. The ManagedConnectionMetaData 
   *  interface provides information about the underlying EIS instance 
   *  associated with the ManagedConenction instance.
   *
   *  @return     ManagedConnectionMetaData instance
   *
   *  @throws     ResourceException     generic exception if operation fails
   *  @throws     NotSupportedException if the operation is not supported
  **/
  public 
  ManagedConnectionMetaData getMetaData() throws ResourceException;

  /** Sets the log writer for this ManagedConnection instance.
   *
   *  <p>The log writer is a character output stream to which all logging and
   *  tracing messages for this ManagedConnection instance will be printed.
   *  Application Server manages the association of output stream with the
   *  ManagedConnection instance based on the connection pooling 
   *  requirements.</p>
   *  
   *  <p>When a ManagedConnection object is initially created, the default
   *  log writer associated with this instance is obtained from the 
   *  ManagedConnectionFactory. An application server can set a log writer
   *  specific to this ManagedConnection to log/trace this instance using
   *  setLogWriter method.</p>
   *  
   *  @param      out        Character Output stream to be associated
   *
   *  @throws     ResourceException  generic exception if operation fails
   *  @throws     ResourceAdapterInternalException
   *                                 resource adapter related error condition
   **/
  public
  void setLogWriter(java.io.PrintWriter out) throws ResourceException;

  /** Gets the log writer for this ManagedConnection instance.
   *
   *  <p>The log writer is a character output stream to which all logging and
   *  tracing messages for this ManagedConnection instance will be printed.
   *  ConnectionManager manages the association of output stream with the
   *  ManagedConnection instance based on the connection pooling 
   *  requirements.</p>
   *
   *  <p>The Log writer associated with a ManagedConnection instance can be
   *  one set as default from the ManagedConnectionFactory (that created
   *  this connection) or one set specifically for this instance by the 
   *  application server.</p>
   *
   *  @return   Character ourput stream associated with this Managed-
   *            Connection instance
   *     
   *  @throws     ResourceException     generic exception if operation fails
  **/
  public 
  java.io.PrintWriter getLogWriter() throws ResourceException;
}
