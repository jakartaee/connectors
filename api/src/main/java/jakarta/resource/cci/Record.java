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


/** *  The <code>javax.resource.cci.Record interface is the base 
 *  interface for the representation of an input or output to the 
 *  execute methods defined on an Interaction.
 *  
 *  <p>The Record interface can be extended to form a one of the 
 *  following representations:
 *  <UL>
 *     <LI> MappedRecord: A key-value pair based collection represents
 *          a record. This interface is based on the <code>java.util.Map</code>
 *     <LI> IndexedRecord:An ordered and indexed collection represents 
 *          a record. This interface is based on the <code>java.util.List</code>.
 *     <LI> JavaBean based representation of an EIS abstraction: An 
 *          example is a custom record generated to represent a purchase 
 *          order in an ERP system.
 *     <LI> <code>javax.resource.cci.ResultSet</code>: This interface 
 *          extends both <code>java.sql.ResultSet</code> and <code>
 *          javax.resource.cci.Record</code>. A ResultSet
 *          represents tabular data.
 *  </UL> 
 *
 *  <p>A MappedRecord or IndexedRecord can contain another Record. This 
 *  means that MappedRecord and IndexedRecord can be used to create 
 *  a hierarchical structure of any arbitrary depth. A basic Java 
 *  type is used as the leaf element of a hierarchical structure 
 *  represented by a MappedRecord or IndexedRecord.
 *
 *  @author  Rahul Sharma
 *  @version 0.8
 *  @see     jakarta.resource.cci.Interaction
 *  @see     java.sql.ResultSet
**/    
public interface Record extends java.lang.Cloneable, java.io.Serializable {
 
  /** Gets the name of the Record.
   *  
   *  @return  String representing name of the Record
  **/
  public
  String getRecordName();
  
  /** Sets the name of the Record.
   *  
   *  @param   name           Name of the Record
  **/
  public
  void setRecordName(String name);
  
  /** Sets a short description string for the Record. This property
   *  is used primarily by application development tools.
   *
   *  @param   description    Description of the Record
  **/
  public
  void setRecordShortDescription(String description);

  /** Gets a short description string for the Record. This property
   *  is used primarily by application development tools.
   *
   *  @return  String representing a short description of the Record
  **/
  public
  String getRecordShortDescription();

  /** Check if this instance is equal to another Record.
   *
   *  @return  true if two instances are equal
  **/
  public
  boolean equals(Object other);


  /** Returns the hash code for the Record instance.
   * 
   *  @return  hash code
  **/
  public
  int hashCode();

  /** Creates and returns a copy of this object. The precise 
   *  meaning of "copy" may depend on the class of the object.
   *
   *  @return a clone of this instance.
   *  @throws  CloneNotSupportedException 
   *           If the object's class does not support the 
   *           Cloneable interface Subclasses that override the 
   *           clone method can also throw this exception to 
   *           indicate that an instance cannot be cloned.
  **/
  public
  Object clone() throws CloneNotSupportedException;

}
