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

/**
 * An <code>ApplicationServerInternalException</code> is thrown 
 * by an application 
 * server to indicate error conditions specific to an application server.
 * These error conditions can be related to either configuration related
 * errors or implementation of mechanisms internal to an application server
 * (example: connection pooling, thread management).
 * 
 * @version 1.0
 * @author Rahul Sharma
 * @author Ram Jeyaraman
 */

public class ApplicationServerInternalException 
        extends jakarta.resource.ResourceException {

    /**
     * Constructs a new instance with null as its detail message.
     */
    public ApplicationServerInternalException() { super(); }

    /**
     * Constructs a new instance with the specified detail message.
     *
     * @param message the detail message.
     */
    public ApplicationServerInternalException(String message) {
	super(message);
    }

    /**
     * Constructs a new throwable with the specified cause.
     *
     * @param cause a chained exception of type 
     * <code>Throwable</code>.
     */
    public ApplicationServerInternalException(Throwable cause) {
	super(cause);
    }

    /**
     * Constructs a new throwable with the specified detail message and cause.
     *
     * @param message the detail message.
     *
     * @param cause a chained exception of type 
     * <code>Throwable</code>.
     */
    public ApplicationServerInternalException(
            String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Constructs a new throwable with the specified detail message and 
     * an error code.
     *
     * @param message a description of the exception.
     * @param errorCode a string specifying the vendor specific error code.
     */
    public ApplicationServerInternalException(
            String message, String errorCode) {
	super(message, errorCode);
    }
}
