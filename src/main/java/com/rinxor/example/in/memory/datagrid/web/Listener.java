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

package com.rinxor.example.in.memory.datagrid.web;

import com.rinxor.example.in.memory.datagrid.cache.DistributedCacheManager;
import javax.servlet.ServletContextEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Thitipong Jampajeen <jampajeen@gmail.com>
 */
public class Listener implements javax.servlet.ServletContextListener {
    private static final Logger LOG = LoggerFactory.getLogger(Listener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DistributedCacheManager.getInstance().init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DistributedCacheManager.getInstance().destroy();
    }
}
