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

package jakarta.resource.spi.work;

/**
 * This exception is thrown by a <code>WorkManager</code> to indicate 
 * that a submitted <code>Work</code> instance has been rejected. The 
 * rejection could be due to internal factors or start timeout expiration.
 *
 * <p>This could be thrown only before the execution of a 
 * <code>Work</code> instance starts (that is, before a 
 * thread has been allocated for <code>Work</code> execution).

 * <p>An associated error code indicates the nature of the error condition.
 * Possible error codes are <code>WorkException.START_TIMED_OUT</code>,
 * <code>WorkException.INTERNAL</code> or <code>WorkException.UNDEFINED</code>.
 *
 * @version 1.0
 * @author  Ram Jeyaraman
 */
public class WorkRejectedException extends WorkException {

    /**
     * Constructs a new instance with null as its detail message.
     */
    public WorkRejectedException() { super(); }

    /**
     * Constructs a new instance with the specified detail message.
     *
     * @param message the detail message.
     */
    public WorkRejectedException(String message) {
	super(message);
    }

    /**
     * Constructs a new throwable with the specified cause.
     *
     * @param cause a chained exception of type <code>Throwable</code>.
     */
    public WorkRejectedException(Throwable cause) {
	super(cause);
    }

    /**
     * Constructs a new throwable with the specified detail message and cause.
     *
     * @param message the detail message.
     *
     * @param cause a chained exception of type <code>Throwable</code>.
     */
    public WorkRejectedException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Constructs a new throwable with the specified detail message and
     * an error code.
     *
     * @param message a description of the exception.
     * @param errorCode a string specifying the vendor specific error code.
     */
    public WorkRejectedException(String message, String errorCode) {
	super(message, errorCode);
    }
}
