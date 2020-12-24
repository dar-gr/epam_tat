package framework.test;

import framework.page.MarksPage;
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

    @Test
    public void filterOfferPage() throws InterruptedException {
        int actualAmountFilteredByDealer = new CatalogOnlinerMobilePage(driver)
                .openPage()
                .clickOfferButtonOfFirstMobile()
                .clickOfficialDealerCheckbox()
                .countAllOffers();
        int expectedAmountFilteredByDealer = new CatalogOnlinerMobilePage(driver)
                .openPage()
                .clickOfferButtonOfFirstMobile()
                .countOnlyOfficialDealerOffer();
        Assert.assertEquals(actualAmountFilteredByDealer, expectedAmountFilteredByDealer);
    }

    @Test
    public void enteringInvalidUser(){
        String actualInvalidMessageAppear = new CatalogOnlinerMobilePage(driver)
                .openPage()
                .clickSignInPage()
                .enterInvalidUser()
                .signInButtonClick()
                .isInvalidMessage();
        String expectedInvalidMessage = "Неверный логин или пароль";
        Assert.assertEquals(actualInvalidMessageAppear, expectedInvalidMessage);
    }

    @Test
    public void enteringValidUser(){
        new CatalogOnlinerMobilePage(driver)
                .openPage()
                .clickSignInPage()
                .enterUserInfo()
                .signInButtonClick();
        String actualUsername = new CatalogOnlinerMobilePage(driver)
                .extendProfileInfoClick()
                .getUsername();
        Assert.assertEquals(actualUsername, "test1101");

    }

    @Test
    public void markerTest(){

        String expectedNameOfMobile = new CatalogOnlinerMobilePage(driver)
                .openPhonePage()
                .getUrl();
        new CatalogOnlinerMobilePage(driver)
                .addInMarks()
                .enterUserInfo()
                .signInButtonClick();
        new CatalogOnlinerMobilePage(driver)
                .addInMarks();
        String actualNameOfMobile = new MarksPage(driver)
                .openPage()
                .openCatalogMarks()
                .openFirstElementAndGetUrl();
        new CatalogOnlinerMobilePage(driver)
                .openPhonePage()
                .addInMarks();
        Assert.assertEquals(actualNameOfMobile, expectedNameOfMobile);
    }
}
