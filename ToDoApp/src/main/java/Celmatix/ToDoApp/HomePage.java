package Celmatix.ToDoApp;

import java.util.List;
import org.openqa.selenium.*;


/**
 * This page is the object repository for all the Web Elements
 * in the Main page of the WebSite
 */

public class HomePage{
	public WebDriver driver;	
	By ulToDoList = By.className("main");
	By txtItemsLeft = By.xpath("//span[@class='todo-count']/strong");
	By txtToDo = By.className("new-todo");
	By lnkClearCompleted = By.xpath("//button[@class='clear-completed']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement ulToDoList()
	{
		return driver.findElement(ulToDoList);
	}
	
	public List<WebElement> toDoListItems()
	{
		return driver.findElement(ulToDoList).findElements(By.tagName("li"));
	}
	
	public WebElement txtItemLeft()
	{
		return driver.findElement(By.xpath("//span[@class='todo-count']/strong"));
	}
    
	public WebElement txtToDo()
	{
		return driver.findElement(txtToDo);
	}
	
	public WebElement lnkClearCompleted()
	{
		return driver.findElement(lnkClearCompleted);
	}
}
