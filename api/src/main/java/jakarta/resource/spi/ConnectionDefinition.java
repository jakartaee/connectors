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

import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Defines a set of connection interfaces and classes pertaining to a particular
 * connection type. This annotation can be placed only on a JavaBean that
 * implements the {@link ManagedConnectionFactory ManagedConnectionFactory}
 * interface.
 * 
 * @since 1.6
 * 
 */

@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Repeatable(ConnectionDefinitions.class)
public @interface ConnectionDefinition {

	/**
	 * Specifies the ConnectionFactory interface supported by the resource
	 * adapter. Example: jakarta.resource.cci.ConnectionFactory or
	 * com.wombat.ConnectionFactory
         * @return the ConnectionFactory interface
	 */
	Class connectionFactory();

	/**
	 * Specifies the Class provided by the resource adapter that implements the
	 * resource adapter specific ConnectionFactory interface. Example:
	 * com.wombat.ConnectionFactoryImpl
         * @return the implementation class of the ConnectionFactory interface
	 */
	Class connectionFactoryImpl();

	/**
	 * Specifies the Connection interface supported by the resource adapter.
	 * Example: jakarta.resource.cci.Connection or com.wombat.Connection
         * @return the Connection interface
	 */
	Class connection();

	/**
	 * Specifies the class provided by the resource adapter that implements the
	 * resource adapter specific Connection interface. Example:
	 * com.wombat.ConnectionImpl
         * @return the implementation class of the Connection interface
	 */
	Class connectionImpl();

}
