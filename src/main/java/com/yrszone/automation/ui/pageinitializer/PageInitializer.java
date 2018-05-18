package com.yrszone.automation.ui.pageinitializer;


import static org.hamcrest.CoreMatchers.instanceOf;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

import com.yrszone.automation.ui.exception.AutomationDriverException;
import com.yrszone.automation.ui.field.BaseElement;
import com.yrszone.automation.ui.field.WebElements;
import com.yrszone.automation.ui.utilities.FindBy;
import com.yrszone.automation.ui.utilities.FindElement;
import com.yrszone.automation.ui.utilities.FindElements;
import com.yrszone.automation.ui.webdriver.UIWebDriver;

/**
 * 
 * initialize : This method will accept page as the argument and initializes all the member variables annotated as FindElement
 * 
 *
 */

public class PageInitializer {
		private PageInitializer(){
		}

	   public static <T extends BasePage> T intializePage(Class<T> pageClass, UIWebDriver driver) throws AutomationDriverException{
	        T objectInst= null;
	        try {
	            objectInst = pageClass.getConstructor().newInstance();
	            objectInst.setDriver(driver);
	            initialize(objectInst, driver);
	        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
	                | NoSuchMethodException | SecurityException e) {
	            throw new AutomationDriverException("Could not initialize page : ", e);
	        }    
	        return objectInst;
	    }

	    @SuppressWarnings("rawtypes")
		static void initialize(BasePage p, UIWebDriver driver) throws AutomationDriverException {
	        try{
	            Field[] fields = p.getClass().getDeclaredFields();
	            String className = p.getClass().getSimpleName();
	            for(Field f : fields){
	            	if(f.getType().getName().equals(WebElements.class.getTypeName())) {
	            		f.setAccessible(true);
	            		com.yrszone.automation.ui.objectrepo.ObjectRepository.Field field;
	            		if(f.isAnnotationPresent(FindElements.class)) {
	            			FindElements ann = f.getAnnotation(FindElements.class);
	            			field = getRepoField(driver, className, f, ann.page(), ann.field());
	            			
	            		}else {
	            			field = getRepoField(driver, className, f, "", "" );
	            		}
	            		verifyFindBy(field.getFindBy());
	                    Class klass = (Class) ((ParameterizedType)f.getGenericType()).getActualTypeArguments()[0];
	                    f.set(p, f.getType().getConstructor(UIWebDriver.class, FindBy.class, String.class, Class.class ).newInstance(driver, field.getFindBy(), field.getFindByValue(), klass));
	                    f.setAccessible(false);	                	
	            	}else if(BaseElement.class.equals(f.getType().getSuperclass())) {
	            		f.setAccessible(true);
	            		com.yrszone.automation.ui.objectrepo.ObjectRepository.Field field;
	            		if(f.isAnnotationPresent(FindElement.class)) {
	            			FindElement ann = f.getAnnotation(FindElement.class);
	            			field = getRepoField(driver, className, f, ann.page(), ann.field());
	            			
	            		}else {
	            			field = getRepoField(driver, className, f, "", "" );
	            		}
	            		f.set(p, f.getType().getConstructor(UIWebDriver.class, FindBy.class, String.class).newInstance(driver, field.getFindBy(), field.getFindByValue()));
	                    f.setAccessible(false);
	            	}
	            	
	            	
/*	            	if(f.isAnnotationPresent(FindElement.class)){
	                	FindElement ann = f.getAnnotation(FindElement.class);
	                	com.yrszone.automation.ui.objectrepo.ObjectRepository.Field field = getRepoField(driver, className, f, ann.page(), ann.field());
	                    f.set(p, f.getType().getConstructor(UIWebDriver.class, FindBy.class, String.class).newInstance(driver, field.getFindBy(), field.getFindByValue()));
	                    f.setAccessible(false);
	                } else if(f.isAnnotationPresent(FindElements.class)){
	                	f.setAccessible(true);
	                	FindElements ann = f.getAnnotation(FindElements.class);
	                    com.yrszone.automation.ui.objectrepo.ObjectRepository.Field field = getRepoField(driver, className, f, ann.page(), ann.field());
	                    verifyFindBy(field.getFindBy());
	                    Class klass = (Class) ((ParameterizedType)f.getGenericType()).getActualTypeArguments()[0];
	                    f.set(p, f.getType().getConstructor(UIWebDriver.class, FindBy.class, String.class, Class.class ).newInstance(driver, field.getFindBy(), field.getFindByValue(), klass));
	                    f.setAccessible(false);
	                }*/
	            }
	        }catch(InvocationTargetException | IllegalArgumentException | IllegalAccessException | InstantiationException | NoSuchMethodException | SecurityException e){
	            throw new AutomationDriverException("Could not initialize page : ", e);
	        }
	    }

		private static com.yrszone.automation.ui.objectrepo.ObjectRepository.Field getRepoField(UIWebDriver driver, String className, Field f, String pageName, String fieldName)throws AutomationDriverException {
			String field = "".equals(fieldName)?  f.getName():fieldName;
			String page = "".equals(pageName)?  className :pageName;
			return driver.getObjRepoManager().getField(page, field);
		}

	    private static void verifyFindBy(FindBy findBy) throws AutomationDriverException{
	        if(findBy!=FindBy.XPATH){
	            throw new AutomationDriverException("Fields annotated with @FindElements can only have xpath as FindBy");
	        }
	    }

	    public static void reInitialize(BasePage p, UIWebDriver driver) throws AutomationDriverException {
	        Field[] fields = p.getClass().getDeclaredFields();
	        p.setDriver(driver);
	        for(Field f : fields){
	        	f.setAccessible(true);
	        	if(f.isAnnotationPresent(FindElement.class)){
	        		 try {
		                    ((BaseElement) f.get(p)).setWebDriver(driver);
		                } catch (IllegalArgumentException | IllegalAccessException e) {
		                    throw new AutomationDriverException("Could not reInitialize page : ", e);
		                }
	        	}
	        	f.setAccessible(false);
	               
	        }
	    }
}
