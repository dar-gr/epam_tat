package framework.test;

import framework.model.User;
import framework.page.AdMobilesPage;
import framework.page.MarksPage;
import framework.service.UserCreator;
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
    public void cleanCompares(){
        new CatalogOnlinerPage(driver)
                .openPage();
        String expectedPage = driver.getCurrentUrl();

        String actualPage = new CatalogOnlinerMobilePage(driver)
                .openPage()
                .chooseTwoFirstMobiles()
                .clickCompare()
                .cleanCompares();
        Assert.assertEquals(actualPage, expectedPage);

    }

    @Test
    public void filterOfferPage(){
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
        Assert.assertFalse(actualInvalidMessageAppear.isEmpty());
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
        User user = UserCreator.withCredentialsFromProperty();
        Assert.assertEquals(actualUsername, user.getUsername());
    }

    @Test
    public void markerAddTest(){

        new CatalogOnlinerMobilePage(driver)
                .openPhonePage();
        String expectedNameOfMobile = driver.getCurrentUrl();
        new CatalogOnlinerMobilePage(driver)
                .addInMarks()
                .enterUserInfo()
                .signInButtonClick();
        new CatalogOnlinerMobilePage(driver)
                .addInMarks();
        new MarksPage(driver)
                .openPage()
                .openCatalogMarks()
                .openFirstElement();
        String actualNameOfMobile = driver.getCurrentUrl();
        new CatalogOnlinerMobilePage(driver)
                .openPhonePage()
                .addInMarks();
        Assert.assertEquals(actualNameOfMobile, expectedNameOfMobile);
    }

    @Test
    public void markerAllDeleteTest() {
        new CatalogOnlinerMobilePage(driver)
                .openPhonePage()
                .addInMarks()
                .enterUserInfo()
                .signInButtonClick();
        new CatalogOnlinerMobilePage(driver)
                .addInMarks();
        String actualMessage = new MarksPage(driver)
                .openPage()
                .openCatalogMarks()
                .chooseAllElements()
                .deleteChosen()
                .noMarksMessage();
        Assert.assertFalse(actualMessage.isEmpty());
    }

    @Test
    public void adMobilesTest(){
        String expectedName = new AdMobilesPage(driver)
                .openPage()
                .getFirstAdName();
        String actualName = new AdMobilesPage(driver)
                .openFirstAd()
                .getAdName();
        Assert.assertTrue(actualName.contains(expectedName));
    }
}
