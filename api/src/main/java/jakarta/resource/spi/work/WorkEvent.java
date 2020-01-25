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

package jakarta.resource.spi.work;

import java.lang.Object;
import java.lang.Runnable;
import java.lang.Exception;
import java.lang.Throwable;
import java.util.EventObject;

/**
 * This class models the various events that occur during the processing of
 * a <code>Work</code> instance.
 *
 * @version 1.0
 * @author  Ram Jeyaraman
 */
public class WorkEvent extends EventObject {

    /**
     * Indicates <code>Work</code> instance has been accepted.
     */
    public static final int WORK_ACCEPTED = 1;

    /**
     * Indicates <code>Work</code> instance has been rejected.
     */
    public static final int WORK_REJECTED = 2;

    /**
     * Indicates <code>Work</code> instance has started execution.
     */
    public static final int WORK_STARTED = 3;

    /**
     * Indicates <code>Work</code> instance has completed execution.
     */
    public static final int WORK_COMPLETED = 4;

    /**
     * The event type.
     */
    private int type;

    /**
     * The <code>Work</code> object on which the event occured.
     */
    private Work work;

    /**
     * The exception that occured during <code>Work</code> processing.
     */
    private WorkException exc;

    /**
     * The start delay duration (in milliseconds).
     */
    private long startDuration = WorkManager.UNKNOWN;

    /**
     * Constructor.
     *
     * @param source The object on which the event initially 
     * occurred.
     *
     * @param type The event type.
     *
     * @param work The <code>Work</code> object on which 
     * the event occured.
     *
     * @param exc The exception that occured during 
     * <code>Work</code> processing.

    */
    public WorkEvent(Object source, int type, Work work, WorkException exc) {
	super(source);
	this.type = type;
	this.work =  work;
	this.exc = exc;
    }

    /**
     * Constructor.
     *
     * @param source The object on which the event initially 
     * occurred.
     *
     * @param type The event type.
     *
     * @param work The <code>Work</code> object on which 
     * the event occured.
     *
     * @param exc The exception that occured during 
     * <code>Work</code> processing.
     *
     * @param startDuration The start delay duration 
     * (in milliseconds).
     */
    public WorkEvent(Object source, int type, Work work, WorkException exc,
            long startDuration) {
	this(source, type, work, exc);
	this.startDuration = startDuration;
    }

    /**
     * Return the type of this event.
     *
     * @return the event type.
     */
    public int getType() { return this.type; }

    /**
     * Return the <code>Work</code> instance which is the cause of the event.
     *
     * @return the <code>Work</code> instance.
     */
    public Work getWork() { return this.work; }

    /**
     * Return the start interval duration.
     *
     * @return the time elapsed (in milliseconds) since the <code>Work</code>
     * was accepted, until the <code>Work</code> execution started. Note, 
     * this does not offer real-time guarantees. It is valid to return -1, if
     * the actual start interval duration is unknown.
     */
    public long getStartDuration() { return this.startDuration; }

    /**
     * Return the <code>WorkException</code>. The actual 
     * <code>WorkException</code> subtype returned depends on the type of the
     * event.
     *
     * @return a <code>WorkRejectedException</code> or a 
     * <code>WorkCompletedException</code>, if any.
     */
    public WorkException getException() { return this.exc; }
}
