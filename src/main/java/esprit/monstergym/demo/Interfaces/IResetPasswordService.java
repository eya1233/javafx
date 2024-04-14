package esprit.monstergym.demo.Interfaces;

import esprit.monstergym.demo.Entities.ResetPassword;
import esprit.monstergym.demo.Entities.User;

public interface IResetPasswordService {

    public void create(ResetPassword entity);
    public ResetPassword get(User user);

    public void ResetPassword(User user);
}
