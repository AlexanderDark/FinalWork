package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.DateParser;

public class BasePage {
    protected Logger logger;
    protected DateParser dateParcer = new DateParser();
    public BasePage() {
        logger = LogManager.getLogger(BasePage.class);
    }
}
