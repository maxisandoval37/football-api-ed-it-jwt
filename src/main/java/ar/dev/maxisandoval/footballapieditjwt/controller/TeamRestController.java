package ar.dev.maxisandoval.footballapieditjwt.controller;

import ar.dev.maxisandoval.footballapieditjwt.entity.Team;
import ar.dev.maxisandoval.footballapieditjwt.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/teams")
public class TeamRestController {

    private final TeamService teamService;

    @GetMapping("/all")
    public List<Team> getAll() {
        return teamService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Team getById(@PathVariable Long id) {
        return teamService.getById(id);
    }

    @PostMapping("/create")
    public Team create(@RequestBody Team team) {
        return teamService.save(team);
    }

    @PutMapping("/update/{id}")
    public Team update(@PathVariable Long id, @RequestBody Team team) {
        return teamService.update(id, team);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        teamService.deleteAll();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        teamService.deleteById(id);
    }
}