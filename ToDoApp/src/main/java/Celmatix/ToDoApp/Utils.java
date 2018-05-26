package Celmatix.ToDoApp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Utils {
	public WebDriver driver;	
	HomePage homepage;

	public Utils(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Method Name:CenterText
	 * Description: Method to Enter text in TodoText field and press Enter 
	 * Author: Savitri
	 * Input: 
	 * 		strToDo: A string that needs to be entered in Text field
	 * Output:None
	 */
	public void enterText(String strToDo)
	{
		homepage = new HomePage(driver);
		homepage.txtToDo().sendKeys(strToDo);
		homepage.txtToDo().sendKeys(Keys.ENTER);
	}
	
	/**
	 * Method Name:verifyText
	 * Description: Method to Verify task entered in present in ToDoList
	 * Author: Savitri
	 * Input: 
	 *   - strToDo : Item name that needs to be verified.
	 * Output:Web driver object
	 */
	public Boolean verifyText(String strToDo)
	{
		homepage = new HomePage(driver);
		
		for(int itr=0;itr<homepage.toDoListItems().size();itr++)
		{
			if(homepage.toDoListItems().get(itr).getText().equals(strToDo))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method Name:getCountToDoItems
	 * Description: Method to read Item Count
	 * Author: Savitri
	 * Input:None 
	 * Output:Retruns item count
	 */
	public String getCountToDoItems()
	{
		homepage = new HomePage(driver);
		return homepage.txtItemLeft().getText();
	}
	
	/**
	 * Method Name:clickClearCompleted
	 * Description: Method to click on clear completed Link
	 * Author: Savitri
	 * Input:None 
	 * Output:None
	 */
	public void clickClearCompleted()
	{
		homepage = new HomePage(driver);
		homepage.lnkClearCompleted().click();
	}
}
