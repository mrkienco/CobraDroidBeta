/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.text.cts;

import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTargetClass;
import dalvik.annotation.TestTargetNew;
import dalvik.annotation.TestTargets;
import dalvik.annotation.ToBeFixed;

import android.text.LoginFilter.UsernameFilterGeneric;

import junit.framework.TestCase;

@TestTargetClass(UsernameFilterGeneric.class)
public class LoginFilter_UsernameFilterGenericTest extends TestCase {

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.COMPLETE,
            method = "LoginFilter.UsernameFilterGeneric",
            args = {}
        ),
        @TestTargetNew(
            level = TestLevel.COMPLETE,
            method = "LoginFilter.UsernameFilterGeneric",
            args = {boolean.class}
        )
    })
    @ToBeFixed(bug = "1695243", explanation = "miss javadoc")
    public void testConstructor() {
        new UsernameFilterGeneric();
        new UsernameFilterGeneric(true);
        new UsernameFilterGeneric(false);
    }

    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "Test isAllowed(char c).",
        method = "isAllowed",
        args = {char.class}
    )
    public void testIsAllowed() {
        UsernameFilterGeneric usernameFilterGeneric = new UsernameFilterGeneric();

        assertTrue(usernameFilterGeneric.isAllowed('b'));
        assertTrue(usernameFilterGeneric.isAllowed('B'));
        assertTrue(usernameFilterGeneric.isAllowed('2'));
        assertFalse(usernameFilterGeneric.isAllowed('*'));
        assertFalse(usernameFilterGeneric.isAllowed('!'));

        // boundary test
        assertTrue(usernameFilterGeneric.isAllowed('0'));
        assertTrue(usernameFilterGeneric.isAllowed('9'));

        assertTrue(usernameFilterGeneric.isAllowed('a'));
        assertTrue(usernameFilterGeneric.isAllowed('z'));

        assertTrue(usernameFilterGeneric.isAllowed('A'));
        assertTrue(usernameFilterGeneric.isAllowed('Z'));

        // test additional characters
        assertTrue(usernameFilterGeneric.isAllowed('@'));
        assertTrue(usernameFilterGeneric.isAllowed('_'));
        assertTrue(usernameFilterGeneric.isAllowed('-'));
        assertTrue(usernameFilterGeneric.isAllowed('.'));

        assertFalse(usernameFilterGeneric.isAllowed('/'));
        assertFalse(usernameFilterGeneric.isAllowed(':'));
        assertFalse(usernameFilterGeneric.isAllowed('`'));
        assertFalse(usernameFilterGeneric.isAllowed('{'));
        assertFalse(usernameFilterGeneric.isAllowed('?'));
        assertFalse(usernameFilterGeneric.isAllowed('['));
    }
}
