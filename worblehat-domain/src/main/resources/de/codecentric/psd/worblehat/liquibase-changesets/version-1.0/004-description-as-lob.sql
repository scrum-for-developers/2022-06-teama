--liquibase formatted sql

-- the above line is necessary in order to be recognized by liquibase
-- see https://docs.liquibase.com/concepts/basic/sql-format.html

--changeset author:id
-- Alter Table: see https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
-- Data Types: https://dev.mysql.com/doc/refman/8.0/en/data-types.html
ALTER TABLE book MODIFY description VARCHAR(4000);


-- most used data types:
-- INT
-- BIGINT
-- DATE
-- VARCHAR(…)
-- BOOLEAN

-- the following statement can be evaluated by liquibase in order to undo the changes from the changeset
--rollback SQL STATEMENT
