package Tests.GlobalStyles;


import Tests.TinyMCE.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        GlobalStyles_HeadlineTest.class,
        GlobalStyles_ParagraphTest.class,
        GlobalStyles_MediumFieldTest.class,
        GlobalStyles_LargeFieldsTest.class,
        TinyMCE_HeadlineTest.class

})
public class TestSuite  {
}
