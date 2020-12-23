package framework.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import framework.page.CatalogOnlinerMobilePage;
import framework.page.CatalogOnlinerPage;

import java.util.List;

public class CatalogOnlinerTest extends CommonConditions{

    @Test
    public void resultOfUnrealFilterInCatalog() {

        List<WebElement> expectedMessageList = new CatalogOnlinerMobilePage(driver)
                .openPage()
                .searchForMaxPriceFilter("5")
                .noResultMessage();
        Assert.assertFalse(expectedMessageList.isEmpty());
    }

    @Test
    public void openMobileCatalog(){
        boolean isOnlyMobilesOnPage = new CatalogOnlinerPage(driver)
                .openPage()
                .clickElectronics()
                .moveToMobiles()
                .clickMobiles()
                .resultListOfMobiles();
        Assert.assertTrue(isOnlyMobilesOnPage);
    }

    @Test
    public void addInCompareList(){
        List<String> actualElementsInCompare = new CatalogOnlinerMobilePage(driver)
                .openPage()
                .chooseTwoFirstMobiles()
                .clickCompare()
                .getComparedElements();
        List<String> expectedElementsInCompare = new CatalogOnlinerMobilePage(driver)
                .openPage()
                .getTwoFirstElements();
        Assert.assertEquals(actualElementsInCompare, expectedElementsInCompare);
    }
}
