package com.pentalog;

import com.pentalog.poms.LoginPage;
import com.pentalog.poms.Logout;
import org.testng.annotations.Test;

@Test
public class LoginTest  extends BaseTest{
    public void testLogin() {
        LoginPage loginObj = new LoginPage(driver);
        loginObj.login("Admin","Lallala_LandAdmin1");
        Logout logout = new Logout(driver);
        logout.userLogout();
    }
}


