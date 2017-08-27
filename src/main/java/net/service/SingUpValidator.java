package net.service;

import net.model.Books;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class SingUpValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Books.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Books books = (Books) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"bookTitle","bookTitle.empty","bookTitle must not be empty");
//        String bookTitle = books.getBookTitle();
//        if (bookTitle.length() > 20) {
            errors.rejectValue("bookTitle","bookTitle.tooLong","bookTitle must be not more than 20 characters");
        }
    }
