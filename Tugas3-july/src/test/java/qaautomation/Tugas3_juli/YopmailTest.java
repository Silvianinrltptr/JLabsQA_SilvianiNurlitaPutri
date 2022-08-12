package qaautomation.Tugas3_juli;

import org.testng.annotations.Test;

public class YopmailTest extends BaseWebYopmailTest{
	@Test
	public void OpenMail() {
		HomePage homePage = new HomePage(getDriver(), getExplicitWait());
		CommonPage common = new CommonPage(getDriver(), getExplicitWait());
		InboxPage inboxPage = new InboxPage(getDriver(), getExplicitWait());
		
		String username = "automationtest";
		String iFrame = "ifmail";//=> //iframe[@id='ifmail']
		
		homePage.inputUsername(username);
		homePage.clickBtn();
		common.switchIframe(iFrame);
		String textEmail = inboxPage.getTextEmail();
		
		System.out.println("===> EMAIL \n" + textEmail);
	}
}
