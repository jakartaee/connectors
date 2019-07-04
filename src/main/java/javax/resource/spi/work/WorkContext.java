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

package javax.resource.spi.work;

import java.io.Serializable;

/**
 * This class serves as a standard mechanism for a resource adapter to propagate
 * an imported context from an enterprise information system to an application
 * server.
 * 
 * <p>
 * A <code>Work</code> instance, that implements the
 * <code>WorkContextProvider</code>, could provide a <code>List</code> of these
 * <code>WorkContext</code> instances (through the getWorkContexts() method),
 * and have them setup as the execution context by the <code>WorkManager</code>
 * when the <code>Work</code> instance gets executed.
 *
 * The resource adapter must not make any changes to the state of the 
 * <code>WorkContext</code> after the <code>Work</code> instance corresponding 
 * to that <code>WorkContext</code> has been submitted to the <code>WorkManager</code>.
 *
 * @since 1.6
 */

public interface WorkContext extends Serializable {
	/**
	 * Get the associated name of the <code>WorkContext</code>. This could be
	 * used by the WorkManager and the resource adapter for debugging purposes.
	 * <p>
	 * 
	 * @return the associated name of the <code>WorkContext</code>
	 */
	String getName();

	/**
	 * Get the brief description of the role played by the
	 * <code>WorkContext</code> and any other related debugging information.
	 * This could be used by the WorkManager and the resource adapter for
	 * debugging purposes.
	 * <p>
	 * 
	 * @return the associated description of the <code>WorkContext</code>
	 */
	String getDescription();

}
