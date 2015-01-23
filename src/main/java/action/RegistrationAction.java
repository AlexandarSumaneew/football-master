package action;

import dao.DAOFactory;
import dao.UserDAO;
import entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationAction implements Action {
    private static final Logger LOGGER = Logger.getLogger(RegistrationAction.class);

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        LOGGER.info("Start RegistrationAction");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (null == login || null == password) {
        }

        DAOFactory daoFactory = new DAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();

        if (userDAO.isUserRegistered(login)) {
            LOGGER.error("Login is not unique");
            return new ActionResult("register.jsp");
        } else {
            User user = new User();
            HttpSession session = req.getSession();

            user.setLogin(login);
            user.setName(req.getParameter("name"));
            user.setLastName(req.getParameter("lastName"));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter(password));
            user.setRoleID(2);
            user.setActive(true);
            userDAO.create(user);

            //todo Позже добавить параметр  jsp и расскомментить
            /*session.setAttribute("successfulMessage", "successful.registration.message");
            session.setAttribute("user", user);*/
            LOGGER.info("New user - " + login);
        }

        LOGGER.info("Finish RegistrationAction");
        return new ActionResult("ok.jsp");
        //return new ActionResult("main.jsp");
    }
}
