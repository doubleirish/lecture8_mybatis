package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.dto.SearchCustomerForm;
import edu.uw.data.lecture8.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
public class SearchMapperTest extends AbstractJUnit4SpringContextTests {

    static final Logger log = LoggerFactory.getLogger(SearchMapperTest.class);

    @Autowired
    private SearchMapper searchMapper;

    @Test
    public void searchCustomers_city_london() {
        SearchCustomerForm form = new SearchCustomerForm();
        String city = "London";
        form.setCity(city);
        List<Customer> customers = searchMapper.searchCustomers(form);
        for (Customer customer : customers) {
            System.out.println("customer " + customer);
            assertEquals(city, customer.getCity());
        }
    }


    @Test
    public void searchCustomers_country_germany() {
        SearchCustomerForm form = new SearchCustomerForm();
        String country = "Germany";
        form.setCountry(country);
        List<Customer> customers = searchMapper.searchCustomers(form);
        for (Customer customer : customers) {
            System.out.println("customer " + customer);
            assertEquals(country, customer.getCountry());
        }
    }


    @Test
    public void searchCustomers_country_germany_and_limit_gt() {
        SearchCustomerForm form = new SearchCustomerForm();
        String country = "Germany";
        Double limitGt = 2000.0;
        form.setCountry(country);
        form.setCreditLimitGreaterThanOrEqual(limitGt);
        List<Customer> customers = searchMapper.searchCustomers(form);
        for (Customer customer : customers) {
            System.out.println("customer " + customer);
            assertEquals(country, customer.getCountry());
            assertTrue(customer.getCreditLimit() > limitGt);
        }
    }

    @Test
    public void searchCustomers_greaterThan_lessThan() {
        SearchCustomerForm form = new SearchCustomerForm();

        Double limitGt = 20_000.0;
        Double limitLt = 50_000.0;

        form.setCreditLimitGreaterThanOrEqual(limitGt);
        form.setCreditLimitLessThanOrEqual(limitLt);
        List<Customer> customers = searchMapper.searchCustomers(form);
        for (Customer customer : customers) {
            System.out.format("Customer  %50s Cache has creditLimit '%f'   \n"
                    , customer.getCustomerName()
                    , customer.getCreditLimit()
            );

            assertTrue(customer.getCreditLimit() >= limitGt);
            assertTrue(customer.getCreditLimit() <= limitLt);

        }
    }


    @Test
    public void searchCustomers_foreach_state_example() {
        SearchCustomerForm form = new SearchCustomerForm();


        List<String> states = Arrays.asList("WA,CA,NY".split(","));
        form.setStates(states);
        List<Customer> customers = searchMapper.searchCustomers(form);
        for (Customer customer : customers) {
            System.out.format("Customer  %50s is in has state '%s'   \n"
                    , customer.getCustomerName()
                    , customer.getState()
            );

            assertThat(customer.getState(), isIn(states));

        }
    }


    @Test
    public void searchCustomersWhoPurchasedAProductLine() {
        SearchCustomerForm form = new SearchCustomerForm();
        form.setProductLine("Ships");


//        List<String> states = Arrays.asList("WA,CA,NY".split(","));
//        form.setStates(states);

        List<Customer> customers = searchMapper.searchCustomersWhoPurchasedAProductLine(form);
        customers.forEach(System.out::println);
    }


}
