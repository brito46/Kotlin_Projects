package junit5_examples.junit5_ex

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class ContactManagerTest {

    @Test
    // The contact is successfully added if the recently created contact is in the map
    fun testCreatedContacts(){
        val me = ContactManager()
        me.addContact("jon","brito", "2011231234")
        assertEquals(1,me.contactList.size)
    }

    @Test
    // Checking if I get valid Exceptions for a user-side error
    fun testFirstNameArgumentsExceptions(){
        val me = ContactManager()
        assertFailsWith<IllegalArgumentException>{ me.addContact(null,"brito", "2011231234") }
    }

    @Test
    // Checking if I get valid Exceptions for a user-side error
    fun testLastNameArgumentsExceptions(){
        val me = ContactManager()
        assertFailsWith<IllegalArgumentException>{ me.addContact("jon",null, "2011231234") }
    }

    @Test
    // Checking if I get valid Exceptions for a user-side error
    fun testPhoneNumberArgumentsExceptions(){
        val me = ContactManager()
        assertAll("Making sure exception is thrown for each edge case",
                { assertFailsWith<IllegalArgumentException>{ me.addContact("jon","brito", null) }},
                { assertFailsWith<IllegalArgumentException>{ me.addContact("jon","brito", "0011231234") }},
                { assertFailsWith<IllegalArgumentException>{ me.addContact("jon","brito", "20112312345") }}
        )
    }

    @Test
    // Checking to see if it can determine a duplicate
    fun testCheckIfContactAlreadyExist(){
        val me = ContactManager()
        me.addContact("jon","brito", "2011231234")
        val contact = Contact("jon","brito", "2011231234")
        assertTrue(me.checkIfContactAlreadyExist(contact))
    }
}