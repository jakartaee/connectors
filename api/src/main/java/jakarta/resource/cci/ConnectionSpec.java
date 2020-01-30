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

/** ConnectionSpec is used by an application component to pass 
 *  connection request-specific properties to the ConnectionFactory.
 *  getConnection method.
 *
 *  <p>It is recommended that the ConnectionSpec interface be 
 *  implemented as a JavaBean to support tools. The properties 
 *  on the ConnectionSpec implementation class must be defined 
 *  through the getter and setter methods pattern. 
 *  
 *  <p>The CCI specification defines a set of standard properties 
 *  for an ConnectionSpec. The properties are defined either on
 *  a derived interface or an implementation class of an empty
 *  ConnectionSpec interface. In addition, a resource adapter may 
 *  define additional properties specific to its underlying EIS.
 *  
 *  @author  Rahul Sharma
 *  @version 1.0 Public Draft 1
 *  @see     jakarta.resource.cci.ConnectionFactory
 **/

public interface ConnectionSpec {

}
