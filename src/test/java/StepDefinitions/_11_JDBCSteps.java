package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _11_JDBCSteps {
    @Then("Send The query the database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String sorgu) {
        // DataBase list
        List<List<String>> dbList= DBUtility.getListData(sorgu);
        System.out.println("dbList = " + dbList);

        // Web List
        DialogContent dc= new DialogContent();
        List<WebElement> uiList=dc.waitVisibleListAllElement(dc.nameList);
        for (WebElement e : uiList)
            System.out.println("e.getText() = " + e.getText());

        // Karşılaştırma
        for (int i = 0; i < dbList.size(); i++) {
            Assert.assertEquals("Hatalı durum", dbList.get(i).get(1), uiList.get(i).getText());
        }
    }
}
