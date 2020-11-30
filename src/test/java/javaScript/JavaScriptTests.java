package javaScript;

import base.BaseTests;
import org.testng.annotations.Test;
// JavaScript scroll to the table
public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable(){

        homePage.clickLargeAndDeepDom().scrollToTable();
    }
    @Test
    public void testScrollToFifthParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
}
