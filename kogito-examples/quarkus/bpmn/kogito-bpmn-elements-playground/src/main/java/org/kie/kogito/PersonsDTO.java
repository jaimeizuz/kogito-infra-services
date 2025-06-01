package org.kie.kogito;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PersonsDTO implements Iterable<PersonDTO>, Serializable {
    
    private List<PersonDTO> personsList;

    public PersonsDTO() {
        personsList = new ArrayList<PersonDTO>(); 
    }

    public PersonsDTO(List<PersonDTO> personsList) {
        this.personsList = personsList;
    }

    public List<PersonDTO> getPersonsList() {
        return personsList;
    }

    public void setPersonsList(List<PersonDTO> personsList) {
        this.personsList = personsList;
    }

    public void addPerson(PersonDTO person) {
        if(personsList == null) {
            personsList = new ArrayList<PersonDTO>(); 
        }

        personsList.add(person);
    } 

    @Override
    public String toString() {
        return "PersonsDTO [personsList=" + personsList + "]";
    }

    @Override
    public Iterator<PersonDTO> iterator() {
        return personsList.iterator();
    }  
}