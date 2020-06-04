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

package jakarta.resource.spi;

/**
 * This interface serves as a marker. An instance of an ActivationSpec must be a
 * JavaBean and must be serializable. This holds the activation configuration
 * information for a message endpoint.
 * 
 * @version 1.0
 * @author Ram Jeyaraman
 */
public interface ActivationSpec extends ResourceAdapterAssociation {

	/**
	 * This method may be called by a deployment tool to validate the overall
	 * activation configuration information provided by the endpoint deployer.
	 * This helps to catch activation configuration errors earlier on without
	 * having to wait until endpoint activation time for configuration
	 * validation. The implementation of this self-validation check behavior is
	 * optional.
	 * 
	 * Note: Since Java EE Connector 1.6 specification, resource adapter
	 * implementations are recommended to use the annotations or the XML 
     * validation deployment descriptor facilities defined by the Bean Validation
     * specification to express their validation requirements of its configuration 
     * properties to the application server.
     *
	 * @throws <code>InvalidPropertyException</code> indicates invalid
	 *         configuration property settings.
	 */
	void validate() throws InvalidPropertyException;
	
}
