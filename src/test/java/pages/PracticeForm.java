package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.fixture.PracticeFormFixture;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeForm {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            userCurrentAdressInput = $("#currentAddress"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            selectCity = $("#city"),
            selectState = $("#state"),
            pressSubmit = $("#submit"),
            checkResult = $(".table-responsive");


    CalendarComponent calendarComponent = new CalendarComponent();
    PracticeFormFixture practiceFormFixture = new PracticeFormFixture();

    public PracticeForm openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeForm setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;

    }

    public PracticeForm lastNameInput(String value) {
        lastNameInput.setValue(value);
        return this;

    }

    public PracticeForm userEmailInput(String value) {
        userEmailInput.setValue(value);
        return this;

    }

    public PracticeForm userNumberInput(String value) {
        userNumberInput.setValue(value);
        return this;

    }

    public PracticeForm genderWrapper(String value) {
        genderWrapper.$(byText(value)).click();
        return this;

    }

    public PracticeForm userCurrentAdressInput(String value) {
        userCurrentAdressInput.setValue(value);
        return this;

    }

    public PracticeForm setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PracticeForm subjectInput(String value) {
        subjectInput.val(value).pressEnter();
        return this;

    }

    public PracticeForm hobbiesWrapper(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;

    }

    public PracticeForm uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;

    }

    public PracticeForm selectState(String value) {
        selectState.click();
        selectState.$(byText(value)).click();
        return this;

    }

    public PracticeForm selectCity(String value) {
        selectCity.click();
        selectCity.$(byText(value)).click();
        return this;

    }

    public void pressSubmit() {
        pressSubmit.pressEnter();

    }

    public PracticeForm checkResult(String key, String value) {
        checkResult.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

    public PracticeForm formResult() {
        checkResult.shouldNotBe(Condition.visible);
        return this;
    }

}
