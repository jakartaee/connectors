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

package jakarta.resource.cci;

import jakarta.resource.ResourceException;

/** 
 * This serves as a request-response message listener type that message
 * endpoints (message-driven beans) may implement. This allows an EIS to
 * communicate with an endpoint using a request-response style.
 *
 *  @author  Ram Jeyaraman
 *  @version 1.0
 */    
public interface MessageListener {

    /**
     * This method allows an EIS to call a message endpoint using a 
     * request-response style communication.
     *
     * @param inputData a <code>Record</code> instance.
     *
     * @return a <code>Record</code> instance or null.
     *
     * @throws ResourceException indicates an exceptional condition.
     */
    Record onMessage(Record inputData) throws ResourceException;
}
