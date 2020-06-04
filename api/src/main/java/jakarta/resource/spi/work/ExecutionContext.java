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

package jakarta.resource.spi.work;

import jakarta.resource.NotSupportedException;
import javax.transaction.xa.Xid;

/**
 * This class models an execution context (transaction, security, etc) 
 * with which the <code>Work</code> instance must be executed.  
 * This class is provided as a convenience for easily creating 
 * <code>ExecutionContext</code> instances by extending this class
 * and overriding only those methods of interest.
 *
 * <p>Some reasons why it is better for <code>ExecutionContext</code> 
 * to be a class rather than an interface: 
 * <ul><li>There is no need for a resource adapter to implement this class. 
 * It only needs to implement the context information like 
 * transaction, etc.
 * <li>The resource adapter code does not have to change when the 
 * <code>ExecutionContext</code> class evolves. For example, more context 
 * types could be added to the <code>ExecutionContext</code> class 
 * (in the future) without forcing resource adapter implementations 
 * to change.</ul>
 *
 * Note: Resource adapters that are developed for Jakarta Connectors specification
 * compliant application servers, are recommended to use
 * the <code>TransactionContext</code> interface instead of this 
 * class. See Chapter.11 Generic Work Context in the Connectors 1.6
 * specification for more details.
 *
 * @version 1.0
 * @author  Ram Jeyaraman
 */
public class ExecutionContext {

    /**
     * transaction context.
     */
    private Xid xid;

    /**
     * transaction timeout value.
     */
    private long transactionTimeout = WorkManager.UNKNOWN;


    /**
     * set a transaction context.
     *
     * @param xid transaction context.
     */
    public void setXid(Xid xid) { this.xid = xid; }

    /**
     * @return an Xid object carrying a transaction context, 
     * if any.
     */
    public Xid getXid() { return this.xid; }

    /**
     * Set the transaction timeout value for a imported transaction.
     *
     * @param timeout transaction timeout value in seconds. Only positive
     * non-zero values are accepted. Other values are illegal and are 
     * rejected with a <code>NotSupportedException</code>.
     *
     * @throws NotSupportedException thrown to indicate an illegal timeout 
     * value.
     */
    public void setTransactionTimeout(long timeout) 
	throws NotSupportedException {
	    if (timeout > 0) {
	        this.transactionTimeout = timeout;
	    } else {
	        throw new NotSupportedException("Illegal timeout value");
	    }
    }

    /** 
     * Get the transaction timeout value for a imported transaction.
     *
     * @return the specified transaction timeout value in seconds. When no
     * timeout value or an illegal timeout value had been specified, a value of
     * -1 (<code>WorkManager.UNKNOWN</code>) is returned; the timeout 
     * processing of such a transaction depends on the application server 
     * implementation.
     */
    public long getTransactionTimeout() {
	    return this.transactionTimeout;
    }
}
