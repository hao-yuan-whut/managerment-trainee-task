/*
 * Copyright (c) 2020 sgmw4cloud Authors. All Rights Reserved.
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

package org.example.services.imp;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.SysUser;
import org.example.mapper.SysUserMapper;
import org.example.services.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lengleng
 * @date 2019/2/1
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public boolean login(String username, String password) {

        QueryWrapper<SysUser> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username", username);
        SysUser user = sysUserMapper.selectOne(queryWrapper);
        if (user == null || !user.getPassword().equals(password)) {
            return false;
        }
        return true;
    }
}
