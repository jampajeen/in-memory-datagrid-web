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

import java.io.IOException;
import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Thitipong Jampajeen <jampajeen@gmail.com>
 */
public class DistributedCacheManager {

    private static final Logger LOG = LoggerFactory.getLogger(DistributedCacheManager.class);

    private final String INFINISPAN_CONF_FILE = "infinispan.xml";
    private final String JGROUPS_CONF_FILE = "jgroups-tcp.xml";

    private String cacheName;
    private String nodeName;

    private EmbeddedCacheManager cacheManager;
    private Cache<String, String> cache;

    private static DistributedCacheManager instance = null;

    public static synchronized DistributedCacheManager getInstance() {
        if (instance == null) {
            instance = new DistributedCacheManager();
        }
        return instance;
    }

    public void init() {
        
        try {
            AppConf conf = new AppConf();
            nodeName = conf.getNodeId();
            cacheName = "dist";

            cacheManager = createCacheManager();
            cache = cacheManager.getCache(cacheName);

            LOG.info("Cache " + cacheName + " started on " + cacheManager.getAddress() + ", cache members are now " + cache.getAdvancedCache().getRpcManager().getMembers() + "\n");

        } catch (Exception ex) {
            LOG.error("Can not initilize Cache " + cacheName + " started on " + cacheManager.getAddress());
        }
    }
    
    public void destroy() {
        cacheManager.stop();
    }

    public synchronized void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public void remove(String key) {
        cache.remove(key);
    }
    
    private EmbeddedCacheManager createCacheManager() throws IOException {
        return createCacheManagerFromXml();
    }

    private EmbeddedCacheManager createCacheManagerFromXml() throws IOException {
        System.setProperty("nodeName", nodeName);
        return new DefaultCacheManager(INFINISPAN_CONF_FILE);
    }
}
