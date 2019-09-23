package com.kangyonggan.demo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangyonggan.demo.mapper.UserMapper;
import com.kangyonggan.demo.model.User;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author kangyonggan
 * @since 2019-09-20
 */
@Log4j2
public class UserMapperTest extends AbstractTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询
     */
    @Test
    public void testFindByUserId() {
        PageHelper.startPage(1, 10);
        List<User> users = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);

        log.info("总条数：{}, 总页数：{}，当前页：{}，每页大小：{}",
                pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getPageNum(), pageInfo.getPageSize());
    }

}
