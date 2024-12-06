package crm_app07service;

import java.util.List;

import crm_app07entity.RoleEntity;
import crm_app07repository.RoleRepository;

public class RoleService {
	private RoleRepository roleRepository = new RoleRepository();
	
	public List<RoleEntity> getAllRoles() {
		return roleRepository.findAllRole();
	}

	public boolean insertRole(String name, String description) {
		return roleRepository.insertRoles(name, description) > 0;
	}
	
	public boolean deleteRoleById(int roleId) {
		int count = roleRepository.deleteByRoleId(roleId);

		return count > 0;
	}
	
	
	public RoleEntity getRoleById(int roleId) {
        return roleRepository.findRoleById(roleId);
    }

    public boolean updateRole(int roleId, String name, String description) {
        return roleRepository.updateRole(roleId, name, description) > 0;
    }
}
