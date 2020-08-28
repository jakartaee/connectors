/*
 * Copyright (c) 2012, 2020 Oracle and/or its affiliates. All rights reserved.
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
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

import static jakarta.resource.spi.TransactionSupport.TransactionSupportLevel;
import java.lang.annotation.Repeatable;

/**
 *  Annotation used to define a Connector Connection Factory resource to be 
 *  registered in JNDI.
 *  
 *  Once defined, a resource may be referenced by a component using the
 *  <code>lookup</code> element of the <code>Resource</code> annotation.
 *
 *  @see jakarta.annotation.Resource
 *  @version 1.7
 *  @since 1.7
 */
@Retention(RUNTIME)
@Target({TYPE})
@Repeatable(ConnectionFactoryDefinitions.class)
public @interface ConnectionFactoryDefinition {

    /**
     *  JNDI name of the connection factory resource being defined.
     */
    String name();

    /**
     *  Description of the resource.
     */
    String description() default "";

    /**
     *  The name of the resource adapter that the administered object must be 
     *  created from. The resource adapter is required to be available at 
     *  deployment time.
     */
    String resourceAdapter();

    /**
     *  The fully qualified name of the connection factory interface 
     *  class.
     */
    String interfaceName();
    
    /**
     *  The level of transaction support the connection factory resource 
     *  needs to support. If a transaction support specification is specified, 
     *  it must be a level of transaction support whose ordinal value in the 
     *  <code>TransactionSupport.TransactionSupportLevel</code> enum is equal
     *  to or lesser than the resource adapter's transaction support 
     *  classification.
     */
    TransactionSupportLevel transactionSupport() 
                default TransactionSupportLevel.NoTransaction;
    
    /**
     *  The maximum number of connections that should be allocated for a 
     *  connection pool that backs this connnection factory resource. The 
     *  default for this attribute is vendor specific. 
     */
    int maxPoolSize() default -1;
    
    /**
     *  The minimum number of connections that should be allocated for a 
     *  connection pool that backs this connnection factory resource. The 
     *  default for this attribute is vendor specific. 
     */
    int minPoolSize() default -1;
    
    /**
     *  Properties of the Connection Factory.  These properties may be
     *  vendor-specific properties. Vendor-specific properties may be combined 
     *  with or used to override the connection factory properties 
     *  defined using this annotation.
     *  
     *  Connection Factory properties that are specified and are not supported 
     *  in a given resource adapter or cannot be mapped to a vendor specific 
     *  configuration property may be ignored.  
     */
    String[] properties() default {};
}
