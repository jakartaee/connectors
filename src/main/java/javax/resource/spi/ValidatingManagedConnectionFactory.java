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

package javax.resource.spi;

import java.util.Set;
import javax.resource.ResourceException;

/** 
 * This interface is implemented by a <code>ManagedConnectionFactory</code>
 * instance that supports the ability to validate 
 * <code>ManagedConnection</code> objects.
 *
 * <p>This may be used by the application server to prune invalid 
 * <code>ManagedConnection</code> objects from its connection pool.
 *
 * <p>The application server may use this functionality to test the
 * validity of a <code>ManagedConnection</code> by passing in a 
 * <code>Set</code> of size one( with the <code>ManagedConnection</code>
 * that has to be tested for validity as the only member of the 
 * <code>Set</code>.
 * 
 *
 *  @author  Ram Jeyaraman
 *  @version 1.0
 */    
public interface ValidatingManagedConnectionFactory {

    /**
     * This method returns a set of invalid <code>ManagedConnection</code> 
     * objects chosen from a specified set of <code>ManagedConnection</code>
     * objects.
     *
     * @param connectionSet a set of <code>ManagedConnection</code> objects
     * that need to be validated.
     *
     * @return a set of invalid <code>ManagedConnection</code> objects.
     *
     * @throws ResourceException generic exception.
     */
    Set getInvalidConnections(Set connectionSet) throws ResourceException;
}
