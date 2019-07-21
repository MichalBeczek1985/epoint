/*
 * package com.example.epoint;
 * 
 * import static org.junit.Assert.assertTrue;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.example.epoint.dao.ContactFormDAOImpl; import
 * com.example.epoint.model.ContactForm;
 * 
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest public class ApplicationTest {
 * 
 * @Autowired private ContactFormDAOImpl ct;
 * 
 * 
 * @Test public void checkIfInserted() { ContactForm cf = new
 * ContactForm("michal", "kowalski", "mb@mail.com", "phone","contact",
 * "reason"); int i = ct.saveOrUpdateTest(cf); assertTrue(i==1); }
 * 
 * 
 * }
 */