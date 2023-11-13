package test;


import org.junit.jupiter.api.Test;
import pages.PracticeForm;
import pages.fixture.PracticeFormFixture;


public class PracticeFormTest extends BaseTest {
    PracticeForm practiceForm = new PracticeForm();
    PracticeFormFixture fixture = new PracticeFormFixture();


    @Test
    void successPracticeFormTest() {
        practiceForm.openPage().
                setFirstName(fixture.firstName).
                lastNameInput(fixture.lastName).
                userEmailInput(fixture.email).
                userNumberInput(fixture.phoneNumber).
                userCurrentAdressInput(fixture.currentAdress).
                genderWrapper(fixture.gender).
                setDateOfBirth(fixture.dayOfBirth, fixture.mountOfBirther, fixture.yearOfBirth).
                subjectInput(fixture.subjects).
                hobbiesWrapper(fixture.hobbies).
                uploadPicture("frost.jpeg").
                selectState(fixture.state).
                selectCity(fixture.city).
                pressSubmit();


        practiceForm.checkResult("Student Name", fixture.firstName + " " + fixture.lastName)
                .checkResult("Student Email", fixture.email)
                .checkResult("Gender", fixture.gender)
                .checkResult("Mobile", fixture.phoneNumber)
                .checkResult("Date of Birth", fixture.dayOfBirth + " " + fixture.mountOfBirther + "," + fixture.yearOfBirth)
                .checkResult("Subjects", fixture.subjects)
                .checkResult("Hobbies", fixture.hobbies)
                .checkResult("Picture", "frost.jpeg")
                .checkResult("Address", fixture.currentAdress)
                .checkResult("State and City", fixture.state + " " + fixture.city);


    }


    @Test
    void checkRequiredFieldsTest() {
        practiceForm.openPage().
                setFirstName(fixture.firstName).
                lastNameInput(fixture.lastName).
                userNumberInput(fixture.phoneNumber).
                genderWrapper(fixture.gender).
                setDateOfBirth(fixture.dayOfBirth, fixture.mountOfBirther, fixture.yearOfBirth).
                pressSubmit();

        practiceForm.checkResult("Student Name", fixture.firstName + " " + fixture.lastName)
                .checkResult("Gender", fixture.gender)
                .checkResult("Mobile", fixture.phoneNumber)
                .checkResult("Date of Birth", fixture.dayOfBirth + " " + fixture.mountOfBirther + "," + fixture.yearOfBirth);


    }

    @Test
    void negativePracticeFormTest() {
        practiceForm.openPage().
                openPage().
                setFirstName(fixture.firstName).
                lastNameInput(fixture.lastName).
                userNumberInput(fixture.incorrectPhoneNumber).
                genderWrapper(fixture.gender).
                setDateOfBirth(fixture.dayOfBirth, fixture.mountOfBirther, fixture.yearOfBirth).
                pressSubmit();


        practiceForm.formResult();


    }

}

