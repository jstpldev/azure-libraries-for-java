/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The HttpAuthentication model.
 */
public class HttpAuthentication {
    /**
     * Gets or sets the HTTP authentication type. Possible values include:
     * 'NotSpecified', 'ClientCertificate', 'ActiveDirectoryOAuth', 'Basic'.
     */
    @JsonProperty(value = "type")
    private HttpAuthenticationType type;

    /**
     * Get the type value.
     *
     * @return the type value
     */
    public HttpAuthenticationType type() {
        return this.type;
    }

    /**
     * Set the type value.
     *
     * @param type the type value to set
     * @return the HttpAuthentication object itself.
     */
    public HttpAuthentication withType(HttpAuthenticationType type) {
        this.type = type;
        return this;
    }

}
