package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.model.Office;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

/**
 * repeatable tests
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/data-tier-spring.xml",
        "classpath:/datasource-embedded-init-p6spy.xml"
        //     "classpath:/datasource-embedded-init.xml"
        //  "classpath:/datasource-standalone-test.xml"
        //  "classpath:/datasource-standalone-p6spy-test.xml"
})
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false) //TODO run with rollback=false too, you may see different results because the transaction is commited.
public class OfficeMapperTest extends AbstractJUnit4SpringContextTests {

    static final Logger log = LoggerFactory.getLogger(OfficeMapperTest.class);

    @Autowired
    private OfficeMapper officeMapper ;

//    @Override
//    @Resource(name = "dataSource")
//    public void setDataSource(DataSource dataSource) {
//        super.setDataSource(dataSource);
//    }



    @Test
    public void findAllOffices() {
        List offices = officeMapper.findAllOffices();
        for (Object office : offices) {
            System.out.println("findAllOffices "+office);
        }
    }

    @Test
        public void findOfficeByCode() {
        Office office = officeMapper.findOfficeByCode("7");
        System.out.println("findOfficeByCode "+office);
        assertThat(office.getCity(),is("London"));
    }

    @Test
    public void findOfficeByCode_RESULT_MAPPING() {
        Office office = officeMapper.findOfficeByCode_ANNOTATED_RESULT_MAPPING("7");
        System.out.println("findOfficeByCode annototated resultmap "+office);
        assertThat(office.getCity(),is("London"));
    }


    @Test
    public void findAllOffices_XML_NESTED() {
        System.out.println("findAllOffices_XML_NESTED");
        List<Office> offices = officeMapper.findAllOffices_XML_NESTED();
        System.out.println("found " + offices.size() + " offices");
        for (Office office : offices) {
            System.out.println("office nested : " + office);
        }
        assertThat(offices.size(),greaterThan(0));
    }



}
