package com.worthsoln.patientview;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import junit.framework.TestCase;

public class PanelNavigationTest extends TestCase {

    public void testNullCurrentCurrent() {
        PanelNavigation panelNav = buildPanelNavigation(null, "1,2,3");
        assertEquals(new Panel(1), panelNav.getCurrentPanel());
    }

    public void testOneInListCurrent() {
        PanelNavigation panelNav = buildPanelNavigation("1", "1");
        assertEquals(new Panel(1), panelNav.getCurrentPanel());
    }

    public void testOneInListPrevious() {
        PanelNavigation panelNav = buildPanelNavigation("1", "1");
        assertNull(panelNav.getPreviousPanel());
    }

    public void testOneInListNext() {
        PanelNavigation panelNav = buildPanelNavigation("1", "1");
        assertNull(panelNav.getNextPanel());
    }

    public void testTwoInListCurrentFirst() {
        PanelNavigation panelNav = buildPanelNavigation("1", "1,2");
        assertEquals(new Panel(1), panelNav.getCurrentPanel());
    }

    public void testTwoInListPreviousFirst() {
        PanelNavigation panelNav = buildPanelNavigation("1", "1,2");
        assertNull(panelNav.getPreviousPanel());
    }

    public void testTwoInListNextFirst() {
        PanelNavigation panelNav = buildPanelNavigation("1", "1,2");
        assertEquals(new Panel(2), panelNav.getNextPanel());
    }

    public void testTwoInListCurrentSecond() {
        PanelNavigation panelNav = buildPanelNavigation("2", "1,2");
        assertEquals(new Panel(2), panelNav.getCurrentPanel());
    }

    public void testTwoInListPreviousSecond() {
        PanelNavigation panelNav = buildPanelNavigation("2", "1,2");
        assertEquals(new Panel(1), panelNav.getPreviousPanel());
    }

    public void testTwoInListNextSecond() {
        PanelNavigation panelNav = buildPanelNavigation("2", "1,2");
        assertEquals(null, panelNav.getNextPanel());
    }

    public void testThreeInListCurrentFirst() {
        PanelNavigation panelNav = buildPanelNavigation("1", "1,2,3");
        assertEquals(new Panel(1), panelNav.getCurrentPanel());
    }

    public void testThreeInListPreviousFirst() {
        PanelNavigation panelNav = buildPanelNavigation("1", "1,2,3");
        assertNull(panelNav.getPreviousPanel());
    }

    public void testThreeInListNextFirst() {
        PanelNavigation panelNav = buildPanelNavigation("1", "1,2,3");
        assertEquals(new Panel(2), panelNav.getNextPanel());
    }

    public void testThreeInListCurrentSecond() {
        PanelNavigation panelNav = buildPanelNavigation("2", "1,2,3");
        assertEquals(new Panel(2), panelNav.getCurrentPanel());
    }

    public void testThreeInListPreviousSecond() {
        PanelNavigation panelNav = buildPanelNavigation("2", "1,2,3");
        assertEquals(new Panel(1), panelNav.getPreviousPanel());
    }

    public void testThreeInListNextSecond() {
        PanelNavigation panelNav = buildPanelNavigation("2", "1,2,3");
        assertEquals(new Panel(3), panelNav.getNextPanel());
    }

    public void testThreeInListCurrentThird() {
        PanelNavigation panelNav = buildPanelNavigation("3", "1,2,3");
        assertEquals(new Panel(3), panelNav.getCurrentPanel());
    }

    public void testThreeInListPreviousThird() {
        PanelNavigation panelNav = buildPanelNavigation("3", "1,2,3");
        assertEquals(new Panel(2), panelNav.getPreviousPanel());
    }

    public void testThreeInListNextThird() {
        PanelNavigation panelNav = buildPanelNavigation("3", "1,2,3");
        assertEquals(null, panelNav.getNextPanel());
    }

    private PanelNavigation buildPanelNavigation(String currentPanelStr, String panelListStr) {
        Panel currentPanel = null;
        if (currentPanelStr != null) {
            currentPanel = new Panel(Integer.parseInt(currentPanelStr));
        }
        List panelList = new ArrayList();
        StringTokenizer panelTokens = new StringTokenizer(panelListStr, ",");
        while (panelTokens.hasMoreTokens()) {
            panelList.add(new Panel(Integer.parseInt(panelTokens.nextToken())));
        }
        PanelNavigation panelNav = new PanelNavigation(currentPanel, panelList);
        return panelNav;
    }
}
