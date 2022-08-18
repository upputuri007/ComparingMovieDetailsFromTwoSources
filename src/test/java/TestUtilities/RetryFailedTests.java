package TestUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

	int count = 0;
	int maxTry = 3;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (!result.isSuccess()) {                      
            if (count < maxTry) {                            
                count++;                                     
                result.setStatus(ITestResult.FAILURE);  
                return true;                                 
            } else {
            	result.setStatus(ITestResult.FAILURE);  
            }
        } else {
        	result.setStatus(ITestResult.SUCCESS);
        }
        return false;
	}

}
