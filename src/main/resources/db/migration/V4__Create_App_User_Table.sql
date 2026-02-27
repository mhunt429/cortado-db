CREATE TABLE app_user
(
    id              SERIAL PRIMARY KEY,
    account_id      INT  NOT NULL REFERENCES user_account(id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED,
    created_date    TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    encrypted_email BYTEA NOT NULL,
    password        TEXT NOT NULL,
    encrypted_name  BYTEA NOT NULL,
    encrypted_phone BYTEA NOT NULL,
    last_login_date TIMESTAMPTZ,
    last_login_ip   VARCHAR(39), --supports ipv6 and v4
    phone_verified  BOOLEAN NOT NULL DEFAULT FALSE,
    email_verified  BOOLEAN NOT NULL DEFAULT FALSE,
    email_hash      VARCHAR(64) NOT NULL UNIQUE
)INHERITS(base_audit_table);

CREATE TRIGGER set_audit_timestamps
BEFORE INSERT OR UPDATE ON app_user
FOR EACH ROW
EXECUTE FUNCTION set_audit_timestamps();



CREATE INDEX au_email_hash_indx ON app_user (email_hash);

CREATE INDEX au_user_id ON app_user (account_id);

/*
 ROLLBACK
 DROP INDEX au_email_hash_indx;
 DROP INDEX au_user_id;
 DELETE FROM flyway_schema_history WHERE script = 'V4__Create_App_User_Table.sql';
 DROP TABLE app_user CASCADE;
 */