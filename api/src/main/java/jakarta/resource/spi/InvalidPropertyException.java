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

package jakarta.resource.spi;

import java.beans.PropertyDescriptor;

/**
 * This exception is thrown to indicate invalid configuration 
 * property settings.
 *
 * @version 0.2
 * @author Ram Jeyaraman
 */
public class InvalidPropertyException
        extends jakarta.resource.ResourceException {

    /*
     * Holder for invalid properties.
     */
    private PropertyDescriptor[] invalidProperties;

    /**
     * Create a InvalidPropertyException.
     */
    public InvalidPropertyException() {
	super();
    }

    /**
     * Create a InvalidPropertyException.
     *
     * @param message a description of the exception
     */
    public InvalidPropertyException(String message) {
	super(message);
    }

    /**
     * Constructs a new throwable with the specified cause.
     *
     * @param cause a chained exception of type <code>Throwable</code>.
     */
    public InvalidPropertyException(Throwable cause) {
	super(cause);
    }

    /**
     * Constructs a new throwable with the specified detail message and cause.
     *
     * @param message the detail message.
     *
     * @param cause a chained exception of type <code>Throwable</code>.
     */
    public InvalidPropertyException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Constructs a new throwable with the specified detail message and
     * an error code.
     *
     * @param message a description of the exception.
     * @param errorCode a string specifying the vendor specific error code.
     */
    public InvalidPropertyException(String message, String errorCode) {
	super(message, errorCode);
    }

    /**
     * Set a list of invalid properties.
     */
    public void setInvalidPropertyDescriptors(
            PropertyDescriptor[] invalidProperties) {
	this.invalidProperties = invalidProperties;
    }

    /**
     * Get the list of invalid properties.
     */
    public PropertyDescriptor[] getInvalidPropertyDescriptors() {
        return this.invalidProperties;
    }
}
