CREATE TABLE account_connector
(
    id                      SERIAL PRIMARY KEY,
    user_id                 INT REFERENCES app_user (id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED,
    institution_id          TEXT NOT NULL DEFAULT '',
    institution_name        TEXT NOT NULL DEFAULT '',
    date_connected          TIMESTAMPTZ NOT NULL,
    encrypted_access_token  BYTEA NOT NULL,
    transaction_sync_cursor TEXT,
    external_id       TEXT NOT NULL DEFAULT ''
) INHERITS(base_audit_table);

CREATE TRIGGER set_audit_timestamps
BEFORE INSERT OR UPDATE ON account_connector
FOR EACH ROW
EXECUTE FUNCTION set_audit_timestamps();

CREATE INDEX ac_userId ON account_connector (user_id);

/*
 ROLLBACK 
 DROP INDEX ac_userId;
DELETE FROM flyway_schema_history WHERE script = 'V5__Create_Account_Connector_Table.sql';
 DROP TABLE account_connector CASCADE;
 */