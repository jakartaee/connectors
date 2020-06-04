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
 * A subclass of the <code>UnavailableException</code> that 
 * indicates that the rejection of the work submission is transient. 
 * It is thrown in situations where the previously failed work submission 
 * might be able to succeed if the resource adapter retries the operation
 * at a later point in time.
 * 
 * @since 1.6
 */
public class RetryableUnavailableException 
				extends UnavailableException
				implements RetryableException {
	/**
	 * Determines if a deserialized instance of this class
	 * is compatible with this class.
	 */
	private static final long serialVersionUID = 3730185319227786830L;

    /**
     * Constructs a new instance with null as its detail message.
     */
	public RetryableUnavailableException() {
		super();
	}

    /**
     * Constructs a new instance with the specified detail message.
     *
     * @param message the detail message.
     */
	public RetryableUnavailableException(String message) {
		super(message);
	}

    /**
     * Constructs a new throwable with the specified cause.
     *
     * @param cause a chained exception of type 
     * <code>Throwable</code>.
     */
	public RetryableUnavailableException(Throwable cause) {
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
	public RetryableUnavailableException(String message, Throwable cause) {
		super(message, cause);
	}

    /**
     * Constructs a new throwable with the specified detail message and
     * an error code.
     *
     * @param message a description of the exception.
     * @param errorCode a string specifying the vendor specific error code.
     */
	public RetryableUnavailableException(String message, String errorCode) {
		super(message, errorCode);
	}

}
