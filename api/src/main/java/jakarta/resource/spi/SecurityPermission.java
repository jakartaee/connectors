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
import static java.lang.annotation.RetentionPolicy.*;

/**
 * The SecurityPermission annotation can be used by the developer, as part of
 * the Connector annotation, to specify the extended security permissions
 * required by the resource adapter
 * 
 * @since 1.6
 */

@Documented
@Retention(RUNTIME)
@Target({})
/* The <code>SecurityPermission</code> declared type is intended 
solely for use as a member type in complex annotation type declarations
like <code>Connector</code>.
*/

public @interface SecurityPermission {
	/**
	 * Specifies an optional description to mention any specific reason that a
	 * resource requires a given security permission.
	 */
	String[] description() default {};

	/**
	 * Specifies a security permission based on the Security policy file syntax.
	 * These security permissions are different from those required by the
	 * default permission set as specified in the connector specification.
	 */
	String permissionSpec() default "";
}
