package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTestsHw2 {

    String firstNameUser = "Firstname",
            lastNameUser = "Secondname",
            email = "useremail@mail.ma",
            gender = "Female",
            phone = "1234567890",
            yearOfBirth = "1998",
            monthOfbirth = "May",
            dayOfbirth = "12",
            picture = "testcat.png";   //dayOfWeekOfBirth = "Friday "


    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }


    @Test
    void successfulSubmitFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("[id=firstName]").setValue(firstNameUser);
        $("[id=lastName]").setValue(lastNameUser);
        $("[id=userEmail]").setValue(email);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $("[id=userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfbirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfbirth).click();

        //$("[aria-label='Choose Friday, May 29th, 1998']").click();
        //   $(String.format("[aria-label='Choose %s, %s, %s']", dayOfWeekOfBirth,monthOfbirth, dayOfbirth,yearOfBirth))
        //$(String.format("react-datepicker__day--0%s:not(react-datepicker__day--outside-month)", dayOfbirth)).click();
        $("#subjectsInput").setValue("Economics").pressEnter();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        //          $("#uploadPicture").uploadFile(new File("src/test/resources/testcat.png"));
        $("#uploadPicture").uploadFromClasspath(picture);
        $("[id=currentAddress").setValue("Russia, Spb, 21");
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Lucknow").pressEnter();
        $("[id=submit]").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstNameUser + " " + lastNameUser));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(phone));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfbirth + " " + monthOfbirth + "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text("Economics, Biology"));
        $x("//td[text()='Hobbies']").parent().shouldHave(text("Sports, Music"));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text("Russia, Spb, 21"));
        $x("//td[text()='State and City']").parent().shouldHave(text("Uttar Pradesh Lucknow"));
    }


}