package library.view;

import library.bean.User;
import library.controller.Request;
import library.service.exception.ServiceException;

public class UserPage implements Page {
    @Override
    public Request run() throws ServiceException {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAvailable options:\n");
        if (userRole == User.UserRole.ADMIN) {
            sb.append("5. Register a new user.\n");
            sb.append("6. Delete user.\n");
        } else {
            sb.append("3. Suggest an administrator to add a book.\n");
        }
        sb.append("9. Change user\n");
        sb.append("0. To finish work.\n");
        System.out.println(sb.toString());
        return null;
    }
}
