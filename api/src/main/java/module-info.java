/*
 * Copyright (c) 2021 Oracle and/or its affiliates. All rights reserved.
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

/**
 * Jakarta Connectors API.
 */
module jakarta.resource {

    requires java.desktop;
    requires transitive java.naming;
    requires transitive java.sql;
    requires transitive java.transaction.xa;

    requires jakarta.annotation;
    requires transitive jakarta.transaction;

    exports jakarta.resource;
    exports jakarta.resource.cci;
    exports jakarta.resource.spi;
    exports jakarta.resource.spi.endpoint;
    exports jakarta.resource.spi.security;
    exports jakarta.resource.spi.work;
}
