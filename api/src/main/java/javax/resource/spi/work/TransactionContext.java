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
 * A standard <code>WorkContext</code> that allows a <code>Work</code> instance
 * to propagate transaction related context information from an EIS to an
 * application server.
 * <p>
 * 
 * This class extends <code>ExecutionContext</code> so that a resource adapter
 * developer could migrate their existing code from
 * <code>ExecutionContext</code> to <code>TransactionContext</code> easily.
 * <p>
 * 
 * @since 1.6
 * @see javax.resource.spi.work.WorkContext
 * @see javax.resource.spi.work.ExecutionContext
 *
 */

public class TransactionContext extends ExecutionContext implements
		WorkContext {
	/**
	 * Determines if a deserialized instance of this class
	 * is compatible with this class.
	 */
	private static final long serialVersionUID = 6205067498708597824L;

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return "Transaction Context";
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return "TransactionContext";
	}
}
