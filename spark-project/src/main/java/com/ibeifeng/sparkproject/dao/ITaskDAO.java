package com.ibeifeng.sparkproject.dao;

import com.ibeifeng.sparkproject.domain.Task;

/*
 * 任务管理DAO接口 提供各种方法,逻辑在实现类里面
 *
 * @author lyj
 */
public interface ITaskDAO {

   /*根据主键查询任务
    *
    * @param taskid 主键
    * @return 任务
    *
    */
    Task findById(long taskid);

}
