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

import java.util.List;
import java.io.Serializable;

/**
 * This interface specifies the methods a {@link Work Work} instance uses to
 * associate a <code>List</code> of {@link WorkContext WorkContext} instances to
 * be set when the <code>Work</code> instance gets executed by a
 * {@link WorkManager WorkManager}.
 * 
 * <p>
 * A <code>Work</code> instance could optionally implement this interface to
 * indicate to the <code>WorkManager</code>, that the <code>WorkContext</code>s
 * provided by this <code>Work</code> instance through the
 * {@link #getWorkContexts() getWorkContexts} method must be used while setting
 * the execution context of the <code>Work</code> instance.
 *
 * If the {@link #getWorkContexts() getWorkContexts} method returns an empty List
 * or null, the WorkManager must treat it as if no additional execution contexts
 * are associated with that Work instance.
 * <p>
 * 
 * @since 1.6
 */
public interface WorkContextProvider extends Serializable {

	/**
	 * Gets an list of <code>WorkContexts</code> that needs to be used by the
	 * <code>WorkManager</code> to set up the execution context while executing
	 * a <code>Work</code> instance.
     * 
	 * @return an <code>List</code> of <code>WorkContext</code> instances.
     * 
	 */
	List<WorkContext> getWorkContexts();
}
