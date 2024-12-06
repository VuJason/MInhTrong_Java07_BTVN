package crm_app07controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_app07entity.RoleEntity;

import crm_app07service.RoleService;

@WebServlet(name = "RoleController", urlPatterns = { "/roles", "/role-add", "/role-update" })
public class RoleController extends HttpServlet {

    private RoleService roleService = new RoleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action) {
            case "/role-add":
                showAddRoleForm(req, resp);
                break;
            case "/role-update":
                showUpdateRoleForm(req, resp);
                break;
            case "/roles":
            	
            	deleteRole(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        if ("/role-update".equals(action)) {
            updateRole(req, resp);
        } else {
            addNewRole(req, resp);
        }
    }

    private void showAddRoleForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("role-add.jsp").forward(req, resp);
    }

    private void showUpdateRoleForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleId = req.getParameter("id");

        if (roleId != null) {
            RoleEntity roleEntity = roleService.getRoleById(Integer.parseInt(roleId));
            req.setAttribute("role", roleEntity);
            req.getRequestDispatcher("role-update.jsp").forward(req, resp);
        }
    }


    private void deleteRole(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("id");

        if (id != null) {
            roleService.deleteRoleById(Integer.parseInt(id));
        }

        List<RoleEntity> listRole = roleService.getAllRoles();
        req.setAttribute("Roles", listRole);
        req.getRequestDispatcher("role-table.jsp").forward(req, resp);
    }

    private void updateRole(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String roleId = req.getParameter("id");
        String roleName = req.getParameter("name");
        String description = req.getParameter("description");

        if (roleId != null && roleService.updateRole(Integer.parseInt(roleId), roleName, description)) {
            resp.sendRedirect(req.getContextPath() + "/roles");
        } else {
            req.setAttribute("error", "Lỗi khi cập nhật vai trò.");
            req.getRequestDispatcher("role-update.jsp").forward(req, resp);
        }
    }

    private void addNewRole(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String roleName = req.getParameter("name");
        String description = req.getParameter("description");

        boolean isInserted = roleService.insertRole(roleName, description);

        if (isInserted) {
            resp.sendRedirect(req.getContextPath() + "/roles");
        } else {
            req.setAttribute("error", "Lỗi khi thêm vai trò mới.");
            req.getRequestDispatcher("role-add.jsp").forward(req, resp);
        }
    }
}
