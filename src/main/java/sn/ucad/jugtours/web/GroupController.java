package sn.ucad.jugtours.web;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ucad.jugtours.model.Group;
import sn.ucad.jugtours.repository.GroupRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;



@RestController
@RequestMapping("/api")
@Slf4j
@CrossOrigin
public class GroupController {
    private  final GroupRepository groupRepository;

    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping("/group/{id}")
    ResponseEntity<?> getGroup(@PathVariable Long id){
        log.info("REST request to get Group : {}", id);
        Optional<Group> group = groupRepository.findById(id);

        return group.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/groups")
    Collection<Group> groups() {
        return groupRepository.findAll();
    }

    @GetMapping("/group")
    ResponseEntity<Group> createGroup(@Valid @RequestBody Group group) throws URISyntaxException {

        log.info("Request to create group: {}", group);

        Group result = groupRepository.save(group);

        return ResponseEntity.created(new URI("/api/group/" + result.getId())).body(result);
    }

    @PutMapping("/group/{id}")
    ResponseEntity<Group> updateGroup(@Valid @RequestBody Group group) {
        log.info("Request to update group: {}", group);
        Group result = groupRepository.save(group);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        log.info("Request to delete group: {}", id);
        groupRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
