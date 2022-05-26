package com.codecrew.fantasticket.business.concretes;

import com.codecrew.fantasticket.business.abstracts.UserService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.core.utilities.results.SuccessDataResult;
import com.codecrew.fantasticket.core.utilities.results.SuccessResult;
import com.codecrew.fantasticket.dataAccess.abstracts.UserDao;
import com.codecrew.fantasticket.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager  implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Customer added.");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<>(this.userDao.findByEmail(email)
                ,"Customer found.");
    }
}
