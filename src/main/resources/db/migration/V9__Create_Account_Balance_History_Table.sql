CREATE TABLE account_balance_history (
    id                   SERIAL PRIMARY KEY,
    user_id              INT NOT NULL REFERENCES app_user(id) ON DELETE SET NULL,
    financial_account_id INT NOT NULL REFERENCES financial_account(id) ON DELETE SET NULL,
    current_balance      DECIMAL NOT NULL,
    available_balance    DECIMAL NOT NULL,
    created_at           TIMESTAMPTZ NOT NULL DEFAULT NOW()
) INHERITS (base_audit_table);

CREATE TRIGGER set_audit_timestamps
BEFORE INSERT OR UPDATE ON account_balance_history
FOR EACH ROW
EXECUTE FUNCTION set_audit_timestamps();

CREATE INDEX account_history_user_id ON account_balance_history(user_id);
CREATE INDEX account_history_financial_account_id ON account_balance_history(financial_account_id);

/*
ROLLBACK
DROP INDEX account_history_user_id;
DROP INDEX account_history_financial_account_id;
DROP TABLE account_history;
DELETE FROM flyway_schema_history where script = 'V9__Create_Account_History_Table.sql';
*/