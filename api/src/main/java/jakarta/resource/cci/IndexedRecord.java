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

package jakarta.resource.cci;

/** IndexedRecord represents an ordered collection of record elements 
 *  based on the <code>java.util.List</code> interface. This interface 
 *  allows a client to access elements by their integer index (position
 *  in the list) and search for elements in the List.
 *
 *  @author  Rahul Sharma
 *  @since   0.8
**/
public interface IndexedRecord extends Record, java.util.List, 
                                       java.io.Serializable {

}
