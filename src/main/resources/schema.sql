CREATE TABLE IF NOT EXISTS "Employee" (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  emp_id VARCHAR(10) NOT NULL,
  emp_name VARCHAR(30) NOT NULL,
  mgr_id  VARCHAR(10)
);