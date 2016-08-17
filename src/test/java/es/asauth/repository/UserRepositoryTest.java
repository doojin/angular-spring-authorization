package es.asauth.repository;

import es.asauth.domain.Role;
import es.asauth.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/db-test-context.xml")
public class UserRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JpaTransactionManager transactionManager;

    @Autowired
    private UserRepository userRepository;

    @Before
    @Transactional
    public void setUp() {
        TransactionTemplate tt = new TransactionTemplate(transactionManager);
        tt.execute(new TransactionCallbackWithoutResult() {
                   @Override
                   protected void doInTransactionWithoutResult(TransactionStatus status) {
                       entityManager.createQuery("DELETE FROM User").executeUpdate();
                   }
               }
        );
    }

    @Test
    public void save() {
        List<User> users = userRepository.findAll();
        assertThat(users.size(), equalTo(0));

        User user = new User();
        user.setAccount("dmitry.papka@gmail.com");
        user.setRole(Role.ADMIN);
        userRepository.save(user);

        users = userRepository.findAll();
        assertThat(users.size(), equalTo(1));
        assertThat(users.get(0).getAccount(), equalTo("dmitry.papka@gmail.com"));
        assertThat(users.get(0).getRole(), equalTo(Role.ADMIN));
    }

}