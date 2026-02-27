CREATE TABLE token (
    id         SERIAL PRIMARY KEY,
    user_id    INT NOT NULL REFERENCES app_user(id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED,
    token      VARCHAR NOT NULL,
    token_type VARCHAR(20) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    expires_at TIMESTAMPTZ NOT NULL
) INHERITS (base_audit_table);

CREATE TRIGGER set_audit_timestamps
BEFORE INSERT OR UPDATE ON token
FOR EACH ROW
EXECUTE FUNCTION set_audit_timestamps();

CREATE INDEX token_user_id ON token(user_id);

/*
ROLLBACK
DROP INDEX token_user_id;
DROP TABLE token;
DELETE FROM flyway_schema_history where script = 'V10__Create_Token_Table.sql';
*/