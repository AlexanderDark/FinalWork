package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.DateParcer;

public class BasePage {
    protected Logger logger;
    protected DateParcer dateParcer = new DateParcer();
    public BasePage() {
        logger = LogManager.getLogger(BasePage.class);
    }
}
