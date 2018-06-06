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

package javax.resource.cci;

/**
 * A <code>ResourceWarning</code> provides information on warnings related to
 * execution of an interaction with an EIS. Warnings are silently 
 * chained to the object whose method caused it to be reported.
 *
 * @see Interaction#getWarnings
 */
public class ResourceWarning extends javax.resource.ResourceException {

    /**
     * Constructs a new instance with null as its detail message.
     */
    public ResourceWarning() { super(); }

    /**
     * Constructs a new instance with the specified detail message.
     *
     * @param message the detail message.
     */
    public ResourceWarning(String message) {
	super(message);
    }

    /**
     * Constructs a new throwable with the specified cause.
     *
     * @param cause a chained exception of type 
     * <code>Throwable</code>.
     */
    public ResourceWarning(Throwable cause) {
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
    public ResourceWarning(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Constructs a new throwable with the specified detail message and 
     * an error code.
     *
     * @param message a description of the exception.
     * @param errorCode a string specifying the vendor specific error code.
     */
    public ResourceWarning(String message, String errorCode) {
	super(message, errorCode);
    }
  
    /**
     * Retrieves the warning chained to this <code>ResourceWarning</code>
     * object.
     *
     * @return next <code>ResourceWarning</code> in the chain; null if none.
     *
     * @deprecated J2SE release 1.4 supports a chained exception facility 
     * that allows any throwable to know about another throwable, if any,
     * that caused it to get thrown. Refer to <code>getCause</code> and 
     * <code>initCause</code> methods of the 
     * <code>java.lang.Throwable</code> class.
     */
    public ResourceWarning getLinkedWarning() {
	try {
	    return ((ResourceWarning)getLinkedException());
	} 
	catch (ClassCastException ex) {
	    return null;
	}
    }
  
    /**
     * Adds an <code>ResourceWarning</code> object to the end of the chain.
     *
     * @param warning <code>ResourceWarning</code> to be added to the chain.
     *
     * @deprecated J2SE release 1.4 supports a chained exception facility 
     * that allows any throwable to know about another throwable, if any,
     * that caused it to get thrown. Refer to <code>getCause</code> and 
     * <code>initCause</code> methods of the 
     * <code>java.lang.Throwable</code> class.
     */
    public void setLinkedWarning(ResourceWarning warning) {
	setLinkedException(warning);
    }
}
