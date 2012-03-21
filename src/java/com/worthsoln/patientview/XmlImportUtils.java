package com.worthsoln.patientview;

import com.worthsoln.patientview.unit.Unit;
import com.worthsoln.patientview.unit.UnitUtils;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;


public class XmlImportUtils {

    public static void sendEmailOfExpectionStackTraceToUnitAdmin(Exception e, File xmlFile, ServletContext context) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        String stacktrace = sw.toString();

        String fileName = xmlFile.getName();

        String unitcode = fileName.substring(0, fileName.indexOf("_"));

        Unit unit = UnitUtils.retrieveUnit(unitcode);

        String toAddress = "";

        if (null == unit || null == unit.getRpvadminemail() || "".equals(unit.getRpvadminemail())) {
            toAddress = context.getInitParameter("support.email");
        }

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
        emailBody += "Please carefully read the stack trace below, there is often a good hint in there as to why your file failed:" + newLine;
        emailBody += newLine;
        emailBody += "Stack Trace:" + newLine;
        emailBody += newLine;
        emailBody += stacktrace + newLine;
        emailBody += newLine;
        emailBody += newLine;
        emailBody += newLine;
        emailBody += "For further help, please contact " + context.getInitParameter("support.email") + newLine;
        emailBody += newLine;

        if ("DUMMY".equalsIgnoreCase(unitcode) || "RSC02".equalsIgnoreCase(unitcode)) {
            EmailUtils.sendEmail(context, context.getInitParameter("noreply.email"), toAddress, "[RPV] File upload failed: " + fileName, emailBody);
        }
    }
}
