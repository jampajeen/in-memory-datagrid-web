/*
 * Copyright 2016 Thitipong Jampajeen <jampajeen@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rinxor.example.in.memory.datagrid.cache;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Thitipong Jampajeen <jampajeen@gmail.com>
 */
public class AppConf {
    private static final Logger LOG = LoggerFactory.getLogger(AppConf.class);
    
    public static final String DEFAULT_CFG_FILE = "app.conf.xml";
    
    private String zoneId;
    private String nodeId;
    
    public AppConf() {
        load(DEFAULT_CFG_FILE);
    }
    public AppConf(String cfgFile) {
        load(cfgFile);
    }
    
    private void load(String cfgFilePath) {
        try {
            XMLConfiguration reader = new XMLConfiguration(cfgFilePath);
            
            zoneId = reader.getString("server.zoneId");
            nodeId = reader.getString("server.uniqueNodeId");
            
        } catch (ConfigurationException ex) {
            LOG.error(ex.getMessage());
        }
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

}
