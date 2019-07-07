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
 * A <code>ResourceAdapterInternalException</code> indicates any 
 * system-level error conditions related to a resource adapter. 
 * The common conditions indicated by this exception type are:
 *  <UL>
 *  <LI>Invalid configuration for creation of a new physical connection. An
        example is invalid server name for a target EIS instance.
 *  <LI>Failure to create a physical connection to a EIS instance due to 
 *      communication protocol error or any resource adapter implementation 
 *      specific error.
 *  <LI>Error conditions internal to resource adapter implementation.
 *  </UL>
 *
 * @version 1.0
 * @author Rahul Sharma
 * @author Ram Jeyaraman
 */

public class ResourceAdapterInternalException 
        extends javax.resource.ResourceException {

    /**
     * Constructs a new instance with null as its detail message.
     */
    public ResourceAdapterInternalException() { super(); }

    /**
     * Constructs a new instance with the specified detail message.
     *
     * @param message the detail message.
     */
    public ResourceAdapterInternalException(String message) {
	super(message);
    }

    /**
     * Constructs a new throwable with the specified cause.
     *
     * @param cause a chained exception of type <code>Throwable</code>.
     */
    public ResourceAdapterInternalException(Throwable cause) {
	super(cause);
    }

    /**
     * Constructs a new throwable with the specified detail message and cause.
     *
     * @param message the detail message.
     *
     * @param cause a chained exception of type <code>Throwable</code>.
     */
    public ResourceAdapterInternalException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Constructs a new throwable with the specified detail message and
     * an error code.
     *
     * @param message a description of the exception.
     * @param errorCode a string specifying the vendor specific error code.
     */
    public ResourceAdapterInternalException(String message, String errorCode) {
	super(message, errorCode);
    }
}
