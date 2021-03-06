/**
 * Get more info at : www.jrebirth.org .
 * Copyright JRebirth.org © 2011-2013
 * Contact : sebastien.bordes@jrebirth.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jrebirth.af.core.resource.fxml;

import org.jrebirth.af.api.resource.builder.ResourceBuilder;
import org.jrebirth.af.api.resource.fxml.FXMLItem;
import org.jrebirth.af.api.resource.fxml.FXMLParams;
import org.jrebirth.af.api.ui.fxml.FXMLComponent;
import org.jrebirth.af.core.resource.builder.AbstractResourceBuilder;
import org.jrebirth.af.core.ui.fxml.FXMLUtils;

/**
 * The class <strong>FXMLBuilder</strong>.
 *
 * Class used to manage style sheet with weak reference.
 *
 * @author Sébastien Bordes
 */
public final class FXMLBuilder extends AbstractResourceBuilder<FXMLItem, FXMLParams, FXMLComponent> implements ResourceBuilder<FXMLItem, FXMLParams, FXMLComponent> {

    /** The class logger. */
    // private static final Logger LOGGER = LoggerFactory.getLogger(FXMLBuilder.class);

    /**
     * {@inheritDoc}
     */
    @Override
    protected FXMLComponent buildResource(final FXMLItem fi, final FXMLParams fp) {
        FXMLComponent component = null;
        if (fp instanceof FXML) {
            // Build the requested font
            component = buildFXMLComponent((FXML) fp);
        }
        return component;
    }

    /**
     * Build a FXML component that embed a node and its FXML controller.
     *
     * @param fxmlParam the FXMLParams object
     *
     * @return the FXMLcomponent wrapper object
     */
    private FXMLComponent buildFXMLComponent(final FXML fxmlParam) {

        return FXMLUtils.loadFXML(null, fxmlParam.getFxmlPath() + FXML.FXML_EXT, fxmlParam.getBundlePath());
    }

}
