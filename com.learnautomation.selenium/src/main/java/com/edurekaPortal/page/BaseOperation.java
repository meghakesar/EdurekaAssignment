package com.edurekaPortal.page;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.ElementsCommon;

public class BaseOperation {
protected  ElementsCommon elementcommon;

public BaseOperation(WebDriver driver) {
	elementcommon = new ElementsCommon();
	
}


}
