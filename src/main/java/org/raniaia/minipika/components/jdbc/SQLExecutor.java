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

import java.sql.SQLException;
import java.util.List;

/**
 * sql执行器
 *
 * @author tiansheng
 */
public interface SQLExecutor {

  /**
   * 执行一条SQL
   *
   * @return true执行成功, false执行失败
   */
  boolean execute(String sql, Object... args) throws SQLException;

  /**
   * 查询数据
   *
   * @param sql  sql脚本
   * @param args 参数
   * @return 自定义结果集
   */
  QueryResultSet select(String sql, Object... args);

  /**
   * 更新数据
   *
   * @param sql  sql脚本
   * @param args 参数
   * @return 影响行数
   */
  int update(String sql, Object... args);

  /**
   * 批量执行
   *
   * @param sql  sql脚本
   * @param args sql参数
   * @return 影响行数
   */
  int[] batch(String sql, List<Object[]> args);

  /**
   * 批量执行多条sql
   *
   * @param sql  sql集合
   * @param args 参数集合，每个集合数组对应一条sql的参数
   * @return 影响行数
   */
  int[] batch(String[] sql, List<Object[]> args);

}