package com.worthsoln.patientview;

import com.worthsoln.patientview.unit.Unit;
import com.worthsoln.patientview.unit.UnitUtils;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;


public class XmlImportUtils {

    public static void sendEmailOfExpectionStackTraceToUnitAdmin(Exception e, File xmlFile, ServletContext context) {

        try {
            String stacktrace = extractStringFromStackTrace(e);

            String fileName = xmlFile.getName();

            String unitcode = fileName.substring(0, fileName.indexOf("_"));

            Unit unit = UnitUtils.retrieveUnit(unitcode);

            String toAddress = allocateToAddress(context, unit);

            String emailBody = createEmailBody(context, stacktrace, fileName);

            EmailUtils.sendEmail(context, context.getInitParameter("noreply.email"), toAddress,
                    "[RPV] File upload failed: " + fileName, emailBody);

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private static String createEmailBody(ServletContext context, String stacktrace, String fileName) {
        String newLine = System.getProperty("line.separator");

        String emailBody = "";
        emailBody += "[This is an automated email from Renal PatientView - do not reply to this email]" + newLine;
        emailBody += newLine;
        emailBody += "The file named: " + newLine;
        emailBody += newLine;
        emailBody += fileName + newLine;
        emailBody += newLine;
        emailBody += "Has failed to load." + newLine;
        emailBody += newLine;
        emailBody += "Please check that it is well formed XML" + newLine;
        emailBody += "Please carefully read the stack trace below, there is often a good hint in there as to why " +
                "your file failed:" + newLine;
        emailBody += newLine;
        emailBody += "Stack Trace:" + newLine;
        emailBody += newLine;
        emailBody += stacktrace + newLine;
        emailBody += newLine;
        emailBody += newLine;
        emailBody += newLine;
        emailBody += "For further help, please contact " + context.getInitParameter("support.email") + newLine;
        emailBody += newLine;
        return emailBody;
    }

    private static String allocateToAddress(ServletContext context, Unit unit) {
        String toAddress = "";

        if (null == unit || null == unit.getRpvadminemail() || "".equals(unit.getRpvadminemail())) {
            toAddress = context.getInitParameter("support.email");
        } else {
            toAddress = unit.getRpvadminemail();
        }
        return toAddress;
    }

    public static String extractStringFromStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        String stacktrace = sw.toString();
        return stacktrace;
    }


    public static String extractFromXMLFileNameNhsno(String filename) {
        try {
            int firstUnderscore = filename.indexOf("_");
            int secondUnderscore = filename.indexOf("_", firstUnderscore + 1);
            int firstPeriod = filename.indexOf(".", secondUnderscore + 1);
            return filename.substring(secondUnderscore + 1, firstPeriod);
        } catch (Exception e) {
            return "";
        }
    }

    public static String extractFromXMLFileNameUnitcode(String filename) {
        try {
            return filename.substring(0, filename.indexOf("_")).toUpperCase();
        } catch (Exception e) {
            return "";
        }
    }
}
