package com.saucedemo.cucumber.steps;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.saucedemo.db.domain.Item;
import com.saucedemo.db.persistence.ConnectionPool;
import com.saucedemo.db.service.ItemService;
import com.saucedemo.db.service.impl.ItemServiceImpl;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.math.BigDecimal;
import java.sql.Connection;

public class SaucedemoSteps extends CucumberRunner {

    private ItemService itemService;
    private Connection connection;
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    
    @Given("^I connect to database$")
    public void iConnectToDatabase(){
        connection = CONNECTION_POOL.getConnection();
        itemService = new ItemServiceImpl();
    }

    @When("^I insert the items$")
    public void iInsertTheItems() {
        Item item = new Item();
        item.setName("Sauce Labs Onesie");
        item.setDescription("Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
        item.setPrice(BigDecimal.valueOf(7.99));
        itemService.create(item);
    }

    @Then("^table items should be filled by inserted items$")
    public void tableItemsShouldBeFilledByInsertedItems() {
        Assert.assertNotNull(itemService.read(1L));
        CONNECTION_POOL.releaseConnection(connection);
    }
}
