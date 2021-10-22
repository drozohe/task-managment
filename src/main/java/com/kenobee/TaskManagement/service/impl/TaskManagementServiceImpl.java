
package com.kenobee.TaskManagement.service.impl;

import com.kenobee.TaskManagement.firebase.FireBaseInitializer;
import com.kenobee.TaskManagement.dto.TaskDTO;
import com.kenobee.TaskManagement.service.TaskManagementService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author drozohe
 */

@Service
public class TaskManagementServiceImpl implements TaskManagementService{

    @Autowired
    private FireBaseInitializer firebase;
    
    @Override
    public List<TaskDTO> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean add(TaskDTO post) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean edit(String id, TaskDTO post) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
