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

import jakarta.resource.ResourceException;

/**
 * This is a mix-in interface that may be optionally implemented by a
 * <code>ManagedConnection</code> implementation. An implementation of this
 * interface must support the lazy connection association optimization.
 * 
 * @version 1.0
 * @author Ram Jeyaraman
 */
public interface DissociatableManagedConnection {

	/**
	 * This method is called by an application server (that is capable of lazy
	 * connection association optimization) in order to dissociate a
	 * <code>ManagedConnection</code> instance from all of its connection
	 * handles.
	 * 
	 * @throws ResourceException
	 *             generic exception if operation fails.
	 * 
	 * @throws ResourceAdapterInternalException
	 *             resource adapter internal error condition
	 * 
	 * @throws IllegalStateException
	 *             Illegal state for dissociating a
	 *             <code>ManagedConnection</code> from all of its connection
	 *             handles.
	 */
	void dissociateConnections() throws ResourceException;

}
