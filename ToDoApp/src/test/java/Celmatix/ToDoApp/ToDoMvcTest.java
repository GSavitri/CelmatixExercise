package Celmatix.ToDoApp;

import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

public class ToDoMvcTest extends Base{
	public static Logger log =LogManager.getLogger(ToDoMvcTest.class.getName());
	String driverpath =System.getProperty("user.dir") ;
	Utils objUtils;
	HomePage homepage;

	/**
	 * Method Name: R1_enterTextAndVerify
	 * Description: Method to enter the text "purchase shampoo"  
	 *               and verify that the text appears in list of to-do
	 * Author: Savitri
	 */	
	@Test
	public void R1_enterTextAndVerify()
	{
		objUtils = new Utils(driver);
		String strToDo = "purchase shampoo";
		objUtils.enterText(strToDo);
		log.info("PASS "+strToDo+" is entered in TextBox ToDolist");
		
		Assert.assertTrue(objUtils.verifyText(strToDo), "FAIL: The item purchase shampoo does not appear in the ToDolist");
	
		if(objUtils.verifyText(strToDo)==true)
		{
			log.info("PASS: The item  "+strToDo+" is presernt in the ToDolist");
			
		}
		else
		{
			log.error("FAIL: The item  "+strToDo+" does not appear in the ToDolist");
		}
		
	}
	
	
	/**
	 * Method Name: R2_enterTextAndVerify
	 * Description: Method to enter the text "wash cat"  
	 *               and verify that the text appears in list of to-do
	 * Author: Savitri
	 */
	@Test
	public void R2_enterTextAndVerify()
	{
		objUtils = new Utils(driver);
		String strToDo = "wash cat";
		objUtils.enterText(strToDo);
		
		Assert.assertTrue(objUtils.verifyText(strToDo), "FAIL: The item wash cat  does not appear in the ToDolist");
	
		if(objUtils.verifyText(strToDo)==true)
		{
			log.info("PASS: The item  "+strToDo+" is presernt in the ToDolist");
			
		}
		else
		{
			log.error("FAIL: The item  "+strToDo+" does not appear in the ToDolistt");
		}		
	}
	
	
	/**
	 * Method Name: R3_enterTextAndVerify
	 * Description: Method to enter the text "purchase band-aids"  
	 *               and verify that the text appears in list of to-do
	 * Author: Savitri
	 */
	
	@Test
	public void R3_enterTextAndVerify()
	{
		objUtils = new Utils(driver);
		String strToDo = "purchase band-aids";
		objUtils.enterText(strToDo);
	
		Assert.assertTrue(objUtils.verifyText(strToDo), "FAIL: The item purchase band-aids does not appear in the ToDolist");
		if(objUtils.verifyText(strToDo)==true)
		{
			log.info("PASS: The item  "+strToDo+" is presernt in the ToDolist as expected");
			
		}
		else
		{
			log.error("FAIL: The item  "+strToDo+" does not appear in the ToDolist");
		}
	}
	
	
	/**
	 * Method Name: R4_countToDoItems
	 * Description: Method to verify the number at the left side 
	 * 				of the list footer correctly indicates 3 items
	 * Author: Savitri
	 */
	@Test
	public void R4_countToDoItems()
	{
		Utils objUtils = new Utils(driver);
		
		Assert.assertEquals(objUtils.getCountToDoItems(), "3");
		
		if(objUtils.getCountToDoItems().equals("3"))
		{
			log.info("PASS: Number at the left side of the list footer is  3 as expected");
		}
		else
		{
			log.error("FAIL: Number at the left side of the list footer is not 3 as expected");
		}
		
	}
	
	/**
	 * Method Name: R5_MarkItemCompleted
	 * Description: Method to  mark the task “wash cat”  as completed	  
	 * Author: Savitri
	 */
	@Test
	public void R5_MarkItemCompleted()
	{
		String strToDo = "wash cat";
		WebElement ulToDoList = driver.findElement(By.className("main"));
		
		List<WebElement> toDoListitems = ulToDoList.findElements(By.tagName("li"));
		
		for(int itr=0;itr<toDoListitems.size();itr++)
		{
			if(toDoListitems.get(itr).getText().equals(strToDo))
			{
				toDoListitems.get(itr).findElement(By.tagName("input")).click();
				log.info("PASS: The task “wash cat”  is marked as completed	 ");
			}
		}
		
	}
	
	/**
	 * Method Name: R6_verifyItemCountAfterTaskComplete
	 * Description: Method to  verify that the total in the list footer correctly indicates 2 items
	 * Author: Savitri
	 */
	@Test
	public void R6_verifyItemCountAfterTaskComplete()
	{
		Utils objUtils = new Utils(driver);
		
		Assert.assertEquals(objUtils.getCountToDoItems(), "2");
		
		if(objUtils.getCountToDoItems().equals("2"))
		{
			log.info("PASS: Number at the left side of the list footer is  2 as expected");
		}
		else
		{
			log.error("FAIL: Number at the left side of the list footer is not 2 as expected");
		}
		
	}
	
	
	/**
	 * Method Name: R7_ClearCompletedAndVerifyList
	 * Description: Method to click “clear completed” and verify that 
	 * 				the “wash cat” item is no longer present in the list
	 * Author: Savitri
	 */
	@Test
	public void R7_ClearCompletedAndVerifyList()
	{
		String strToDo = "wash cat";
		Utils objUtils = new Utils(driver);
		objUtils.clickClearCompleted();
		Boolean result=objUtils.verifyText(driverpath);
		Assert.assertFalse(result, "The completed task “wash cat” is not removed on clearing the completed.");
		if(objUtils.verifyText(strToDo)==false)
		{
			log.info("PASS: The “wash cat” item is no longer present in the list as expected");
		}
		else
		{
			log.error("FAIL: The completed task “wash cat” is not removed on clearing the completed.");
		}
	}
	
	
	/**
	 * Method Name: R8_VerifyCodeInjectionExploit
	 * Description: Method to read data from getData method 
	 * 				and verify code injection scenarios.
	 * Author: Savitri
	 */
	@Test(dataProvider="getData")
	public void VerifyCodeInjectionExploit(String strToDo)
	{
		objUtils = new Utils(driver);
		objUtils.enterText(strToDo);
	
		Assert.assertTrue(objUtils.verifyText(strToDo), "FAIL: The item "+strToDo+" does not appear in the ToDolist");
		
		if(objUtils.verifyText(strToDo)==true)
		{
			log.info("PASS: The item  "+strToDo+" is presernt in the ToDolist as expected");
			
		}
		else
		{
			log.error("FAIL: The item  "+strToDo+" does not appear in the ToDolist");
		}	
		
	}
	
	/**
	 * Method Name: getData
	 * Description: Method is a data provider that provides text to verify Code Injection exploit
	 * Author: Savitri
	 */
	@DataProvider
	public Object[] getData()
	{
		
		Object[] data=new Object[5];
		
		data[0]="<script>alert('Injected!');</script>";
		data[1]="javascript:alert(document.cookie);";
		data[2]="javascript:alert('Executed!');";
		data[3]="javascript:void(document.forms[0].total.value=1);";
		data[4]="Select count(*) from todos where name=\"\" or \"1=1\"";
		
		return data;
	}
}