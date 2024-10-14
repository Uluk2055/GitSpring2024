package demoqa.pages;


import demoqa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PracticeFormPage extends BasePage{


    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement email;
//
//    @FindBy(className = "col-md-9 col-sm-12")
//    public WebElement genderField;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    public WebElement male;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    public WebElement female;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    public WebElement other;

    @FindBy(id = "userNumber")
    public WebElement mobileNumber;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dob;

    @FindBy(className = "react-datepicker__day--011")
    public WebElement dobDay;

    @FindBy(id = "subjectsInput")
    public WebElement subject;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    public WebElement sports;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    public WebElement reading;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    public WebElement music;

//    @FindBy(id = "uploadPicture")
//    public WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(xpath = "//div[contains(text(), 'Select State')]")
    public WebElement state;

    @FindBy(xpath = "//div[contains(text(), 'Select City')]")
    public WebElement city;


    //id="state"
    //div[@class=" css-1uccc91-singleValue" and text() = 'Haryana']
    //id="city"
    //div[@class=" css-1uccc91-singleValue" and text() = 'Panipat']

    @FindBy(id = "submit")
    public WebElement submitBtn;



    public PracticeFormPage inputFirstName(String firstName) {
        webElementActions.navigateToElement(this.firstName).input(this.firstName, firstName);
        return this;
    }

    public PracticeFormPage inputLastName(String lastName) {
        webElementActions.input(this.lastName, lastName);
        return this;
    }

    public PracticeFormPage inputEmail(String email) {
        webElementActions.scrollToElement(this.email).input(this.email, email);
        return this;
    }

    public PracticeFormPage clickOnGender(String gender) {
            switch (gender.toLowerCase()){
                case "male" : webElementActions.click(male);
                break;
                case "female" : webElementActions.click(female);
                break;
                case "other" : webElementActions.click(other);
                break;
                default: throw new IllegalArgumentException("Not valid gender");
            }
        return this;
    }

    public PracticeFormPage inputMobileNumber(String mobileNumber) {
        webElementActions.scrollToElement(this.mobileNumber).input(this.mobileNumber, mobileNumber);
        return this;
    }

    public PracticeFormPage clickDOB() {
        webElementActions.click(this.dob);
        return this;
    }

    public PracticeFormPage selectDOBDay() {
        webElementActions.click(this.dobDay);
        return this;
    }

    public PracticeFormPage inputSubjects(String ... subject){
        webElementActions.navigateToElement(this.subject);
        webElementActions.click(this.subject);
            for (String s : subject) {
                this.subject.sendKeys(s);
                this.subject.sendKeys(Keys.ENTER);
            }
            return this;

    }

//    public PracticeFormPage inputSubjects(String subject) {
//        webElementActions.inputAndEnter(this.subject, subject);
//        return this;
//    }

//    public PracticeFormPage inputSubject(String subject) {
//        webElementActions.input(this.subject, subject);
//        return this;
//    }

    public PracticeFormPage clickOnHobbies(int ... hobbie) {
        for (int i : hobbie) {
            switch (i) {
                case 1:
                    webElementActions.navigateToElement(sports);
                    webElementActions.click(sports);
                    break;
                case 2:
                    webElementActions.navigateToElement(reading);
                    webElementActions.click(reading);
                    break;
                case 3:
                    webElementActions.navigateToElement(music);
                    webElementActions.click(music);
                    break;
                default:
                    throw new IllegalArgumentException("Select a valid hobby");
            }
        }
        return this;
    }

    public PracticeFormPage inputCurrentAddress(String currentAddress) {
        webElementActions.input(this.currentAddress, currentAddress);
        return this;
    }

//    public PracticeFormPage selectStateAndCity(int stateIndex, int cityIndex) {
//        webElementActions.navigateToElement(this.state).click(this.state);
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
//        WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectState(stateIndex))));
//        state.click();
//
//        webElementActions.navigateToElement(this.city).click(this.city);
//        WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectCity(selectState(stateIndex), cityIndex))));
//        city.click();
//        return this;
//    }
    public PracticeFormPage clickOnSubmit() {
        webElementActions.scrollToElement(this.submitBtn).click(this.submitBtn);
        return this;
    }

//    private String selectState(int stateIndex) {
//        return switch (stateIndex) {
//            case 1 -> "//div[contains(text(), 'NCR')]";
//            case 2 -> "//div[contains(text(), 'Uttar Pradesh')]";
//            case 3 -> "//div[contains(text(), 'Haryana')]";
//            case 4 -> "//div[contains(text(), 'Rajasthan')]";
//            default -> throw new IllegalArgumentException("Select a valid state");
//        };
//    }

//    private String selectCity(String state, int cityIndex) {
//        String stateFormated = state.substring(state.indexOf("'") + 1, state.lastIndexOf("'")).toLowerCase();
//        switch (stateFormated) {
//            case "ncr":
//                return getNcrCity(cityIndex);
//            case "uttar pradesh":
//                return getUttarCity(cityIndex);
//            case "haryana":
//                return cityIndex == 1 ? "//div[contains(text(), 'Karnal')]" : "//div[contains(text(), 'Panipat')]";
//            case "rajasthan":
//                return cityIndex == 1 ? "//div[contains(text(), 'Jaipur')]" : "//div[contains(text(), 'Jaiselmer')]";
//            default:
//                throw new IllegalArgumentException("Select a valid city");
//        }
//    }

//    private static String getUttarCity(int cityIndex) {
//        return switch (cityIndex) {
//            case 1 -> "//div[contains(text(), 'Arga')]";
//            case 2 -> "//div[contains(text(), 'Lucknow')]";
//            case 3 -> "//div[contains(text(), 'Merrut')]";
//            default ->
//                    throw new IllegalArgumentException("There is no such city in the Uttar Pradesh state (choose one of these: Arga, Lucknow, Merrut)");
//        };
//    }
//
//    private static String getNcrCity(int cityIndex) {
//
//        return switch (cityIndex) {
//            case 1 -> "//div[contains(text(), 'Delhi')]";
//            case 2 -> "//div[contains(text(), 'Gurgaon')]";
//            case 3 -> "//div[contains(text(), 'Noida')]";
//            default ->
//                    throw new IllegalArgumentException("There is no such city in the Uttar Pradesh state (choose one of these: Arga, Lucknow, Merrut)");
//        };
//    }

//    public PracticeFormPage fillForm(Form form) throws InterruptedException {
//        Random random = new Random();
//        inputFirstName(form.getFirstName())
//                .inputLastName(form.getLastName())
//                .inputUserEmail(form.getEmail())
//                .selectGender("male")
//                .inputUserPhoneNumber(form.getPhoneNumber())
//                .selectBirthDate(form.getYearOfBirth(), form.getMonthOfBirth(), form.getDayOfBirth())
//                .inputSubject("Maths", "Economics", "Computer")
//                .selectHobbies(1, 2)
//                .uploadPicture()
//                .inputCurrentAddress(form.getCurrentAddress())
//                .selectStateAndCity(2, 2)
//                .submit();
//        return this;
//    }


}

