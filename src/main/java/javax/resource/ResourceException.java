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

package javax.resource;

/**
 * This is the root interface of the exception hierarchy defined
 * for Jakarta&trade; Connectors.
 * 
 * The ResourceException provides the following information:
 * <UL>
 *   <LI> A resource adapter vendor specific string describing the error.
 *        This string is a standard Java exception message and is available
 *        through getMessage() method.
 *   <LI> resource adapter vendor specific error code.
 *   <LI> reference to another exception. Often a resource exception
 *        will be result of a lower level problem. If appropriate, this
 *        lower level exception can be linked to the ResourceException.
 *        Note, this has been deprecated in favor of Java&trade; SE release 1.4 exception
 *        chaining facility.
 * </UL>
 *
 * @version 1.0
 * @author Rahul Sharma
 * @author Ram Jeyaraman
 */

public class ResourceException extends java.lang.Exception {

    /** Vendor specific error code */
    private String errorCode;

    /** reference to another exception */
    private Exception linkedException;

    /**
     * Constructs a new instance with null as its detail message.
     */
    public ResourceException() { super(); }

    /**
     * Constructs a new instance with the specified detail message.
     *
     * @param message the detail message.
     */
    public ResourceException(String message) {
	super(message);
    }

    /**
     * Constructs a new throwable with the specified cause.
     *
     * @param cause a chained exception of type <code>Throwable</code>.
     */
    public ResourceException(Throwable cause) {
	super(cause);
    }

    /**
     * Constructs a new throwable with the specified detail message and cause.
     *
     * @param message the detail message.
     *
     * @param cause a chained exception of type <code>Throwable</code>.
     */
    public ResourceException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Create a new throwable with the specified message and error code.
     *
     * @param message a description of the exception.
     * @param errorCode a string specifying the vendor specific error code.
     */
    public ResourceException(String message, String errorCode) {
	super(message);
	this.errorCode = errorCode;
    }    

    /**
     * Set the error code.
     *
     * @param errorCode the error code.
     */
    public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
    }

    /**
     * Get the error code.
     *
     * @return the error code.
     */
    public String getErrorCode() {
	return this.errorCode;
    }

    /**
     * Get the exception linked to this ResourceException
     *
     * @return         linked Exception, null if none
     *
     * @deprecated Java SE release 1.4 supports a chained exception facility 
     * that allows any throwable to know about another throwable, if any,
     * that caused it to get thrown. Refer to <code>getCause</code> and 
     * <code>initCause</code> methods of the 
     * <code>java.lang.Throwable</code> class..
     */
    public Exception getLinkedException() {
	return (linkedException);
    }

    /**
     * Add a linked Exception to this ResourceException.
     *
     * @param ex       linked Exception
     *
     * @deprecated Java SE release 1.4 supports a chained exception facility 
     * that allows any throwable to know about another throwable, if any,
     * that caused it to get thrown. Refer to <code>getCause</code> and 
     * <code>initCause</code> methods of the 
     * <code>java.lang.Throwable</code> class.
     */
    public void setLinkedException(Exception ex) {
	linkedException = ex;
    }

    /**
     * Returns a detailed message string describing this exception.
     *
     * @return a detailed message string.
     */
    public String getMessage() {
	String msg = super.getMessage();
	String ec = getErrorCode();
	if ((msg == null) && (ec == null)) {
	    return null;
	}
	if ((msg != null) && (ec != null)) {
	    return (msg + ", error code: " + ec);
	}
	return ((msg != null) ? msg : ("error code: " + ec));
    }
}
