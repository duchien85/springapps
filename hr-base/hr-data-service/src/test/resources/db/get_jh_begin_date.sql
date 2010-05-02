create or replace
FUNCTION GET_JH_BEGIN_DATE
(
  P_EMP_ID IN employees.employee_id%type
)
RETURN DATE AS
  a_hire_date DATE;
  a_max_end_date DATE;
BEGIN
  select max(jh.end_date) INTO a_max_end_date from job_history jh where employee_id = P_EMP_ID;
  select e.hire_date INTO a_hire_date from employees e where e.employee_id = P_EMP_ID;
  RETURN COALESCE (a_max_end_date, a_hire_date, sysdate);
END GET_JH_BEGIN_DATE;

