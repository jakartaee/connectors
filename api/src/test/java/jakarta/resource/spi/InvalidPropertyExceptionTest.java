/*
 * Copyright (c) 2022 Contributors to Eclipse Foundation. All rights reserved.
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

import java.beans.PropertyDescriptor;
import java.io.*;

public class InvalidPropertyExceptionTest {
    public void testSerializability() throws Exception {
        PropertyDescriptor ipd [] = { new PropertyDescriptor("echo", EchoBean.class) };
        var ipex = new InvalidPropertyException();
        ipex.setInvalidPropertyDescriptors(ipd);

        try (var baos = new ByteArrayOutputStream()) {
            try (var oos = new ObjectOutputStream(baos)) {
                oos.writeObject(ipex);
            }

            var bais = new ByteArrayInputStream(baos.toByteArray());
            try (var ois = new ObjectInputStream(bais)) {
                var ripex = (InvalidPropertyException)ois.readObject();
            }
        }
    }
}

