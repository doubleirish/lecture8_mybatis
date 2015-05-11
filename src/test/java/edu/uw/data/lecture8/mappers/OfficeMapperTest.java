package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.model.Office;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * repeatable tests
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/data-tier-spring.xml",
        "classpath:/datasource-embedded-init-p6spy.xml"
        //     "classpath:/datasource-embedded-init.xml"
        //  "classpath:/datasource-standalone-test.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) //TODO run with rollback=false too, you may see different results because the transaction is commited.
public class OfficeMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

    static final Logger log = LoggerFactory.getLogger(OfficeMapperTest.class);

    @Autowired
    private OfficeMapper officeMapper ;

    @Override
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }



    @Test
    public void findAllOffices() {
        List allCustomers = officeMapper.findAllOffices();
        for (Object customer : allCustomers) {
            System.out.println("office "+customer);
        }
    }

    @Test
    public void findOfficeByCode() {
       Office office = officeMapper.findOfficeByCode("7");
      assertThat(office.getCity(),is("London"));
    }



}
