
package com.kenobee.TaskManagement.service;

import com.kenobee.TaskManagement.dto.TaskDTO;
import java.util.List;

/**
 *
 * @author drozohe
 */
public interface TaskManagementService {
    
    List<TaskDTO> list();

    Boolean add(TaskDTO post);

    Boolean edit(String id,TaskDTO post);

    Boolean delete(String id);    
    
}
