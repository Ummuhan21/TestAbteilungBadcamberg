package stepDefinition;

import baseClass.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjekts.TS2_GL.GeC_Bewerber;

public class GeCBewerberÄndern extends BaseClass {

    GeC_Bewerber bewerber = new GeC_Bewerber();

    @And("Ich schreibe in das Suchfeld den gewünschten Bewerber, den ich ändern möchte")
    public void ichSchreibeInDasSuchfeldDenGewünschtenBewerberDenIchÄndernMöchte() {
        sendKeys(bewerber.lBewerberMaskeSuchbuttonTextFeld,"Müller");
    }

    @And("Ich klicke auf der Button OK, nachdem ich in das Feld Suche die gewünschten Bewerber eingegeben habe")
    public void ichKlickeAufDerButtonOKNachdemIchInDasFeldSucheDieGewünschtenBewerberEingegebenHabe() {
        click(bewerber.lBewerberMaskeSuchfeldOkButton);
    }

    @And("Ich klicke auf den Bewerber")
    public void ichKlickeAufDenBewerber() {
        click(bewerber.lBewerberMaskeAllBewerberListe);
    }

    @Then("Ich sehe auf der Seite unter der Button {string}")
    public void ichSeheAufDerSeiteUnterDerButton(String text) {
        waitForVisibilty(bewerber.fußLeisteButtons(text));
    }

    @And("Ich klicke auf der Seite der Button {string}")
    public void ichKlickeAufDerSeiteUnterDerButton(String text) {
        click(bewerber.fußLeisteButtons(text));
    }

    @Then("Ich sehe die von mir geänderte Bewerber")
    public void ichSeheDieVonMirGeänderteBewerber() {
        sleep(2000);
        click(bewerber.bewerberFußLeisteButton("Suchen"));
        click(bewerber.lSuchFeldZürecksetzenButton);
        click(bewerber.lBewerberMaskeSuchfeldOkButton);
        Assert.assertTrue(driver.getPageSource().contains("Müller"));
    }

    @And("Ich ändere die Daten der angelegten Bewerber")
    public void ichÄndereDieDatenDerAngelegtenBewerber() {
        bewerber.angelegteBewerberÄndern();
    }
}
