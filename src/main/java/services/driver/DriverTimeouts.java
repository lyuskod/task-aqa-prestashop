package services.driver;

import interfaces.driver.IDriverTimeouts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;

import java.time.Duration;

public class DriverTimeouts implements IDriverTimeouts {
    public enum PredefinedTimeouts {
        MIN_1(Duration.ofMinutes(1));

        private final Duration duration;

        PredefinedTimeouts(Duration duration) {
            this.duration = duration;
        }

        public Duration getDuration() {
            return this.duration;
        }
    }

    private final Timeouts timeouts;

    public DriverTimeouts(WebDriver driver) {
        this.timeouts = driver.manage().timeouts();
    }

    @Override
    public void setImplicitTime(Duration time) {
        this.timeouts.implicitlyWait(time);
    }

    @Override
    public void setPageLoadTime(Duration duration) {
        this.timeouts.pageLoadTimeout(duration);
    }

    @Override
    public void setTimeouts(Duration implicitTimeout, Duration pageLoadTimeout) {
        this.timeouts.implicitlyWait(implicitTimeout);
        this.timeouts.pageLoadTimeout(pageLoadTimeout);
    }

    public void setDefaultTimeouts()
    {
        this.timeouts.implicitlyWait(PredefinedTimeouts.MIN_1.getDuration());
        this.timeouts.pageLoadTimeout(PredefinedTimeouts.MIN_1.getDuration());
        this.timeouts.scriptTimeout(PredefinedTimeouts.MIN_1.getDuration());
    }
}
