package pages;

import static Utils.SeleniumUtils.*;
import org.openqa.selenium.By;

public class HomePage {
    private final By HOMEPAGE_TITLE = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");

    public String getHomePageTitle(){
        return getTitle(HOMEPAGE_TITLE);
    }


}
