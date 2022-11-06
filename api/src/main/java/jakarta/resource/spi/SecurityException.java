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
 * A <code>SecurityException</code> indicates error conditions 
 * related to the security
 * contract between an application server and resource adapter. The common
 * error conditions represented by this exception are:
 * <UL>
 * <LI>Invalid security information (represented as a Subject instance) passed
 *     across the security contract - for example, credentials have expired or
 *     have invalid format.
 * <LI>Lack of support for a specific security mechanism in an EIS or resource 
 *     adapter.
 * <LI>Failure to create a connection to an EIS because of failed 
 *     authentication or authorization.
 * <LI>Failure to authenticate a resource principal to an EIS instance 
 *     or failure 
 *     to establish a secure association with an underlying EIS instance.
 * <LI>Access control exception to indicate that a requested access to an EIS 
 *     resource or a request to create a new connection is denied.
 *  </UL>
 *
 * @version 1.0
 * @author Rahul Sharma
 * @author Ram Jeyaraman
 */

public class SecurityException extends jakarta.resource.ResourceException {

    private static final long serialVersionUID = 6087673525816667265L;

    /**
     * Constructs a new instance with null as its detail message.
     */
    public SecurityException() { super(); }

    /**
     * Constructs a new instance with the specified detail message.
     *
     * @param message the detail message.
     */
    public SecurityException(String message) {
	super(message);
    }

    /**
     * Constructs a new throwable with the specified cause.
     *
     * @param cause a chained exception of type <code>Throwable</code>.
     */
    public SecurityException(Throwable cause) {
	super(cause);
    }

    /**
     * Constructs a new throwable with the specified detail message and cause.
     *
     * @param message the detail message.
     *
     * @param cause a chained exception of type <code>Throwable</code>.
     */
    public SecurityException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Constructs a new throwable with the specified detail message and
     * an error code.
     *
     * @param message a description of the exception.
     * @param errorCode a string specifying the vendor specific error code.
     */
    public SecurityException(String message, String errorCode) {
	super(message, errorCode);
    }
}
