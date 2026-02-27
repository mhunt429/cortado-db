CREATE TABLE access_log(
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES app_user(id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED,
    access_type VARCHAR(40) NOT NULL,
    access_date TIMESTAMPTZ NOT NULL,
    ip_address VARCHAR(40),
    user_agent VARCHAR(255),
    success BOOLEAN NOT NULL
) INHERITS(base_audit_table);

/*
ROLLBACK
DROP TABLE access_log;
DELETE FROM flyway_schema_history WHERE script = 'V19__Add_Access_Log_Table.sql';
*/
