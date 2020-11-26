package domain;

import org.domain.Contact;
import org.domain.ContactDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ContactDaoTest {

    private final ContactDao target = new ContactDao();

    @Test
    void add() {
        int before = target.getAll().size();
        target.add(new Contact());
        int after = target.getAll().size();

        assertEquals(1, (after - before));
    }

    @Test
    void get() {
        Contact m = target.getById(1);
        assertNotNull(m);
    }
}
