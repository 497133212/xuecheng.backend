package com.xuecheng.manage_cms.dao;

import com.xuecheng.manage_cms.service.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Austin
 * @date 2019/8/25
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class PageServiceTest {
    @Autowired
    PageService pageService;

    @Test
    public void testGetPageHtml() {
        String pageHtml = pageService.getPageHtml("5b9b5c2fb6eb080aa0b28e56");
        System.out.println(pageHtml);
    }
}
