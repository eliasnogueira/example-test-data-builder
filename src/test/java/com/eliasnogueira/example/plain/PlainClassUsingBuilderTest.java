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
import com.eliasnogueira.model.plain.UserRegistrationBuilder;
import java.time.LocalDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlainClassUsingBuilderTest {

    private static final Logger LOG = LogManager.getLogger(PlainClassUsingBuilderTest.class);

    @Test
    @DisplayName("Test Data with builder in the plain class")
    public void plainClassWithBuilder() {
        int year = 1980;
        int month = 3;
        int day = 21;

        UserRegistration userRegistration = new UserRegistrationBuilder().
            name("Robert Spencer").
            email("rob.spencer@gmail.com").
            password("4r3e2w1qW").
            dateOfBirth(LocalDate.of(year, month, day)).
            build();

        LOG.info(userRegistration);

        assertNotNull(userRegistration);
    }
}
