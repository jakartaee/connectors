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

import java.lang.NoSuchMethodException;
import javax.transaction.xa.XAResource;
import jakarta.resource.spi.UnavailableException;

/**
 * This serves as a factory for creating message endpoints.
 *
 * @version 1.7
 * @since 1.5
 * @author  Ram Jeyaraman, Sivakumar Thyagarajan
 */
public interface MessageEndpointFactory {

    /**
     * This is used to create a message endpoint. The message endpoint is
     * expected to implement the correct message listener type.
     *
     * @param xaResource an optional <code>XAResource</code> 
     * instance used to get transaction notifications when the message delivery
     * is transacted.
     *
     * @return a message endpoint instance.
     *
     * @throws UnavailableException indicates a transient failure
     * in creating a message endpoint. Subsequent attempts to create a message
     * endpoint might succeed.
     */
    MessageEndpoint createEndpoint(XAResource xaResource)
	throws UnavailableException;

    /**
     * This is used to create a message endpoint. The message endpoint is
     * expected to implement the correct message listener type.
     *
     * @param xaResource an optional <code>XAResource</code> 
     * instance used to get transaction notifications when the message delivery
     * is transacted.
     * 
     * @param timeout an optional value used to specify the time duration
     * (in milliseconds) within which the message endpoint needs to be
     * created by the <code>MessageEndpointFactory</code>. Otherwise, the
     * <code>MessageEndpointFactory</code> rejects the creation of the
     * <code>MessageEndpoint</code> with an UnavailableException.  Note, this
     * does not offer real-time guarantees.
     * 
     * @return a message endpoint instance.
     *
     * @throws UnavailableException indicates a transient failure
     * in creating a message endpoint. Subsequent attempts to create a message
     * endpoint might succeed.
     * @since 1.6
     */
    MessageEndpoint createEndpoint(XAResource xaResource, long timeout)
    throws UnavailableException;

    /**
     * This is used to find out whether message deliveries to a target method
     * on a message listener interface that is implemented by a message 
     * endpoint or a target method in the <code>Class</code> returned by the 
     * <code>getBeanClass</code> method, will be transacted or not. 
     *
     * The message endpoint may indicate its transacted delivery preferences 
     * (at a per method level) through its deployment descriptor. The message 
     * delivery preferences must not change during the lifetime of a 
     * message endpoint. 
     * 
     * @param method description of a target method. This information about
     * the intended target method allows an application server to find out 
     * whether the target method call will be transacted or not.
     *
     * @throws NoSuchMethodException indicates that the specified method
     * does not exist on the target endpoint.
     *
     * @return true, if message endpoint requires transacted message delivery.
     */
    boolean isDeliveryTransacted(java.lang.reflect.Method method)
	throws NoSuchMethodException;
    
    /**
     * Returns a unique name for the message endpoint deployment represented
     * by the <code>MessageEndpointFactory</code>. If the message endpoint has 
     * been deployed into a clustered application server then this method must 
     * return the same name for that message endpoint’s activation in each 
     * application server instance. 
     * 
     * It is recommended that this name be human-readable since this name may
     * be used by the resource adapter in ways that may be visible to a user
     * or administrator. 
     * 
     * It is also recommended that this name remain unchanged even in cases 
     * when the application server is restarted or the message endpoint 
     * redeployed.
     *
     * @return a new <code>String</code> instance representing the unique
     * name of the message endpoint deployment
     *
     * @since 1.7
     */
    String getActivationName();

    /**
     * Return the <code>Class</code> object corresponding to the message
     * endpoint class. For example, for a Message Driven Bean this is the 
     * <code>Class</code> object corresponding to the application's MDB class.  
     * 
     * The resource adapter may use this to introspect the 
     * message endpoint class to discover annotations, interfaces implemented, 
     * etc. and modify the behavior of the resource adapter accordingly.
     * 
     * A return value of <code>null</code> indicates that the 
     * <code>MessageEndpoint</code> doesn't implement the business methods of 
     * underlying message endpoint class. 
     * 
     * @return A <code>Class</code> corresponding to the message endpoint class.
     * 
     * @since 1.7
     */
    public Class<?> getEndpointClass();
}
