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

/**
 * This interface models a <code>WorkManager</code> that supports distributed
 * execution of Work instances.
 * 
 * <p>
 * A <code>DistributableWorkManager</code> may choose to distribute a
 * <code>Work</code> instance submitted by a resource adapter to another
 * <code>WorkManager</code> instance running in a different Java&trade; virtual machine
 * (that is running in the same host or different hosts) for achieving optimal
 * resource utilization or for providing better response times.
 * 
 * <p>
 * A <code>WorkManager</code> implementation that supports the submission of
 * <code>DistributableWork</code> instances must implement the
 * <code>DistributableWorkManager</code> marker interface.
 * 
 * @since 1.6
 */
public interface DistributableWorkManager extends WorkManager {
	
}
