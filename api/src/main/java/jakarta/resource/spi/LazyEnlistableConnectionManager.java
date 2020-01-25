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

import jakarta.resource.ResourceException;

/**
 * This is a mix-in interface that may be optionally implemented by a 
 * <code>ConnectionManager</code> implementation. An implementation of
 * this interface must support the lazy transaction enlistment optimization.
 *
 * @version 1.0
 * @author  Ram Jeyaraman
 */
public interface LazyEnlistableConnectionManager {

    /**
     * This method is called by a resource adapter (that is capable of
     * lazy transaction enlistment optimization) in order to lazily enlist
     * a connection object with a XA transaction. 
     *
     * @param mc The <code>ManagedConnection</code> instance that needs to be
     * lazily associated.
     *
     * @throws  ResourceException Generic exception.
     *
     * @throws  ApplicationServerInternalException 
     *                            Application server specific exception.
     *
     * @throws  ResourceAllocationException
     *                            Failed to allocate system resources for
     *                            connection request.
     *
     * @throws  ResourceAdapterInternalException
     *                            Resource adapter related error condition.
     */
    void lazyEnlist(ManagedConnection mc) throws ResourceException;
}

