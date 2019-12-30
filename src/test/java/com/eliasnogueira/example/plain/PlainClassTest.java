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
package com.eliasnogueira.example.plain;

import com.eliasnogueira.model.plain.UserRegistration;
import java.time.LocalDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlainClassTest {

    private static final Logger LOG = LogManager.getLogger(PlainClassTest.class);

    @Test
    @DisplayName("Test Data with plain class")
    public void plainClass() {
        int year = 1982;
        int month = 8;
        int day = 15;

        // Using setters
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.setName("Elias Nogueira");
        userRegistration.setEmail("elias@gmail.com");
        userRegistration.setPassword("1q2w3e4R");
        userRegistration.setDateOfBirth(LocalDate.of(year, month, day));
        LOG.info(userRegistration);

        // Using class constructor (not recommended)
        UserRegistration otherUserRegistration = new UserRegistration(
            "Eva de Vries", "evadevries@gmail.com", "eV@devr1es", LocalDate.of(1997, 11, 5));
        LOG.info(otherUserRegistration);

        assertNotNull(userRegistration);
    }

}
