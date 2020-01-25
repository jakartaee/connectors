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

package jakarta.resource.cci;

/** A ResultSet represents tabular data that is retrieved from an EIS
 *  instance by the execution of an Interaction.. The CCI ResultSet is 
 *  based on the JDBC ResultSet.   
 *
 *  <p>Refer the CCI specification in Connectors 1.0 for detailed
 *  requirements on the implementation of a CCI ResultSet.
 *
 *  @author  Rahul Sharma
 *  @since   0.8
 *  @see     java.sql.ResultSet
**/
public interface ResultSet extends Record, java.sql.ResultSet {

}
