
package com.kenobee.TaskManagement.controller;

import com.kenobee.TaskManagement.dto.TaskDTO;
import com.kenobee.TaskManagement.service.TaskManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author drozohe
 */

@RestController
@RequestMapping(value = "/tasks/v1")
public class TaskController {
    
    //[drozo] inyectar el servicio dentro del controlador, a traves de la interface accedo a la implementación.
    @Autowired
    private TaskManagementService service;
    
    @GetMapping(value = "/greet")
    public String greet(){
        return  "Hello desde spring boot ";
    }    
    
    
    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody TaskDTO post){
        return new ResponseEntity(service.add(post), HttpStatus.OK);
    }
    
    @GetMapping(value = "/list")
    public ResponseEntity list(){
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }
    
    @PutMapping(value = "/{id}/update")
    public ResponseEntity edit(@PathVariable(value = "id") String id, @RequestBody TaskDTO task){
        return new ResponseEntity(service.edit(id,task), HttpStatus.OK);
    }
    
     @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return  new ResponseEntity(service.delete(id), HttpStatus.OK);
    }    

    
    
}
