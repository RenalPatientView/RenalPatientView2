package com.worthsoln.patientview.letter;

import com.worthsoln.HibernateUtil;
import com.worthsoln.database.DatabaseDAO;
import com.worthsoln.database.action.DatabaseAction;
import com.worthsoln.patientview.User;
import com.worthsoln.patientview.logon.LogonUtils;
import com.worthsoln.patientview.user.UserUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LetterDisplayAction extends DatabaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {
        User user = UserUtils.retrieveUser(request);
        List letters = getLettersForPatient(user, request);
        List fixedLetters = sortNullDatesOnLetters(letters);
        request.setAttribute("letters", fixedLetters);
        request.setAttribute("user", user);
        return LogonUtils.logonChecks(mapping, request);
    }

    private List getLettersForPatient(User user, HttpServletRequest request) throws Exception {

        DatabaseDAO dao = getDao(request);
        LetterDao letterDao = new LetterDao(user);
        List letters = dao.retrieveList(letterDao);

        return letters;
    }

    private List sortNullDatesOnLetters(List letters) {
        for (Object obj : letters) {
            Letter letter = (Letter) obj;
            Letter tempLetter = (Letter) HibernateUtil.getPersistentObject(Letter.class, letter.getId());
            letter.setDate(tempLetter.getDate());
        }
        return letters;
    }


    public String getDatabaseName() {
        return "patientview";
    }

    public String getIdentifier() {
        return "letter";
    }
}
