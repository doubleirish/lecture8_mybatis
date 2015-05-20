package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.dto.CustomerSalesReportDetail;
import edu.uw.data.lecture8.model.Employee;
import org.apache.ibatis.annotations.Param;
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
import java.util.Map;

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
public class SalesReportMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

    static final Logger log = LoggerFactory.getLogger(SalesReportMapperTest.class);

    @Autowired
    private SalesReportMapper salesReportMapper;

    @Override
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }



    @Test
    public void findBestCustomers() {
        List<CustomerSalesReportDetail> bestCustomers = salesReportMapper.findBestCustomers();
        for (CustomerSalesReportDetail customer : bestCustomers) {
            System.out.println("best customer "+customer);
        }
    }

    @Test
    public void findMostPopularProducts() {
        List<Map> bestProducts = salesReportMapper.findMostPopularProducts();
        for (Map bestProduct : bestProducts) {
            System.out.println("best customer "+ bestProduct);
        }
    }

    @Test
    public void findCustomersForSalesRep() {
        Employee salesRep = new Employee("Larry", "Bott");

        List<String> customers = salesReportMapper.findCustomersForSalesRep(salesRep);
        System.out.println("found "+customers.size() +" customers for salesrep "+salesRep);
        for (String customer : customers) {

            System.out.format ("salesrep %s %s   manages   customer %s \n",salesRep.getFirstName(),salesRep.getLastName(),customer);
        }
    }



}
