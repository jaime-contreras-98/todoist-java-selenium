package helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {


    World world;
    WebDriver driver;
    Components comps;
    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentThread = new ThreadLocal<ExtentTest>(); // Thread para manejar multiples hilos/reportes

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName()); //aqui tiene que ir el nombre del feature scenario
        extentThread.set(test); // cada hilo tiene su propio id, no van a chocar ya que son id únicos
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentThread.get().log(Status.PASS, "Test passed!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentThread.get().fail(result.getThrowable());

        try {
            world.driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        //Screenshot
        String filePath = null;

        try {
            filePath = comps.getScreenshot(result.getMethod().getMethodName(), world.driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentThread.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // para generar el archivo
    }

}
