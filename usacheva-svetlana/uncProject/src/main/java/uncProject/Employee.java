package uncProject;

/**
 * Created by Sveta on 28.12.2016.
 */
public class Employee {

        private Integer implId;
        private String name;
        private String department;

        public void setId(Integer id) {

            this.implId = id;
        }
        public Integer getId() {

            return implId;
        }
        public void setDepartment(String department) {

            this.department = department;
        }
        public String getDepartment() {

            return department;
        }

        public void setName(String name) {

            this.name = name;
        }
        public String getName() {

            return name;
        }
}
