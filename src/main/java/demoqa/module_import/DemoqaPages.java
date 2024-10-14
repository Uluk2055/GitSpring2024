package demoqa.module_import;

import demoqa.pages.*;

public class DemoqaPages {

    public PracticeFormPage practiceFormPage;
    public TextBoxPage textBoxPage;
    public ButtonsPage buttonsPage;
    public BrowserWindowsPage browserWindowsPage;
    public AlertPage alertPage;
    public CheckBoxPage checkBoxPage;
    public SelectMenuPage selectMenuPage;
    public FramesPage framesPage;
    public RadioButtonPage radioButtonPage;
    public LinksPage linksPage;


    public DemoqaPages(){
        practiceFormPage = new PracticeFormPage();
        textBoxPage = new TextBoxPage();
        buttonsPage = new ButtonsPage();
        browserWindowsPage = new BrowserWindowsPage();
        alertPage = new AlertPage();
        checkBoxPage = new CheckBoxPage();
        selectMenuPage = new SelectMenuPage();
        framesPage = new FramesPage();
        radioButtonPage = new RadioButtonPage();
        linksPage = new LinksPage();

    }

    public PracticeFormPage getPracticeFormPage() {
        return practiceFormPage;
    }

    public TextBoxPage getTextBoxPage() {
        return textBoxPage;
    }

    public ButtonsPage getButtonsPage() {
        return buttonsPage;
    }

    public BrowserWindowsPage getBrowserWindowsPage() {
        return browserWindowsPage;
    }

    public AlertPage getAlertPage() {
        return alertPage;
    }

    public CheckBoxPage getCheckBoxPage() {
        return checkBoxPage;
    }

    public SelectMenuPage getSelectMenuPage() {
        return selectMenuPage;
    }

    public FramesPage getFramesPage() {
        return framesPage;
    }

    public RadioButtonPage getRadioButtonPage() {
        return radioButtonPage;
    }

    public LinksPage getLinksPage() {
        return linksPage;
    }
}
