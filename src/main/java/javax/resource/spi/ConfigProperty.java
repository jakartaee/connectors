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
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Designates a JavaBean property as a configuration property
 * 
 * @since 1.6
 * @version Java EE Connector Architecture 1.6
 */

@Documented
@Retention(RUNTIME)
@Target( { FIELD, METHOD })
public @interface ConfigProperty {

	/**
	 * Inferred by the container if unspecified.
	 */
	Class type() default Object.class;

    /**
     * Describes the configuration property.
     */
	String[] description() default {};

	/**
	 * Inferred by the container for field based annotations if possible.
	 */
	String defaultValue() default "";

	/**
	 * Indicates that the configuration tools must ignore considering this
	 * Property during auto-discovery of Configuration properties.
	 */
	boolean ignore() default false;
	
	/**
	 * Indicates that the configuration property supports
	 * dynamic updates to its value during the lifetime of
	 * the JavaBean
	 */
	boolean supportsDynamicUpdates() default false;
	
	/**
	 * Indicates that the configuration property is confidential and
	 * recommends application server's configuration tools to 
	 * use special visual aids for editing them. 
	 */
	boolean confidential() default false;
}
