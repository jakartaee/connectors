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
import jakarta.resource.spi.work.WorkContext;

/**
 * The <code>Connector</code> annotation is a component-defining annotation and
 * it can be used by the resource adapter developer to specify that the JavaBean
 * is a resource adapter JavaBean. The Connector annotation is applied to the
 * JavaBean class.
 * 
 * @since 1.6
 */

@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface Connector {

    /**
     * Describes the resource adapter module.
     * @return description
     */
    String[] description() default {};

    /**
     * An optional short name, providing information about the
     * resource adapter module,  that is intended to be displayed 
     * by tools.
     * @return display name
     */
  	String[] displayName() default {};

    /**
     * Specifies the file name for small GIF or JPEG icon images that are 
     * used to represent the resource adapter in a GUI tool. 
     *
     * Each smallIcon must be associated with a largeIcon element and the 
     * application server must use the ordinal value in their respective 
     * arrays to find the related pairs of icons.
     * @return small icon file name
     */
    String[] smallIcon() default {};

    /**
     * Specifies the file name for large GIF or JPEG icon images that are 
     * used to represent the resource adapter in a GUI tool. 
     * Each smallIcon must be associated with a largeIcon element and 
     * the application server must use the ordinal value in their 
     * respective arrays to find the related pairs of icons.
     * @return large icon file name
     */
    String[] largeIcon() default {};

    /**
     * Specifies the name of the resource adapter provider vendor.
     * @return vendor name
     */
    String vendorName() default "";

    /**
     * Contains information about the type of EIS. For example, the type of an
     * EIS can be product name of the EIS independent of any version info.This
     * helps in identifying EIS instances that can be used with this resource
     * adapter.
     * @return type of EIS
     */
    String eisType() default "";

    /**
     * Specifies the version of the resource adapter implementation.
     * @return resource adapter version
     */
    String version() default "";

    /**
     * Specifies licensing requirements for the resource adapter module and an
     * optional description of the licensing terms .
     * @return licensing requirements
     */
    String[] licenseDescription() default {};

    /**
     * Specifies whether a license is required to deploy and use this resource
     * adapter
     * @return true if licensed required
     */
    boolean licenseRequired() default false;

    /**
     * Specifies the authentication mechanisms supported by the resource
     * adapter.
     *
     * @see AuthenticationMechanism
     * @return Support Authentication Mechanisms
     */
    AuthenticationMechanism[] authMechanisms() default {};

    /**
     * Specifies whether reauthentication is supported
     * @return true if reauthentication is supported
     */
    boolean reauthenticationSupport() default false;

    /**
     * Specifies the extended security permissions required to be provided for
     * the operation of the resource adapter module
     *
     * @see SecurityPermission
     * @return the extended security permissions
     */
    SecurityPermission[] securityPermissions() default {};

    /**
     * Specifies the level of transaction support provided by the resource
     * adapter.
     *
     * @see TransactionSupport.TransactionSupportLevel
     * @return level of transaction support
     */
    TransactionSupport.TransactionSupportLevel transactionSupport() default TransactionSupport.TransactionSupportLevel.NoTransaction;

    /**
     * Specifies a list of fully qualified classes that implements the
     * {@link WorkContext WorkContext} interface that a resource adapter
     * requires the application server to support.
     * @return list of class names that implement the work context interface
     */
    Class<? extends WorkContext>[] requiredWorkContexts() default {};
}
