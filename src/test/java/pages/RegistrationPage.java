package pages;

import com.codeborne.selenide.SelenideElement;
import components.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String FORM_TiTLE = "Student Registration Form";
    private final String RESULT_TITLE = "Thanks for submitting the form";

    private Calendar calendar = new Calendar();

    private SelenideElement modal = $("[role=dialog]");

    public void openPage(){
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FORM_TiTLE));
    }
    public void typeFirstName(String firstNameUser){
        $("[id=firstName]").setValue(firstNameUser);
    }

    public void typeLastName(String lastNameUser){
        $("[id=lastName]").setValue(lastNameUser);
    }

    public RegistrationPage typeEmail(String email){
        $("[id=userEmail]").setValue(email);

        return this;
    }

    public RegistrationPage selectGender(String gender){
        $("[id=genterWrapper]").$(byText(gender)).scrollTo().click();

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year){
        calendar.setDate(day, month, year);

        return this;
    }


    public RegistrationPage typePhone(String phone){
        $("[id=userNumber]").setValue(phone);

        return this;
    }


    public RegistrationPage selectSubject(String subject){
        $("#subjectsInput").setValue(subject).scrollTo().pressEnter();

        return this;
    }

    public RegistrationPage selectHobby(String hobby){
        $("#hobbiesWrapper").$(byText(hobby)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String picture) {
        $("#uploadPicture").uploadFromClasspath(picture);

        return this;
    }

    public RegistrationPage typeAddress(String address) {
        $("[id=currentAddress]").setValue(address);

        return this;
    }

    public RegistrationPage selectState (String state){
        $("#react-select-3-input").setValue(state).pressEnter();

        return this;
    }

    public RegistrationPage selectCity (String city){
        $("#react-select-4-input").setValue(city).pressEnter();

        return this;
    }

    public RegistrationPage checkResult (){
        $("#submit").scrollTo().click();

        return this;
    }

    public void checkResultsTitle(){
        modal.$(".modal-title").shouldHave(text(RESULT_TITLE));
    }

    public RegistrationPage checkResultsValue(String value) {
        modal.$(".table-responsive").shouldHave(text(value));
        return this;
    }
}
