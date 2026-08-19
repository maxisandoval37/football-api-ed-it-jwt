package ar.dev.maxisandoval.footballapieditjwt.service;

import ar.dev.maxisandoval.footballapieditjwt.entity.Team;
import ar.dev.maxisandoval.footballapieditjwt.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public Team getById(Long id) {
        return teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Team not found with id: "+id));
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public Team update(Long id, Team updatedTeam) {
        Team existingTeam = getById(id);

        existingTeam.setName(updatedTeam.getName());
        existingTeam.setCapacity(updatedTeam.getCapacity());

        return teamRepository.save(existingTeam);
    }

    public void deleteById(Long id) {
        teamRepository.deleteById(id);
    }

    public void deleteAll() {
        teamRepository.deleteAll();
    }
}