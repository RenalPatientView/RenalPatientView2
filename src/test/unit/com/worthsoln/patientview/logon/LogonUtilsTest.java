package com.worthsoln.patientview.logon;

import com.Ostermiller.util.RandPass;
import junit.framework.TestCase;

public class LogonUtilsTest extends TestCase {

    public void testGenerateNewPassword() {
        System.out.println(new RandPass(RandPass.NUMBERS_AND_LETTERS_ALPHABET).getPass(8));
    }

    public void testDisplayRole() {
        assertEquals("Unit Admin", LogonUtils.displayRole("unitadmin"));
        assertEquals("Unit Staff", LogonUtils.displayRole("unitstaff"));
        assertEquals("Super Admin", LogonUtils.displayRole("superadmin"));
        assertEquals("Patient", LogonUtils.displayRole("patient"));
        assertEquals("Role Unknown", LogonUtils.displayRole("utterrubbish324958ywfb"));
    }
}
