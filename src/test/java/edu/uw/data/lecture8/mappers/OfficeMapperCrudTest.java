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

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
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
        //
        // verify office does not yet exist
        //
        String newCity = "New Dublin";
        Office officeBefore = officeMapper.findOfficeByCity(newCity);
        assertNull(officeBefore);  //does not exist yet

        //
        // build office
        //
        Office office = new Office();

        office.setCity(newCity);
        office.setOfficeType(new OfficeType(1));
        //
        // insert office
        //
        officeMapper.insertOffice(office);

        //
        // verify   office was inserted correctly
        //

        Office officeAfter = officeMapper.findOfficeByCity(newCity);
        assertNotNull(officeAfter);  //does not exist yet
        assertThat(officeAfter.getCity(),is(newCity));


    }

    @Test
        public void updateOffice() {
        Office office = officeMapper.findOfficeByCity("NYC");
        System.out.println("Office BEFORE "+office);
//

        String updatedPhone = "212-555-1234";
        office.setPhone(updatedPhone);
        int updatedOfficeTypeNum = 1;
        office.setOfficeType(new OfficeType(updatedOfficeTypeNum));
        //
        // update
        //
        officeMapper.updateOffice(office);


        Office updateOffice = officeMapper.findOfficeByCity("NYC");
        System.out.println("Office AFTER UPDATE "+updateOffice);

        assertThat(updateOffice.getPhone(), Matchers.is(updatedPhone));
       // assertThat(updateOffice.getState(), Matchers.is(updatedState));
        assertThat(updateOffice.getOfficeType().getOfficeType(), Matchers.is(updatedOfficeTypeNum));
    }

    @Test
    public void deleteOffice() {
        Office office = officeMapper.findOfficeByCity("DeleteMe");
        System.out.println("deleting office "+office);
        //
        // delete office
        //
        officeMapper.deleteOffice(office.getOfficeCode());

        Office officeDel = officeMapper.findOfficeByCity("DeleteMe");
        System.out.println("deleted office "+officeDel);
        assertNull(officeDel);
    }




}
