package com.xuecheng.ucenter.dao;

import com.xuecheng.framework.domain.ucenter.XcMenu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Austin
 * @date 2019/12/13
 */
public interface XcMenuRepository extends JpaRepository<XcMenu,String> {
}
