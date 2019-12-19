/*
 * MIT License
 *
 * Copyright (c) 2019 Elias Nogueira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.eliasnogueira.data;

import com.eliasnogueira.model.lombok.UserRegistration;
import java.time.LocalDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserRegistrationFixedData {

    private static final Logger LOG = LogManager.getLogger(UserRegistrationData.class);

    public static UserRegistration createUser() {
        UserRegistration userRegistration = UserRegistration.builder().
            name("Test user").
            email("test@gmail.com").
            password("12345678").
            dateOfBirth(LocalDate.of(2001, 7, 18))
            .build();

        LOG.info(userRegistration);

        return userRegistration;
    }

    public static UserRegistration createUserWithNotValidPassword() {
        UserRegistration userRegistration = UserRegistration.builder().
            name("Test user - not valid password").
            email("notValidPassword@gmail.com").
            password("12345678").
            dateOfBirth(LocalDate.of(1996, 12, 2))
            .build();

        LOG.info(userRegistration);

        return userRegistration;
    }

    public static UserRegistration createUserWithNotValidEmail() {
        UserRegistration userRegistration = UserRegistration.builder().
            name("Test user - not valid email").
            email("emailNotValid").
            password("1q2w3e4rT").
            dateOfBirth(LocalDate.of(1989, 10, 21))
            .build();

        LOG.info(userRegistration);

        return userRegistration;
    }

    public static UserRegistration createUserNotValidDateOfBirth() {
        UserRegistration userRegistration = UserRegistration.builder().
            name("Test user - not valid birth date").
            email("notValidBirthDate@gmail.com").
            password("4r3e2w1qQ").
            dateOfBirth(LocalDate.of(2030, 12, 31))
            .build();

        LOG.info(userRegistration);

        return userRegistration;
    }
}