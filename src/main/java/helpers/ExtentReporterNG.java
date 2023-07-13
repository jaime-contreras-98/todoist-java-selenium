package helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.cdimascio.dotenv.Dotenv;

/**
 * Configuración del reporte!!
 */
public class ExtentReporterNG {

    /**
     * @return
     */
    public static ExtentReports getReportObject() {
        Dotenv dotenv = Dotenv.configure().load();
        String path = System.getProperty("user.dir") + "\\reports\\index.html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        // AQUI PODEMOS METER INFO DEL .ENV
        extent.setSystemInfo(dotenv.get("username"), dotenv.get("role"));

        return extent;
    }
}
