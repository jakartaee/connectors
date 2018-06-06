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

import java.io.Serializable;

/**
 * A marker interface indicating that the Exception is transient. It is used
 * in situations where a previously failed operation might be able to succeed 
 * if the resource adapter performs some recovery steps and retries the
 * operation.
 * 
 * @since 1.6
 * @version Java EE Connector Architecture 1.6
 */
public interface RetryableException extends Serializable {

}
