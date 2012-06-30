<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<td id="left_login" class="left">
    <div>
        <div>
            <img src="http://milady.reaperman.org/nhshackday/beaker.png" alt=""/>
        </div>
        <div>
            <form action="j_security_check" method="POST">
                <div>
                    <h3>Username</h3>
                    <div><input type="text" name="j_username" class="loginform" tabindex="1" /></div>
                </div>

                <div>
                    <h3>Password</h3>
                    <div><input type="password" name="j_password" class="loginform" tabindex="2" /></div>
                </div>

                <br />

                <div>
                    <input type="submit" value="Log in" class="formbutton" style="border-style: outset;" tabindex="3" />
                </div>
            </form>
        </div>

        <div>
            <a href="forgotten-password.jsp">Forgotten password?</a>
        </div>
    </div>
</td>
