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
import net.datafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UserRegistrationData {

    private static final Logger LOG = LogManager.getLogger(UserRegistrationData.class);
    private static final Faker faker = new Faker();
    private static final int PASSWORD_MINIMUM_LENGTH = 8;
    private static final int PASSWORD_MAXIMUM_LENGTH = 16;
    private static final boolean includeUppercase = true;
    private static final boolean includeSpecial = true;
    private static final boolean includeDigit = true;

    private UserRegistrationData() {
    }

    public static UserRegistration createUser() {
        UserRegistration userRegistration = UserRegistration.builder().
                name(faker.name().fullName()).
                email(faker.internet().emailAddress()).
                password(faker.internet().password(
                        PASSWORD_MINIMUM_LENGTH, PASSWORD_MAXIMUM_LENGTH, includeUppercase, includeSpecial, includeDigit)).
                dateOfBirth(convertDateToLocalDate(faker.date().birthday()))
                .build();

        LOG.info(userRegistration);

        return userRegistration;
    }

    public static UserRegistration createUserWithNotValidPassword() {
        int minimumPasswordLength = 1;
        int maximumPasswordLength = 7;

        UserRegistration userRegistration = UserRegistration.builder().
                name(faker.name().fullName()).
                email(faker.internet().emailAddress()).
                password(faker.internet().password(minimumPasswordLength, maximumPasswordLength)).
                dateOfBirth(convertDateToLocalDate(faker.date().birthday()))
                .build();

        LOG.info(userRegistration);

        return userRegistration;
    }

    public static UserRegistration createUserWithNotValidEmail() {
        UserRegistration userRegistration = UserRegistration.builder().
                name(faker.name().fullName()).
                email(faker.internet().username()).
                password(faker.internet().password(
                        PASSWORD_MINIMUM_LENGTH, PASSWORD_MAXIMUM_LENGTH, includeUppercase, includeSpecial, includeDigit)).
                dateOfBirth(convertDateToLocalDate(faker.date().birthday()))
                .build();

        LOG.info(userRegistration);
        return userRegistration;
    }

    public static UserRegistration createUserNotValidDateOfBirth() {
        UserRegistration userRegistration = UserRegistration.builder().
                name(faker.name().fullName()).
                email(faker.internet().emailAddress()).
                password(faker.internet().password(
                        PASSWORD_MINIMUM_LENGTH, PASSWORD_MAXIMUM_LENGTH, includeUppercase, includeSpecial, includeDigit)).
                dateOfBirth(convertDateToLocalDate(faker.date().future(60, TimeUnit.DAYS)))
                .build();

        LOG.info(userRegistration);

        return userRegistration;
    }

    private static LocalDate convertDateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
