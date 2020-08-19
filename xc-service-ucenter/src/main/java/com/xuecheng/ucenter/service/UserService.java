package com.xuecheng.ucenter.service;

import com.xuecheng.framework.domain.ucenter.XcCompanyUser;
import com.xuecheng.framework.domain.ucenter.XcMenu;
import com.xuecheng.framework.domain.ucenter.XcUser;
import com.xuecheng.framework.domain.ucenter.ext.XcUserExt;
import com.xuecheng.framework.domain.ucenter.request.RegisterRequest;
import com.xuecheng.framework.domain.ucenter.response.AuthCode;
import com.xuecheng.framework.domain.ucenter.response.RegisterResult;
import com.xuecheng.ucenter.dao.XcCompanyUserRepository;
import com.xuecheng.ucenter.dao.XcMenuMapper;
import com.xuecheng.ucenter.dao.XcUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
public class UserService {

    @Autowired
    XcUserRepository xcUserRepository;

    @Autowired
    XcCompanyUserRepository xcCompanyUserRepository;

    @Autowired
    XcMenuMapper xcMenuMapper;

    //根据账号查询xcUser信息
    public XcUser findXcUserByUsername(String username){
        return xcUserRepository.findByUsername(username);
    }

    //根据账号查询用户信息
    public XcUserExt getUserExt(String username){
        //根据账号查询xcUser信息
        XcUser xcUser = this.findXcUserByUsername(username);
        if(xcUser == null){
            return null;
        }
        //用户id
        String userId = xcUser.getId();
        //查询用户所有权限
        List<XcMenu> xcMenus = xcMenuMapper.selectPermissionByUserId(userId);

        //根据用户id查询用户所属公司id
        XcCompanyUser xcCompanyUser = xcCompanyUserRepository.findByUserId(userId);
        //取到用户的公司id
        String companyId = null;
        if(xcCompanyUser!=null){
            companyId = xcCompanyUser.getCompanyId();
        }
        XcUserExt xcUserExt = new XcUserExt();
        BeanUtils.copyProperties(xcUser,xcUserExt);
        xcUserExt.setCompanyId(companyId);
        //设置权限
        xcUserExt.setPermissions(xcMenus);
        return xcUserExt;
    }


    public RegisterResult register(RegisterRequest registerRequest) {
        XcUser xcUser = this.findXcUserByUsername(registerRequest.getUsername());
        if(xcUser != null){
            return new RegisterResult(AuthCode.AUTH_REGISTER_EXISTS);
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        XcUser createUser = new XcUser();
        createUser.setUsername(registerRequest.getUsername());
        String encode = bCryptPasswordEncoder.encode(registerRequest.getPassword());
        createUser.setPassword(encode);
        createUser.setName(registerRequest.getName());
        createUser.setUtype(registerRequest.getUtype());
        createUser.setSex(registerRequest.getSex());
        createUser.setCreateTime(new Date());
        createUser.setEmail(registerRequest.getEmail());
        createUser.setQq(registerRequest.getQq());
        createUser.setPhone(registerRequest.getPhone());
        createUser.setStatus("1");
        xcUserRepository.save(createUser);
        return new RegisterResult(AuthCode.AUTH_SUCCESS);
    }
}
