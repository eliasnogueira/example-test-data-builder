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
package com.eliasnogueira.example.data;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.eliasnogueira.data.UserRegistrationFixedData;
import com.eliasnogueira.model.lombok.UserRegistration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsingFixedDataTest {

    @Test
    @DisplayName("Create a valid user")
    public void createValidUser() {
        UserRegistration validUser = UserRegistrationFixedData.createUser();
        assertNotNull(validUser);
    }

    @Test
    @DisplayName("Create user with invalid date of birth")
    public void createUserNotValidDateOfBirth() {
        UserRegistration userNotValidDateOfBirth = UserRegistrationFixedData.createUserNotValidDateOfBirth();
        assertNotNull(userNotValidDateOfBirth);
    }

    @Test
    @DisplayName("Create a user with invalid email")
    public void userWithNotValidEmail() {
        UserRegistration userWithNotValidEmail = UserRegistrationFixedData.createUserWithNotValidEmail();
        assertNotNull(userWithNotValidEmail);
    }

    @Test
    @DisplayName("Create a user with invalid password")
    public void createUserWithNotValidPassword() {
        UserRegistration userWithNotValidPassword = UserRegistrationFixedData.createUserWithNotValidPassword();
        assertNotNull(userWithNotValidPassword);
    }
}
