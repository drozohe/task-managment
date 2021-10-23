
package com.kenobee.TaskManagement.dto;

import java.util.ArrayList;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static org.springframework.boot.autoconfigure.data.RepositoryType.AUTO;
import org.springframework.context.annotation.Role;

/**
 *
 * @author drozohe
 */

@Data @NoArgsConstructor @AllArgsConstructor
public class UserDTO {    
    private Long id;
    private String username;
    private String name;
    private String password;    
}
