package com.aaron.gezai.swagger2springboot;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * This class will for retrieving of contact, by Id, get all contact
 * and add contact.
 */

@RestController
@ApiModel(description = "Details about the contact")
public class AddressBookResource {
    /**
     * this map contacts will be my temporary storage of contacts.
     */
   ConcurrentMap<String,Contact> contacts = new ConcurrentHashMap<String, Contact>() ;

    /**
     *
      * @return
     */
   @GetMapping("/swagger")

    public String greeting() {
        return "redirect:/swagger-ui.html";
    }

   /**
     * a method to return a contact
     * @param id the id of the contact
     * @return  the contact having the given id
     */

    @GetMapping("/{id}")
    @ApiOperation(
            value = "Finds Contact by Id",
            notes = "Provide and id to look up specific contact form the adddress book",
            response = Contact.class)
    public Contact getContact(
            @ApiParam(value="ID value for the contact you need to retireve",required = true)
            @PathVariable String id){
        return  contacts.get(id);// todo
    }

    /**
     * a method to return the list of Contact
     * @return list of all contacts
     */
    @GetMapping("/")
    public List<Contact> getAllContacts(){
        return new ArrayList<>(contacts.values());
    }

    /**
     * a method to add a contact from json body
     * @param contact the json body will bind as a contact.
     * @return the contact added will be returned.
     */
    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact){
        contacts.put(contact.getId(),contact);
        return contact;// todo
    }

}
