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

import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Defines a set of connection definitions that the JavaBean, that has been
 * annotated with this annotation, is a part of. This annotation can be placed
 * only on a JavaBean that implements the {@link ManagedConnectionFactory
 * ManagedConnectionFactory} interface.
 * 
 * @since 1.6
 */

@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface ConnectionDefinitions {

	/**
	 * An array of {@link ConnectionDefinition ConnectionDefinition}s associated
	 * with the <code>ManagedConectionFactory</code> JavaBean.
	 * 
	 * @return an array of <code>ConnectionDefinition</code>s associated with
     * the <code>ManagedConnectionFactory</code> instance.
	 */
	ConnectionDefinition[] value();

}
