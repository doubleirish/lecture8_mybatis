package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.model.ProductLine;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

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
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//TODO run with rollback=false too, you may see different results because the transaction is commited.
public class ProductLineMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

    static final Logger log = LoggerFactory.getLogger(ProductLineMapperTest.class);

    @Autowired
    private ProductLineMapper productLineMapper;

    @Override
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }


    @Test //LAB 2
    public void findAllProductLinesTest_LAB() {
        List<ProductLine> productLines = productLineMapper.findAllProductLines();
        log.info("found  " + productLines.size() + " product lines");
        assertThat(productLines.size(), greaterThan(0));

        for (ProductLine productLine : productLines) {
            System.out.println("productLine " + productLine);
        }

    }


    @Test  //LAB 2
    public void findByIdTest_LAB() {
        String productLineName = "Ships";
        ProductLine productLine = productLineMapper.findById(productLineName);
        System.out.println("productLine " + productLine);
        assertThat(productLine, notNullValue());

    }


}
