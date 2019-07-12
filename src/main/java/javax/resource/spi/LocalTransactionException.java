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

package javax.resource.spi;

/** 
 * A <code>LocalTransactionException</code> represents various 
 * error conditions related to the local transaction management contract. 
 * The Jakarta&trade; Transactions specification specifies the 
 * <code>javax.transaction.xa.XAException</code> class for exceptions 
 * related to XAResource based transaction management contract. 
 *  
 * <p>The <code>LocalTransactionException</code> is used for the local 
 * transaction management contract to indicate the following common 
 * error conditions:
 *  <UL>
 *  <LI>Invalid transaction context when a transaction operation is executed. 
 *      For example, calling <code>commit</code> method on 
 *      <code>LocalTransaction</code> object without an active
 *      local transaction is an error condition.
 *  <LI>Transaction is rolled back instead of getting committed during a 
 *      <code>commit</code> method call on the <code>LocalTransaction</code> 
 *      object.
 *  <LI>An attempt to start a local transaction from the same thread on a
 *      <code>ManagedConnection</code> that is already associated with
 *      an active local transaction.
 *  <LI>Any resource adapter or resource manager specific error conditions 
 *      related to local transaction management. Examples are violation of 
 *      integrity of resources, deadlock detection, communication failure 
 *      during transaction completion, retry required or any internal error
 *      in a resource manager.
 *  </UL>
 *
 * @version 1.0
 * @author Rahul Sharma
 * @author Ram Jeyaraman
 */

public class LocalTransactionException 
        extends javax.resource.ResourceException {

    /**
     * Constructs a new instance with null as its detail message.
     */
    public LocalTransactionException() { super(); }

    /**
     * Constructs a new instance with the specified detail message.
     *
     * @param message the detail message.
     */
    public LocalTransactionException(String message) {
	super(message);
    }

    /**
     * Constructs a new throwable with the specified cause.
     *
     * @param cause a chained exception of type <code>Throwable</code>.
     */
    public LocalTransactionException(Throwable cause) {
	super(cause);
    }

    /**
     * Constructs a new throwable with the specified detail message and cause.
     *
     * @param message the detail message.
     *
     * @param cause a chained exception of type <code>Throwable</code>.
     */
    public LocalTransactionException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Constructs a new throwable with the specified detail message and
     * an error code.
     *
     * @param message a description of the exception.
     * @param errorCode a string specifying the vendor specific error code.
     */
    public LocalTransactionException(String message, String errorCode) {
	super(message, errorCode);
    }
}
