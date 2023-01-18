package au.com.frankdev;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import au.com.frankdev.model.User;
import au.com.frankdev.repository.UserRepository;
import au.com.frankdev.WebServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@Slf4j
public class WebServiceApplicationTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void test() {
        
        User user = this.userRepository.save(
            User.builder()
                .name("JPA")
                .balance(new BigDecimal("15.88"))
                .enabled(true)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build()
        );
        
        log.info("saved user: {}", user);
    }
}
