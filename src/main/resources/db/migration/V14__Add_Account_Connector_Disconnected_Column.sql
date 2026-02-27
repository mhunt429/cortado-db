ALTER TABLE account_connector ADD COLUMN disconnected_ts TIMESTAMPTZ;

/*
ROLLBACK;
ALTER TABLE account_connector DROP COLUMN disconnected_ts;
DELETE FROM flyway_schema_history WHERE script = 'V14__Add_Account_Connector_Disconnected_Column.sql';
*/