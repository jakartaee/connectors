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
 * This interface specifies the methods to associate a 
 * <code>ResourceAdapter</code> object with other objects that 
 * implement this interface like 
 * <code>ManagedConnectionFactory</code> and <code>ActivationSpec</code>.
 *
 * @version 1.0
 * @author  Ram Jeyaraman
 */
public interface ResourceAdapterAssociation {

    /**
     * Get the associated <code>ResourceAdapter</code> object.
     *
     * @return the associated <code>ResourceAdapter</code> object.
     */
    ResourceAdapter getResourceAdapter();

    /**
     * Associate this object with a <code>ResourceAdapter</code> object. 
     * Note, this method must be called exactly once. That is, the 
     * association must not change during the lifetime of this object.
     *
     * @param ra <code>ResourceAdapter</code> object to be associated with.
     *
     * @throws ResourceException generic exception.
     *
     * @throws ResourceAdapterInternalException
     *            resource adapter related error condition.
     *
     * @throws IllegalStateException indicates that this object is in an
     * illegal state for the method invocation. For example, this occurs when
     * this method is called more than once on the same object.
     */
    void setResourceAdapter(ResourceAdapter ra) throws ResourceException;
}

