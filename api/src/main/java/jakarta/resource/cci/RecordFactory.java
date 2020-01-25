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

import java.util.Map;
import java.util.Collection;
import jakarta.resource.ResourceException;
import jakarta.resource.NotSupportedException;


/** The RecordFactory interface is used for creating MappedRecord and 
 *  IndexedRecord instances. Note that the RecordFactory is only used 
 *  for creation of generic record instances. A CCI implementation 
 *  provides an implementation class for the RecordFactory interface.
 *
 *  @author   Rahul Sharma
 *  @since    0.8
 *  @see      jakarta.resource.cci.IndexedRecord
 *  @see      jakarta.resource.cci.MappedRecord
**/
public interface RecordFactory {
  
  /** Creates a MappedRecord. The method takes the name of the record
   *  that is to be created by the RecordFactory. The name of the 
   *  record acts as a pointer to the meta information (stored in 
   *  the metadata repository) for a specific record type.
   *
   *  @param  recordName   Name of the Record
   *  @return MappedRecord
   *  @throws ResourceException  Failed to create a MappedRecord.
   *                             Example error cases are:
   *                              
   *          <UL>
   *             <LI> Invalid specification of record name
   *             <LI> Resource adapter internal error
   *             <LI> Failed to access metadata repository
   *          </UL>
   *  @throws NotSupportedException Operation not supported          
   *                            
  **/
  public
  MappedRecord createMappedRecord(String recordName) 
                  throws ResourceException;

  /** Creates a IndexedRecord. The method takes the name of the record
   *  that is to be created by the RecordFactory. The name of the 
   *  record acts as a pointer to the meta information (stored in 
   *  the metadata repository) for a specific record type.
   *
   *  @param  recordName   Name of the Record
   *  @return IndexedRecord
   *  @throws ResourceException  Failed to create an IndexedRecord.
   *                             Example error cases are:
   *                              
   *          <UL>
   *             <LI> Invalid specification of record name
   *             <LI> Resource adapter internal error
   *             <LI> Failed to access metadata repository
   *          </UL>
   *  @throws NotSupportedException Operation not supported          
 **/
  public
  IndexedRecord createIndexedRecord(String recordName) 
                  throws ResourceException;

}

