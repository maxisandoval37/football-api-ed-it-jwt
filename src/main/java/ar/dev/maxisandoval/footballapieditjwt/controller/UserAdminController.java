package ar.dev.maxisandoval.footballapieditjwt.controller;

import ar.dev.maxisandoval.footballapieditjwt.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/admin/users")
public class UserAdminController {

    private final UserService userService;

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {

        if (!userService.existById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado: "+id);
        }

        userService.deleteById(id);
        return ResponseEntity.ok("Usuario eliminado correctamente "+id);
    }
}