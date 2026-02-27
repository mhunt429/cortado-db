CREATE TABLE connection_sync_data(
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES app_user(id),
    sync_type VARCHAR(40) NOT NULL, -- AccountBalance, Investments, Transactions, RecurringTransactions
    last_sync_date TIMESTAMPTZ NOT NULL,
    next_sync_date TIMESTAMPTZ NOT NULL,
    connector_id INT NOT NULL REFERENCES account_connector(id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED
) INHERITS(base_audit_table);

CREATE TRIGGER set_audit_timestamps
BEFORE INSERT OR UPDATE ON connection_sync_data
FOR EACH ROW
EXECUTE FUNCTION set_audit_timestamps();

CREATE INDEX connection_sync_userId on connection_sync_data(user_id);

/*
 ROLLBACK
 DROP INDEX connection_sync_userId;
 DROP TABLE connection_sync_data;
 DELETE FROM flyway_schema_history WHERE script = 'V8__connection_sync_data.sql';
 */