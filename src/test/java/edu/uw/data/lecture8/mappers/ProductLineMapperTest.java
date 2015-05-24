package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.model.Office;
import edu.uw.data.lecture8.model.OfficeType;
import edu.uw.data.lecture8.model.Product;
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
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;

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


    @Test
    public void findAllProductLinesTest() {
        List<ProductLine> productLines = productLineMapper.findAllProductLines();
        log.info("found  " + productLines.size() + " product lines");
        assertThat(productLines.size(), greaterThan(0));

        for (ProductLine productLine : productLines) {
            System.out.println("productLine " + productLine);
        }

    }


    @Test
    public void findByIdTest() {
        String productLineName = "Ships";
        ProductLine productLine = productLineMapper.findById(productLineName);
        System.out.println("productLine " + productLine);
        assertThat(productLine, notNullValue());

    }

    @Test
    public void findProductLineByIdWithProducts_NESTED_SELECT() {
        String productLineName = "Ships";
        ProductLine productLine = productLineMapper.findProductLineByIdWithProducts_NESTED_SELECT(productLineName);
        System.out.println("productLine " + productLine);
        assertThat(productLine, notNullValue());
        Set<Product> products = productLine.getProducts();
        assertThat(products, notNullValue());

        System.out.println("products set suze" + products.size());
        assertThat(products.size(), greaterThan(0));

        for (Product product : products) {
           log.info("NESTED SELECT COLLECTION "+product.getProductLine() + ":" + product.getProductName());
            assertThat(product.getProductLine(), is(productLineName));
        }

    }

    @Test
    public void findProductLineByIdWithProducts_NESTED_RESULTS() {
        String productLineName = "Ships";
        ProductLine productLine = productLineMapper.findProductLineByIdWithProducts_NESTED_RESULTS(productLineName);
        System.out.println("productLine " + productLine);
        assertThat(productLine, notNullValue());


        Set<Product> products = productLine.getProducts();

        assertThat(products, notNullValue());

        log.info("found "+products.size()+" products for '"+productLineName+"' productline ");
        System.out.println("products set size" + products.size());

        assertThat(products.size(), greaterThan(0));

        for (Product product : products) {
            System.out.println("NESTED RESULT COLLECTION " + product.getProductLine() + ":" + product.getProductName());
          //  assertEquals(productLineName, product.getProductLine() );
        }

    }


}
