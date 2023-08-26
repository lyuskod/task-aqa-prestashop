package com.github.prestashop.interfaces.driver;

import java.time.Duration;

public interface IDriverTimeouts {
    void setImplicitTime(Duration duration);

    void setPageLoadTime(Duration duration);

    void setScriptTimeout(Duration duration);
}
