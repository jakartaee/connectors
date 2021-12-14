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

package jakarta.resource.spi.work;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;

/**
 * A standard {@link WorkContext WorkContext} that allows a {@link Work Work}
 * instance to propagate security related context information from an EIS to an
 * application server.
 * <p>
 * This allows an EIS/resource adapter to flow-in security context information
 * and execute a Work instance, and call methods on a MessageEndpoint interface,
 * to effect message inflow, within that Work instance, in the context of an
 * established identity.
 * </p>
 * 
 * <p>
 * A resource adapter indicates to the WorkManager, that a Work instance needs
 * to be run in a specified security execution context by submitting a Work
 * instance that implements WorkContextProvider interface and ensuring that the
 * List of WorkContexts for that Work instance contains an instance of its
 * subclass of SecurityContext.
 * </p>
 * 
 * <p>
 * It should be noted however that when a resource adapter flows-in an identity
 * to be used by the application server, the propagated identity may or may not
 * belong to the application server's security domain.
 * </p>
 * 
 * <p>
 * There are therefore, two scenarios while a resource adapter propagates a
 * security identity from an EIS to the application server:
 * </p>
 * 
 * <ul>
 * <li>Case 1: Resource adapter flows-in an identity in the application server's
 * security domain: In this case, the application server could just set the
 * initiating principal, flown-in from the resource adapter, as the security
 * context the Work instance executes as.</li>
 * <li>Case 2: Resource adapter flows-in an identity belonging to the EIS'
 * security domain: The resource adapter establishes a connection to the EIS and
 * needs to perform a Work in the context of an EIS identity. In this case, the
 * initiating or caller principal does not exist in the application server's
 * security domain and a translation from one domain to the other needs to be
 * performed.</li>
 * </ul>
 * <p>
 * 
 * @since 1.6
 * @see jakarta.resource.spi.work.WorkContextProvider
 * 
 */

public abstract class SecurityContext implements WorkContext {

	/**
	 * Determines if a deserialized instance of this class
	 * is compatible with this class.
	 */
	private static final long serialVersionUID = 7730296651802712658L;

	/**
	 * {@inheritDoc}
	 */
        @Override
	public String getDescription() {
		return "Security Context";
	}

	/**
	 * {@inheritDoc}
	 */
        @Override
	public String getName() {
		return "SecurityContext";
	}

	/**
	 * The container calls this method to set up the security Context for the
	 * <code>Work</code> instance.
	 * <p>
	 * 
	 * The handler argument must not be null, and the argument handler and the
	 * <code>CallbackHandler</code> passed to this method must support the
	 * following <code>Callback</code>s defined in the Jakarta Authentication
	 * specification:
	 * 
	 * <ul>
	 * <li>CallerPrincipalCallback</li>
	 * <li>GroupPrincipalCallback</li>
	 * <li>PasswordValidationCallback</li>
	 * </ul>
         * <p>
	 * The following <code>Callback</code>s may be supported by the container.
         * </p>
	 * <ul>
	 * <li>CertStoreCallback</li>
	 * <li>PrivateKeyCallback</li>
	 * <li>SecretKeyCallback</li>
	 * <li>TrustStoreCallback</li>
	 * </ul>
	 * 
	 * 
	 * A resource adapter might use the <code>CallerPrincipalCallback</code> "to
	 * set the container's representation of the caller principal. The
	 * CallbackHandler must establish the argument Principal as the caller
	 * principal associated with the invocation being processed by the
	 * container. When the argument Principal is null, the handler will
	 * establish the container's representation of the unauthenticated caller
	 * principal."
	 * <p>
	 * 
	 * A resource adapter might use the <code>GroupPrincipalCallback</code> "to
	 * establish the container's representation of the corresponding group
	 * principals within the Subject. When a null value is passed to the groups
	 * argument, the handler will establish the container's representation of no
	 * group principals within the Subject. Otherwise, the handler's processing
	 * of this callback is additive, yielding the union (without duplicates) of
	 * the principals existing within the Subject, and those created with the
	 * names occurring within the argument array. The CallbackHandler will
	 * define the type of the created principals."
	 * <p>
	 * 
	 * A resource adapter might use the <code>PasswordValidationCallback</code>
	 * "to employ the password validation facilities of its containing runtime."
	 * <p>
	 * 
	 * The executionSubject argument must be non-null and it must not be
	 * read-only. It is expected that this method will populate this
	 * executionSubject with principals and credentials that would be flown into
	 * the application server.
	 * <p>
	 * 
	 * The serviceSubject argument may be null, and when it is not null it must not be
	 * read-only. It represents the application server and it may be used by the
	 * Work implementation to retrieve Principals and credentials necessary to
	 * establish a connection to the EIS (in the cause of mutual-auth like
	 * scenarios). If the Subject is not null, the Work implementation may
	 * collect the server credentials, as necessary, by using the callback
	 * handler passed to them .
	 * <p>
	 * 
	 * 
	 * When this method is called, the method implementation
	 * <ul>
	 * <li>identifies the security context that needs to be flown-in to the
	 * application server to serve as the execution context of the Work
	 * instance.</li>
	 * <li>populates the executionSubject with the EIS Principals and
	 * Credentials that it wants to serve as the security context for the Work
	 * instance to be executed in.</li>
	 * <li>adds instances of the necessary Callbacks , usually a subset of the
	 * ones listed above, to an array and invokes the handle() method in the
	 * container's CallbackHandler implementation passing in the array of
	 * Callback instances.</li>
	 * <li>on successful return from the CallbackHandler.handle() method the
	 * setSecurityContext returns after ensuring that the executionSubject is
	 * populated with the valid Principals and Credentials that represent the
	 * execution context of the Work instance</li>
	 * </ul>
	 * <p>
	 * 
	 * See Jakarta Authentication specification and
	 *      related JavaDoc
	 * 
	 * @param handler
	 *            A <code>CallbackHandler</code> provided by the
	 *            <code>WorkManager</code> that supports the
	 *            <code>Callback</code>s described above
	 * @param executionSubject
	 *            A Subject that represents the security identity that needs to
	 *            be established as the context for the <code>Work</code>
	 *            instance. It is used by the method implementation to store
	 *            Principals and credentials that needs to be used as the
	 *            security context of the <code>Work</code> instance.
	 * @param serviceSubject
	 *            A Subject that represents the application server It may be
	 *            used by the method implementation as the source of Principals
	 *            or credentials to be used to validate a connection to the EIS.
	 *            If the Subject is not null, the method implementation may add
	 *            additional Principals or credentials (pertaining to the
	 *            recipient of the service request) to the Subject. *
	 */
	public abstract void setupSecurityContext(CallbackHandler handler,
			Subject executionSubject, Subject serviceSubject);
}
