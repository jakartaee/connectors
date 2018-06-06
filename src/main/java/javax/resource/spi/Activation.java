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

import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Designates a JavaBean as an <code>ActivationSpec</code>. This annotation may
 * be placed on a JavaBean. A JavaBean annotated with the Activation annotation
 * is not required to implement the {@link ActivationSpec ActivationSpec}
 * interface.
 * 
 * <p>The ActivationSpec JavaBean contains the configuration information pertaining
 * to inbound connectivity from an EIS instance. A resource adapter capable of
 * message delivery to message endpoints must provide an JavaBean class
 * implementing the {@link ActivationSpec ActivationSpec} interface or annotate
 * a JavaBean with the <code>Activation</code> annotation for each supported
 * endpoint message listener type.
 * 
 * <p>The ActivationSpec JavaBean has a set of configurable properties specific to
 * the messaging style and the message provider.
 * 
 * <p>Together with the messageListener annotation element, this annotation
 * specifies information about a specific message listener type supported by the
 * messaging resource adapter.
 * 
 * @since 1.6
 * @version Java EE Connector Architecture 1.6
 */

@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface Activation {

	/**
	 * Indicates the message listener type(s) associated with this activation.
	 * 
	 * @return The Java types of the Message Listener interface this
	 *         activation-spec is associated with.
	 */
	Class[] messageListeners();
}
