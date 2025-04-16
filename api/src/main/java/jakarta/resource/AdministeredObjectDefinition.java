/*
 * Copyright (c) 2012, 2020 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2025 Contributors to Eclipse Foundation. All rights reserved.
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

package jakarta.resource;

import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 *  Annotation used to define a Connector administered object to be
 *  registered in JNDI.
 *
 *  Once defined, an administered object may be referenced
 *  by a component using the <code>lookup</code> element of the
 *  <code>Resource</code> annotation.
 *
 *  @see jakarta.annotation.Resource
 *  @version 1.7
 *  @since 1.7
 */
@Retention(RUNTIME)
@Target({TYPE})
@Repeatable(AdministeredObjectDefinitions.class)
public @interface AdministeredObjectDefinition {

    /**
     * JNDI name of the administered object being defined.
     * @return name
     */
    String name();
    
    /**
     * Description of the administered object.
     * @return description
     */
    String description() default "";

    /**
     *  The name of the resource adapter that the administered object must be 
     *  created from. The resource adapter is required to be available at 
     *  deployment time.
     * @return resource adapter
     */
    String resourceAdapter();

    /**
     *  Fully qualified name of the administered object’s class
     * @return className
     */
    String className();

    /**
     *  Fully qualified name of the administered object’s interface 
     * @return fully qualified name
     */
    String interfaceName() default "";

    /**
     *  Properties of the administered object.  These properties may be
     *  vendor-specific properties. Vendor-specific properties may be combined 
     *  with or used to override the administered object properties 
     *  defined using this annotation.
     *  
     *  Administered Object properties that are specified and are not supported 
     *  in a given resource adapter or cannot be mapped to a vendor specific 
     *  configuration property may be ignored.  
     * @return properties of the administered object.
     */
    String[] properties() default {};
}
