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

package jakarta.resource.spi.endpoint;

import jakarta.resource.ResourceException;
import jakarta.resource.spi.IllegalStateException;
import jakarta.resource.spi.UnavailableException;

/**
 * This defines a contract for a message endpoint. This is implemented by an
 * application server.
 *
 * @version 1.0
 * @author  Ram Jeyaraman
 */
public interface MessageEndpoint {

    /**
     * This is called by a resource adapter before a message is delivered.
     *
     * @param method description of a target method. This information about
     * the intended target method allows an application server to decide 
     * whether to start a transaction during this method call, depending 
     * on the transaction preferences of the target method.
     * The processing (by the application server) of the actual message 
     * delivery method call on the endpoint must be independent of the 
     * class loader associated with this descriptive method object. 
     *
     * @throws NoSuchMethodException indicates that the specified method
     * does not exist on the target endpoint.
     *
     * @throws ResourceException generic exception.
     *
     * @throws ApplicationServerInternalException indicates an error 
     * condition in the application server.
     *
     * @throws IllegalStateException indicates that the endpoint is in an
     * illegal state for the method invocation. For example, this occurs when
     * <code>beforeDelivery</code> and <code>afterDelivery</code> 
     * method calls are not paired.
     *
     * @throws UnavailableException indicates that the endpoint is not 
     * available.
     */
    void beforeDelivery(java.lang.reflect.Method method)
	throws NoSuchMethodException, ResourceException;

    /**
     * This is called by a resource adapter after a message is delivered.
     *
     * @throws ResourceException generic exception.
     *
     * @throws ApplicationServerInternalException indicates an error 
     * condition in the application server.
     *
     * @throws IllegalStateException indicates that the endpoint is in an
     * illegal state for the method invocation. For example, this occurs when
     * beforeDelivery and afterDelivery method calls are not paired.
     *
     * @throws UnavailableException indicates that the endpoint is not 
     * available.
     */
    void afterDelivery() throws ResourceException;

    /**
     * This method may be called by the resource adapter to indicate that it
     * no longer needs a proxy endpoint instance. This hint may be used by
     * the application server for endpoint pooling decisions.
     */
    void release();
}
