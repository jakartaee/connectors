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

import java.util.EventListener;

/**
 * This models a <code>WorkListener</code> instance which would be notified
 * by the <code>WorkManager</code> when the various <code>Work</code> 
 * processing events (work accepted, work rejected, work started, 
 * work completed) occur.
 *
 * The <code>WorkListener</code> instance must not make any thread 
 * assumptions and must be thread-safe ie., a notification could 
 * occur from any arbitrary thread. Further, it must not make any
 * assumptions on the ordering of notifications.
 *
 * @version 1.0
 * @author  Ram Jeyaraman
 */
public interface WorkListener extends EventListener {

    /** 
     * Invoked when a <code>Work</code> instance has been accepted.
     *
     * @param e A <code>WorkEvent</code> object that provides more 
     * information about the accepted Work.
     */
    void workAccepted(WorkEvent e);

    /** 
     * Invoked when a <code>Work</code> instance has been rejected.
     *
     * @param e A <code>WorkEvent</code> object that provides more 
     * information about the rejected Work.
     */
    void workRejected(WorkEvent e);

    /** 
     * Invoked when a <code>Work</code> instance has started execution.
     * This only means that a thread has been allocated.
     *
     * @param e A <code>WorkEvent</code> object that provides more 
     * information about the rejected Work.
     */
    void workStarted(WorkEvent e);

    /** 
     * Invoked when a <code>Work</code> instance has completed execution.
     *
     * @param e A <code>WorkEvent</code> object that provides more 
     * information about the completed Work.
     */
    void workCompleted(WorkEvent e);
}
