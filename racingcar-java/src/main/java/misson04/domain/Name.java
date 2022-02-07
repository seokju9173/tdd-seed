package misson04.domain;

import misson04.exception.NamingEmptyException;
import misson04.exception.NamingSizeException;

import static misson04.utils.Validator.isCorrectNameLength;
import static misson04.utils.Validator.isEmptyAndIsNull;

public class Name {

    private final String name;

    public Name(String name) {
        checkNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkNameLength(String name) {
        if (isEmptyAndIsNull(name)) {
            throw new NamingEmptyException();
        }

        if (isCorrectNameLength(name)) {
            throw new NamingSizeException();
        }
    }
}
