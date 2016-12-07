
select *
  from "Employee";

select "Employee"."Name",
        count("EmpToProject"."Name")
  from "Employee" left join 
       "EmpToProject" on
       "EmpToProject"."EmpID"="Employee"."EmpID"
  group by "Employee"."EmpID"
  order by "Employee"."EmpID"
;

select "Company"."Name",
        "Project"."Name"
  from "Company" join 
       "Project" on
       "Company"."Name"="Project"."Company"
  order by "Company"."Name"
;

select "Employee"."Name",
        "Project"."Name"
  from "Employee" left join 
       "Project" on
       "Employee"."EmpID"="Project"."Manager"
  order by "Project"."Name"
;
     
update "Employee"
   set "Department"='DepNew'
 where "EmpID"=1
;

update "Employee"
   set "Department"='DepNew'
 where "EmpID"=6
;
insert into "Company"(
            "Name")
    values ('CompToDelete')
;
 
delete from "Company"
 where "Name"='CompToDelete'
;