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

package javax.resource.spi.work;

/**
 * This class models the possible error conditions that might occur during
 * associating an <code>WorkContext</code> with a <code>Work</code> instance.
 * 
 * <p>
 * This class is not designed as an Enumerated type (Enum), as the error codes
 * listed below could be expanded to accommodate custom error conditions for
 * custom <code>WorkContext</code> types.
 * 
 * @since 1.6
 * @version Java EE Connector Architecture 1.6
 */
public class WorkContextErrorCodes {

	/**
	 * Indicates that a <code>WorkContext</code> type, that was not specified as
	 * optional, passed in by the <code>Work</code> instance is not supported by
	 * the container.
	 * 
	 * @since 1.6
	 */
	public static final String UNSUPPORTED_CONTEXT_TYPE = "1";

	/**
	 * Indicates that there are more than one instance of a <code>WorkContext</code>
	 * type passed in by the <code>Work</code> instance.
	 * <p>
	 * 
	 * @since 1.6
	 */
	public static final String DUPLICATE_CONTEXTS = "2";

	/**
	 * Indicates a failure in recreating the <code>WorkContext</code> instance.
	 * For <code>TransactionContext</code> instances, the
	 * <code>WorkManager</code> must use this failure code when it should have
	 * used {@link WorkException#TX_RECREATE_FAILED} as the error code.
	 * 
	 * @since 1.6
	 */
	public static final String CONTEXT_SETUP_FAILED = "3";

	/**
	 * Indicates that the container cannot support recreating the
	 * <code>WorkContext</code> instance. For
	 * <code>TransactionContext</code> instances, the
	 * <code>WorkManager</code> must use this failure code when it should have
	 * used {@link WorkException#TX_CONCURRENT_WORK_DISALLOWED} as the error
	 * code.
	 * 
	 * @since 1.6
	 */
	public static final String CONTEXT_SETUP_UNSUPPORTED = "4";

}
