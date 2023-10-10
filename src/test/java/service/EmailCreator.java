package service;

import model.Email;

public class EmailCreator {
    public static final String TESTDATA_EMAIL_SUBJECT = "testdata.email.subject";

    public static Email setEmailSubjectFromProperty(){
        return new Email(TestDataReader.getTestData(TESTDATA_EMAIL_SUBJECT));
    }
}
