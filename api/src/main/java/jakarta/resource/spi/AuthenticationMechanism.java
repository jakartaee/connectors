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

@Documented
@Retention(RUNTIME)
@Target({})
/* The <code>AuthenticationMechanism</code> declared type is intended 
solely for use as a member type in complex annotation type declarations
like <code>Connector</code>.
*/

/**
 * An annotation used to specify the authentication mechanism 
 * supported by the resource adapter.
 *
 * @since 1.6
 */
public @interface AuthenticationMechanism {

    /** 
     * An enumerated type that represents the various interfaces
     * that a resource adapter may support for the representation
     * of the credentials.
     *
     * @since 1.6
     */
    public enum CredentialInterface {
        /**
         * Corresponds to 
         * <code>javax.resource.spi.security.PasswordCredential</code>.
         * This is the default credential interface
         */
        PasswordCredential, 
        
        /**
         * Corresponds to <code>org.ietf.jgss.GSSCredential</code>
         */
        GSSCredential,
        
        /**
         * Corresponds to 
         * <code>javax.resource.spi.security.GenericCredential</code>
         */
        GenericCredential 
    }

    /**
     * The authentication-mechanismType specifies an authentication
     * mechanism supported by the resource adapter. Note that this
     * support is for the resource adapter and not for the
     * underlying EIS instance.
     *
     */
    String authMechanism() default  "BasicPassword";

    /**
     * The optional description specifies
     * any resource adapter specific requirement for the support of
     * security contract and authentication mechanism.
     */
    String[] description() default {};

    /**
     * Represents the interface that the resource adapter implementation
     * supports for the representation of the credentials.
     *
     * Note that BasicPassword mechanism type should support the
     * <code>javax.resource.spi.security.PasswordCredential</code> interface.
     * The Kerbv5 mechanism type should support the
     * <code>org.ietf.jgss.GSSCredential</code> interface or the deprecated
     * <code>javax.resource.spi.security.GenericCredential</code> interface.
     */
    CredentialInterface credentialInterface() 
    					default CredentialInterface.PasswordCredential;
}

