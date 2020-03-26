package org.raniaia.poseidon.components;

/*
 * Copyright (C) 2020 tiansheng All rights reserved.
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

/*
 * Creates on 2020/3/26.
 */

import org.raniaia.poseidon.components.config.GlobalConfig;
import org.raniaia.poseidon.components.jdbc.datasource.unpooled.IDataSource;
import org.raniaia.poseidon.framework.provide.component.Component;
import org.raniaia.poseidon.framework.provide.component.ComponentType;

/**
 * @author tiansheng
 */
public class MyComponents {

    @Component(type = ComponentType.PARAMETER, name = "defaultDataSource")
    public IDataSource getIDataSource(){
        return GlobalConfig.getConfig().getIDataSource();
    }

}
