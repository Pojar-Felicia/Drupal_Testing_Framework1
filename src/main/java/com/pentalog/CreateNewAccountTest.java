package com.pentalog;

import com.pentalog.poms.NewAccount;
import org.testng.annotations.Test;

@Test
public class CreateNewAccountTest extends BaseTest {
public void  testCreateNewAccount(){
    NewAccount newAccount = new NewAccount(driver);
    newAccount.setNewAccount("Felicia_Pojar","felicia@gmail.com");
}
}


