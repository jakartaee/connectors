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
package jakarta.resource.spi.work;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

/**
 * A standard {@link WorkContext WorkContext} that allows a {@link Work Work}
 * instance to propagate quality-of-service (QoS) hints about the {@link Work
 * Work} to the <code>WorkManager</code>.
 *
 * @since 1.6
 * @see jakarta.resource.spi.work.WorkContextProvider
 */
public class HintsContext implements WorkContext {

    /**
     * Determines if a deserialized instance of this class is compatible with
     * this class.
     */
    private static final long serialVersionUID = 7956353628297167255L;

    public static final String NAME_HINT = "jakarta.resource.Name";
    public static final String LONGRUNNING_HINT = "jakarta.resource.LongRunning";

    protected String description = "Hints Context";
    protected String name = "HintsContext";

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Set a brief description of the role played by the instance of
     * HintsContext and any other related debugging information.
     *
     * This could be used by the resource adapter and the WorkManager for
     * logging and debugging purposes.
     *
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set the associated name of the HintsContext. This could be used by the
     * resource adapter and the WorkManager for logging and debugging purposes.
     *
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    Map<String, Serializable> hints = new HashMap<>();

    /**
     * Set a Hint and a related value. 
     * The hintName must be non-Null. 
     * Standard HintNames are defined in the Jakarta Connectors specification. Use of
     * "jakarta.resource." prefixed hintNames are reserved for use by the
     * Jakarta Connectors specification.
     *
     * @param hintName name of the hint to set
     * @param value value to set
     */
    public void setHint(String hintName, Serializable value) {
        hints.put(hintName, value);
    }

    /**
     * Get all hints
     *
     * @return Map keyed on hint name
     */
    public Map<String, Serializable> getHints() {
        return hints;
    }

}
