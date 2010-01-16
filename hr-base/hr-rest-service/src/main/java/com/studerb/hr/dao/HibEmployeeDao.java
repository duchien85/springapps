package com.studerb.hr.dao;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.studerb.hr.model.Employee;

@Repository
public class HibEmployeeDao extends AbstractHibernateDao<Employee> implements EmployeeDao {

    private final String TABLE_NAME = "EMPLOYEES";

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public void delete(Employee entity) {
        Long managerId = entity.getManager() == null ? null : entity.getManager().getId();
        Long employeeId = entity.getId();
        Query q = getCurrentSession().createQuery(
                "update Employee e set e.manager.id = :managerId where e.manager.id = :employeeId");
        q.setParameter("employeeId", employeeId, Hibernate.LONG);
        q.setParameter("managerId", managerId, Hibernate.LONG);
        int modified = q.executeUpdate();
        logger.debug("modified " + modified + " subemployees of employee " + employeeId
                + " to new manager with manager.id: " + managerId);
        Query q2 = getCurrentSession().createQuery(
                "update Department d set d.manager.id = null where d.manager.id = :employeeId");
        q2.setParameter("employeeId", employeeId, Hibernate.LONG);
        int modified2 = q2.executeUpdate();
        logger.debug("modified " + modified2
                + " departments - set manager to null - that were formerly managed by employee: " + employeeId);
        super.delete(entity);
    }

    @Override
    public void delete(Long id) {
        Employee e = get(id);
        delete(e);
    }
}
