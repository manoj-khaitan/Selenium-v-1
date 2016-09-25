// spec.js

describe('Protractor Demo App', function() {
	var createsytusrtab = element(by.xpath("//span[contains(.,'Create System User')]"));
	var randVal = Date.now()
        var searchbutton = element(by.xpath(".//*[.='Search']"));

	function click_tab(tabname){
		var tabname = element(by.xpath("(//a[.='"+tabname+"'])[1]"));
		tabname.click();
	}

        function click_sub_tab(tabname){
		var tabname = element(by.xpath("(//span[.='"+tabname+"'])[1]"));
		tabname.click();
	}


  it('should be able to login', function() {
    browser.get('https://dashboard.cpexcalibur.com');
    element(by.xpath(".//*[@id='input_0']")).sendKeys('qa@psolution.com');
    element(by.xpath(".//*[@id='input_1']")).sendKeys('abc123');
    //element(by.xpath(".//*[@id='input_1']")).sendKeys('abc');
    element(by.buttonText('Login')).click();
    var h2header = element(by.xpath("//h2[contains(.,'Welcome Admin User: QA User')]"));
    expect(h2header.getText()).toEqual('Welcome Admin User: QA User');
  });

  it('should be verifying CLIENT support service', function() {
	   element(by.xpath("(//a[.='CLIENT SUPPORT SERVICES'])[1]")).click();
	  var searchbutton = element(by.xpath(".//*[.='Search']"));
	  var drpdwnbutton = element(by.xpath(".//*[@id='select_value_label_2']/span[2]"));
	  var searchtextbox = element(by.className('ng-pristine ng-untouched ng-valid'));
	  searchtextbox.sendKeys('*');
	  searchbutton.click(); 
	  var result = element(by.xpath(".//td[contains(.,'sysadmin@excalibur.com')]"));
	  expect(result.getText()).toEqual('sysadmin@excalibur.com')
	  var searchbx1 = element(by.className('ng-valid md-input ng-dirty ng-valid-parse ng-touched'));
	  searchbx1.clear();
	  searchbx1.sendKeys('sysadmin@excalibur.com');	
          searchbutton.click();
	  expect(result.getText()).toEqual('sysadmin@excalibur.com')
	  searchbx1.clear();
	  searchbx1.sendKeys('sysad');	
          searchbutton.click();
	  expect(result.getText()).toEqual('sysadmin@excalibur.com')
          drpdwnbutton.click();
	  element(by.cssContainingText('md-option', 'Last Name')).click();
	  searchbx1.clear();
          searchbx1.sendKeys('*');
	  searchbutton.click(); 
          expect(result.getText()).toEqual('sysadmin@excalibur.com')
  });
 it('user should be able to create a account', function() {
	   var usercrtdsuccessmsg = element(by.xpath(".//span[contains(.,'User has been created successfully')]"));
	   click_tab("Dashboard");
	   click_tab("ADMIN SERVICES");
	   click_tab("Admin Service Module");
	   createsytusrtab.click();
	   var email = element(by.model("user.email"));
	   email.clear();
           var emailid = 'test'+randVal+'@psolution.com';
	   email.sendKeys(emailid);

	   var password = element(by.model("user.password"));
	   password.clear();
	   password.sendKeys('abc123');
	   var name = element(by.model("user.firstName"));
	   name.sendKeys('test');
	   var lstname = element(by.model("user.lastName"));
	   lstname.sendKeys('test1');
	   element(by.model("user.role")).all(by.tagName('md-radio-button')).get(1).click();
	   element(by.model("user.country")).click();
	   element(by.cssContainingText('md-option', 'Albania')).click();
	   element(by.xpath("(//button[contains(.,'Next')])[1]")).click();
          
          //selecting values from organization page
	   element(by.model("user.organization")).click();
	   element(by.cssContainingText('md-option', 'Ninja Publishing Organization')).click();
	   element(by.xpath("(//button[contains(.,'Next')])[2]")).click();
	   //selecting access level

	   element(by.model("permissionLevel")).all(by.tagName('md-radio-button')).get(2).click();
	   element(by.xpath("(//button[contains(.,'Next')])[3]")).click();
	   element(by.xpath("//button[contains(.,'Submit')]")).click();
	   var usercrtdsuccessmsg = element(by.xpath(".//span[contains(.,'User has been created successfully')]"));
	   expect(usercrtdsuccessmsg.getText()).toEqual('User has been created successfully');

           //verifyinh results for newly created user
	   click_sub_tab("Account search");
	   element(by.model("searchValue")).sendKeys(emailid);
	   searchbutton.click();
	   var result = element(by.xpath("(//td[.='"+emailid+"'])"));
	   expect(result.isDisplayed());

	  });
});