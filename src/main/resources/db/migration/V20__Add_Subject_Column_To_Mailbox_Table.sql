ALTER TABLE user_mailbox ADD COLUMN subject VARCHAR(100) NOT NULL;

/*
Rollback;
ALTER TABLE user_mailbox DROP COLUMN subject;
DELETE FROM flyway_schema_history WHERE script = 'V20__Add_Subject_Column_To_Mailbox_Table.sql';
*/