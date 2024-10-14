package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends BasePage {

    @FindBy(xpath = "//button[@title='Toggle']")
    public WebElement toggle;

    @FindBy(xpath = "//label[@for='tree-node-home']")
    public WebElement home;

    @FindBy(id = "tree-node-desktop")
    public WebElement desktop;
    @FindBy(xpath = "//label[@for='tree-node-notes']")
    public WebElement notes;
    @FindBy(xpath = "//label[@for='tree-node-commands']")
    public WebElement commands;

    @FindBy(xpath = "//label[@for='tree-node-documents']")
    public WebElement documents;

    @FindBy(id = "tree-node-office")
    public WebElement office;

    @FindBy(id = "tree-node-downloads")
    public WebElement downloads;

    @FindBy(xpath = "//button[@title='Expand all']")
    public WebElement expandAll;

    @FindBy(xpath = "//button[@title='Collapse all']")
    public WebElement collapseAll;

    public CheckBoxPage clickOnExpandAll() {
        webElementActions.click(this.expandAll);
        return this;
    }

    public CheckBoxPage clickOnNotes() {
        webElementActions.click(this.notes);
        return this;
    }

    public CheckBoxPage clickOnDocuments() {
        webElementActions.click(this.documents);
        return this;
    }

    public CheckBoxPage clickOnCollapseAll() {
        webElementActions.click(this.collapseAll);
        return this;
    }
}
