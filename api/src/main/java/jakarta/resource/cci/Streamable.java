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


import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

/** Streamable interface enables a resource adapter to extract data from
 *  an input Record or set data into an output Record as a stream of 
 *  bytes. 
 *
 *  <p>The Streamable interface provides a resource adapter's view
 *  of the data that has been set in a Record instance by a component.
 *  
 *  <p>The Streamable interface is not directly used by a component. It
 *  is used by a resource adapter implementation. A component uses Record 
 *  or any derived interfaces to manage records.
 *
 *  @author Rahul Sharma
 *  @since  0.8
 *  @see    jakarta.resource.cci.Record
**/

public interface Streamable {

  /** Read data from an InputStream and initialize fields of a 
   *  Streamable object. 
   *
   *  @param  istream   InputStream that represents a resource
   *                    adapter specific internal representation
   *                    of fields of a Streamable object
   * @throws java.io.IOException if there is an error reading from the stream
  **/
  public
  void read(InputStream istream) throws IOException;
  

  /** Write fields of a Streamable object to an OutputStream
   *  @param  ostream   OutputStream that holds value of a
   *                    Streamable object
   * @throws java.io.IOException if there is an error writing to the stream
  **/
  public
  void write(OutputStream ostream) throws IOException;

}

