package junit5_examples.junit5_ex

class ContactManager {
    val contactList = HashMap<String, Contact>()

    fun addContact(firstName: String?, lastName: String?, phoneNumber: String?) {
        val contact = Contact(firstName, lastName, phoneNumber)
        validateContact(contact)
        if(checkIfContactAlreadyExist(contact)) return
        contactList.put(generateKey(contact), contact)
    }

    fun getAllContacts(): Collection<Contact>? {
        return contactList.values
    }

    fun checkIfContactAlreadyExist(contact: Contact): Boolean {
        return contactList.containsKey(generateKey(contact))
    }

    private fun validateContact(contact: Contact) {
        contact.validateFirstName()
        contact.validateLastName()
        contact.validatePhoneNumber()
    }

    private fun generateKey(contact: Contact): String {
        return "${contact.getFirstName()} ${contact.getLastName()}"
    }
}