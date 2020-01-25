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

package jakarta.resource.spi.security;

import jakarta.resource.spi.ManagedConnectionFactory;

/**
 * The class PasswordCredential acts as a holder for username and
 * password.
 *
 * @see jakarta.resource.spi.ManagedConnectionFactory
 *
 * @author  Rahul Sharma
 * @version 0.6
 * @since   0.6
 */

public final class PasswordCredential implements java.io.Serializable {

  private String userName;
  private char[] password;
  private ManagedConnectionFactory mcf;

  /**
   * Creates a new <code>PasswordCredential</code> object from the given
   * user name and password.
   *
   * <p> Note that the given user password is cloned before it is stored in
   * the new <code>PasswordCredential</code> object.
   *
   * @param userName the user name
   * @param password the user's password
  **/
  public 
  PasswordCredential(String userName, char[] password) {
    this.userName = userName;
    this.password = (char[])password.clone();
  }

  /**
   * Returns the user name.
   *
   * @return the user name
  **/
  public 
  String getUserName() {
    return userName;
  }

  /**
   * Returns the user password.
   *
   * <p> Note that this method returns a reference to the password. It is
   * the caller's responsibility to zero out the password information after
   * it is no longer needed.
   *
   * @return the password
  **/
  public 
  char[] getPassword() {
    return password;
  }

  /** Gets the target ManagedConnectionFactory for which the user name and 
   *  password has been set by the application server. A ManagedConnection-
   *  Factory uses this field to find out whether PasswordCredential should
   *  be used by it for sign-on to the target EIS instance.
   *
   *  @return    ManagedConnectionFactory instance for which user name and
   *             password have been specified
   **/
  public
  ManagedConnectionFactory getManagedConnectionFactory() {
    return mcf;
  }

 /**  Sets the target ManagedConenctionFactory instance for which the user 
  *   name and password has been set by the application server.
   *
   *  @param     mcf   ManagedConnectionFactory instance for which user name
   *                   and password have been specified
   **/
  public
  void setManagedConnectionFactory(ManagedConnectionFactory mcf) {
    this.mcf = mcf;
  }

  /** Compares this PasswordCredential with the specified object for 
   *  equality. The two PasswordCredential instances are the same if
   *  they are equal in username and password.
   *
   *  @param other  Object to which PasswordCredential is to be compared
   *  @return <tt>true</tt> if and if the specified object is a
   *            PasswordCredential whose username and password are
   *            equal to this instance.
  **/
  public 
  boolean equals(Object other) {
    if (!(other instanceof PasswordCredential))
      return false;

    PasswordCredential pc = (PasswordCredential)other;

    if (!(userName.equals(pc.userName)))
      return false;

    if (password.length != pc.password.length)
      return false;
    
    for (int i = 0; i < password.length;i++) {
      if (password[i] != pc.password[i]) 
	return false;
    }

    return true;
  }

  /** Returns the hash code for this PasswordCredential
   * 
   *  @return  hash code for this PasswordCredential
  **/
  public
  int hashCode() {
    String s = userName;

      int passwordHash = 0;
      for (char passChar : password) {
          passwordHash += passChar;
      }

    return s.hashCode() + passwordHash;
  }

}

