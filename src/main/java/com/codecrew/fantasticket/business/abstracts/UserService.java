package com.codecrew.fantasticket.business.abstracts;

import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.User;

public interface UserService {

    Result add(User user);

    DataResult<User> findByEmail(String email);
}
