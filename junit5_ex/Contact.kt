package junit5_examples.junit5_ex

import java.lang.IllegalArgumentException

class Contact {
    private var firstName: String? = null
    private var lastName: String? = null
    private var phoneNumber: String? = null

    constructor (firstName: String?, lastName: String?, phoneNumber: String?) {
        this.firstName = firstName
        this.lastName = lastName
        this.phoneNumber = phoneNumber
    }

    fun getFirstName(): String? {
        return this.firstName
    }

    fun getLastName(): String? {
        return lastName
    }

    fun getPhoneNumber(): String? {
        return phoneNumber
    }

    fun validateFirstName() {
        if (firstName == null) throw IllegalArgumentException("First Name cannot be empty")
    }

    fun validateLastName() {
        if (lastName == null) throw IllegalArgumentException("Last Name cannot be empty")
    }

    fun validatePhoneNumber() {
        if (phoneNumber == null) throw IllegalArgumentException("Phone Number cannot be empty")

        else if (phoneNumber!!.length != 10) throw IllegalArgumentException("Phone Number should be 10 digits")

        else if (!phoneNumber!!.matches("\\d+".toRegex())) throw IllegalArgumentException("Phone Number should only contain digits")

        else if (phoneNumber!![0] == '0') throw IllegalArgumentException("Phone Number cannot start with 0")
    }
}