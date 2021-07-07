package local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.services;

import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.models.Role;
import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImplication implements RoleService {

    @Autowired
    RoleRepository roleRepo;

    // Save A Role
    @Override
    public Role save(Role role) {
        return roleRepo.save(role);
    }
}