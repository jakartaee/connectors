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

package jakarta.resource.spi.work;

import java.lang.Object;
import java.lang.Runnable;
import java.lang.Exception;
import java.lang.Throwable;

/**
 * This class is provided as a convenience for easily creating 
 * <code>WorkListener</code> instances by extending this class
 * and overriding only those methods of interest.
 *
 * @version 1.0
 * @author  Ram Jeyaraman
 */
public class WorkAdapter implements WorkListener {

    /** 
     * Invoked when a <code>Work</code> instance has been accepted.
     */
    public void workAccepted(WorkEvent e) {}

    /** 
     * Invoked when a <code>Work</code> instance has been rejected.
     */
    public void workRejected(WorkEvent e) {}

    /** 
     * Invoked when a <code>Work</code> instance has started execution.
     * This only means that a thread has been allocated.
     */
    public void workStarted(WorkEvent e) {}

    /** 
     * Invoked when a <code>Work</code> instance has completed execution.
     */
    public void workCompleted(WorkEvent e) {}
}
