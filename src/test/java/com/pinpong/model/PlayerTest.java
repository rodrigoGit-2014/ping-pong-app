package com.pinpong.model;

import com.pinpong.persistance.PlayerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection.H2;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = H2)
public class PlayerTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlayerDao playerDao;

    @Test
    public void testPlayerEntity() {
        this.entityManager.persist(new Player(3, "juaco"));
        List<Player> player = (List<Player>) this.playerDao.findAll();

        for (Player player1 : player) {
            assertThat(player1.getId()).isEqualTo(3);
            assertThat(player1.getName()).isEqualTo("juaco");
        }
    }

}