package net.time4j.format.expert;

import net.time4j.PlainDate;
import net.time4j.format.DisplayMode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(JUnit4.class)
public class StyleProcessorTest {

    @Test
    public void flexibleStylePattern() {
        PlainDate date = PlainDate.of(2016, 12, 18);
        ChronoFormatter<PlainDate> chinese =
            ChronoFormatter.ofDateStyle(DisplayMode.LONG, Locale.CHINESE);
        ChronoFormatter<PlainDate> english =
            ChronoFormatter.ofDateStyle(DisplayMode.LONG, Locale.ENGLISH);
        assertThat(
            chinese.with(Locale.ENGLISH).format(date),
            is(english.format(date))
        );
    }

}
