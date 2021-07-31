package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomUtils.getRandomString;


public class RegistrationWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();


    String firstNameUser = faker.name().firstName(),
            lastNameUser = faker.name().lastName(),
            email = faker.internet().safeEmailAddress(),
            gender = "Female",
            phone = getRandomString(10),
            year = "1998",
            month = "May",
            day = "12",
            subject = "Biology",
            hobby = "Sports",
            picture = "testcat.png",
            address = faker.address().streetAddress(),
            state = "Uttar Pradesh",
            city = "Lucknow";


    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }


    @Test
    void successfulSubmitFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstNameUser);
        registrationPage.typeLastName(lastNameUser);
        registrationPage.typeEmail(email)
                .selectGender(gender).typePhone(phone)
                .setDateOfBirth(day, month, year)
                .selectSubject(subject)
                .selectHobby(hobby)
                .uploadPicture(picture)
                .typeAddress(address)
                .selectState(state)
                .selectCity(city)
                .checkResult();

        registrationPage.checkResultsTitle();
        registrationPage.checkResultsValue(firstNameUser + " " + lastNameUser)
                .checkResultsValue(email)
                .checkResultsValue(gender)
                .checkResultsValue(phone)
                .checkResultsValue(day + " " + month + "," + year)
                .checkResultsValue(subject)
                .checkResultsValue(hobby)
                .checkResultsValue(picture)
                .checkResultsValue(address)
                .checkResultsValue(state + " " + city);


    }


}