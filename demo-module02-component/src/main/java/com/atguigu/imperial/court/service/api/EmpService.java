package com.atguigu.imperial.court.service.api;

import com.atguigu.imperial.court.entity.Emp;

/**
 * @author zhangtao
 * @version 1.0
 */
public interface EmpService {
    Emp getEmpByLogin(String loginAccount, String loginPassword);
}
