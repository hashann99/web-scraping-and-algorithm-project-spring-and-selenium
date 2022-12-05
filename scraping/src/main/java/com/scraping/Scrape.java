package com.scraping;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Scrape implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        new Ebay().start();
    }
}
