package com.nzonly.tb.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-20 下午9:59:13
 * @version V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BaseTestNoWeb extends AbstractTransactionalJUnit4SpringContextTests {

}
