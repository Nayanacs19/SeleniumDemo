package constants;

public final class FrameworkConstants {
    private final static String REPORT_PATH = System.getProperty("user.dir")+"/index.html";
    private final static String RESET_TEXT = "Please enter your username to identify your account to reset your password";

    public static String getReportPath() {
        return REPORT_PATH;
    }

    public static String getResetText(){
        return RESET_TEXT;
    }
}
