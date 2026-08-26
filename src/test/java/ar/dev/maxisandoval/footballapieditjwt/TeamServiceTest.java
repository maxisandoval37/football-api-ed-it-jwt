package ar.dev.maxisandoval.footballapieditjwt;

import ar.dev.maxisandoval.footballapieditjwt.entity.*;
import ar.dev.maxisandoval.footballapieditjwt.service.TeamService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Transactional
@Slf4j
class TeamServiceTest {
    private final TeamService teamService;
    private final Faker faker = new Faker(Locale.forLanguageTag("es-AR"));

    private Team buildFakeTeamWithPlayers() {
        String teamName = faker.team().name();
        int capacity = faker.number().numberBetween(1,100);
        int playerCount = faker.number().numberBetween(1,12);

        log.info("teamName -> " + teamName);

        List<Player> players = new ArrayList<>();

        Team team = Team.builder()
                .name(teamName)
                .capacity(capacity)
                .players(players)
                .build();

        players.addAll(IntStream.range(0, playerCount)
                .mapToObj(i -> Player.builder()
                        .name(faker.name().fullName())
                        .team(team)
                        .build())
                .toList()
        );

        return team;
    }

    @BeforeEach
    void setUp() {
        teamService.deleteAll();
        IntStream.range(0, 3).mapToObj(i -> buildFakeTeamWithPlayers()).forEach(teamService::save);
    }

    @Test
    void testGetAll() {
        List<Team> teams = teamService.getAll();

        assertNotNull(teams);
        assertEquals(3, teams.size());

        teams.forEach(team -> {
            assertNotNull(team.getName());
            assertNotNull(team.getCapacity());

            team.getPlayers().forEach(player -> {
                assertNotNull(player.getId());
                assertNotNull(player.getName());
            });
        });
    }

    @Test
    void testGetById() {
        Team savedTeam = teamService.save(buildFakeTeamWithPlayers());
        Team team = teamService.getById(savedTeam.getId());

        assertNotNull(team.getName());
        assertNotNull(team.getCapacity());
    }

    @Test
    void testGetByIdNotFound() {
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> teamService.getById(Long.MAX_VALUE));
        assertTrue(exception.getMessage().contains("Team not found with id"));
    }

    @Test
    void testSave() {
        Team savedTeam = teamService.save(buildFakeTeamWithPlayers());
        assertNotNull(savedTeam.getId());
        assertNotNull(savedTeam.getName());
        assertNotNull(savedTeam.getCapacity());

        assertFalse(savedTeam.getPlayers().isEmpty());
    }

    @Test
    void testUpdate() {
        Team originalTeam = teamService.getAll().get(0);

        originalTeam.setName("Team Updated");
        originalTeam.setCapacity(123);

        Team updatedTeam = teamService.update(originalTeam.getId(), originalTeam);

        assertEquals("Team Updated", updatedTeam.getName());
        assertEquals(123, updatedTeam.getCapacity());
    }

    @Test
    void testDeleteById() {
        List<Team> teams = teamService.getAll();
        int teamCount = teams.size();

        teamService.deleteById(teams.get(0).getId());

        assertEquals(teamCount-1, teamService.getAll().size());
    }

    @Test
    void testDeleteAll() {
        teamService.deleteAll();

        assertEquals(0, teamService.getAll().size());
    }
}