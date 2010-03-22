package com.worthsoln.patientview;

import com.worthsoln.actionutils.ActionUtils;
import com.worthsoln.database.DatabaseDAO;
import com.worthsoln.database.action.DatabaseAction;
import com.worthsoln.patientview.logon.LogonUtils;
import com.worthsoln.patientview.resultheading.ResultHeading;
import com.worthsoln.patientview.resultheading.ResultHeadingDao;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestResultsAction extends DatabaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {
        DatabaseDAO dao = getDao(request);
        Patient patient = PatientUtils.retrievePatient(request, dao);
        if (patient != null) {
            request.setAttribute("patient", patient);

            Panel currentPanel = managePanels(request, dao);
            TestResultForPatientDao resultDao = new TestResultForPatientDao(patient.getNhsno(), currentPanel);
            List<TestResult> results = dao.retrieveList(resultDao);
            Collection<Result> resultsInRecords = turnResultsListIntoRecords(results);
            managePages(request, resultsInRecords);
            request.setAttribute("results", resultsInRecords);

            List<ResultHeading> resultsHeadingsList = dao.retrieveList(new ResultHeadingDao(currentPanel));
            request.setAttribute("resultsHeadings", resultsHeadingsList);
        } else if (!request.isUserInRole("patient")) {
            return LogonUtils.logonChecks(mapping, request, "control");
        }
        ActionUtils.setUpNavLink(mapping.getParameter(), request);
        return LogonUtils.logonChecks(mapping, request);
    }

    private Panel managePanels(HttpServletRequest request, DatabaseDAO dao) {
        Panel currentPanel = currentPanel(request);
        List<Panel> panelList = dao.retrieveList(new PanelsDao());
        for (Panel p : panelList) {
            p.setResultHeadings(dao.retrieveList(new ResultHeadingDao(p)));
        }
        PanelNavigation panelNav = new PanelNavigation(currentPanel, panelList);
        request.setAttribute("panelNav", panelNav);
        return currentPanel;
    }

    private void managePages(HttpServletRequest request, Collection<Result> resultsInRecords) {
        Panel currentPage = currentPage(request);
        int resultsPerPage = resultsPerPage(request);
        int numberOfResults = resultsInRecords.size();
        int numberOfPages = (int) Math.ceil((1.0 * numberOfResults) / (1.0 * resultsPerPage));
        List<Panel> pageList = createPages(numberOfPages);
        PanelNavigation pageNav = new PanelNavigation(currentPage, pageList);
        request.setAttribute("pages", pageList);
        request.setAttribute("numberOfPages", numberOfPages + "");
        request.setAttribute("resultsPerPage", resultsPerPage);
        request.setAttribute("resultsOffset", (currentPage.getPanel() - 1) * resultsPerPage);
        request.setAttribute("pageNav", pageNav);
    }

    private int resultsPerPage(HttpServletRequest request) {
        ServletContext servletContext = request.getSession().getServletContext();
        String resultsPerPageString = servletContext.getInitParameter("default.results.per.page");
        return Integer.parseInt(resultsPerPageString);
    }

    private List<Panel> createPages(int numberOfPages) {
        List<Panel> pages = new ArrayList<Panel>();
        for (int i = 1; i <= numberOfPages; i++) {
            Panel page = new Panel(i);
            pages.add(page);
        }
        return pages;
    }

    private Panel currentPanel(HttpServletRequest request) {
        Panel currentPanel = null;
        try {
            currentPanel = new Panel(Integer.parseInt(request.getParameter("panel")));
        } catch (Exception e) {
            ;
        }
        return currentPanel;
    }

    private Panel currentPage(HttpServletRequest request) {
        Panel currentPage = null;
        try {
            currentPage = new Panel(Integer.parseInt(request.getParameter("page")));
        } catch (Exception e) {
            currentPage = new Panel(1);
        }
        return currentPage;
    }

    private Collection<Result> turnResultsListIntoRecords(List<TestResult> resultsList) {
        Map<TestResultId, Result> resultsRecords = new TreeMap<TestResultId, Result>();
        for (TestResult testResult : resultsList) {
            TestResultId testResultId = new TestResultId(testResult);
            Result result = resultsRecords.get(testResultId);
            if (result == null) {
                result = new Result(testResult);
                resultsRecords.put(testResultId, result);
            }
            result.addResult(testResult.getTestcode(), testResult.getValue());
        }
        return resultsRecords.values();
    }

    public String getDatabaseName() {
        return "patientview";
    }

    public String getIdentifier() {
        return "edtaCode";
    }
}

class TestResultId implements Comparable {

    private String nhsno;
    private Calendar dateStamped;
    private String prepost;

    public TestResultId(TestResult testResult) {
        this.nhsno = testResult.getNhsno();
        this.prepost = testResult.getPrepost();
        this.dateStamped = testResult.getDatestamped();
    }

    public int compareTo(Object o) {
        TestResultId resultToCompareThisTo = (TestResultId) o;
        if (nhsno.equals(resultToCompareThisTo.getNhsno())) {
            if (dateStamped.equals(resultToCompareThisTo.getDateStamped())) {
                return prepost.compareToIgnoreCase(resultToCompareThisTo.getPrepost());
            } else if (dateStamped.before(resultToCompareThisTo.getDateStamped())) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return nhsno.compareToIgnoreCase(resultToCompareThisTo.getNhsno());
        }
    }

    public String getNhsno() {
        return nhsno;
    }

    public String getPrepost() {
        return prepost;
    }

    public Calendar getDateStamped() {
        return dateStamped;
    }
}
