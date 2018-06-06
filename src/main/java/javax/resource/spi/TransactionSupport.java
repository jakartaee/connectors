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
 * This interface may be optionally implemented by a 
 * <code>ManagedConnectionFactory</code> to provide its level of transaction
 * support at runtime.
 *
 * <p>When a <code>ManagedConnectionFactory</code> implements this interface,
 * the application server uses the <code>TransactionSupportLevel</code> returned
 * by getTransactionSupport() method and not the value specified in the 
 * resource adapter deployment descriptor or deployer configuration
 *
 * @since 1.6
 * @version Java EE Connector Architecture 1.6
 */
public interface TransactionSupport extends java.io.Serializable {

    /**
     * An enumerated type that represents the levels of transaction support
     * a resource adapter may support.
     *
     * @since 1.6
     * @version Java EE Connector Architecture 1.6
     */
    public enum TransactionSupportLevel {
        /**
         * The resource adapter supports neither resource manager nor JTA 
         * transactions.
         * @since 1.6
         */
        NoTransaction, 
        /**
         * The resource adapter supports resource manager local transactions 
         * by implementing the <code>LocalTransaction</code> interface.
         * @since 1.6
         */
        LocalTransaction, 
        /**
         * The resource adapter supports both resource manager local 
         * and JTA transactions by implementing the <code>LocalTransaction</code>
         * and <code>XAResource</code> interfaces.
         * @since 1.6
         */
        XATransaction 
    };

    /**
     * Get the level of transaction support, supported by the 
     * <code>ManagedConnectionFactory</code>. A resource adapter must always
     * return a level of transaction support whose ordinal value in
     * <code>TransactionSupportLevel</code> enum is equal to or lesser than
     * the resource adapter's transaction support classification.
     *
     * @since 1.6
     */
    public TransactionSupportLevel getTransactionSupport();
}
