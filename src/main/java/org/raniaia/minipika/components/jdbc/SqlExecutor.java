package org.raniaia.minipika.components.jdbc;

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
 * Creates on 2020/6/1.
 */

/**
 * sql执行器
 * @author tiansheng
 */
public interface SqlExecutor {

  /**
   * 执行一条SQL
   *
   * @return true执行成功, false执行失败
   */
  void execute(String sql, Object... args);

  /**
   * 查询数据
   *
   * @param sql     sql脚本
   * @param args    参数
   */
  void select(String sql, Object... args);

  /**
   * 更新数据
   *
   * @param sql     sql脚本
   * @param args    参数
   * @return 更新条数
   */
  int update(String sql, Object... args);

  /**
   * 删除一条数据
   *
   * @param sql      sql脚本
   * @param args     参数
   * @return 更新条数
   */
  int delete(String sql, Object... args);

}