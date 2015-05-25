package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.model.Office;
import edu.uw.data.lecture8.model.OfficeType;
import org.hamcrest.Matchers;
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
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNull;

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
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) //TODO run with rollback=false too, you may see different results because the transaction is commited.
public class OfficeMapperCrudTest extends AbstractTransactionalJUnit4SpringContextTests {

    static final Logger log = LoggerFactory.getLogger(OfficeMapperCrudTest.class);

    @Autowired
    private OfficeMapper officeMapper ;

    @Override
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }



    @Test
    public void insertOffice() {
        Office office = new Office();
        office.setOfficeCode(8);
        office.setCity("Seattle");
        office.setOfficeType(new OfficeType(1));
        officeMapper.insertOffice(office);

    }

    @Test
        public void updateOffice() {
        Office office = officeMapper.findOfficeById(7);
        System.out.println("Office BEFORE "+office);
//
        String updatedCity = "OF_ANGLES";
        office.setCity(updatedCity);
        //String updatedState = "OF_MIND";
        //office.setState(updatedState);
        office.setOfficeType(new OfficeType(3));
        officeMapper.updateOffice(office);


        Office updateOffice = officeMapper.findOfficeById(7);
        System.out.println("Office AFTER UPDATE "+updateOffice);

        assertThat(updateOffice.getCity(), Matchers.is(updatedCity));
       // assertThat(updateOffice.getState(), Matchers.is(updatedState));
        assertThat(updateOffice.getOfficeType().getOfficeType(), Matchers.is(3));
    }

    @Test
    public void deleteOffice() {
        Office office = officeMapper.findOfficeById(99);
        System.out.println("deleting office "+office);
        //
        // delete office
        //
        officeMapper.deleteOffice(99);

        Office officeDel = officeMapper.findOfficeById(99);
        System.out.println("deleted office "+officeDel);
        assertNull(officeDel);
    }




}